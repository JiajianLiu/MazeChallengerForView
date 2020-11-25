package framework;

import business.Maze;

public class CommandProcessor {
	
	public static Model copy;
	public CommandProcessor()
	{
		this.copy= new Maze();
	}
	public static void execute(Command cmmd) {
		//copy = cmmd.model;
		cmmd.execute();
	}
	
	public static void redo() {
		
	}
	public static void undo() {
		
	}
	
//	public static void main(String[] args)
//	{
//		CommandProcessor cm = new CommandProcessor();
//		Maze m = new Maze();
//		cm.execute(new MoveEast());
//	}
	
}
