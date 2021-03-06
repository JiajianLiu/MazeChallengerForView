package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;

public class MoveWest extends Command{

	private Heading heading;
	public MoveWest(Maze maze) {
		this(maze, null);
	}
	public MoveWest(Maze maze, Heading heading) {
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	public MoveWest(Model model) {
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
				this.heading = Heading.WEST;
			}
			maze.move(heading);
		}
		
	}


}
