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
		//Maze m = (Maze) model;
		//Maze newM = new Maze();
		if(model != null && model instanceof Maze) 
		{
			model = new Maze();
			model.changed();
		}
	}
	

}
