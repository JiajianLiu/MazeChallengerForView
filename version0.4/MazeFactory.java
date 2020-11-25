package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

public class MazeFactory implements AppFactory {

	@Override
	public Model makeModel() {
		Maze m = new Maze();
		return m;
	}

	@Override
	public AppPanel makePanel(Model model, ActionListener listener) {
		JPanel panel = new JPanel();
		AppPanel mp = null;
		//panel = (AppPanel) mp;
		
		if(model instanceof Maze) {
			mp = new MazePanel(model, listener);
			MazeView mv = new MazeView(makeModel());
			panel.setLayout(new GridLayout(1,2));
			panel.add(mp);
			panel.add(mv);
		}
		panel.setVisible(true);
		return mp;
	}

	@Override
	public String[] getEditCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String about() {
		// TODO Auto-generated method stub
		return null;
	}

}
