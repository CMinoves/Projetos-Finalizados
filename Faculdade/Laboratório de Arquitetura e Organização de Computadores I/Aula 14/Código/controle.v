module controle(op, dist,EscPC, EscMEM,LerMEM,Ji,RegFonte,LerMEMDaqui,ULAFonte,EscReg);
input [3:0] op;
input dist;
output reg EscPC, EscMEM,LerMEM,Ji,RegFonte,LerMEMDaqui,ULAFonte,EscReg;

always case (op)
	3'b000: begin
		if(dist == 1)begin //hlf
			EscPC<=0;
			EscMEM<=0;
			LerMEM <= 0;
			Ji <= 0;
			RegFonte <= 0;
			LerMEMDaqui <= 0;
			EscReg <= 1;
		end
		else begin //lfh
			EscPC<=0;
			EscMEM<=0;
			LerMEM <= 0;
			Ji <= 0;
			RegFonte <= 1;
			LerMEMDaqui <= 1;
			EscReg <= 1;
		end
	end
	3'b001: begin//bne
		EscPC<=1;
		EscMEM<=0;
		LerMEM <= 0;
		Ji <= 0;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 0;
	end
	3'b010: begin //j
		EscPC<=1;
		EscMEM<=0;
		LerMEM <= 0;
		Ji <= 1;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 1;
	end
	3'b011: begin // lw
		EscPC<=0;
		EscMEM<=0;
		LerMEM <= 1;
		Ji <= 0;
		RegFonte <= 1;
		LerMEMDaqui <= 0;
		EscReg <= 1;
	end
	3'b100: begin // sw
		EscPC<=0;
		EscMEM<=1;
		LerMEM <= 0;
		Ji <= 0;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 0;
	end
	3'b101: begin //beq
		EscPC<=1;
		EscMEM<=0;
		LerMEM <= 0;
		Ji <= 0;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 0;
	end
	3'b110: begin //cnt
		EscPC<=0;
		EscMEM<=0;
		LerMEM <= 0;
		Ji <= 0;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 1;
	end
	3'b111: begin //set
		EscPC<=0;
		EscMEM<=0;
		LerMEM <= 0;
		Ji <= 0;
		RegFonte <= 0;
		LerMEMDaqui <= 0;
		EscReg <= 1;
	end
endcase
endmodule

