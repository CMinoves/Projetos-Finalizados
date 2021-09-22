module fluxo_dados(a,b,c,S);
input a,b,c;
output S;

assign S = (~a&~b&~c || ~a&~b&c || a&~b&c || a&b&~c);


endmodule
