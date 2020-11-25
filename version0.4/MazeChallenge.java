package presentation;

import framework.AppFrame;

public class MazeChallenge {
	public static void main(String[] args) {
		AppFrame appframe = new AppFrame(new MazeFactory());
		appframe.display();
	}
}
