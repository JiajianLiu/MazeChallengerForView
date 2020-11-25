package framework;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


import javax.swing.JPanel;

import presentation.MazeView;

public class AppPanel extends JPanel implements Observer{
	protected Model model;
	protected ActionListener listener;
	public Set<View> views;
	
	public AppPanel()
	{
		views = new HashSet<View>();
	}
	
	public AppPanel(Model model, ActionListener listener)
	{
		this.model = model;
		this.listener = listener;
		views = new HashSet<View>();
		model.addObserver(this);
	}
	
	public void update(Observable subject, Object msg) {
		// override in a subclass
		System.out.println("in app panel update");
	}
	
	public void setModel(Model model) {
		if(this.model != null) 
			this.model.deleteObserver(this);
		
		this.model = model;
		
		if(this.model != null) 
			this.model.addObserver(this);
		
		for(View view: views) {
			view.setModel(model);
		}
	}
	
	public void add(View view) {
		super.add(view);

		views.add(view);
	}
}