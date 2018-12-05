package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.PruefungsDetailsController;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;

public class PruefungsDetails extends JFrame {
	private Pruefung pruefung;
	private JTextField textFieldPrfungstitel;
	private JTable tableAufgaben;
	private JTable tableTeilnehmer;
	private JTable tableTermine;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	
	PruefungsDetailsController controller;
	Aufgabe aufgabe;
	Termin termin;
	Nutzer nutzer;
	
	public PruefungsDetails() {
		this.controller = new PruefungsDetailsController(this);
		onCreate();
		fuelleAufgaben();
	}
	
	//Josah Weber (Konstruktor erstmal zum testen)
	//Josah Weber (Konstruktor zum Bearbeiten der Pruefung)
// branch 'master' of https://github.com/hasoj1506/SoftwareProjektPruefung.git
	public PruefungsDetails(Pruefung pruefung){
		this.pruefung = pruefung;
		onCreate();
		fuellePruefungsDetailsZumBearbeiten();
	}
	
	public void onCreate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnSpeichern = new JButton("Speichern");
		panelButtons.add(btnSpeichern);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		panelButtons.add(btnLschen);
		
		JButton btnFreigeben = new JButton("Freigeben");
		panelButtons.add(btnFreigeben);
		
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{0, 153, 300, 0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 0, 0, 0, 50, 0, 50, 0, 50, 0, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 1;
		gbc_lblPrfungstitel.gridy = 1;
		panelMain.add(lblPrfungstitel, gbc_lblPrfungstitel);
		
		textFieldPrfungstitel = new JTextField();
		GridBagConstraints gbc_textFieldPrfungstitel = new GridBagConstraints();
		gbc_textFieldPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrfungstitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrfungstitel.gridx = 2;
		gbc_textFieldPrfungstitel.gridy = 1;
		panelMain.add(textFieldPrfungstitel, gbc_textFieldPrfungstitel);
		textFieldPrfungstitel.setColumns(10);
		
		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDauermin = new GridBagConstraints();
		gbc_lblDauermin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDauermin.gridx = 1;
		gbc_lblDauermin.gridy = 2;
		panelMain.add(lblDauermin, gbc_lblDauermin);
		
		textFieldDauer = new JTextField();
		GridBagConstraints gbc_textFieldDauer = new GridBagConstraints();
		gbc_textFieldDauer.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDauer.gridx = 2;
		gbc_textFieldDauer.gridy = 2;
		panelMain.add(textFieldDauer, gbc_textFieldDauer);
		textFieldDauer.setColumns(5);
		
		JLabel lblPunkte = new JLabel("Punkte:");
		GridBagConstraints gbc_lblPunkte = new GridBagConstraints();
		gbc_lblPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunkte.gridx = 1;
		gbc_lblPunkte.gridy = 3;
		panelMain.add(lblPunkte, gbc_lblPunkte);
		
		textFieldPunkte = new JTextField();
		GridBagConstraints gbc_textFieldPunkte = new GridBagConstraints();
		gbc_textFieldPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPunkte.gridx = 2;
		gbc_textFieldPunkte.gridy = 3;
		panelMain.add(textFieldPunkte, gbc_textFieldPunkte);
		textFieldPunkte.setColumns(5);
		
		JLabel lblAufgaben = new JLabel("Aufgaben:");
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.anchor = GridBagConstraints.NORTH;
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 1;
		gbc_lblAufgaben.gridy = 4;
		panelMain.add(lblAufgaben, gbc_lblAufgaben);
		
		tableAufgaben = new JTable();
		GridBagConstraints gbc_tableAufgaben = new GridBagConstraints();
		gbc_tableAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_tableAufgaben.fill = GridBagConstraints.BOTH;
		gbc_tableAufgaben.gridx = 2;
		gbc_tableAufgaben.gridy = 4;
		panelMain.add(tableAufgaben, gbc_tableAufgaben);
		
		JPanel panelAufgabenButtons = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelAufgabenButtons.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelAufgabenButtons = new GridBagConstraints();
		gbc_panelAufgabenButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelAufgabenButtons.gridwidth = 2;
		gbc_panelAufgabenButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelAufgabenButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAufgabenButtons.gridx = 1;
		gbc_panelAufgabenButtons.gridy = 5;
		panelMain.add(panelAufgabenButtons, gbc_panelAufgabenButtons);
		
		JButton btnLschen_1 = new JButton("L\u00F6schen");
		panelAufgabenButtons.add(btnLschen_1);
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		panelAufgabenButtons.add(btnBearbeiten);
		
		JButton btnNeu = new JButton("Neu");
		panelAufgabenButtons.add(btnNeu);
		
		JLabel lblNewLabel = new JLabel("Teilnehmer:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		panelMain.add(lblNewLabel, gbc_lblNewLabel);
		
		tableTeilnehmer = new JTable();
		GridBagConstraints gbc_tableTeilnehmer = new GridBagConstraints();
		gbc_tableTeilnehmer.insets = new Insets(0, 0, 5, 5);
		gbc_tableTeilnehmer.fill = GridBagConstraints.BOTH;
		gbc_tableTeilnehmer.gridx = 2;
		gbc_tableTeilnehmer.gridy = 6;
		panelMain.add(tableTeilnehmer, gbc_tableTeilnehmer);
		
		JPanel panelTeilnehmerButtons = new JPanel();
		FlowLayout fl_panelTeilnehmerButtons = (FlowLayout) panelTeilnehmerButtons.getLayout();
		fl_panelTeilnehmerButtons.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelTeilnehmerButtons = new GridBagConstraints();
		gbc_panelTeilnehmerButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTeilnehmerButtons.gridwidth = 2;
		gbc_panelTeilnehmerButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelTeilnehmerButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTeilnehmerButtons.gridx = 1;
		gbc_panelTeilnehmerButtons.gridy = 7;
		panelMain.add(panelTeilnehmerButtons, gbc_panelTeilnehmerButtons);
		
		JButton btnLschen_2 = new JButton("L\u00F6schen");
		panelTeilnehmerButtons.add(btnLschen_2);
		
		JButton btnBearbeiten_1 = new JButton("Bearbeiten");
		panelTeilnehmerButtons.add(btnBearbeiten_1);
		
		JButton btnNeu_1 = new JButton("Neu");
		panelTeilnehmerButtons.add(btnNeu_1);
		
		JLabel lblTermine = new JLabel("Termine:");
		GridBagConstraints gbc_lblTermine = new GridBagConstraints();
		gbc_lblTermine.anchor = GridBagConstraints.NORTH;
		gbc_lblTermine.insets = new Insets(0, 0, 5, 5);
		gbc_lblTermine.gridx = 1;
		gbc_lblTermine.gridy = 8;
		panelMain.add(lblTermine, gbc_lblTermine);
		
		tableTermine = new JTable();
		GridBagConstraints gbc_tableTermine = new GridBagConstraints();
		gbc_tableTermine.insets = new Insets(0, 0, 5, 5);
		gbc_tableTermine.fill = GridBagConstraints.BOTH;
		gbc_tableTermine.gridx = 2;
		gbc_tableTermine.gridy = 8;
		panelMain.add(tableTermine, gbc_tableTermine);
		
		JPanel panelTermineButtons = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelTermineButtons.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelTermineButtons = new GridBagConstraints();
		gbc_panelTermineButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTermineButtons.gridwidth = 2;
		gbc_panelTermineButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelTermineButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTermineButtons.gridx = 1;
		gbc_panelTermineButtons.gridy = 9;
		panelMain.add(panelTermineButtons, gbc_panelTermineButtons);
		
		JButton btnLschen_3 = new JButton("L\u00F6schen");
		panelTermineButtons.add(btnLschen_3);
		
		JButton btnBearbeiten_2 = new JButton("Bearbeiten");
		panelTermineButtons.add(btnBearbeiten_2);
		
		JButton btnNeu_2 = new JButton("Neu");
		panelTermineButtons.add(btnNeu_2);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	//Josah Weber
	public void fuellePruefungsDetailsZumBearbeiten(){
		textFieldPrfungstitel.setText(pruefung.getBezeichnung());
		textFieldDauer.setText(String.valueOf(pruefung.getDauer()));
		
	}
	
	public static void main(String[] args) {
		PruefungsDetails p = new PruefungsDetails();
	}
	
	public JTable getTableAufgaben() {
		return tableAufgaben;
	}
	
	public void fuelleAufgaben() {
		controller.fuelleTabelleAufgaben();
	}

}
