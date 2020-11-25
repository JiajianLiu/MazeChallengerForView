package framework;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


import javax.swing.JPanel;

public class AppPanel extends JPanel implements Observer{
	protected Model model;
	public ActionListener listener;
	public Set<View> views;
	
	// this class didn't have the ability to initialize listener and model
	// need to add later 
	// is for void main test for now
	public AppPanel()
	{
	//	this.model = model;
		//this.listener = listener;
		views = new HashSet<View>();
	}
	
	public void update(Observable subject, Object msg) {
		// override in a subclass
	}
	
	public void setModel(Model model) {
		if(this.model != null) 
			this.model.deleteObserver(this);
		
		this.model = model;
		
		if(this.model != null) 
			this.model.addObserver(this);
		
		for(View view: views) view.setModel(model);
	}
	
	public void add(View view) {
		super.add(view);
//		if (view instanceof MazeView)
//			MazeView m = ()
		//views = new TreeSet<View>();
		views.add(view);
	}
}
