package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import business.Maze;
import framework.Model;
import framework.View;
/*
 * shuti wang
 */

public class MazeView extends View{
	private int[][] rooms = new int[Maze.maze_size][Maze.maze_size];
	private int roomWidth = getWidth()/Maze.maze_size;
	private int roomx, roomy;
	
	public MazeView(Model model) {
		super(model);
		if(model != null && model instanceof Maze) {
			Maze maze = (Maze) model;
			roomx = maze.exitRoomX();
			roomy = maze.exitRoomY();
			System.out.println("roomx: " + roomx);
			System.out.println("roomy: " + roomy);
			
		}
	}

	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		gc.setColor(Color.DARK_GRAY);
	    gc.fillRect(0,0,this.getWidth(),this.getHeight());
	    gc.setColor(Color.LIGHT_GRAY);
		if(model !=null && model instanceof Maze) {
			Maze maze = (Maze) model;
			for(int row = 0; row<Maze.maze_size;row++) {
				gc.drawLine(0, row*this.getWidth()/Maze.maze_size, this.getHeight(), row*this.getWidth()/Maze.maze_size);
				for(int col=0; col <Maze.maze_size; col++) {
					System.out.println(col*this.getWidth()/Maze.maze_size);
					gc.drawLine(row*this.getWidth()/Maze.maze_size, col * this.getWidth()/Maze.maze_size, row*this.getWidth()/Maze.maze_size, this.getHeight());
				}
			}
			gc.setColor(Color.RED);
			//gc.()
		}
		
	}
	
	public void isExit() {
		
	}
	public static void main(String[] args){
		Maze m = new Maze();
		View mv = new MazeView(m);
		JFrame jp1 = new JFrame();
        JPanel panel = new JPanel();
        panel.add(mv);
        //panel.setBackground(Color.black);
        jp1.add(panel);
        jp1.setSize(new Dimension(500,500));
        jp1.setVisible(true);
        jp1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
