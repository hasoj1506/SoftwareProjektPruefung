package Models;

public class DatenbankTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();
		
		Nutzer nutzer1 = new Nutzer("Hans", "Dieter", "hDieter","1234",true);
		
		service.persistNutzer(nutzer1);

	}

}
