module mainMemory (addr, data, wr_en, rd_en, Clock, q);
input [7:0] addr; 
input [7:0] data;
input wr_en, rd_en, Clock;
output [7:0] q;

reg [7:0] Mem [0:31];

initial 
begin
  
// Coloque o seu programa nas posições de memória
  //valor do $zero = 0
  Mem[5'h0] = 8'b00000;
//	...
    
end

always @(posedge Clock)
begin
  if (wr_en) Mem[addr] = data;
  if(rd_en) q = Mem[addr];
end

endmodule