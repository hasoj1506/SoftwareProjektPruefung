package Views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AufgabenDetailsController;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import TableModels.AufgabendetailsTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

//Yanek Wilken
public class AufgabendetailsView {

	private JFrame frame;
	
	private JPanel northPanel;
	private JPanel headPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;

	private JTextField afgdTitelTextField;
	private JTextField afgdFrageTextField;
	private JTextField afgdPunkteTextField;
	
	private JLabel lblPunktzahl;

	private JTable afgdTable;

	private JButton afgdButtonNeuAntwort;
	private JButton afgdButtonBearbeitenAntwort;
	private JButton afgdButtonLoeschenAntwort;
	private JButton afgdButtonSpeichernAufgabe;
	private JButton afgdButtonLoescheAufgabe;
	private JCheckBox chckbxAntwortenVerwrfenl;
	private JButton btnAbbrechen;

	private AufgabenDetailsController controller;
	private PruefungsDetails pruefungsDetailsView;

	private Pruefung pruefung;
	private Aufgabe aufgabe;

	/**
	 * @wbp.parser.entryPoint
	 */

	public AufgabendetailsView(Aufgabe aufgabe, PruefungsDetails pruefungsDetailsView) { // Konstruktor
																							// falls
																							// bestehende
																							// Aufgabe
																							// bearbeitet
																							// wird

		this.pruefungsDetailsView = pruefungsDetailsView;
		this.pruefung = aufgabe.getPruefung();
		this.aufgabe = aufgabe;
		onCreate();
		this.controller = new AufgabenDetailsController(this, this.aufgabe);
		titleCheck();
		btnAction();
		aufgabenCheck();
	}

	public void onCreate() {

		this.frame = new JFrame("Aufgabendetails");
		frame.setBackground(new Color(0, 155, 187));
		frame.setForeground(Color.WHITE);
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);
		frame.setMinimumSize(new Dimension(1200, 800));

