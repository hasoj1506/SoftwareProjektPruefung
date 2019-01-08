package TableComparatoren;

import java.util.Comparator;

import Models.Student;

//Firat Aslan
public class TeilnehmerComparator implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		return s1.getNachname().compareTo(s2.getNachname());
	}

}
