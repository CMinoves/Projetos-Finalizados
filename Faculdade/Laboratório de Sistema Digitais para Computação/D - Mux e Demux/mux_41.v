module mux_41(l1,l2,l3,l4,a,b,S);

input l1,l2,l3,l4,a,b;
output S;

assign S = ~a&~b&l1 | ~a&b&l2 | a&~b&l3 | a&b&l4;



endmodule
