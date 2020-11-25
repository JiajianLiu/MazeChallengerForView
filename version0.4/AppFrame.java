package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

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
	     setSize(500, 500);
	   
	     
	  }
	  
	  public void display() { this.setVisible(true); }
	  
	  public void setModel(Model model) {
	     // used by open and new, details below
	  }
	  
	  protected JMenuBar createMenuBar() {
	     JMenuBar bar = new JMenuBar();
	     // add file, edit, and help menus
//	     JMenu fileMenu = // ...
//	     JMenu helpMenu = // ...
//	     JMenu editMenu = 
//	         Utilities.makeMenu("Edit", factory.getEditCommands(), this);
	     // now add menus to bar
	     return bar;
	  }

	  public void actionPerformed(ActionEvent ae) {
	     String cmmd = ae.getActionCommand();
	     
	     if (cmmd == "Save") {
	        Utilities.save(model, false);
	     } else if (cmmd == "SaveAs") {
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
	     } else {
	        Command command = factory.makeEditCommand(model, cmmd);
	        CommandProcessor.execute(command);
	     }
	  }
}
