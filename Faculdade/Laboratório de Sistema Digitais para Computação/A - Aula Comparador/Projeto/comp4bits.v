module comp4bits(x,y,ma,me,ig);
//compara X em relação a Y
input [3:0] x, y;
output ma,me,ig;
//variáveis intermediárias
wire [3:0] aux_ig,aux_ma,aux_me;
comp1bit bloco3(x[3],y[3],1,aux_ma[3],aux_me[3],aux_ig[3]);
comp1bit bloco2(x[2],y[2],aux_ig[3],aux_ma[2],aux_me[2],aux_ig[2]);
comp1bit bloco1(x[1],y[1],aux_ig[2],aux_ma[1],aux_me[1],aux_ig[1]);
comp1bit bloco0(x[0],y[0],aux_ig[1],aux_ma[0],aux_me[0],aux_ig[0]);
assign ig = aux_ig[0];
assign ma = | aux_ma;
assign me = | aux_me;
endmodule

//comp1bit(a,b,hab,ma,me,ig)