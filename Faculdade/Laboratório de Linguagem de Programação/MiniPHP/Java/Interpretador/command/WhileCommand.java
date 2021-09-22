package Interpretador.command;
import Interpretador.expr.BoolExpr;
import Interpretador.expr.*;

public class WhileCommand extends Command{
	private BoolExpr cond;
	private Command cmds;

	WhileCommand(int line, BoolExpr cond, Command cmds){
		super(line);
		this.cond = cond;
		this.cmds = cmds;
	}

	public void execute(){

	}
}
