package Interpretador.expr;

public class CompositeBoolExpr extends BoolExpr{
	private BoolExpr left;
	private RelOp op;
	private BoolExpr right;

	public CompositeBoolExpr(int line, BoolExpr left, RelOp op, BoolExpr right){
		super(line);
		this.left = left;
		this.op = op;
		this.right = right;
	}

	public boolean expr(){

	}
}
