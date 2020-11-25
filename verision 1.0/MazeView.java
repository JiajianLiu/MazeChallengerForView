package presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import business.Maze;
import framework.Model;
import framework.View;
/**
 * shuti wang, Nov 7, modified Nov 8. modified Nov 11
 */

public class MazeView extends View{
	private int[][] rooms;
	private boolean isExitRoom;

	/**
	 * constructor: set the room 
	 * @param model
	 */
	public MazeView(Model model) {
		super(model);
		if(model != null && model instanceof Maze) {
			//Maze maze = (Maze) model;
			rooms = new int[Maze.maze_size][Maze.maze_size];
			isExitRoom = false;

		}
	}

	/**
	 * paintComponent: draw a 20 by 20 rooms, and a player placed in random room, and an exit room.
	 * if the person successfully enter the exit room, the game end
	 */
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Graphics2D gc2d = (Graphics2D) gc;
		
		// define variables
		double roomWidth = (double)this.getWidth()/Maze.maze_size;
		double roomHeight = (double)this.getHeight()/Maze.maze_size;
		double roomStartx = (double)this.getWidth()/Maze.maze_size;
		double roomStarty = (double)this.getHeight()/Maze.maze_size;
		int pwidth= (int) (roomWidth *0.8 - roomWidth*0.2);
		int pheight = (int) (roomHeight*0.8 - roomHeight*0.2);
		//double exitxStart,exityStart;
		int exitx, exity;
		int pPosx, pPosy;
		
		// paint background
		gc2d.setColor(Color.DARK_GRAY);
	    gc2d.fillRect(0,0,this.getWidth(),this.getHeight());

		if(model !=null && model instanceof Maze) {
			Maze maze = (Maze) model;
			exitx = maze.exitRoomX();
			exity = maze.exitRoomY();
//			exitxStart = exitx* roomWidth;
//			exityStart = exity* roomHeight;
			pPosx = (int) (maze.getPx()* roomWidth + roomWidth*0.2);
			pPosy = (int) (maze.getPy()* roomHeight+ roomHeight*0.2);
			for(int row = 0; row<Maze.maze_size;row++) {
				for(int col=0; col <Maze.maze_size; col++) {
					gc2d.setStroke(new BasicStroke(3));
					gc2d.setColor(new Color(0,0,0));
					Rectangle2D.Double rect = new Rectangle2D.Double(roomStartx*row, roomStarty* col, roomWidth , roomHeight);
					gc2d.draw(rect);
					
				}
			}
			
			// paint player
			gc2d.setColor(Color.RED);
			gc2d.fillOval(pPosx ,pPosy,pwidth, pheight);
			
//			//paint exit room
//			gc2d.setColor(Color.BLUE);
//			Rectangle2D.Double room = new Rectangle2D.Double(exitxStart, exityStart, roomWidth, roomHeight);
//			gc2d.fill(room);
			
			//check if player is exit
			if(maze.getPx()== exitx && maze.getPy() == exity) {
				isExitRoom = true;
				System.out.println("enter rooms");
			}
		}

	}
	
	/**
	 * return boolean to check if the room is exit
	 * @return
	 */
	public boolean isExit() {
		return isExitRoom;
	}
	
	/**
	 * reset exit room when start a new game
	 */
	public void resetExitRoom() {
		isExitRoom = false;
	}
	
}
