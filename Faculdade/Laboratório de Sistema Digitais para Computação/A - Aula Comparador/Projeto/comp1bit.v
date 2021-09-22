module comp1bit(a,b,hab,ma,me,ig);
	input a, b,hab;
	output ma,me,ig;
	assign ig = hab & (a ~^b);
	assign ma = hab & (a& ~b); 
	assign me = hab & (~a & b);
endmodule
