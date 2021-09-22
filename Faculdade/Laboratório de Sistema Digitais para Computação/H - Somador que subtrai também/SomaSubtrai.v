//Nome: Cristhian Sala Minoves
//Data: 17/05/2019

module SomaSubtrai(n1,n2,tr0,disp1,disp2);

	input [3:0] n1;
	input tr0;
	input [3:0] n2;
	wire[4:0] r;
	wire[0:4] ts;
	output [0:6] disp1;
	output [0:6] disp2;
	wire [4:0] newn2;
	//realizando o complemento de 2 quando tr0 = 1
	assign newn2[0] = n2[0]^tr0;
	assign newn2[1] = n2[1]^tr0;
	assign newn2[2] = n2[2]^tr0;
	assign newn2[3] = n2[3]^tr0;
		
	//realizando as somas bit a bit
	
	Somador1bit s0(n1[0],newn2[0],tr0,r[0],ts[0]);
	Somador1bit s1(n1[1],newn2[1],ts[0],r[1],ts[1]);
	Somador1bit s2(n1[2],newn2[2],ts[1],r[2],ts[2]);
	Somador1bit s3(n1[3],newn2[3],ts[2],r[3],ts[3]);
	Somador1bit bitsinal(0,tr0,ts[3],r[4],ts[4]);
	//variáveis auxiliares
	
	wire [3:0] dez;
	wire [3:0] uni;
	
	//separando em unidade e dezena para mostrar no display de 7 segmentos
	
	assign dez = (r/10);
	assign uni = (r%10);
	
	//escrevendo no display de 7 segmentos
	
	BCDComportamental unidade({uni},disp1);
	BCDComportamental dezena({dez},disp2);

endmodule
