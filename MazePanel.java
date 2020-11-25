package presentation;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

import business.Maze;
import framework.AppPanel;
import framework.Utilities;

public class MazePanel extends AppPanel
{
	/** 
	 * sumija worked on Nov 8
	 * jiajian, sumija, shuti worked on update method on Nov 12 and Nov 13
	 */
	private static final long serialVersionUID = 1L;
	private MazeView mazeView;
	private JTextField exitDistanceField = new JTextField("0", 10);
	private JTextField movesLeftField = new JTextField("0", 10);
	private static JButton south, north, west, east;
	
		
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
			p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);
			
			
			p = new JPanel();
			movesLeftField = new JTextField("" + maze.getRemainingMoves(), 10);
			movesLeftField.addActionListener(listener);
			movesLeftField.setEditable(false);
			
			p.add(new JLabel("Moves Left "));
			p.add(movesLeftField);
			p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);
			
			
			p = new JPanel();
			north = new JButton("North");
			north.setPreferredSize(new Dimension(100, 50));
			north.addActionListener(listener);
			p.add(north);
			p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);
		    
			p = new JPanel();
			east = new JButton("East");
			east.setPreferredSize(new Dimension(100, 50));
			east.addActionListener(listener);
		 	p.add(east);
		 	p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);

			p = new JPanel();
			west = new JButton("West");
			west.setPreferredSize(new Dimension(100, 50));
			west.addActionListener(listener);
			p.add(west);
			p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);

			p = new JPanel();
			south = new JButton("South");
			south.setPreferredSize(new Dimension(100, 50));
			south.addActionListener(listener);
			p.add(south);
			p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);

			p = new JPanel();
			JButton reset = new JButton("Reset");
		 	reset.setPreferredSize(new Dimension(100, 50));
		 	reset.addActionListener(listener);
		  	p.add(reset);
		  	p.setBorder(new LineBorder(Color.BLACK, 1));
			buttonPanel.add(p);
			
			//add button panel for left side
			//add view for right side
			this.setLayout(new GridLayout(1,2));
			this.add(buttonPanel);
			this.add(mazeView);	
			setBorder(new LineBorder(Color.BLACK, 1));	  
	}
		
	public static void enableButton(boolean enable) 
	{
		south.setEnabled(enable);
		north.setEnabled(enable);
		east.setEnabled(enable);
		west.setEnabled(enable);
	}
		
	@Override
	public void update(Observable subject, Object msg) 
	{
		Maze maze = (Maze) model;
		this.exitDistanceField.setText("" + maze.distanceToExit());
		this.movesLeftField.setText("" + maze.getRemainingMoves());
		mazeView.resetExitRoom();
		
		if(maze.distanceToExit() ==0 || maze.getRemainingMoves() ==0) 
		{
			enableButton(false);
		}
		if (Utilities.reset)
		{
			enableButton(true);
		}
		
		if(maze.getRemainingMoves() ==0 && !(maze.getPx() == maze.exitRoomX() && maze.getPy() == maze.exitRoomY()) && Utilities.reset != true) 
		{
        	Utilities.inform("No more remaining moves.");
        	
        }
		Utilities.reset = false;
		repaint();
	 }
}	