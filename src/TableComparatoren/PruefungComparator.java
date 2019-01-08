package TableComparatoren;

import java.util.Comparator;

import Models.Pruefung;

//Firat Aslan
public class PruefungComparator implements Comparator<Pruefung> {

	public int compare(Pruefung p1, Pruefung p2) {
		return p2.getPruefungId() - p1.getPruefungId();
	}

}
