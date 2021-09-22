package Interpretador.expr;
import Interpretador.value.*;
public class AcessExpr extends Expr{
	private Expr base;
	private Expr index;

	public AcessExpr(int line, Expr base, Expr index){
		super(line);
		this.base = base;
		this.index = index;
	}

	public Value<?> expr(){

	}
}
