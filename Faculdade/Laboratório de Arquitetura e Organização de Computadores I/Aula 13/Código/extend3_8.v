module extend3_8(entrada, habBitSinal, saida);
  input [2:0]entrada;
  input habBitSinal;
  output reg [7:0]saida;
  
  always@(*)begin
    if(entrada[2]==0 || habBitSinal==0)begin
      saida = entrada;
    end
    else begin
      saida = entrada;
      saida[3] = 1;
      saida[4] = 1; 
      saida[5] = 1; 
      saida[6] = 1; 
      saida[7] = 1; 
    end
  end 
endmodule
