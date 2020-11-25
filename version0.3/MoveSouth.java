package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;

public class MoveSouth extends Command{

	private Heading heading;
	public MoveSouth(Maze maze) {
		this(maze, null);
	}
	public MoveSouth(Maze maze, Heading heading) {
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	public MoveSouth(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
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
