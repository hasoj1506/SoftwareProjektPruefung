package Testklassen;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Student;
import Views.LoginAbfrage;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

public class JosahTestKlasse {

	public static void main(String[] args) {

//		try {
//
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			
//		} catch (UnsupportedLookAndFeelException e) {
//
//		} catch (ClassNotFoundException e) {
//
//		} catch (InstantiationException e) {
//
//		} catch (IllegalAccessException e) {
//
//		};
//
//		
//		PruefungsverwaltungView view = new PruefungsverwaltungView();
//		
		DatabaseService db = DatabaseService.getInstance();
//		List<Pruefung> pruefungen = db.readPruefungen();
//		Pruefung pruefung = pruefungen.get(0);
//		List<Student> studenten = new ArrayList<Student>(pruefung.getStudenten());
//		Student student = studenten.get(0);
//		
//		PruefungView pruefungView = new PruefungView(student);
		
		List<Student> studentList = db.readLogin(233);
		System.out.println(studentList.size());

	}
}
