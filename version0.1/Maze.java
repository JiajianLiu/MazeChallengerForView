package business;
import framework.Model;

import framework.Model;
import framework.Utilities;

public class Maze extends Model{
	private double row, column;
	private Heading heading;
	private int x=0,y=0; // player's position
	private int remainingMoves = 0; // steps the user can move
	private int distanceToExit =0; // steps take for user to reach the exit room
	
	public Maze(double row, double column) {
		super();
		this.row = row;
		this.column = column;
		
		x = Utilities.randomInt((int)this.row);
		y = Utilities.randomInt((int)this.column);
		
	}
	public Maze() {
		this(20.0,20.0);
	}
	public void setRow(int row) {
		this.row= row;
		changed();
	}

	public double getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
		changed();
	}

	public double getRow() {
		return row;
	}
	
	public void move(Heading heading) {
		this.heading=heading;
		if(this.heading == Heading.EAST) {
			x++;
		}
		if(this.heading == Heading.NORTH){
			y--;
		}
		if(this.heading == Heading.SOUTH) {
			y++;
		}
		if(this.heading == Heading.WEST) {
			x--;
		}
		changed();

	}
	public Heading getHeading() {
		return this.heading;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void copy(Model model) {
		super.copy(model);
		Maze maze = (Maze) model;
		x = maze.x;
		y = maze.y;
		row = maze.row;
		column = maze.column;
		changed();
		
	}
	
	public int reduceMoves() {
		//return Math.abs(this.remainingMoves --);

		int temp =  Math.abs(this.remainingMoves --);
		changed();
		return temp;
	}
	
	public int distanceToExit(int steps) {
		this.distanceToExit = steps;
		if(this.remainingMoves == 0) {
			this.remainingMoves = (int) Math.ceil(this.distanceToExit * 1.5);
		}
		changed();
		return this.distanceToExit;
	}


//public int shortestDistance(int room) { 			
	public int shortestDistance(int roomx, int roomy) { 
		if(Math.abs(x-roomx) == Math.abs(y-roomy)) {
			System.out.println("x-roomx == y-roomy");
			return (int) Math.abs((x-roomx) *2) ;
		}
		if(x < roomx) {
			System.out.println("x<roomx");
			if(y == roomy) {
				return Math.abs(x-roomx);
			}
			return Math.abs(y + (roomx - x));
		}
		
		if (x > roomx) { 
			System.out.println("x>roomx");
			if (y == roomy) 
				return  Math.abs(x - roomx);
			return Math.abs(roomy + x - roomx);
		}
		
		if (x == roomx) {
			System.out.println("x==roomx");
			return Math.abs(y-roomy);
		}

		return 0;
}
	}
	

	
//	public static void main(String[] args) {
//		Maze maze = new Maze();
//		maze.setHeading(Heading.EAST);
//		System.out.println(maze.getHeading());
//	}