		JPanel middleArbeitsPanel = new JPanel();
		middleArbeitsPanel.setBackground(Color.WHITE);
		middleArbeitsPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(middleArbeitsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_middleArbeitsPanel = new GridBagLayout();
		gbl_middleArbeitsPanel.columnWidths = new int[] { 20, 150, 125, 65, 0 };
		gbl_middleArbeitsPanel.rowHeights = new int[] { 0, 50, 0 };
		gbl_middleArbeitsPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_middleArbeitsPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		middleArbeitsPanel.setLayout(gbl_middleArbeitsPanel);

		JLabel afgdAntwortenLabel = new JLabel("Antworten:");
		afgdAntwortenLabel.setForeground(new Color(51, 51, 51));
		afgdAntwortenLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_afgdAntwortenLabel = new GridBagConstraints();
		gbc_afgdAntwortenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdAntwortenLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdAntwortenLabel.gridx = 1;
		gbc_afgdAntwortenLabel.gridy = 0;
		middleArbeitsPanel.add(afgdAntwortenLabel, gbc_afgdAntwortenLabel);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 0;
		middleArbeitsPanel.add(tableScrollPane, gbc_tableScrollPane);

		afgdTable = new JTable();
		afgdTable.setRowHeight(25);
		afgdTable.setFont(new Font("Verdana", Font.PLAIN, 16));
		afgdTable.setMinimumSize(new Dimension(500, 300));
		afgdTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableScrollPane.setViewportView(afgdTable);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		middleArbeitsPanel.add(panel_2, gbc_panel_2);

		afgdButtonNeuAntwort = new JButton("Neu");
		panel_2.add(afgdButtonNeuAntwort);
		afgdButtonNeuAntwort.setFont(new Font("Verdana", Font.PLAIN, 16));

		afgdButtonBearbeitenAntwort = new JButton("Bearbeiten");
		panel_2.add(afgdButtonBearbeitenAntwort);
		afgdButtonBearbeitenAntwort.setFont(new Font("Verdana", Font.PLAIN, 16));

		afgdButtonLoeschenAntwort = new JButton("L\u00F6schen");
		panel_2.add(afgdButtonLoeschenAntwort);
		afgdButtonLoeschenAntwort.setFont(new Font("Verdana", Font.PLAIN, 16));

		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(204, 204, 204));
		southPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 10));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.setBorder(null);
		southPanel.add(buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 46, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		afgdButtonSpeichernAufgabe = new JButton("Aufgabe Speichern");
		afgdButtonSpeichernAufgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_afgdButtonSpeichernAufgabe = new GridBagConstraints();
		gbc_afgdButtonSpeichernAufgabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonSpeichernAufgabe.insets = new Insets(0, 0, 0, 5);
		gbc_afgdButtonSpeichernAufgabe.gridx = 0;
		gbc_afgdButtonSpeichernAufgabe.gridy = 0;
		buttonPanel.add(afgdButtonSpeichernAufgabe, gbc_afgdButtonSpeichernAufgabe);

		afgdButtonLoescheAufgabe = new JButton("Aufgabe L\u00F6schen");
		afgdButtonLoescheAufgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_afgdButtonLoescheAufgabe = new GridBagConstraints();
		gbc_afgdButtonLoescheAufgabe.insets = new Insets(0, 0, 0, 5);
		gbc_afgdButtonLoescheAufgabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonLoescheAufgabe.gridx = 1;
		gbc_afgdButtonLoescheAufgabe.gridy = 0;
		buttonPanel.add(afgdButtonLoescheAufgabe, gbc_afgdButtonLoescheAufgabe);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.gridx = 2;
		gbc_btnAbbrechen.gridy = 0;
		buttonPanel.add(btnAbbrechen, gbc_btnAbbrechen);

		northPanel = new JPanel();
		northPanel.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[] { 596, 0 };
		gbl_northPanel.rowHeights = new int[] { 81, 32, 93, 0 };
		gbl_northPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_northPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		northPanel.setLayout(gbl_northPanel);

		headPanel = new JPanel();
		GridBagConstraints gbc_headPanel = new GridBagConstraints();
		gbc_headPanel.insets = new Insets(0, 0, 5, 0);
		gbc_headPanel.fill = GridBagConstraints.BOTH;
		gbc_headPanel.gridx = 0;
		gbc_headPanel.gridy = 0;
		headPanel.setBackground(new Color(0, 155, 187));
		northPanel.add(headPanel, gbc_headPanel);
		GridBagLayout gbl_headPanel = new GridBagLayout();
		gbl_headPanel.columnWidths = new int[] { 35, 30, 0, 0, 30, 0 };
		gbl_headPanel.rowHeights = new int[] { 50, 0, 0, 48, 0 };
		gbl_headPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_headPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		headPanel.setLayout(gbl_headPanel);

		lblNewLabel = new JLabel("Aufgabendetails");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		headPanel.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("Lege die Eigenschaften der Aufgabe fest");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		headPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("/Logo_FH_Bielefeld-652.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		headPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel eingabePanel = new JPanel();
		eingabePanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_eingabePanel = new GridBagConstraints();
		gbc_eingabePanel.fill = GridBagConstraints.BOTH;
		gbc_eingabePanel.gridx = 0;
		gbc_eingabePanel.gridy = 2;
		northPanel.add(eingabePanel, gbc_eingabePanel);
		eingabePanel.setMinimumSize(new Dimension(400, 300));
		GridBagLayout gbl_eingabePanel = new GridBagLayout();
		gbl_eingabePanel.columnWidths = new int[] { 20, 150, 169, 215, 0, 65, 0 };
		gbl_eingabePanel.rowHeights = new int[] { 43, 0, 0, 0, 0, 0 };
		gbl_eingabePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_eingabePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		eingabePanel.setLayout(gbl_eingabePanel);

		JLabel afgdTitelLabel = new JLabel("Aufgabentitel:");
		afgdTitelLabel.setForeground(new Color(51, 51, 51));
		afgdTitelLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_afgdTitelLabel = new GridBagConstraints();
		gbc_afgdTitelLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdTitelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdTitelLabel.gridx = 1;
		gbc_afgdTitelLabel.gridy = 1;
		eingabePanel.add(afgdTitelLabel, gbc_afgdTitelLabel);

		afgdTitelTextField = new JTextField();
		GridBagConstraints gbc_afgdTitelTextField = new GridBagConstraints();
		gbc_afgdTitelTextField.gridwidth = 3;
		gbc_afgdTitelTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdTitelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdTitelTextField.gridx = 2;
		gbc_afgdTitelTextField.gridy = 1;
		eingabePanel.add(afgdTitelTextField, gbc_afgdTitelTextField);
		afgdTitelTextField.setColumns(10);

		JLabel afgdFrageLabel = new JLabel("Fragestellung:");
		afgdFrageLabel.setForeground(new Color(51, 51, 51));
		afgdFrageLabel.setBackground(new Color(255, 255, 255));
		afgdFrageLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_afgdFrageLabel = new GridBagConstraints();
		gbc_afgdFrageLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdFrageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdFrageLabel.gridx = 1;
		gbc_afgdFrageLabel.gridy = 2;
		eingabePanel.add(afgdFrageLabel, gbc_afgdFrageLabel);

		afgdFrageTextField = new JTextField();
		afgdFrageTextField.setText("\r\n");
		GridBagConstraints gbc_afgdFrageTextField = new GridBagConstraints();
		gbc_afgdFrageTextField.gridwidth = 3;
		gbc_afgdFrageTextField.anchor = GridBagConstraints.NORTH;
		gbc_afgdFrageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdFrageTextField.fill = GridBagConstraints.BOTH;
		gbc_afgdFrageTextField.gridx = 2;
		gbc_afgdFrageTextField.gridy = 2;
		eingabePanel.add(afgdFrageTextField, gbc_afgdFrageTextField);
		afgdFrageTextField.setColumns(10);

		lblPunktzahl = new JLabel("Punktzahl:");
		lblPunktzahl.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPunktzahl = new GridBagConstraints();
		gbc_lblPunktzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunktzahl.anchor = GridBagConstraints.EAST;
		gbc_lblPunktzahl.gridx = 1;
		gbc_lblPunktzahl.gridy = 3;
		eingabePanel.add(lblPunktzahl, gbc_lblPunktzahl);

		afgdPunkteTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		eingabePanel.add(afgdPunkteTextField, gbc_textField);
		afgdPunkteTextField.setColumns(10);

		chckbxAntwortenVerwrfenl = new JCheckBox("Antworten verw\u00FCrfen");
		GridBagConstraints gbc_chckbxAntwortenVerwrfenl = new GridBagConstraints();
		gbc_chckbxAntwortenVerwrfenl.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAntwortenVerwrfenl.gridx = 3;
		gbc_chckbxAntwortenVerwrfenl.gridy = 3;
		eingabePanel.add(chckbxAntwortenVerwrfenl, gbc_chckbxAntwortenVerwrfenl);
		chckbxAntwortenVerwrfenl.setBackground(new Color(255, 255, 255));
		chckbxAntwortenVerwrfenl.setFont(new Font("Verdana", Font.PLAIN, 16));

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null); // Frame wird in der Mitte des
											// Bildschirms erzeugt
	}

	public void btnAction() {

		afgdButtonNeuAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.antwortErstellen();
			}
		});

		// ActionListener zum schließen des Frames
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				pruefungsDetailsView.getFrame().setVisible(true);
			}
		});

		afgdButtonBearbeitenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.antwortBearbeiten();
			}
		});

		afgdButtonLoeschenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.antwortLoeschen();
			}
		});

		afgdButtonSpeichernAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.aufgabeSpeichern();

			}
		});

		afgdButtonLoescheAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.aufgabeLoeschen();// t
			}
		});

		afgdTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					controller.antwortBearbeiten();
				}
			}
		});

	}

	public void titleCheck() { // Prüft ob Aufgabe neu erzeugt wird oder
								// bestehende Aufgabe bearbeitet wird,
								// und passt enstsprechend den Frame Titel an

		String prfTitel = "Neue Prüfung";
		String afgTitel = "Neue Aufgabe";

		if (this.pruefung.getBezeichnung() != null) {
			prfTitel = this.pruefung.getBezeichnung();
		}

		if (this.aufgabe != null && this.aufgabe.getAufgabentitel() != null) {
			afgTitel = this.aufgabe.getAufgabentitel();
		}

		frame.setTitle(prfTitel + " - Aufgabendetails - " + afgTitel);

	}

	public void aufgabenCheck() { // Trägt die Daten einer bestehenden Aufgabe
									// in die TextFields ein

		if (this.aufgabe != null) {

			afgdTitelTextField.setText(this.aufgabe.getAufgabentitel());
			afgdFrageTextField.setText(this.aufgabe.getFrageStellung());
			afgdPunkteTextField.setText(String.valueOf(this.aufgabe.getPunktzahl()));
			controller.getModel().setAntworten(new ArrayList<Antwort>(aufgabe.getAntworten()));
		}
	}

	public void fehlerMeldung(String text) {
		JOptionPane.showMessageDialog(this.frame, text);
	}

	public void schliessen() {
		this.frame.dispose();
	}

	public JTextField getAfgdTitelTextField() {
		return afgdTitelTextField;
	}

	public JTextField getAfgdFrageTextField() {
		return afgdFrageTextField;
	}

	public JTextField getAfgdPunkteTextField() {
		return afgdPunkteTextField;
	}

	public JTable getAfgdTable() {
		return afgdTable;
	}

	public JFrame getAfgdFrame() {
		return this.frame;
	}

	public AufgabenDetailsController getController() {
		return this.controller;
	}

	public Pruefung getPruefung() {
		return pruefung;
	}

	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public PruefungsDetails getPruefungsDetailsView() {
		return pruefungsDetailsView;
	}
	
	public JCheckBox getChckbxAntwortenVerwrfenl() {
		return chckbxAntwortenVerwrfenl;
	}

	public void setChckbxAntwortenVerwrfenl(JCheckBox chckbxAntwortenVerwrfenl) {
		this.chckbxAntwortenVerwrfenl = chckbxAntwortenVerwrfenl;
	}

}
