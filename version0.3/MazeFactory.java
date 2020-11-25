package presentation;

import business.Maze;
import framework.Command;
import framework.Model;
/*
 * History
 * 11/06 jiajian Liu modified on the codes of BrickFactory
 * 
 */
public class MazeFactory {
	
	public Model makeModel() { return new Maze(); }
	  public String[] getEditCommands() {
	     return new String[] { "Move East", "Move West", "Move South", "Move North", "Reset"};
	  }
	  public Command makeEditCommand(Model model, String type) {
		  Command c = new MoveEast(model);
	     if (type == "Move East") 
	    	 c = new MoveEast(model);
	     if (type == "Move West") 
	    	 c = new MoveWest(model);
	     if (type == "Move South") 
	    	 c = new MoveSouth(model);
	     if (type == "Move North") 
	    	 c = new MoveNorth(model);
	     if (type == "Reset") 
	    	 c = new Reset(model);
		return c;
	     
	  }
	  public String getTitle() { return "Maze Challenger"; }
	  // etc.
	}

