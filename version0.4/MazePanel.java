package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppFrame;
import framework.AppPanel;
import framework.Model;

public class MazePanel extends AppPanel
{
	private Maze maze;
	private ActionListener controller;
	public static JTextField exitDistanceField = new JTextField("0", 10);
	public static JTextField movesLeftField = new JTextField("0", 10);
	/**
	 * Creates the left panel and the right panel of the MazeChallenge
	 * @param maze
	 * @param listener
	 */
	
	public MazePanel(Maze maze, ActionListener listener)
	{
		super();
		this.controller = listener;
		//create mazeView
		//make button panel
		MazeView view = new MazeView(maze);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(7,1));
		
		//add to button panel
		JPanel p = new JPanel();
		exitDistanceField = new JTextField("" + maze.distanceToExit(), 10);
		exitDistanceField.addActionListener(controller);
		exitDistanceField.setEditable(false);
		
		p.add(new JLabel("Exit Distance "));
		p.add(exitDistanceField);
		buttonPanel.add(p);
		
		
		p = new JPanel();
		movesLeftField = new JTextField("" + maze.getRemainingMoves(), 10);
		movesLeftField.addActionListener(controller);
		movesLeftField.setEditable(false);
		
		p.add(new JLabel("Moves Left "));
		p.add(movesLeftField);
		buttonPanel.add(p);
		
		
		
		p = new JPanel();
		JButton north = new JButton("North");
		north.setPreferredSize(new Dimension(100, 50));
		p.add(north);
		buttonPanel.add(p);
	    
		p = new JPanel();
		JButton east = new JButton("East");
		east.setPreferredSize(new Dimension(100, 50));
	 	p.add(east);
		buttonPanel.add(p);

		p = new JPanel();
		JButton west = new JButton("West");
		west.setPreferredSize(new Dimension(100, 50));
		p.add(west);
		buttonPanel.add(p);

		p = new JPanel();
		JButton south = new JButton("South");
		south.setPreferredSize(new Dimension(100, 50));
		p.add(south);
		buttonPanel.add(p);

		p = new JPanel();
		JButton reset = new JButton("Reset");
	 	reset.setPreferredSize(new Dimension(100, 50));
	  	p.add(reset);		
		buttonPanel.add(p);
		
		
		//add button panel for left side
		//add view for right side
		this.setLayout(new GridLayout(1,2));
		this.add(buttonPanel);
		this.add(view);		
	}
	
	public void update(Observable subject, Object msg) 
	{
		repaint();
	}
	public static void main(String[] args)
	{
		Maze m = new Maze();
		MazeView v = new MazeView(m);
		ActionListener listener = new AppPanel().listener;
		JFrame jp1 = new JFrame();
		AppPanel mp = new MazePanel(m,listener);

		jp1.add(mp);
		jp1.setSize(new Dimension(500,1000));
  		jp1.setVisible(true);
 		jp1.pack();
		jp1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(WIDTH);
	}
}
