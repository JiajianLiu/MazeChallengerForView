package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;
import framework.Utilities;

public class MoveWest extends Command{

	private Heading heading;
	public MoveWest(Model maze) {
		this(maze, null);
	}
	public MoveWest(Model maze, Heading heading) {
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	
	@Override
	public void execute() {
		if(model != null && model instanceof Maze) 
		{
			Maze maze = (Maze) model;
			if(this.heading == null) 
			{
				this.heading = Heading.WEST;
			}
			maze.move(heading);
			
			if(maze.getPx() == maze.exitRoomX() && maze.getPy() == maze.exitRoomY())
			{
				System.out.println("successfully exit...");
				Utilities.inform("You have exited the Maze!");
			}
		}
		
	}


}