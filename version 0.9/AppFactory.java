package framework;

import java.awt.event.ActionListener;

public interface AppFactory {
	  public Model makeModel();
	  public AppPanel makePanel(Model model, ActionListener listener);
	  public String[] getEditCommands();
	  public Command makeEditCommand(Model model, String type);
	  public String getTitle();
	  public String[] getHelp();
	  public String about();
	  public String content();
	
}
