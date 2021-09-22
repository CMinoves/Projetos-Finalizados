module Somador1bit(n1,n2,te,r,ts);
	input n1,n2,te;
	output r,ts;
	
	assign r = n1^n2^te;
	
	assign ts = (n1&n2) |(n1&te)|(n2&te);
endmodule
