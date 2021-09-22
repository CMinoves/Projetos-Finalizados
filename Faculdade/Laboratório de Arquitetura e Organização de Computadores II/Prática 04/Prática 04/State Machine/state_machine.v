module state_machine(acao, escrita,writeback, clock);//snoop
input clock;
input [1:0] acao; //simboliza a entrada via CDB
/*
00 - Read Miss
01 - Read hit
10 - Write miss
11 - write hit
*/
output reg [1:0] escrita;//simboliza a saida do CDB
/*
00 - read miss on bus
01 - invalidate on bus
10 - write miss on bus
11 - Null on bus
*/

output reg writeback;//simboliza a saida do CDB
/*
0 - Sem writeback
1 - com writeback
*/

reg [1:0] estado;
/*
00 - invalid
01 - shared
10 - exclusive
*/

always @(posedge clock) begin
	writeback = 1'b0;
	escrita = 2'b11;
	case(estado)
		2'b00: begin//invalid
				case (acao)
					2'b00: begin//read miss
						estado = 2'b01;
						escrita = 2'b00;
					end
					2'b10: begin//write miss
						estado = 2'b10;
						escrita = 2'b10;
					end
				endcase
			end
		2'b01: begin //shared
				case(acao)
					2'b00://read miss
					begin
						estado = 2'b01;
						escrita = 2'b00;
					end
					2'b01://read hit
						estado = 2'b01;
					2'b10: //write miss
					begin
						estado = 2'b10;
						escrita = 2'b10;
					end
					2'b11: //write hit
					begin
						estado = 2'b10;
						escrita = 2'b01;
					end
				endcase
			end
			
		2'b10: begin//exclusive
			case(acao)
				2'b00:begin //read miss
					estado = 2'b01;
					writeback = 1'b1;
					escrita = 2'b00;
				end
				2'b10: begin//write miss
					escrita = 2'b10;
					writeback = 1'b1;
					estado = 2'b10;
				end
				2'b01://read hit
						estado = 2'b10;
				2'b11://write hit
					estado = 2'b10;
				
			endcase
		end
		default
			estado = 2'b00;//invalid
	endcase
end
endmodule
