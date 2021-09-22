//Nome: Cristhian Sala Minoves
//Data: 11/04/2019
module decodificadorMARAvilhoso(a,b,c,d,l1,l2,l3,l4,l5,l6,l7);

	input a,b,c,d;
	output l1,l2,l3,l4,l5,l6,l7;
	
	assign l1 = ~a&~b&~c&d || b&~c&~d;
	assign l2 = b&~c&d || b&c&~d;
	assign l3 = ~b&c&~d;
	assign l4 = b&~c&~d || ~a&~b&~c&d || b&c&d;
	assign l5 = d || b&~c;
	assign l6 = c&d || ~a&~b&d || ~a&~b&c;
	assign l7 = ~a&~b&~c || b&c&d;
	
endmodule
