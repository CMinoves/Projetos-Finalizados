package interpretador.expr;
import Interpretador.value.*;

public class VarVarExpr extends SetExpr {

	private Expr varvar;

	public VarVarExpr(int line, Expr varvar){
		super(line);
		this.varvar = varvar;
	}

	public Value<?> expr(){

	}

	public void setExpr(Value<?> valor){

	}
}
