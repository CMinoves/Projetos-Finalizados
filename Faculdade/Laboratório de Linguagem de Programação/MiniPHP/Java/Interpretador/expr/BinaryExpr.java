package Interpretador.expr;

public class BinaryExpr extends Expr{

	private Expr left;
	private BinaryOp op;
	private Expr right;

	public BinaryExpr(int linha, Expr left, BinaryOp op, Expr right){
		super(linha);
		this.left = left;
		this.op = op;
		this.right = right;
	}

	public int expr(){
		int numE = left.expr();
		int numD = right.expr();
		switch(op){
			case ADC: return (numE+numD);
			case SUB: return (numE-numD);
			case DIV: int numInt = numE/numD; return (numInt);
			case MUL: return (numE*numD);
			case CON: String num = numE+""+numD; return Integer.parseInt(num);
			case RES:
			default: return (numE%numD);
		}
	}

}
