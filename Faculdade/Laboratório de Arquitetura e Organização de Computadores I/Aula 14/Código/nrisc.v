module nrisc;
wire clock;
//instanciando o PC
wire [7:0] pcIn, pcOut;

pc1 pc(clock,pcin,pcout);
//instanciando o controle
wire [3:0] op;
wire dist, EscMEM,LerMEM,Ji,RegFonte,LerMEMDaqui,ULAFonte,EscReg;

Controle controle(op, dist,EscPC, EscMEM,LerMEM,Ji,RegFonte,LerMEMDaqui,ULAFonte,EscReg);
//instanciando a memoria de instruçao
wire [7:0] Instoutput;
Memoria_Inst instructionsMemory (pcOut, Clock, Instoutput);
//instanciando o banco de registradores
wire [1:0] Read1;
assign Read1[1] = Instoutput[2];
assign Read1[0] = Instoutput[1];
wire [1:0] Read2;
assign Read2[1] = Instoutput[4];
assign Read2[0] = Instoutput[3];
wire [1:0] WriteReg;
assign WriteReg[1] = Instoutput[4];
assign WriteReg[0] = Instoutput[3];
wire [7:0] Data1;
wire [7:0] Data2;
wire [7:0] WriteData;
BancoReg bancoReg(Read1, Read2, WriteReg, WriteData, EscReg, Data1, Data2, clock);
//instanciando o extensor de sinal 3_8
wire [2:0] entrada3;
assign entrada3[2] = Instoutput[2];
assign entrada3[1] = Instoutput[1];
assign entrada3[0] = Instoutput[0];
wire [7:0] saida3;
Extensor3_8 extend3_8(entrada3, saida3);
//instanciando o mux do registrador
wire [7:0]PreULAResult;
MuxPreULA mux(saida3,Data2,ULAFonte, PreULAResult);
//instanciando o controle da ULA
wire [2:0]cod;
assign cod[2] = INStoutput[7];
assign cod[1] = INStoutput[6];
assign cod[0] = INStoutput[5];
wire dist;
assign dist = INStoutput[0];
wire [2:0] ALUCtl;
ControleULA ALUControl(cod,dist,ALUCtl);
//instanciando a ULA
wire Zero;
wire [7:0] ALUOut;
nUla ula(ALUctl, Data1, Data2,ALUOut, Zero);

//iniciando o mux para o lfh
wire [7:0] PreMem;
muxLFH mux(Data2,Data1,LerMEMDaqui,PreMEM);
//instanciando a memoria de dados
wire [7:0] MemOut
Memoria_Dados mainMemory (PreMEM, Data1, wr_en, rd_en, Clock, MemOut);
//instanciando o mux da ULA
muxPosULA mux(ALUOut,MemOut,RegFonte,PreMEM);
//instanciando o primeiro mux do branch
wire [7:0] nulo;
assign nulo[0] = 0;
assign nulo[1] = 0;
assign nulo[2] = 0;
assign nulo[3] = 0;
assign nulo[4] = 0;
assign nulo[5] = 0;
assign nulo[6] = 0;
assign nulo[7] = 0;
wire [7:0] PosBranch;
muxPosBranch mux(nulo,saida3,Zero,PosBranch);
//instanciando o extensor 5_8
wire [4:0]entrada5;
assign entrada5[0] = Instoutput[0];
assign entrada5[1] = Instoutput[1];
assign entrada5[2] = Instoutput[2];
assign entrada5[3] = Instoutput[3];
wire [7:0]saida5;
Extensor5_8 extend5_8(entrada5,saida5);
//instanciando o segundo mux do branch
wire [7:0] PreSoma;
MuxPosExtensor mux(PosBranch,saida5,Ji,PreSoma);
//instanciando a primeira soma
wire [7:0]oito;
assign oito = 8;
wire [7:0]saidaSomaPc;
somaPC soma(Pcout,oito,saidaSomaPc);
//instanciando a soma do branch
wire [7:0]saidaSomaBranch;
somaBranch soma(saidaSomaPc,PreSoma,saidaSomaBranch);

endmodule
