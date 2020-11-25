package framework;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JPanel;

public class AppPanel extends JPanel implements Observer{
	protected Model model;
	public ActionListener listener;
	protected Set<View> views;
	
	
	public void update(Observable subject, Object msg) {
		// override in a subclass
	}
	
	public void setModel(Model model) {
		if(this.model != null) 
			this.model.deleteObserver(this);
		
		this.model = model;
		
		if(this.model != null) 
			this.model.addObserver(this);
		
		//for(View view: views) view.setModel(model);
	}
	
	public void add(View view) {
		super.add(view);
		views.add(view);
	}
	
}
