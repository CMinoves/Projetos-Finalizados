module Mex2 (clock,data,rdaddress,wraddress,wren,q);
	input	  clock;
	input	[7:0]  data;
	input	[4:0]  rdaddress;
	input	[4:0]  wraddress;
	input	  wren;
	output	[7:0]  q;
	Ex2 mem (clock,data,rdaddress,wraddress,wren,q);
endmodule
