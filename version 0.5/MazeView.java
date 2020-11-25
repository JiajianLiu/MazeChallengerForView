package presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import business.Maze;
import framework.Model;
import framework.Utilities;
import framework.View;
/*
 * shuti wang, Nov 7, modified Nov 8.
 */

public class MazeView extends View{
	private int[][] rooms = new int[Maze.maze_size][Maze.maze_size];
	private int exitx, exity;
	private static boolean isExitRoom = false;

	/**
	 * constructor: set the room 
	 * @param model
	 */
	public MazeView(Model model) {
		super(model);
		if(model != null && model instanceof Maze) {
			Maze maze = (Maze) model;
			exitx = maze.exitRoomX();
			exity = maze.exitRoomY();
			System.out.println("exitx: " + exitx);
			System.out.println("exity: " + exity);
			
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
		int roomWidth = this.getWidth()/Maze.maze_size;
		int roomHeight = this.getHeight()/Maze.maze_size;
		int roomStartx = this.getWidth()/Maze.maze_size;
		int roomStarty = this.getHeight()/Maze.maze_size;
		int pwidth= (int) (roomWidth *0.8 - roomWidth*0.2);
		int pheight = (int) (roomHeight*0.8 - roomHeight*0.2);
		int exitxStart = exitx * roomWidth;
		int exityStart = exity * roomHeight;
		
		// paint background
		gc2d.setColor(Color.DARK_GRAY);
	    gc2d.fillRect(0,0,this.getWidth(),this.getHeight());
	    
	    //paint rooms
	    gc2d.setColor(Color.BLACK);
		if(model !=null && model instanceof Maze) {
			Maze maze = (Maze) model;
			exitx = maze.exitRoomX();
			exity = maze.exitRoomY();
			 exitxStart = exitx * roomWidth;
			 exityStart = exity * roomHeight;
//			exitx = Utilities.randomInt(Maze.maze_size);
//			exity = Utilities.randomInt(Maze.maze_size);
			int pPosx = (int) (maze.getPx()* roomWidth + roomWidth*0.2);
			int pPosy = (int) (maze.getPy()* roomHeight+ roomHeight*0.2);
			for(int row = 0; row<Maze.maze_size;row++) {
				for(int col=0; col <Maze.maze_size; col++) {
					gc2d.setStroke(new BasicStroke(3));
					gc2d.drawRect(roomStartx*row, roomStarty* col, roomWidth , roomHeight);
				}
			}
			
			// paint player
			gc2d.setColor(Color.RED);
			gc2d.fillOval(pPosx ,pPosy,pwidth, pheight);
			
			//paint exit room
			gc2d.setColor(Color.BLUE);
			gc2d.fillRect(exitxStart, exityStart, roomWidth, roomHeight);
			
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
	public static boolean isExit() {
		return isExitRoom;
	}
	
//	/**
//	 * test case
//	 * @param args
//	 */
//	public static void main(String[] args){
//		Maze m = new Maze();
//		View mv = new MazeView(m);
//		JFrame jp1 = new JFrame();
//        JPanel panel = new JPanel();
//        panel.add(mv);
//        //panel.setBackground(Color.black);
//        jp1.add(panel);
//        jp1.setSize(new Dimension(500,500));
//        jp1.setVisible(true);
//        jp1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}