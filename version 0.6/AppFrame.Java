package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import business.Heading;
import business.Maze;
import presentation.MazeFactory;
import presentation.MazePanel;
import presentation.MazeView;

public class AppFrame extends JFrame implements ActionListener{
	private AppFactory factory;
	  private Model model;
	  private AppPanel panel;
	  
	  public AppFrame(AppFactory factory) {
	     this.factory = factory;
	     model = factory.makeModel();
	     panel = factory.makePanel(model, this);
	     getContentPane().add(panel);
	     setJMenuBar(createMenuBar());
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setTitle(factory.getTitle());  
	     setSize(1000, 500);
	   
	     
	  }
	  
	  public void display() { this.setVisible(true); }
	  
	  public void setModel(Model model) {
	     // used by open and new, details below
		  this.model = model;
		  panel.setModel(model);
		  //Utilities.open(model);
	  }
	  
	  protected JMenuBar createMenuBar() {
	     JMenuBar bar = new JMenuBar();
	     // add file, edit, and help menus
	     
	     String[] fileCommands = new String[7];
	     fileCommands[0] = "New";
	     fileCommands[1] = "Save";
	     fileCommands[2] = "Save As";
	     fileCommands[3] = "Open";
	     fileCommands[4] = "Quit";
	     fileCommands[5] = "Redo";
	     fileCommands[6] = "Undo";
	     JMenu fileMenu = Utilities.makeMenu("File", fileCommands, this);
	     JMenu helpMenu = Utilities.makeMenu("Help", factory.getHelp(), this);
	     JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
//	         Utilities.makeMenu("Edit", factory.getEditCommands(), this);
	     
	     // now add menus to bar
	     bar.add(fileMenu);
	     
	     bar.add(editMenu);
	     bar.add(helpMenu);
	     return bar;
	  }

	  public void actionPerformed(ActionEvent ae) {
	     String cmmd = ae.getActionCommand();
	     
	     if (cmmd == "Save") {
	        Utilities.save(model, false);
	     } else if (cmmd == "Save As") {
	        Utilities.save(model, true);
	     } else if (cmmd == "Open") {
	        Model newModel = Utilities.open(model);
	        setModel(newModel);
	     } else if (cmmd == "New") {
	        Utilities.saveChanges(model);
	        setModel(factory.makeModel());
	        // needed cuz setModel sets to true:
	        model.setUnsavedChanges(false);
	     } else if (cmmd == "Quit") {
	        Utilities.saveChanges(model);
	        System.exit(1);
	     } else if (cmmd == "About") {
	        Utilities.inform(factory.about());
	     } else if (cmmd == "Help") {
	        Utilities.inform(factory.getHelp());
	     } else if (cmmd == "East" || cmmd == "West" || cmmd == "North"
	    		 || cmmd == "South" || cmmd == "Reset"){
	        Command command = factory.makeEditCommand(model, cmmd);
	        CommandProcessor.execute(command);
	        Maze m = (Maze) model;
	        MazePanel.exitDistanceField.setText("" + m.distanceToExit());
	        MazePanel.movesLeftField.setText("" + m.getRemainingMoves());
//	        MazeView mv = new MazeView(m);
//	        System.out.println("mv.isExit() = " + mv.isExit());
//	        if(mv.isExit()) {
//				//System.out.println("successfully exit...");
//				Utilities.inform("You have exited the Maze!");
//			}
		// add these two lines for check exception if No more reminding steps
	       if(m.getRemainingMoves() ==0) {
	        	Utilities.inform("No more reminding steps.");

	        }
	      
	     }
	     else if (cmmd == "Content")
	        {
	        	Utilities.inform(factory.content());
	        }
	  }
	  
	  
		
}
