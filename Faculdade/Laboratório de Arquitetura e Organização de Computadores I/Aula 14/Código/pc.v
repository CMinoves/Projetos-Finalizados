module pc(clock,pcin,pcout);
input [7:0] pcin;
output reg[7:0] pcout;
input clock;

always@(posedge clock) begin
	pcout <=pcin;
end
endmodule
