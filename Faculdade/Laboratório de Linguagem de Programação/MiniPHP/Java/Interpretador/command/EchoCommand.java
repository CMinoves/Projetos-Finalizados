package Interpretador.command;
import Interpretador.expr.Expr;

public class EchoCommand extends Command{
	private Expr expr;

	public EchoCommand(int line, Expr expr){
		super(line);
		this.expr = expr;
	}

	public void execute(){
		System.out.println(expr.expr());
	}
}
