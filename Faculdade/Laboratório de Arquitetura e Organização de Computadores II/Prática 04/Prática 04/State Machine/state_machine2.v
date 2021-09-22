module state_machine2(acao, writeback, clock, abort);//snoop
input clock;
input [1:0] acao; //simboliza a entrada via CDB
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

output reg abort;
/*
0 - não aborta o acesso(padrão)
1 - aborta o acesso
*/
reg [1:0] estado;
/*
00 - invalid
01 - shared
10 - exclusive
*/

always @(posedge clock) begin
	writeback = 1'b0;
	abort = 1'b0;
	case(estado)
		2'b01: begin//shared
			case(acao)
				2'b10: begin//write miss
					estado = 2'b00;
				end
				2'b00://read miss
					estado = 2'b01;
				2'b01://invalidate
					estado = 2'b00;
			endcase
		end
		2'b10: begin //exclusive
			case(acao)
				2'b10: begin//write miss
					estado = 2'b00;
					writeback = 1'b1;
					abort = 1'b1;
				end
				2'b00: begin//read miss
					estado = 2'b01;
					writeback = 1'b1;
					abort = 1'b1;
				end
			endcase
		end
		 2'b00://forçando a ficar no invalido
			estado = 2'b00;
		default
			estado = 2'b10;//exclusive
	endcase
end

endmodule
