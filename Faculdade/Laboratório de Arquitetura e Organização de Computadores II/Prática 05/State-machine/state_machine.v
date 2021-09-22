module state_machine(acao, escrita, clock, dataWriteBack);//dir
input clock;
input [2:0] acao; //simboliza a entrada
/*
000 - read miss
001 - read hit
010 - write hit
011 - invalidate
100 - write miss
101 - fetch
110 - fetch invalidate
*/
output reg [2:0] escrita;//simboliza a saida
/*
000 - read miss
001 - read hit
010 - write hit
011 - invalidate
100 - write miss
101 - fetch
110 - fetch invalidate
111 - mensagem vazia
*/
reg [1:0] estado;
/*
00 - invalid
01 - shared
10 - modified
*/

output reg dataWriteBack;
/*
0 - sem writeback
1 - com writeback
*/

always @(posedge clock) begin
	dataWriteBack = 1'b0;
	escrita = 3'b111;
	case(estado)
		2'b00: begin//invalid
				case (acao)
					3'b000://read miss
					begin
						estado = 2'b01;
						escrita = 3'b000;
					end
					3'b100: //write miss
					begin
						estado = 2'b10;
						escrita = 3'b100;
					end
				endcase
			end
		2'b01: begin //shared
				case(acao)
					3'b000://read miss
						escrita = 3'b000;
					3'b010: //write hit
					begin
						estado = 2'b10;
						escrita = 3'b011;
					end
					3'b001://read hit
						estado = 2'b01;
					3'b100://write miss
						begin
							estado = 2'b10;
							escrita = 3'b100;
						end
					3'b011://invalidate
						estado = 2'b00;
				endcase
			end
		2'b10: begin//modified
			case(acao)
				3'b101://fetch
				begin
					estado = 2'b01;
					dataWriteBack = 1'b1;
				end
				3'b000://read miss
				begin
					estado = 2'b01;
					dataWriteBack = 1'b1;
					escrita = 3'b000;
				end
				3'b110://fetch invalidate
				begin
					estado = 2'b00;
					dataWriteBack = 1'b1;
				end
				3'b100://write miss
				begin
					estado = 2'b10;
					dataWriteBack = 1'b1;
					escrita = 3'b100;
				end
				3'b001://read hit
						estado = 2'b10;
				3'b010://write hit
						estado = 2'b10;
			endcase
		end
		default
			estado = 2'b10;//modified
	endcase
end
endmodule
