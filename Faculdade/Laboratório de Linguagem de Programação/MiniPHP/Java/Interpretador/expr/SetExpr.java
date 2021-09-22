package Interpretador.expr;
import Interpretador.value.*;
public abstract class SetExpr extends Expr{

	private int linha;

	protected SetExpr(int linha){
		super(linha);
		this.linha = linha;
	}

	public abstract Value<?> expr();

	abstract void setExpr(Value<?> valor);

}
