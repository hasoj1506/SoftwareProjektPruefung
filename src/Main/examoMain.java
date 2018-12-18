package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.LoginAbfrage;

public class examoMain {

	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		};

		
		LoginAbfrage login = new LoginAbfrage();
		
		
	}

}
