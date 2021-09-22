package Interpretador.command;
import Interpretador.expr.*;
public class AssignCmd extends Command {
	private Expr left;
	private AssignOp op;
	private Expr right;

	public AssignCmd(int line, Expr left, AssignOp op, Expr right){
		super(line);
		this.left = left;
		this.op = op;
		this.right = right;
	}

	public void execute(){

	}
}
