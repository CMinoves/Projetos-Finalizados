module instructionsMemory (address, Clock, q);
input [7:0] address; 
//input [7:0] data;
input Clock;
output [7:0] q;

//256 slots de memoria, de 00 at� ef
reg [7:0] Mem [0:255];

initial 
begin
  //Coloque o seu programa nas posi��es de mem�ria 
  //////////////////////////////////////////////////
  Mem[32'h0] = 8'b11100111;	//set $s0 8
  Mem[32'h1] = 8'b11101001;  	//set $s1 1
  Mem[32'h2] = 8'b11000001;  	//cnt $s0 1  
//	...
end

assign q = Mem[address];

endmodule