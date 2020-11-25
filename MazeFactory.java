package presentation;

import java.awt.event.ActionListener;
import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;
import framework.Utilities;

/**
 * jiajian liu on Nov 5
 */
public class MazeFactory implements AppFactory 
{
	@Override
	public Model makeModel() 
	{
		Maze m = new Maze();
		return m;
	}

	@Override
	public AppPanel makePanel(Model model, ActionListener listener) 
	{
		
		AppPanel mp = new AppPanel(model, listener);
		if (model instanceof Maze)
		{
			mp = new MazePanel((Maze)model, listener);
		}
		return mp;
	}

	public String[] getEditCommands() 
	{
	     return new String[] { "East", "West", "South", "North", "Reset"};
	  }
	
	public Command makeEditCommand(Model model, String type) 
	{
		 Command c = new MoveEast(model);
	     if (type == "East") 
	    	 c = new MoveEast(model);
	     if (type == "West") 
	    	 c = new MoveWest(model);
	     if (type == "South") 
	    	 c = new MoveSouth(model);
	     if (type == "North") 
	    	 c = new MoveNorth(model);
	     if (type == "Reset") 
	    	 c = new Reset(model);
		return c;
	     
	  }
	
	 /**
	  * change title to that save file when open a save file or make title Maze Challenge
	  */
	  public String getTitle() 
	  { 
		  if(Utilities.fName!="" && Utilities.fName !=null) 
		  {
			  return "Maze Challenge located:"+ Utilities.fName;
		  }
		  return "Maze Challenge";
	  }	

	@Override
	public String[] getHelp() 
	{
		String[] helps = new String[2];
		helps[0] = "About";
		helps[1] = "Content";
		return helps;
	}

	@Override
	public String about() 
	{
		String about = "Maze Challenge version 1.0 by Group Manatee @ 2019";
		return about;
	}
	
	public String content() 
	{
		String content = "Locate the escape room in number of alloted moves";
		return content;
	}

	public String getDefaultTitle()
	{
		return "Maze Challenge";
	}

}