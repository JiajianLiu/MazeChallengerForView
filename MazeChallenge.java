package presentation;

import framework.AppFrame;

public class MazeChallenge 
{
	/**
	 * shuti on Nov 7
	 * @param args
	 */
	public static void main(String[] args) 
	{
		AppFrame appframe = new AppFrame(new MazeFactory());
		appframe.display();
	}
}