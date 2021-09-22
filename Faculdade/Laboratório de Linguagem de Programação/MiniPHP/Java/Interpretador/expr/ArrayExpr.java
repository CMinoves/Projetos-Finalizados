package Interpretador.expr;
import java.util.HashMap;
import java.util.Map;
import Interpretador.value.*;
public class ArrayExpr extends Expr{
	public Map<Expr, Expr> array;

	public ArrayExpr(int line){
		super(line);
		array = new HashMap<Expr, Expr>();
	}

	public void insere(Expr key, Expr value){
		array.put(key, value);
	}

	public Value<?> expr(){

	}

}
