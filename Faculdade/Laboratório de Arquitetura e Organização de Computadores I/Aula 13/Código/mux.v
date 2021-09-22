module mux(v0,v1,ctrl, result);
input vo,v1,ctrl;
output reg result;
always @(ctrl, v0, v1) begin //reevaluate if these change
case (ALUctl)
	0: result = v0;
	1: result = v1;
endcase
end
endmodule
