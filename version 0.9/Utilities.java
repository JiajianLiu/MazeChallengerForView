package framework;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Utilities {

	// enables stack traces and diagnostics
	public static Boolean DEBUG = true;
	public static Random gen = new Random();
	public static String fName="";
	public static String preFileName ="";
	// asks user a yes/no question
	public static boolean confirm(String query) {
		int result = JOptionPane.showConfirmDialog(null,
				query, "choose one", JOptionPane.YES_NO_OPTION);
		return result == 1;
	}

	// asks user for info
	public static String ask(String query) {
		return JOptionPane.showInputDialog(null, query);
	}

	// tells user some info
	public static void inform(String info) { // for help
		JOptionPane.showMessageDialog(null,info);
	}

	// tells user lots of info
	public static void inform(String[] items) { //edit
		String infoString = "";
		for(int i = 0; i < items.length; i++) {
			infoString = infoString + "\n" + items[i];
		}
		inform(infoString);
	}

	// tells user about an error
	public static void error(String gripe) {
		JOptionPane.showMessageDialog(null,
				gripe,
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	// tells user about an exception
	public static void error(Exception gripe) {
		if (DEBUG) gripe.printStackTrace();
		JOptionPane.showMessageDialog(null,
				gripe.getMessage(),
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	// asks user save changes?
	public static void saveChanges(Model model) {
		if (model.hasUnsavedChanges() &&
		      Utilities.confirm("current model has unsaved changes, continue?")) {// if choose no
			Utilities.save(model, true); // change to true when press choice no, so can save the file by give a  name
			
		} 
		// ignore if choose yes
	}

	/**
	 * check if user is open file system to retrieve file or try to save a file
	 * choice == 1 means save file
	 * choice == 2 means open file
	 * @param fName
	 * @param choice
	 * @return
	 */
	public static String getFileName(String fName, int choice) {
		System.out.println("in get file name");
		JFileChooser chooser = new JFileChooser();
		String result = null;
		int returnVal =0;
		//boolean isExit = false;
		
		if (fName != null) {
//			File file = new File(fName);
//			isExit = file.exists();
//			if(isExit) {
//				Utilities.confirm("Do you want to overwrite the exist ");
//			}
		   // open chooser in directory of fName
			System.out.println("int getfile fname != null");
           chooser.setCurrentDirectory(new File(fName));
		}
		
		if (choice == 1)
			returnVal = chooser.showSaveDialog(chooser);
		else if (choice ==2)
			returnVal = chooser.showOpenDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			result= chooser.getSelectedFile().getPath();
			preFileName = result;
		}
		return result;
	}

	/**
	 * save a new file by passing 1 to getFileName()
	 * @param model
	 * @param saveAs
	 */
	public static void save(Model model, Boolean saveAs) {
		System.out.println("in save");
		String fName = model.getFileName();
		if (fName == "" || saveAs) {
			fName = Utilities.getFileName(fName, 1); // 1 mean save
			model.setFileName(fName);
			System.out.println("int save get filename: " + fName);
		}
		try {
			ObjectOutputStream os =
			   new ObjectOutputStream(new FileOutputStream(fName));
			model.setUnsavedChanges(false);
			os.writeObject(model);
			os.close();
		} catch (Exception err) {
			model.setUnsavedChanges(true);
			Utilities.saveChanges(model);
			//Utilities.error("The name has not been saved");
		}
	}

	/**
	 * open an existing file by passing 2 to getFileName()
	 * @param model
	 * @return
	 */
	public static Model open(Model model) {
		saveChanges(model);
		//String fName = Utilities.getFileName(model.getFileName(), 2); // 2 mean open
		fName = Utilities.getFileName(model.getFileName(), 2); // 2 mean open
		System.out.println("fName: " + fName);
		Model newModel = null;
		try {
			ObjectInputStream is =
			   new ObjectInputStream(new FileInputStream(fName));
			newModel = (Model)is.readObject();
			is.close();
		}catch(NullPointerException e) {
			System.out.println(model);
			return model;
		}
		catch (Exception err) {
			System.out.println("in open");
			Utilities.saveChanges(model);
		}
		return newModel;
	}

	// a simple menu maker
	public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
		JMenu result = new JMenu(name);
		for(int i = 0; i < items.length; i++) {
			JMenuItem item = new JMenuItem(items[i]);
			item.addActionListener(handler);
			result.add(item);
		}
		return result;
	}

	/**
	 * get random number from 0 to n-1
	 * @param n
	 * @return
	 */
	public static int randomInt(int n) {
		return gen.nextInt(n);
	}
	// etc.
}