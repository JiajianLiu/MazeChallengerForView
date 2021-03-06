package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;

public class MoveEast extends Command{
	private Heading heading;
	public MoveEast(Maze maze) {
		this(maze, null);
	}
	public MoveEast(Maze maze, Heading heading) {
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	public MoveEast(Model model) {
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
				this.heading = Heading.EAST;
			}
			maze.move(heading);
		}
		
	}

}
