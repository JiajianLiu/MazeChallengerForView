package presentation;

import framework.AppFrame;

public class MazeChallenger {
	  public static void main(String[] args) {
		  
	     AppFrame app = new AppFrame(new MazeFactory());
	     app.display();
	  }
	  
}
