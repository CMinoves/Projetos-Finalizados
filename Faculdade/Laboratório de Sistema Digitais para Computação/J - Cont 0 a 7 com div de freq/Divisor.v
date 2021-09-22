//Nome: Cristhian Sala Minoves
//Data: 13/06/2019

module Divisor(clock,reset,num);
	input clock;
	input reset;
	reg [22:0] n;
	output reg num;
	always@(posedge clock, posedge reset)
	begin
		if(reset)
			n = 0;
		else
			n = n+1;
		num = n[22];
	end
endmodule
