package framework;

import business.Maze;
import presentation.MazePanel;

public class CommandProcessor {
	public static void execute(Command cmmd) {
		cmmd.execute(); // go to model find the new heading and process it
	}
	
	public static void redo(Model model) {
		Maze m = (Maze) model;
//        MazePanel.exitDistanceField.setText("" + m.distanceToExit());
//    	MazePanel.movesLeftField.setText("" + m.getRemainingMoves());
	}
	public static void undo() {
		
	}
}
