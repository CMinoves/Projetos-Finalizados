package Interpretador.command;
import Interpretador.expr.*;
public class IfCommand extends Command {
	private BoolExpr cond;
	private Command thencmds;
	private Command elsecmds;

	public IfCommand(int line, Command thencmds, Command elsecmds){
		super(line);
		this.elsecmds = elsecmds;
		this.thencmds = thencmds;
	}

	private void addElseCommand(Command elsecmds){
		this.elsecmds = elsecmds;
	}

	public void execute(){
		if(cond.expr()){
			thencmds.execute();
		}else{
			elsecmds.execute();
		}
	}
}
