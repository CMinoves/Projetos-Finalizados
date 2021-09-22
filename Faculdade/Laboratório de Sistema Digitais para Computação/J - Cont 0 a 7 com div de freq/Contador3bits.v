//Nome: Cristhian Sala Minoves
//Data: 13/06/2019

module Contador3bits(CLOCK_50,reset,led);
	output [1:7] led;
	input CLOCK_50;
	wire clock;
	input reset;
	reg [2:0] num;
	Divisor Div(CLOCK_50,reset,clock);
	always@(posedge clock, posedge reset)
	begin
		if(reset)
			num = 0;
		else
			num = num+1;
	end
	decodificadorMARAvilhoso(0,num[2],num[1],num[0],led[1],led[2],led[3],led[4],led[5],led[6],led[7]);
endmodule
