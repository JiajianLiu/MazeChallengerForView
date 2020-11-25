package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;

public class MoveSouth extends Command{

	private Heading heading;
	public MoveSouth(Model maze) {
		this(maze, null);
	}
	public MoveSouth(Model maze, Heading heading) {
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	
	@Override // where to throw the exception???????????????
	public void execute() {
		if(model != null && model instanceof Maze) 
		{
			Maze maze = (Maze) model;
			if(this.heading == null) 
			{
				this.heading = Heading.SOUTH;
			}
			maze.move(heading);
		}
		
	}


}
