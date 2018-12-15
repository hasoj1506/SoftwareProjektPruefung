package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Models.*;
import Views.LoginPruefungsverwaltung;


public class examoDozentMain {

	public static void main(String[] args) {
	
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		};

		LoginPruefungsverwaltung login = new LoginPruefungsverwaltung();
		
	}

}
