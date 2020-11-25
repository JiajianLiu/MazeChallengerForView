package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Sumija Sai worked on JMenuBar on Nov 7
 * Jiajian liu worked on setModel() and AppFrame() constructor on Nov 8
 * Sumija, jiajian, shuti worked on actionPerformed on Nov 12
 */
public class AppFrame extends JFrame implements ActionListener
{
	  private AppFactory factory;
	  private Model model;
	  private AppPanel panel;
	  
	  public AppFrame(AppFactory factory) 
	  {
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
	  
	  public void setModel(Model model) 
	  {
	     // used by open and new, details below
		  this.model = model;
		  panel.setModel(model);
		  this.setTitle(factory.getTitle());
		  model.changed();
	  }
	  
	  protected JMenuBar createMenuBar() 
	  {
	     JMenuBar bar = new JMenuBar();
	     // add file, edit, and help menus
	     
	     String[] fileCommands = new String[5];
	     fileCommands[0] = "New";
	     fileCommands[1] = "Save";
	     fileCommands[2] = "Save As";
	     fileCommands[3] = "Open";
	     fileCommands[4] = "Quit";
	     JMenu fileMenu = Utilities.makeMenu("File", fileCommands, this);
	     JMenu helpMenu = Utilities.makeMenu("Help", factory.getHelp(), this);
	     JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
	     
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
	        this.setTitle(factory.getTitle());
	     } 
	     else if (cmmd == "Save As") {
	        Utilities.save(model, true);
	        this.setTitle(factory.getTitle());
	     }
	     else if (cmmd == "Open") {
	        Model newModel = Utilities.open(model);
	        setModel(newModel);  
	        this.setTitle(factory.getTitle()); // add new title
	     }
	     else if (cmmd == "New") {
	    	Utilities.reset = true;
	        Utilities.saveChanges(model);
	        setModel(factory.makeModel());
	        // needed cuz setModel sets to true:
	        model.setUnsavedChanges(false);
	     
        	this.setTitle(factory.getDefaultTitle());
	     }
	     else if (cmmd == "Quit") {
	        Utilities.saveChanges(model);
	        System.exit(1);
	     }
	     else if (cmmd == "About") {
	        Utilities.inform(factory.about());
	     }
	     else if (cmmd == "Help") {
	        Utilities.inform(factory.getHelp());
	     }
	     else if (cmmd =="Content") {
		    	 Utilities.inform(factory.content());
		 }
	     else {
		        Command command = factory.makeEditCommand(model, cmmd);
		        CommandProcessor.execute(command);
		        if(cmmd == "Reset")
		        {
		        	this.setTitle(factory.getDefaultTitle());
		        }
	     }
	  }
}