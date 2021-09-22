module ALUControl(FuncCode,dist,ALUCtl);
input [2:0]FuncCode;
input dist;
output [3:0]reg ALUCtl;
always case (FuncCode)
	3'b000: begin
		if(dist == 1)begin
			ALUCtl<=1; //hlf
		end
		else begin
			ALUCtl<=2; //lfh
		end
	end
	3'b001: ALUCtl<=3; //bne
	3'b011: ALUCtl<=4; // lw
	3'b100: ALUCtl<=5; // sw
	3'b101: ALUCtl<=6; //beq
	3'b110: ALUCtl<=7; //cnt
	3'b111: ALUCtl<=8; //set
default: ALUCtl<=15; // should not happen
endcase
endmodule