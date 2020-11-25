package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppPanel;
import framework.Utilities;

public class MazePanel extends AppPanel{
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MazeView mazeView;
	private JTextField exitDistanceField = new JTextField("0", 10);
	private JTextField movesLeftField = new JTextField("0", 10);
	
		
		public MazePanel(Maze maze, ActionListener listener)
		{
			
			super(maze,listener);
			
			//create mazeView
			//make button panel
			mazeView = new MazeView(maze);
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(7,1));
			
			//add to button panel
			JPanel p = new JPanel();
			exitDistanceField = new JTextField("" + maze.distanceToExit(), 10);
			exitDistanceField.addActionListener(listener);
			exitDistanceField.setEditable(false);
			
			p.add(new JLabel("Exit Distance "));
			p.add(exitDistanceField);
			buttonPanel.add(p);
			
			
			p = new JPanel();
			movesLeftField = new JTextField("" + maze.getRemainingMoves(), 10);
			movesLeftField.addActionListener(listener);
			movesLeftField.setEditable(false);
			
			p.add(new JLabel("Moves Left "));
			p.add(movesLeftField);
			buttonPanel.add(p);
			
			
			p = new JPanel();
			JButton north = new JButton("North");
			north.setPreferredSize(new Dimension(100, 50));
			north.addActionListener(listener);
			p.add(north);
			buttonPanel.add(p);
		    
			p = new JPanel();
			JButton east = new JButton("East");
			east.setPreferredSize(new Dimension(100, 50));
			east.addActionListener(listener);
		 	p.add(east);
			buttonPanel.add(p);

			p = new JPanel();
			JButton west = new JButton("West");
			west.setPreferredSize(new Dimension(100, 50));
			west.addActionListener(listener);
			p.add(west);
			buttonPanel.add(p);

			p = new JPanel();
			JButton south = new JButton("South");
			south.setPreferredSize(new Dimension(100, 50));
			south.addActionListener(listener);
			p.add(south);
			buttonPanel.add(p);

			p = new JPanel();
			JButton reset = new JButton("Reset");
		 	reset.setPreferredSize(new Dimension(100, 50));
		 	reset.addActionListener(listener);
		  	p.add(reset);		
			buttonPanel.add(p);
			
			//add button panel for left side
			//add view for right side
			this.setLayout(new GridLayout(1,2));
			this.add(buttonPanel);
			this.add(mazeView);	
	  
	}
		
	@Override
	public void update(Observable subject, Object msg) {
		System.out.println("in maze panel udpate");
		
		
		try {
			Maze maze = (Maze) model;
			System.out.printf("exit room: " + maze.exitRoomX());
			System.out.printf("(px, py): (%d, %d)", maze.getPx(),maze.getPy());
			System.out.println("distance to exit: " +maze.distanceToExit());
			System.out.println("remaining moves: "+ maze.getRemainingMoves());this.exitDistanceField.setText("" + maze.distanceToExit());
	    this.movesLeftField.setText("" + maze.getRemainingMoves());
	    mazeView.resetExitRoom();
		}catch(NullPointerException e) {
			System.out.println("values are null");
		}
		
		
		
		repaint();
//		this.exitDistanceField.setText("" + maze.distanceToExit());
//    	this.movesLeftField.setText("" + maze.getRemainingMoves());
	}
	 
}	

