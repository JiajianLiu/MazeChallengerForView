package presentation;

import business.Heading;
import business.Maze;
import framework.Command;
import framework.Model;
import framework.Utilities;

/**
 * jiajian liu worked on Nov 3
 * sumija modified execute() Nov 12
 */
public class MoveEast extends Command
{
	private Heading heading;
	
	public MoveEast(Model maze) 
	{
		this(maze, null);
	}
	public MoveEast(Model maze, Heading heading) 
	{
		super(maze); // command constructor accept Model type
		this.heading = heading;
	}
	
	@Override
	public void execute() 
	{
		if(model != null && model instanceof Maze) 
		{
			Maze maze = (Maze) model;
			if(this.heading == null) 
			{
				this.heading = Heading.EAST;
			}
			maze.move(heading);
			
			if(maze.getPx() == maze.exitRoomX() && maze.getPy() == maze.exitRoomY())
			{
				Utilities.inform("You have exited the Maze!");
			}
		}
		
	}

}