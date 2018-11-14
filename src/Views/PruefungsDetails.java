package Views;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class PruefungsDetails extends JFrame{
	private JTable tableTermine;
	private JTextField textFieldTitel;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	public PruefungsDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.anchor = GridBagConstraints.EAST;
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 0;
		gbc_lblPrfungstitel.gridy = 0;
		getContentPane().add(lblPrfungstitel, gbc_lblPrfungstitel);
		
		textFieldTitel = new JTextField();
		GridBagConstraints gbc_textFieldTitel = new GridBagConstraints();
		gbc_textFieldTitel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitel.gridx = 1;
		gbc_textFieldTitel.gridy = 0;
		getContentPane().add(textFieldTitel, gbc_textFieldTitel);
		textFieldTitel.setColumns(10);
		
		JLabel lblDauermin = new JLabel("Dauer (Min):");
		GridBagConstraints gbc_lblDauermin = new GridBagConstraints();
		gbc_lblDauermin.anchor = GridBagConstraints.EAST;
		gbc_lblDauermin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDauermin.gridx = 0;
		gbc_lblDauermin.gridy = 1;
		getContentPane().add(lblDauermin, gbc_lblDauermin);
		
		textFieldDauer = new JTextField();
		GridBagConstraints gbc_textFieldDauer = new GridBagConstraints();
		gbc_textFieldDauer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDauer.gridx = 1;
		gbc_textFieldDauer.gridy = 1;
		getContentPane().add(textFieldDauer, gbc_textFieldDauer);
		textFieldDauer.setColumns(10);
		
		JLabel lblPunkte = new JLabel("Punkte:");
		GridBagConstraints gbc_lblPunkte = new GridBagConstraints();
		gbc_lblPunkte.anchor = GridBagConstraints.EAST;
		gbc_lblPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunkte.gridx = 0;
		gbc_lblPunkte.gridy = 2;
		getContentPane().add(lblPunkte, gbc_lblPunkte);
		
		textFieldPunkte = new JTextField();
		GridBagConstraints gbc_textFieldPunkte = new GridBagConstraints();
		gbc_textFieldPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPunkte.gridx = 1;
		gbc_textFieldPunkte.gridy = 2;
		getContentPane().add(textFieldPunkte, gbc_textFieldPunkte);
		textFieldPunkte.setColumns(10);
		
		JLabel lblAufgaben = new JLabel("Aufgaben:");
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 0;
		gbc_lblAufgaben.gridy = 3;
		getContentPane().add(lblAufgaben, gbc_lblAufgaben);
		
		JButton btnAufgabenlisteffnen = new JButton("Aufgaben-Liste \u00F6ffnen");
		GridBagConstraints gbc_btnAufgabenlisteffnen = new GridBagConstraints();
		gbc_btnAufgabenlisteffnen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAufgabenlisteffnen.gridx = 1;
		gbc_btnAufgabenlisteffnen.gridy = 3;
		getContentPane().add(btnAufgabenlisteffnen, gbc_btnAufgabenlisteffnen);
		
		JLabel lblTeilnehmer = new JLabel("Teilnehmer:");
		GridBagConstraints gbc_lblTeilnehmer = new GridBagConstraints();
		gbc_lblTeilnehmer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeilnehmer.gridx = 0;
		gbc_lblTeilnehmer.gridy = 4;
		getContentPane().add(lblTeilnehmer, gbc_lblTeilnehmer);
		
		JButton btnTeilnehmerlisteffnen = new JButton("Teilnehmer-Liste \u00F6ffnen");
		GridBagConstraints gbc_btnTeilnehmerlisteffnen = new GridBagConstraints();
		gbc_btnTeilnehmerlisteffnen.insets = new Insets(0, 0, 5, 0);
		gbc_btnTeilnehmerlisteffnen.gridx = 1;
		gbc_btnTeilnehmerlisteffnen.gridy = 4;
		getContentPane().add(btnTeilnehmerlisteffnen, gbc_btnTeilnehmerlisteffnen);
		
		JPanel panelTermine = new JPanel();
		GridBagConstraints gbc_panelTermine = new GridBagConstraints();
		gbc_panelTermine.gridheight = 2;
		gbc_panelTermine.gridwidth = 2;
		gbc_panelTermine.insets = new Insets(0, 0, 5, 0);
		gbc_panelTermine.fill = GridBagConstraints.BOTH;
		gbc_panelTermine.gridx = 0;
		gbc_panelTermine.gridy = 5;
		getContentPane().add(panelTermine, gbc_panelTermine);
		panelTermine.setLayout(new BorderLayout(0, 0));
		
		tableTermine = new JTable();
		panelTermine.add(tableTermine, BorderLayout.CENTER);
		
		JPanel panelBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTermine.add(panelBtns, BorderLayout.SOUTH);
		
		JButton btnNeu = new JButton("Neu");
		btnNeu.setBackground(Color.WHITE);
		panelBtns.add(btnNeu);
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		panelBtns.add(btnBearbeiten);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		panelBtns.add(btnLschen);
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelButtons.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.gridwidth = 2;
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 7;
		getContentPane().add(panelButtons, gbc_panelButtons);
		
		JButton btnFreischalten = new JButton("Freischalten");
		panelButtons.add(btnFreischalten);
		
		JButton btnLschen_1 = new JButton("L\u00F6schen");
		panelButtons.add(btnLschen_1);
		
		JButton btnSpeichern = new JButton("Speichern");
		panelButtons.add(btnSpeichern);
		
		
	}

}
