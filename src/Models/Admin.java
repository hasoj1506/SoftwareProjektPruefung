package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import DatabaseService.DatabaseService;

//Marco Penner
@Entity
public class Admin{
	
	@Id
	private int adminId = 1;
	private static Admin instance;
	private String passwort;

	private Admin() {
		this.passwort = "examo";
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
