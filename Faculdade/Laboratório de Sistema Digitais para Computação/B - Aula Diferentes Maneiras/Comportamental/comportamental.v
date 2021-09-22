module comportamental(a,b,c,s);
input a,b,c;
output s;
reg s;

always@(a or b or c)
	begin
		case({a,b,c})
		3'b000 : s = 1'b1;
		3'b001 : s = 1'b1;
		3'b010 : s = 1'b0;
		3'b011 : s = 1'b0;
		3'b100 : s = 1'b0;
		3'b101 : s = 1'b1;
		3'b110 : s = 1'b1;
		3'b111 : s = 1'b0;
		endcase
	end
	
endmodule
