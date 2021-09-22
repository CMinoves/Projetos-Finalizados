module memoria(clock, entrada, writeback, tag, saida, confirma);
input clock;
input writeback;
input [3:0] entrada;
input [2:0] tag;
reg [4:0] mem1, mem2, mem3, mem4, mem5, mem6,mem7;
output reg [3:0]saida;
output reg confirma;
/*
	tag1 = 3'b000;
	tag2 = 3'b001;
	tag3 = 3'b010;
	tag4 = 3'b011;
	tag5 = 3'b100;
	tag6 = 3'b101;
	tag7 = 3'b110;
*/

initial begin//valores iniciais
	mem1 = 5'b01010;
	mem2 = 5'b01000;
	mem3 = 5'b01010;
	mem4 = 5'b10010;
	mem5 = 5'b10100;
	mem6 = 5'b11100;
	mem7 = 5'b11110;
end

always @(posedge clock)begin
confirma = 1'b0;//colocando 0 para que a saida seja inválida, pois ainda não teve processamento
if(writeback)begin//fazendo o writeback e alterando o valor na memória
	case(tag)
		3'b000: begin
			mem1 = entrada;
		end
		3'b001: begin
			mem2 = entrada;
		end
		3'b010: begin
			mem3 = entrada;
		end
		3'b011: begin
			mem4 = entrada;
		end
		3'b100: begin
			mem5 = entrada;
		end
		3'b101: begin
			mem6 = entrada;
		end
		3'b110: begin
			mem7 = entrada;
		end
	endcase
end else begin
	case(tag)//sem fazer wb = fazendo leitura
		3'b000: begin
			confirma = 1'b1;
			saida = mem1;
		end
		3'b001: begin
			confirma = 1'b1;
			saida = mem2;
		end
		3'b010: begin
			confirma = 1'b1;
			saida = mem3;
		end
		3'b011: begin
			confirma = 1'b1;
			saida = mem4;
		end
		3'b100: begin
			confirma = 1'b1;
			saida = mem5;
		end
		3'b101: begin
			confirma = 1'b1;
			saida = mem6;
		end
		3'b110: begin
			confirma = 1'b1;
			saida = mem7;
		end
	endcase
end

end

endmodule
