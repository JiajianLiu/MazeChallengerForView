package presentation;


import business.Maze;
import framework.Command;
import framework.Model;

public class Reset extends Command {
	
	public Reset(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		if(model != null && model instanceof Maze) 
		{
			// cast model to Maze
			Maze maze = (Maze) model;
			System.out.println("reached Reset.execute()");
			this.model.copy(maze); // change model.copy(m);
			
		}
	}

}