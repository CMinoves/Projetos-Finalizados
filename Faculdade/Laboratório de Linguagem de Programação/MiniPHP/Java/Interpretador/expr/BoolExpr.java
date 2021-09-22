package Interpretador.expr;
import Interpretador.value.*;


public abstract class BoolExpr {
	private int line;

	protected BoolExpr(int line){
		this.line = line;
	}

	public int getLine(){
		return this.line;
	}

	public abstract boolean expr();
}
