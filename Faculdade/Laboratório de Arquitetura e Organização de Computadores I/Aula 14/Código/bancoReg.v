module bancoReg(Read1, Read2, WriteReg, WriteData, RegWrite, Data1, Data2, clock);
  input [1:0]Read1;
  input [1:0]Read2;
  input [1:0]WriteReg;
  input [7:0]WriteData;
  input RegWrite, clock;
  output [7:0]Data1;
  output [7:0]Data2;
  reg [7:0]RF[31:0];
  
  initial 
begin
  
// Coloque o seu programa nas posi��es de mem�ria
  RF[5'h0] = 8'b0;
//	...
    
end
  assign Data1 = RF[Read1];
  assign Data2 = RF[Read2];
  
  always@(posedge clock)begin
    if(RegWrite)begin
      RF[WriteReg] <= WriteData;
    end
  end
endmodule
