package Interpretador.command;
import Interpretador.expr.*;

public class ForeachCommand extends Command {
	private Expr expr;
	private Commmand cmds;
	private Variable key;
	private Variable value;

	public ForeachCommand(int line, Expr expr,Commmand cmds, Variable key, Variable value){
		super(line);
		this.expr = expr;
		this.cmds = cmds;
		this.key = key;
		this.value = value;
	}

	public void execute(){

	}
}
