package Models;

import javax.persistence.Entity;
import javax.persistence.Id;

//Marco Penner
@Entity
public class Admin{
	
	@Id
	private int adminId = 1;
	private static Admin instance;
	private String passwort;

	private Admin() {
		this.passwort = "examo"; //Hier Standard Passwort ändern
	}
	
	public static Admin getInstance() {

		if (instance == null) {

			instance = new Admin();
		}

		return instance;
	}
	

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


}
