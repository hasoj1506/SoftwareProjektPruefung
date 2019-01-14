package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.LoginAbfrage;

//Firat Aslan
public class examoMain {

	// passt lookandfeel ans system an und startet login abfrage
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		}
		;

		LoginAbfrage login = new LoginAbfrage();

	}

}
