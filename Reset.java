package presentation;

/**
 * jiajian liu worked on Nov 3

 */
import business.Maze;

import framework.Command;
import framework.Model;
import framework.Utilities;

public class Reset extends Command 
{	
	public Reset(Model model) 
	{
		super(model);
	}

	@Override
	public void execute() 
	{	
		if(model != null && model instanceof Maze) 
		{
			// cast model to Maze
			Utilities.reset = true;
			Maze maze = (Maze) model;
			Maze newMaze = new Maze();
			maze.copy(newMaze);
			MazePanel.enableButton(true);

		}
	}

}
