module registrador(dado, clock, habilitaEscrita, out);
  input [31:0]dado;
  input clock, habilitaEscrita;
  output reg [31:0]out;
  initial out = 0;
  
  always@(posedge clock)begin
    if(habilitaEscrita)begin
      out = dado;
    end
  end
endmodule
  
