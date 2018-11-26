package Models;

public class DatenbankTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();
		
		Nutzer nutzerA = new Nutzer("Hans", "Dieter", "hDieter","1234",true);
		Nutzer nutzerB = new Nutzer("Franz", "Rudolf", "hRudolf","3563",true);
		Nutzer nutzerC = new Nutzer("Werner", "Ulf", "hUlf","3234",true);
		Nutzer nutzerD = new Nutzer("Fritz", "Meier", "hMeier","1564",true);
		Nutzer nutzerE = new Nutzer("Hainer", "Karsten", "hKarsten","1222",true);
		
		service.persistNutzer(nutzerA);
		service.persistNutzer(nutzerB);
		service.persistNutzer(nutzerC);
		service.persistNutzer(nutzerD);
		service.persistNutzer(nutzerE);

	}

}
