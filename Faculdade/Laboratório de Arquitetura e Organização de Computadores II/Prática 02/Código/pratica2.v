module pratica2 (Resetn, PClock, MClock, Run, Bus, Done);

	input Resetn, PClock , MClock, Run;
	
	output [15:0]Bus;
	output Done;
	
	wire [15:0] DIN;
	wire [4:0] addr;
//Lembrar de conferir a ordem - proc, mem e count - se der certo chingar o cara do github
	
	
	processor processador (DIN, Resetn, PClock, Run, Done, Bus);		
	memory2 memoria (addr, MClock, DIN);
	counter contador (Resetn, MClock, addr);
	
endmodule

module counter (Resetn, Clock, n);
	input Resetn, Clock;
	output reg [4:0] n;

	always @ (posedge Clock)
		if (Resetn == 0)
			n <= 5'b00000;
		else
			n <= n + 1'b1;
			
endmodule

module processor (DIN, Resetn, Clock, Run, Done, Bus);

	input [15:0] DIN;
	input Resetn, Clock, Run;
	
	output reg Done;
	output reg [15:0] Bus;

	//reg [15:0] Bus;
	reg [0:7] Rin, Rout;
	reg [15:0] Sum;
	reg IRin, DINout, Ain, Gin, Gout, AddSub;
	
	wire [1:0] Tstep_Q;
	wire [2:0] I;
	wire [0:7] Xreg, Yreg;
	wire [15:0] R0, R1, R2, R3, R4, R5, R6, R7, A, G;
	wire [1:9] IR;
	wire [1:10] Sel; // bus selector
	
	wire Clear = Resetn || Done ;//| (~Run & ~Tstep_Q[1] & ~Tstep_Q[0]); // fix
	upcount Tstep (Clear, Clock, Tstep_Q);
	assign I = IR[1:3];
	dec3to8 decX (IR[4:6], 1'b1, Xreg);
	dec3to8 decY (IR[7:9], 1'b1, Yreg);
	
	/* Instruction Table
	* 	000: mv		Rx,Ry				: Rx <- [Ry]
	* 	001: mvi		Rx,#D				: Rx <- D
	* 	010: add		Rx, Ry			: Rx <- [Rx] + [Ry]
	* 	011: sub		Rx, Ry			: Rx <- [Rx] - [Ry]
	* 	OPCODE format: III XXX YYY, where 
	* 	III = instruction, XXX = Rx, and YYY = Ry. For mvi,
	* 	a second word of data is loaded from DIN
	*/
	
	always @(Tstep_Q or I or Xreg or Yreg)
	begin
		Done = 1'b0; Ain = 1'b0; Gin = 1'b0; Gout = 1'b0; AddSub = 1'b0;
		IRin = 1'b0; DINout = 1'b0; Rin = 8'b0; Rout = 8'b0;
		case (Tstep_Q)
			2'b00: // store DIN in IR as long as Tstep_Q == 0
				begin
					IRin = 1'b1;
				end
			2'b01:   //define signals in time step T1
				case (I)
					3'b000: // mv Rx,Ry
					begin
						Rout = Yreg;
						Rin = Xreg;
						Done = 1'b1;
					end
					3'b001: // mvi Rx,#D
					begin
						// data is required to be on DIN
						DINout = 1'b1;
						Rin = Xreg; 
						Done = 1'b1;
					end
					3'b010, 3'b11: //add, sub 
					begin
						Rout = Xreg;
						Ain = 1'b1;
					end
					default: ; 
				   endcase
			2'b10:   //define signals in time step T2
				case (I)
					3'b010: // add
					begin
						Rout = Yreg;
						Gin = 1'b1;
					end
					3'b011: // sub
					begin
						Rout = Yreg;
						AddSub = 1'b1;
						Gin = 1'b1;
					end
					default: ; 
				endcase
			2'b11:   //define signals in time step T3
				case (I)
					3'b010, 3'b011: //add, sub
					begin
						Gout = 1'b1;
						Rin = Xreg;
						Done = 1'b1;
					end
					default: ;
				endcase
		endcase
	end	
	
	regn reg_0 (Bus, Rin[0], Clock, R0);
	regn reg_1 (Bus, Rin[1], Clock, R1);
	regn reg_2 (Bus, Rin[2], Clock, R2);
	regn reg_3 (Bus, Rin[3], Clock, R3);
	regn reg_4 (Bus, Rin[4], Clock, R4);
	regn reg_5 (Bus, Rin[5], Clock, R5);
	regn reg_6 (Bus, Rin[6], Clock, R6);
	regn reg_7 (Bus, Rin[7], Clock, R7);
	regn reg_A (Bus, Ain, Clock, A);
	regn #(.n(9)) reg_IR (DIN, IRin, Clock, IR);

	//	alu
	always @(AddSub or A or Bus)
		begin
		if (!AddSub)
			Sum = A + Bus;
	    else
			Sum = A - Bus;
		end

	regn #(.n(16)) reg_G (Sum, Gin, Clock, G);

	// define the internal processor bus
	assign Sel = {Rout, Gout, DINout};

	always @(*)
	begin
		if (Sel == 10'b1000000000)
			Bus = R0;
   	else if (Sel == 10'b0100000000)
			Bus = R1;
		else if (Sel == 10'b0010000000)
			Bus = R2;
		else if (Sel == 10'b0001000000)
			Bus = R3;
		else if (Sel == 10'b0000100000)
			Bus = R4;
		else if (Sel == 10'b0000010000)
			Bus = R5;
		else if (Sel == 10'b0000001000)
			Bus = R6;
		else if (Sel == 10'b0000000100)
			Bus = R7;
		else if (Sel == 10'b0000000010)
			Bus = G;
   	else Bus = DIN;
	end	
endmodule

module upcount(Clear, Clock, Q);
	input Clear, Clock;
	output [1:0] Q;
	reg [1:0] Q;
	
	always @(posedge Clock)
	 	if (Clear)
			Q <= 2'b0;
		else 
			Q <= Q + 1'b1;
endmodule

module dec3to8(W, En, Y);
	input [2:0] W;
	input En;
	output [0:7] Y;
	reg [0:7] Y;
	
	always @(W or En)
	begin
		if (En == 1)
			case (W)
				3'b000: Y = 8'b10000000;
	   	   3'b001: Y = 8'b01000000;
				3'b010: Y = 8'b00100000;
				3'b011: Y = 8'b00010000;
				3'b100: Y = 8'b00001000;
				3'b101: Y = 8'b00000100;
				3'b110: Y = 8'b00000010;
				3'b111: Y = 8'b00000001;
			endcase
		else 
			Y = 4'b00000000;
	end
endmodule

module regn(R, Rin, Clock, Q);
	parameter n = 16;
	input [n-1:0] R;
	input Rin, Clock;
	output [n-1:0] Q;
	reg [n-1:0] Q;

	always @(posedge Clock)
	 	if (Rin)
			Q <= R;
endmodule

