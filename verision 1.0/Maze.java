package business;

import framework.Model;
import framework.Utilities;

/**
 * shuti wang create Nov 1, 2019, modified on Nov 6, 2019, modified on Nov 8, 2019
 * jiajian liu worked on copy() on Nov 5
 */
public class Maze extends Model {
	private int px, py; // player's position
	private int remainingMoves = 0; // steps the user can move
	private int exitX, exitY;
	public static int maze_size = 20;

	/**
	 * Constructor randomly generalizes the position of the player and exit room, 
	 * calculate the moves remain which is (1.5 time the distance to exit.
	 */
	public Maze() {
		super();		
		do{
			px = Utilities.randomInt(Maze.maze_size);
			py = Utilities.randomInt(Maze.maze_size);
			exitX = Utilities.randomInt(Maze.maze_size);
			exitY = Utilities.randomInt(Maze.maze_size);
		}while(px == exitX && py == exitY); 

		this.remainingMoves = (int) Math.ceil(1.5 * this.distanceToExit());
	}
	
	/**
	 * move() will move the player's position by 1 in according to the heading, also reduce the steps left by 1
	 * @param heading
	 */
	public void move(Heading heading) {
		if (heading == Heading.EAST) {
			if(px < Maze.maze_size-1)
				px++;
		}
		if (heading == Heading.NORTH) {
			if(py >0)
				py--;
		}
		if (heading == Heading.SOUTH) {
			if(py <Maze.maze_size-1)
				py++;
		}
		if (heading == Heading.WEST) {
			if(px > 0) {
				px--;
			}
		}
		
		if(remainingMoves >0)
			this.remainingMoves--; // the exception is thrown when become negative a another class.
		distanceToExit();
		
		changed();
	}

	/**
	 * return steps remaining
	 * @return
	 */
	public int getRemainingMoves() {
		return this.remainingMoves;
	}
	
	/** method take the exit of the roomx and roomy and calculate shortest 
	 * distance that the player can take to find the exit
	 * @param roomx
	 * @param roomy
	 * @return shortest distance to find the exit
	 */
	public int distanceToExit() {
		return Math.abs(this.px-this.exitX) + Math.abs(this.py-this.exitY);
	}
	
	/**
	 * return the exit roomX
	 * @return
	 */
	public int exitRoomX(){
		return this.exitX;
	}
	
	/**
	 * return the exit roomY
	 * @return
	 */
	public int exitRoomY(){
		return this.exitY;
	}

	/**
	 * return personX
	 * @return
	 */
	public int getPx() {
		return this.px;
	}
	/**
	 * return personY
	 * @return
	 */
	public int getPy() {
		return this.py;
	}
	
	public void copy(Model other) {
		  super.copy(other);
		  Maze m = (Maze)other;
		  px = m.px;
		  py = m.py;
		  exitX = m.exitX;
		  exitY = m.exitY;
		  remainingMoves = (int) Math.ceil(1.5 * m.distanceToExit());
		  changed();
		  
	}
}
