package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PruefungsDetails extends JFrame {
	private JTextField textFieldPrfungstitel;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	private JTable tableAufgaben;
	private JTable tableTeilnehmer;
	private JTable tableTermine;
	public PruefungsDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelButtons.add(btnSpeichern);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		panelButtons.add(btnLschen);
		
		JButton btnFreigeben = new JButton("Freigeben");
		panelButtons.add(btnFreigeben);
		
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{0, 153, 300, 0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 50, 0, 50, 0, 50, 0, 50, 0, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		panelMain.add(panel, gbc_panel);
		
		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblDauermin);
		
		textFieldDauer = new JTextField();
		panel.add(textFieldDauer);
		textFieldDauer.setColumns(4);
		
		JLabel lblPunte = new JLabel("Punkte:");
		lblPunte.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblPunte);
		
		textFieldPunkte = new JTextField();
		panel.add(textFieldPunkte);
		textFieldPunkte.setColumns(4);
		
		JLabel lblAufgaben = new JLabel("Aufgaben:");
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.anchor = GridBagConstraints.NORTH;
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 1;
		gbc_lblAufgaben.gridy = 3;
		panelMain.add(lblAufgaben, gbc_lblAufgaben);
		
		tableAufgaben = new JTable();
		GridBagConstraints gbc_tableAufgaben = new GridBagConstraints();
		gbc_tableAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_tableAufgaben.fill = GridBagConstraints.BOTH;
		gbc_tableAufgaben.gridx = 2;
		gbc_tableAufgaben.gridy = 3;
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
		gbc_panelAufgabenButtons.gridy = 4;
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
		gbc_lblNewLabel.gridy = 5;
		panelMain.add(lblNewLabel, gbc_lblNewLabel);
		
		tableTeilnehmer = new JTable();
		GridBagConstraints gbc_tableTeilnehmer = new GridBagConstraints();
		gbc_tableTeilnehmer.insets = new Insets(0, 0, 5, 5);
		gbc_tableTeilnehmer.fill = GridBagConstraints.BOTH;
		gbc_tableTeilnehmer.gridx = 2;
		gbc_tableTeilnehmer.gridy = 5;
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
		gbc_panelTeilnehmerButtons.gridy = 6;
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
		gbc_lblTermine.gridy = 7;
		panelMain.add(lblTermine, gbc_lblTermine);
		
		tableTermine = new JTable();
		GridBagConstraints gbc_tableTermine = new GridBagConstraints();
		gbc_tableTermine.insets = new Insets(0, 0, 5, 5);
		gbc_tableTermine.fill = GridBagConstraints.BOTH;
		gbc_tableTermine.gridx = 2;
		gbc_tableTermine.gridy = 7;
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
		gbc_panelTermineButtons.gridy = 8;
		panelMain.add(panelTermineButtons, gbc_panelTermineButtons);
		
		JButton btnLschen_3 = new JButton("L\u00F6schen");
		panelTermineButtons.add(btnLschen_3);
		
		JButton btnBearbeiten_2 = new JButton("Bearbeiten");
		panelTermineButtons.add(btnBearbeiten_2);
		
		JButton btnNeu_2 = new JButton("Neu");
		panelTermineButtons.add(btnNeu_2);
	}

}
