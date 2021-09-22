module state_machine2(acao, escrita, clock, dataWriteBack, dataValueReply,sharers);//dir
input clock;
input [1:0] acao; //simboliza a entrada
/*
00 - read miss
01 - read hit
10 - Data Writeback
11 - write miss
*/
output reg [1:0] escrita;//simboliza a saida
/*
00 - valor nulo
01 - invalidate
10 - fetch
11 - fetch invalidate
*/
output reg [1:0] sharers;
/*
00 - Nulo
01 - sharers = {}
10 - sharers = {p}
11 - Sharers = sharers + {p}
*/
reg [1:0] estado;
/*
00 - uncached
01 - shared
10 - exclusive
*/
input dataWriteBack;
/*
0 - sem writeback
1 - com writeback
*/
output reg dataValueReply;

always @(posedge clock) begin
	escrita = 2'b00;
	sharers = 2'b00;
	dataValueReply = 1'b0;
	case(estado)
		2'b00: begin//uncached
				case (acao)
					2'b00://read miss
						begin
							estado = 2'b01;
							dataValueReply = 1'b1;
							sharers = 2'b10;
						end
					2'b11://write miss
						begin
							estado = 2'b10;
							dataValueReply = 1'b1;
							sharers = 2'b10;
						end
				endcase
			end
		2'b01: begin //shared
				case(acao)
					2'b00://read miss
						begin
							estado = 2'b01;
							sharers = 2'b11;
							dataValueReply = 1'b1;
						end
					2'b11://write miss
						begin
							estado = 2'b10;
							escrita = 2'b01;
							dataValueReply = 1'b1;
							sharers = 2'b10;
						end
				endcase
			end
		2'b10: begin//exclusive
			case(acao)
				2'b11://write miss
					begin
						estado = 2'b10;
						dataValueReply = 1'b1;
						sharers = 2'b10;
						escrita = 2'b11;
					end
				2'b00: //read miss
					begin
						estado = 2'b01;
						dataValueReply = 1'b1;
						sharers = 2'b11;
						escrita = 2'b10;
					end
				2'b10://data writeback
					begin
						estado = 2'b00;
						sharers = 2'b01;
					end
			endcase
		end
		default
		estado = 2'b00;
	endcase
end
endmodule
