package Interpretador.expr;

public class SingleBoolExpr extends BoolExpr{
	private Expr left;
	private RelOp op;
	private Expr right;

	public SingleBoolExpr(int line, Expr left, RelOp op, Expr right){
		super(line);
		this.left = left;
		this.op = op;
		this.right = right;
	}

	public boolean expr(){

	}
}
