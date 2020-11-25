package framework;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

abstract public class View extends JComponent implements Observer {

	protected Model model;
	public View(Model model) {
		setModel(model);
	}
	public View()
	{
		this(null);
	}
	public void setModel(Model model) {
		if(this.model != null) {
			this.model.deleteObserver(this);
		}
		this.model = model;
		if(model != null) {
			this.model.addObserver(this);
			/**
			 * This method is called whenever the observed object is changed. 
			 * An application calls an Observable object's notifyObservers method 
			 * to have all the object's observers notified of the change.
			 */
			this.update(model,null); // update itself.
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
