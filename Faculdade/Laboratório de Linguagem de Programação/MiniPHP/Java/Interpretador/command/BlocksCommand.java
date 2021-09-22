package Interpretador.command;

import java.util.ArrayList;
import java.util.List;

public class BlocksCommand extends Command{
	private List<Command> cmds;

	public BlocksCommand(int line){
		super(line);
		cmds = new ArrayList<Command>();
	}

	public void addCommand(Command cmd){
		this.cmds.add(cmd);
	}

	public void execute() {
		for (Command cmd : cmds)
            cmd.execute();

	}
}
