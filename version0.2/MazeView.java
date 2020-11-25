package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import business.Maze;
import framework.Model;
import framework.View;


public class MazeView extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room[][] rooms;
	
	public MazeView(Model model) {
		super(model);
		if(model != null && model instanceof Maze) {
			Maze maze = (Maze) model;
			this.rooms= new Room[(int) maze.getRow()][(int) maze.getColumn()];
		}
		for (int row = 0; row < rooms.length; row++) 
		{
			{ for (int col = 0; col < rooms[row].length; col++) 
				{
					Room r = new Room();
					r.setRoomX(row *100);
					r.setRoomY(col*100);
					rooms[row][col] = r;
				} 
			}
		}
		
	}
	
	
	public void paintComponent(Graphics gc) {
		if(model !=null && model instanceof Maze) {
			Maze maze = (Maze) model;
			for (int row = 0; row < rooms.length; row++) 
			{
				{ for (int col = 0; col < rooms[row].length; col++) 
					{
						rooms[row][col].paintRoom(gc);
					} 
				}
			}
			
		}
	}
	
	
	public static void main(String[] args)
	{
		Maze m = new Maze();
		MazeView mw = new MazeView(m);
		
JFrame jp1 = new JFrame();
        
        jp1.getContentPane().add(mw, BorderLayout.CENTER);
        jp1.setSize(new Dimension(500,500));
        jp1.setVisible(true);
	}
}
