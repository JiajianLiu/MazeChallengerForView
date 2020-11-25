package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppFrame;
import framework.AppPanel;
import framework.Model;
import framework.View;

public class MazePanel extends AppPanel{
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  Maze maze;
	private ActionListener controller;
	public static JTextField exitDistanceField = new JTextField("0", 10);
	public static JTextField movesLeftField = new JTextField("0", 10);
	
	
		
		public MazePanel(Maze maze, ActionListener listener)
		{
			
			super();
			//MazePanel.maze = maze;
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
			this.add(view);	
	   
	}
	
//	class ViewPanel extends JPanel implements Observer
//	{
//		ViewPanel(Model model, ActionListener listener)
//		{
//			MazeView view = new MazeView(maze);
//			this.setLayout(new GridLayout(1,1));
//			this.add(view);
//		}

//		@Override
//		public void update(Observable o, Object arg) {
//			// TODO Auto-generated method stub
//			repaint();
//		}
//	}
		
	public void update(Observable subject, Object msg) {
		
		repaint();
	}
//	public static void main(String[] args){
//
//		
//		ActionListener listener = new AppPanel().listener ;
//		Maze m = new Maze();
//		MazeView v = new MazeView(m);
//		JFrame jp1 = new JFrame();
//	MazePanel mp = new MazePanel(m,listener);
//	//JPanel panel = new JPanel();
////		panel.setLayout(new GridLayout(1,2));
////	panel.add(mp);
////		panel.add(v);
//		jp1.add(mp);
//    jp1.setSize(new Dimension(1000,500));
//    jp1.setVisible(true);
//    jp1.pack();
//    jp1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    System.out.println(WIDTH);
//	}

	
	
	
}