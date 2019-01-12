package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import Models.Aufgabe;
import Models.Student;
import TableModels.AuswertungTableModel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import DatabaseService.DatabaseService;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

//Firat Aslan
public class AuswertungView extends JFrame{
	
	private JLabel txtErreichtePunktzahl;
	private JLabel txtGesamtpunktzahlProzent;
	private JLabel txtBonuspunkte;
	private JTable table;
	private JLabel txtGesamtpunktzahl;
	private JLabel txtMatrikelNr;
	private JButton btnNewButton;
	private JFrame frame;

	Student student;
	
	private double erreichtePunktzahl;
	private int bonusPunkte;
	
	DatabaseService service = DatabaseService.getInstance();

	public AuswertungView(Student student, double erreichtePunktzahl) {
		onCreate();
		this.student = student;
		this.erreichtePunktzahl = erreichtePunktzahl;
		fuelleAuswertung();
		btnAction();
		setStudentErgebnis();
	}

	public void onCreate() {
		frame = new JFrame("Ergebnis");
		frame.setSize(new Dimension(750, 540));
		frame.setMaximumSize(new Dimension(750, 540));
		frame.setMinimumSize(new Dimension(750, 540));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		btnNewButton = new JButton("Schlie\u00DFen");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 30, 68, 30, 0 };
		gbl_panel_1.rowHeights = new int[] { 30, 0, 30, 83, 30, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 50, 50, 50, 10, 50, 50, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblErreichteGesamtpunktzahl = new JLabel("Erreichte Gesamtpunktzahl:");
		lblErreichteGesamtpunktzahl.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblErreichteGesamtpunktzahl = new GridBagConstraints();
		gbc_lblErreichteGesamtpunktzahl.anchor = GridBagConstraints.EAST;
		gbc_lblErreichteGesamtpunktzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblErreichteGesamtpunktzahl.gridx = 1;
		gbc_lblErreichteGesamtpunktzahl.gridy = 0;
		panel_3.add(lblErreichteGesamtpunktzahl, gbc_lblErreichteGesamtpunktzahl);

		txtErreichtePunktzahl = new JLabel();
		txtErreichtePunktzahl.setBorder(null);
		GridBagConstraints gbc_txtGesamtPunktzahl = new GridBagConstraints();
		gbc_txtGesamtPunktzahl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGesamtPunktzahl.insets = new Insets(0, 0, 5, 5);
		gbc_txtGesamtPunktzahl.gridx = 2;
		gbc_txtGesamtPunktzahl.gridy = 0;
		panel_3.add(txtErreichtePunktzahl, gbc_txtGesamtPunktzahl);

		JLabel lblVon = new JLabel("von");
		lblVon.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblVon = new GridBagConstraints();
		gbc_lblVon.insets = new Insets(0, 0, 5, 5);
		gbc_lblVon.gridx = 3;
		gbc_lblVon.gridy = 0;
		panel_3.add(lblVon, gbc_lblVon);

		txtGesamtpunktzahl = new JLabel();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		panel_3.add(txtGesamtpunktzahl, gbc_textField);

		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer:");
		lblMatrikelnummer.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.EAST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 6;
		gbc_lblMatrikelnummer.gridy = 0;
		panel_3.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		txtMatrikelNr = new JLabel();
		txtMatrikelNr.setBorder(null);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 0;
		panel_3.add(txtMatrikelNr, gbc_textField_1);

		JLabel lblNewLabel = new JLabel("Erreichte Gesamtpunktzahl in %:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		txtGesamtpunktzahlProzent = new JLabel();
		GridBagConstraints gbc_txtGesamtpunktzahlProzent = new GridBagConstraints();
		gbc_txtGesamtpunktzahlProzent.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGesamtpunktzahlProzent.insets = new Insets(0, 0, 0, 5);
		gbc_txtGesamtpunktzahlProzent.gridx = 2;
		gbc_txtGesamtpunktzahlProzent.gridy = 1;
		panel_3.add(txtGesamtpunktzahlProzent, gbc_txtGesamtpunktzahlProzent);

		JLabel lblAnzahlBonuspunkte = new JLabel("Anzahl Bonuspunkte:");
		lblAnzahlBonuspunkte.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblAnzahlBonuspunkte = new GridBagConstraints();
		gbc_lblAnzahlBonuspunkte.anchor = GridBagConstraints.EAST;
		gbc_lblAnzahlBonuspunkte.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnzahlBonuspunkte.gridx = 6;
		gbc_lblAnzahlBonuspunkte.gridy = 1;
		panel_3.add(lblAnzahlBonuspunkte, gbc_lblAnzahlBonuspunkte);

		txtBonuspunkte = new JLabel();
		GridBagConstraints gbc_txtBonuspunkte = new GridBagConstraints();
		gbc_txtBonuspunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBonuspunkte.insets = new Insets(0, 0, 0, 5);
		gbc_txtBonuspunkte.gridx = 7;
		gbc_txtBonuspunkte.gridy = 1;
		panel_3.add(txtBonuspunkte, gbc_txtBonuspunkte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		panel_1.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setRowHeight(35);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 155, 187));
		frame.getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblErgebnis = new JLabel("Ergebnisauswertung");
		lblErgebnis.setForeground(new Color(255, 255, 255));
		lblErgebnis.setFont(new Font("Gill Sans MT", Font.BOLD, 32));
		panel_2.add(lblErgebnis);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public void fuelleAuswertung() {

		double prozent = (this.erreichtePunktzahl / student.getPruefung().getPunkte()) * 100;
		int bonusPunkte = 0;

		if (prozent >= 95) {
			bonusPunkte = 6;
		} else if (prozent >= 80) {
			bonusPunkte = 5;
		} else if (prozent >= 65) {
			bonusPunkte = 4;
		} else if (prozent >= 50) {
			bonusPunkte = 3;
		} else if (prozent >= 35) {
			bonusPunkte = 2;
		} else if (prozent > 0) {
			bonusPunkte = 1;
		} else {
			bonusPunkte = 0;
		}
		
		this.bonusPunkte = bonusPunkte;

		txtMatrikelNr.setText(String.valueOf(student.getMatrikelNr()));
		txtGesamtpunktzahl.setText(String.valueOf(student.getPruefung().getPunkte()));
		txtErreichtePunktzahl.setText(String.valueOf(this.erreichtePunktzahl));
		txtGesamtpunktzahlProzent.setText(String.valueOf((Math.round(prozent) * 100) / 100));
		txtBonuspunkte.setText(String.valueOf(bonusPunkte));

		AuswertungTableModel model = new AuswertungTableModel(
				new ArrayList<Aufgabe>(student.getPruefung().getAufgaben()));

		table.setModel(model);

	}

	public void btnAction() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}

		});
		
	}
	
	public void setStudentErgebnis(){
		student.setErreichtePunktzahl(erreichtePunktzahl);
		student.setBonusPunkte(bonusPunkte);
		student.setEingeloggt(false);
		student.setHatAbgegeben(true);
		service.persistNutzer(student);
	}
	
}
