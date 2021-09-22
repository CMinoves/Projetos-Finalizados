package interpretador.expr;
import java.util.Map;
import java.util.HashMap;

public class Variable extends Expr{

	private String nome;
	private int valor;
	private static Map<String, Variable> variavel;

	static{
		variavel = new HashMap<String, Variable>();
	}

	private Variable(String nome){
		super(-1);
		this.nome = nome;
		this.valor = 0;
	}

	public static Variable instance(String nome){
		Variable var = variavel.get(nome);
		if(var == null){
			var = new Variable(nome);
			variavel.put(nome, var);
		}

		return var;
	}

	public int expr(){
		return valor;
	}

	public String getName(){
		return nome;
	}

	public void setExpr(int valor){
		this.valor = valor;
	}



}
