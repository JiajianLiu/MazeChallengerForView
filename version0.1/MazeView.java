package presentation;

import java.awt.Graphics;

import business.Maze;
import framework.Model;
import framework.View;


public class MazeView extends View{
	private Room[][] rooms;
	
	public MazeView(Model model) {
		super(model);
		if(model != null && model instanceof Maze) {
			Maze maze = (Maze) model;
			this.rooms= new Room[(int) maze.getRow()][(int) maze.getColonm()];
		}
	}
	
	
	public void paintComponent(Graphics gc) {
		if(model !=null && model instanceof Maze) {
			Maze maze = (Maze) model;
			// draw
		}
	}
	
}
