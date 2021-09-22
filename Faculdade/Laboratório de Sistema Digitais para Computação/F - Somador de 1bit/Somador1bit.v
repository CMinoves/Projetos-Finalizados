module Somador1bit(n1,n2,te,l1,l2,l3,l4,l5,l6,l7);
	input n1,n2,te;
	wire s,ts;
	wire a,b;
	assign a = 0;
	assign b = 0;
	output l1,l2,l3,l4,l5,l6,l7;
	
	assign c = n1^n2^te;
	assign d = n1&n2;
	
	decodificadorMARAvilhoso teste(0,0,c,d,l1,l2,l3,l4,l5,l6,l7);
	
	/*assign l1 = ~a&~b&~c&d || b&~c&~d;
	assign l2 = b&~c&d || b&c&~d;
	assign l3 = ~b&c&~d;
	assign l4 = b&~c&~d || ~a&~b&~c&d || b&c&d;
	assign l5 = d || b&~c;
	assign l6 = c&d || ~a&~b&d || ~a&~b&c;
	assign l7 = ~a&~b&~c || b&c&d;*/
endmodule
