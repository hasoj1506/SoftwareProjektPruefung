package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.PruefungViewController;
import Models.Nutzer;
import Models.Pruefung;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class PruefungView {
	Pruefung pruefung;
	Nutzer nutzer;

	private JFrame frame;
	private int timerZeit;
	private JTextField txtAufgabentext;
	private JTable antwortenTable;
	private JTable tableAufgaben;
	private JTextField txtAufgabentitel;

	PruefungViewController controller;

	public PruefungView(Pruefung pruefung, Nutzer nutzer) {
		this.pruefung = nutzer.getPruefung();
		this.pruefung = pruefung;

		erstellePruefungView();
		this.controller = new PruefungViewController(this, pruefung, nutzer);
		btnAction();
	}

	public void erstellePruefungView() {

		this.frame = new JFrame("Prüfung");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane aufgabenlisteScrollPane = new JScrollPane();
		aufgabenlisteScrollPane.setPreferredSize(new Dimension(100, 2));
		aufgabenlisteScrollPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(aufgabenlisteScrollPane, BorderLayout.WEST);

		tableAufgaben = new JTable();
		tableAufgaben.setBackground(new Color(255, 255, 255));
		aufgabenlisteScrollPane.setViewportView(tableAufgaben);
		tableAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAufgaben.setBorder(null);

		JPanel aufgabenstellungPanel = new JPanel();
		aufgabenstellungPanel.setBackground(new Color(255, 255, 255));
		aufgabenstellungPanel.setMinimumSize(new Dimension(100, 100));
		frame.getContentPane().add(aufgabenstellungPanel, BorderLayout.CENTER);
		GridBagLayout gbl_aufgabenstellungPanel = new GridBagLayout();
		gbl_aufgabenstellungPanel.columnWidths = new int[] { 0, 0, 91, 0, 207, 0 };
		gbl_aufgabenstellungPanel.rowHeights = new int[] { 0, 0, 30, 150, 150, 30 };
		gbl_aufgabenstellungPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_aufgabenstellungPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0 };
		aufgabenstellungPanel.setLayout(gbl_aufgabenstellungPanel);

		JButton button = new JButton("<Voherige");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		aufgabenstellungPanel.add(button, gbc_button);

		txtAufgabentitel = new JTextField("");
		txtAufgabentitel.setDisabledTextColor(new Color(255, 255, 255));
		txtAufgabentitel.setSelectionColor(new Color(255, 255, 255));
		txtAufgabentitel.setEditable(false);
		txtAufgabentitel.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAufgabentitel.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_txtAufgabentitel = new GridBagConstraints();
		gbc_txtAufgabentitel.anchor = GridBagConstraints.NORTHEAST;
		gbc_txtAufgabentitel.fill = GridBagConstraints.BOTH;
		gbc_txtAufgabentitel.insets = new Insets(0, 0, 5, 5);
		gbc_txtAufgabentitel.gridx = 2;
		gbc_txtAufgabentitel.gridy = 1;
		aufgabenstellungPanel.add(txtAufgabentitel, gbc_txtAufgabentitel);

		JButton btnNchste = new JButton("N\u00E4chste>");
		GridBagConstraints gbc_btnNchste = new GridBagConstraints();
		gbc_btnNchste.insets = new Insets(0, 0, 5, 5);
		gbc_btnNchste.gridx = 3;
		gbc_btnNchste.gridy = 1;
		aufgabenstellungPanel.add(btnNchste, gbc_btnNchste);

		JLabel lblAufgabenstellung = new JLabel("Aufgabenstellung:");
		lblAufgabenstellung.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAufgabenstellung = new GridBagConstraints();
		gbc_lblAufgabenstellung.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAufgabenstellung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgabenstellung.gridx = 0;
		gbc_lblAufgabenstellung.gridy = 3;
		aufgabenstellungPanel.add(lblAufgabenstellung, gbc_lblAufgabenstellung);

		txtAufgabentext = new JTextField();
		GridBagConstraints gbc_txtAufgabentext = new GridBagConstraints();
		gbc_txtAufgabentext.fill = GridBagConstraints.BOTH;
		gbc_txtAufgabentext.gridwidth = 4;
		gbc_txtAufgabentext.insets = new Insets(0, 0, 5, 5);
		gbc_txtAufgabentext.gridx = 1;
		gbc_txtAufgabentext.gridy = 3;
		aufgabenstellungPanel.add(txtAufgabentext, gbc_txtAufgabentext);
		txtAufgabentext.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAufgabentext.setColumns(10);

		JScrollPane aufgabentextScrollPane = new JScrollPane();
		aufgabentextScrollPane.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_aufgabentextScrollPane = new GridBagConstraints();
		gbc_aufgabentextScrollPane.anchor = GridBagConstraints.NORTHEAST;
		gbc_aufgabentextScrollPane.fill = GridBagConstraints.BOTH;
		gbc_aufgabentextScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_aufgabentextScrollPane.gridx = 4;
		gbc_aufgabentextScrollPane.gridy = 3;
		aufgabenstellungPanel.add(aufgabentextScrollPane, gbc_aufgabentextScrollPane);

		JLabel lblAntworten = new JLabel("Antworten:");
		lblAntworten.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAntworten = new GridBagConstraints();
		gbc_lblAntworten.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAntworten.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntworten.gridx = 0;
		gbc_lblAntworten.gridy = 4;
		aufgabenstellungPanel.add(lblAntworten, gbc_lblAntworten);

		JScrollPane antwortenScrollPane = new JScrollPane();
		antwortenScrollPane.setMaximumSize(new Dimension(0, 0));
		antwortenScrollPane.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_antwortenScrollPane = new GridBagConstraints();
		gbc_antwortenScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_antwortenScrollPane.fill = GridBagConstraints.BOTH;
		gbc_antwortenScrollPane.gridx = 4;
		gbc_antwortenScrollPane.gridy = 4;
		aufgabenstellungPanel.add(antwortenScrollPane, gbc_antwortenScrollPane);

		antwortenTable = new JTable();
		antwortenTable.setShowGrid(false);
		antwortenTable.setSelectionBackground(SystemColor.inactiveCaptionBorder);
		antwortenTable.setRowHeight(20);
		antwortenTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		antwortenTable.setBackground(SystemColor.inactiveCaption);
		antwortenTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		antwortenTable.getColumnModel().getColumn(0).setMaxWidth(50);
		antwortenTable.setTableHeader(null);
		antwortenScrollPane.setViewportView(antwortenTable);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.setForeground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton btnAbgabe = new JButton("Abgabe");
		btnAbgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAbgabe.setPreferredSize(new Dimension(100, 29));
		btnAbgabe.setMinimumSize(new Dimension(30, 29));
		Image abgabeIcon = new ImageIcon(this.getClass().getResource("/abgabe.png")).getImage();

		JLabel lblVersion = new JLabel("Version 1.01");
		lblVersion.setHorizontalAlignment(SwingConstants.LEFT);
		buttonPanel.add(lblVersion);
		btnAbgabe.setIcon(null);
		btnAbgabe.setBackground(SystemColor.activeCaption);
		buttonPanel.add(btnAbgabe);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 155, 187));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 66, 630, -355, 0, -164, 0, 10, 0 };
		gbl_panel.rowHeights = new int[] { 70, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		// t
		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer: 1587953");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 0;
		panel.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 3;
		gbc_lblPrfungstitel.gridy = 0;
		panel.add(lblPrfungstitel, gbc_lblPrfungstitel);
		lblPrfungstitel.setFont(new Font("Gill Sans MT", Font.PLAIN, 26));

		JLabel lblRestzeit = new JLabel("Restzeit: 24:32");
		GridBagConstraints gbc_lblRestzeit = new GridBagConstraints();
		gbc_lblRestzeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblRestzeit.gridx = 5;
		gbc_lblRestzeit.gridy = 0;
		panel.add(lblRestzeit, gbc_lblRestzeit);
		timerZeit = 60;

		String[] antworten = new String[7];
		for (int i = 0; i < antworten.length; i++) {
			antworten[i] = "Antwort " + (i + 1);
		}

		frame.pack();
		frame.setVisible(true);

	}

	public void btnAction() {

		tableAufgaben.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					controller.fuelleAufgabe(nutzer.getPruefung());
				}

			}
		});

	}

	public JTable getAntwortenTable() {
		return antwortenTable;
	}

	public JTable getAufgabenTable() {
		return tableAufgaben;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtAufgabentitel() {
		return txtAufgabentitel;
	}

	public JTextField getTxtAufgabentext() {
		return txtAufgabentext;
	}

	/*
	 * public static void main(String[] args) { PruefungView view = new 
	 * PruefungView(); }
	 */
}
