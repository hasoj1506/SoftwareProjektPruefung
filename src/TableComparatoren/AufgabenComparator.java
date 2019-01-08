package TableComparatoren;

import java.util.Comparator;

import Models.Aufgabe;

//Firat Aslan
public class AufgabenComparator implements Comparator<Aufgabe> {

	public int compare(Aufgabe a1, Aufgabe a2) {
		return a1.getAufgabeId() - a2.getAufgabeId();
	}

}
