package presentation;
import java.awt.event.ActionListener;


import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;
import framework.Utilities;

public class MazeFactory implements AppFactory {

	@Override
	public Model makeModel() {
		Maze m = new Maze();
		return m;
	}

	@Override
	public AppPanel makePanel(Model model, ActionListener listener) {
		
		AppPanel mp = new AppPanel(model, listener);
		if (model instanceof Maze)
		{
			mp = new MazePanel((Maze)model, listener);
		}
		
		return mp;
	}

	public String[] getEditCommands() {
	     return new String[] { "East", "West", "South", "North", "Reset"};
	  }
	
	public Command makeEditCommand(Model model, String type) {
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
	  * change title to that save file when open a save file or make title Maze Challenger
	  */
	  public String getTitle() { 
		  if(Utilities.fName!="" && Utilities.fName !=null) {
			  System.out.println(Utilities.fName);
			  return  Utilities.fName.toString();
		  }
		  else if(Utilities.fName==null)
			  return Utilities.preFileName.toString();
		  return "Maze Challenger"; 
		  }
	  // etc.
	

	@Override
	public String[] getHelp() {
		// TODO Auto-generated method stub
		String[] helps = new String[2];
		
		helps[0] = "About";
		helps[1] = "Content";
		return helps;
	}

	@Override
	public String about() {
		// TODO Auto-generated method stub
		String about = "Maze Challenger version 1.0 by Group Manatee @ 2019";
		return about;
	}
	
	public String content() {
		// TODO Auto-generated method stub
		String content = "Locate the escape room in number of alloted moves";
		return content;
	}


}