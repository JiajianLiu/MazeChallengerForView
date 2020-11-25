package presentation;

import javax.swing.JComponent;

public class Room extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double width;
	private double length;
	private boolean isExit;
	private boolean PersonEntered;
	
	public Room()
	{
		width = 1;
		length = 1;
	}
}
