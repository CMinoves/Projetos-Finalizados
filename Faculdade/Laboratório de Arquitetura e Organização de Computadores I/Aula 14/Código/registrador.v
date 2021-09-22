module registrador(dado, clock, habilitaEscrita, out);
  input [7:0]dado;
  input clock, habilitaEscrita;
  output reg [7:0]out;
  initial out = 0;
  
  always@(posedge clock)begin
    if(habilitaEscrita)begin
      out = dado;
    end
  end
endmodule
  
