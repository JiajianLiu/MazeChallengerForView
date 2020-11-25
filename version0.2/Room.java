package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

import business.Heading;

import javax.swing.JComponent;

public class Room extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double width, x=0;
	private double length, y=0;
	private boolean isExit;
	private boolean PersonEntered;
	
	
	public Room()
	{
		width = 10.0;
		length = 10.0;
		isExit = false;
		PersonEntered = false;
	}

	public double getRoomWidth() {
		return this.width;
		
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public boolean isPersonEntered() {
		return PersonEntered;
	}

	public void setPersonEntered(boolean personEntered) {
		PersonEntered = personEntered;
	}

	public double getRoomY() {
		return y;
	}

	public void setRoomY(double y) {
		this.y = y;
	}

	public double getRoomX() {
		return x;
	}

	public void setRoomX(double x) {
		this.x = x;
	}

	public void paintRoom(Graphics g)
	{
		Graphics2D gc2d = (Graphics2D)g;
		Rectangle2D.Double s = new Rectangle2D.Double(x, y, length, width);
		gc2d.fill(s);
		gc2d.setColor(Color.black);
	//	if ()
		
		
	}
	
	public static void main(String[]args)
	{
		Room r = new Room();
		r.setRoomX(100);
		r.setRoomY(100);
		r.setWidth(100);
		r.setLength(100);
		JFrame jp1 = new JFrame();
        
        jp1.getContentPane().add(r, BorderLayout.CENTER);
        jp1.setSize(new Dimension(500,500));
        jp1.setVisible(true);
        
        
        
	}
}