package Testklassen;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.LoginAbfrage;

public class JosahTestKlasse {

	public static void main(String[] args) {
		try {

//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		};

		
		LoginAbfrage login = new LoginAbfrage();
		
		

		
	}

}
