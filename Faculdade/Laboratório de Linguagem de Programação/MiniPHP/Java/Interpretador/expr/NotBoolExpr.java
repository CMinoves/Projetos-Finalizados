package Interpretador.expr;

public class NotBoolExpr extends BoolExpr{
	private BoolExpr termo;

	public NotBoolExpr(int line, BoolExpr termo){
		super(line);
		this.termo = termo;
	}

	public boolean expr() {

	}
}
