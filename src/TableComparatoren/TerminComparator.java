package TableComparatoren;

import java.util.Comparator;

import Models.Termin;

//Firat Aslan
public class TerminComparator implements Comparator<Termin> {

	public int compare(Termin t1, Termin t2) {
		return t1.getTerminId() - t2.getTerminId();
	}

}
