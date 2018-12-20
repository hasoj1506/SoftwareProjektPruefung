package Testklassen;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.LoginAbfrage;
import Views.PruefungsverwaltungView;

public class JosahTestKlasse {

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		};

		
		PruefungsverwaltungView view = new PruefungsverwaltungView();

	}
}
