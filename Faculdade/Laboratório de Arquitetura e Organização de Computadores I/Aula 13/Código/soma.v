module soma(v1,v2,saida);
input [31:0] v1,v2;
output reg [31:0] saida;

always@(v1,v2,saida) begin
	saida <=v1+v2;
end
endmodule
