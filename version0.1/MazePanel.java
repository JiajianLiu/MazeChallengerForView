package presentation;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppPanel;

public class MazePanel extends AppPanel{
	private Maze maze;
	private JTextField exitField, movesField;
	private JLabel exitLabel, movesLabel;
	
	public MazePanel(Maze maze, ActionListener listener) {
		//super(maze,listener)
	}
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
}
