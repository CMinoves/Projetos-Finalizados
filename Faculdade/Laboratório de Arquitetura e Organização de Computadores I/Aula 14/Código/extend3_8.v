module extend3_8(entrada,saida);
  input [2:0]entrada;
  output reg [7:0]saida;
      assign saida = entrada;
      assign saida[3] = 0;
      assign saida[4] = 0; 
      assign saida[5] = 0; 
      assign saida[6] = 0; 
      assign saida[7] = 0; 
endmodule
