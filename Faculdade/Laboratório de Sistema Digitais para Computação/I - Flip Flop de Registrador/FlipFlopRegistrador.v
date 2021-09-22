module FlipFlopResgistrador(q3,q2,q1,q0,reset,clock,in);

input clock, reset, in;
output reg q3,q2,q1,q0;

always@(posedge clock or posedge reset)
begin
	if(reset)
	
	begin
		q3 <= 1'b0;
		q2 <= 1'b0;
		q1 <= 1'b0;
		q0 <= 1'b0;
	end
	
	else
	
	begin
		q3 <=in;
		q2 <=q3;
		q1 <=q2;
		q0 <=q1;
	end
	
end

endmodule
