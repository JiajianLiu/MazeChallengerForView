package framework;


public class CommandProcessor {
	public static void execute(Command cmmd) {
		cmmd.execute();
	}
	
	public void redo() {
		
	}
	public void undo() {
		
	}
	
//	public static void main(String[] args)
//	{
//		CommandProcessor cm = new CommandProcessor();
//		Maze m = new Maze();
//		cm.execute(new MoveEast());
//	}
	
}
