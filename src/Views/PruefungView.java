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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.Timer;
import javax.swing.Box;
import javax.swing.DropMode;

public class PruefungView {
	Pruefung pruefung;
	Nutzer nutzer;

	private JFrame frame;
	private int timerZeit;
	private JTextField txtAufgabentext;
	private JTable antwortenTable;
	private JTable tableAufgaben;
	private JTextField txtAufgabentitel;

	JLabel lblPrfungstitel;

	PruefungViewController controller;
	private JTextField txtTimer;
	private JTextField txtMatrNr;
	private JTextField textField_2;

	JButton btnNchste;
	JButton btnVorher;
	JButton btnAbgabe;

	boolean zeitUm = false;
	public boolean isZeitUm() {
		return zeitUm;
	}

	Timer timer;
	int count = 0;
	int delay = 1000;

	public PruefungView(Nutzer nutzer) {
		this.nutzer = nutzer;
		this.pruefung = nutzer.getPruefung();
	
		erstellePruefungView();
		this.controller = new PruefungViewController(this, pruefung, nutzer);
		btnAction();
		
		PruefungEinweisungPopUp pop = new PruefungEinweisungPopUp(nutzer, this);
	}

	public void erstellePruefungView() {

		this.frame = new JFrame("Prüfung");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);

		JScrollPane aufgabenlisteScrollPane = new JScrollPane();
		aufgabenlisteScrollPane.setMinimumSize(new Dimension(200, 32));
		aufgabenlisteScrollPane.setPreferredSize(new Dimension(200, 2));
		aufgabenlisteScrollPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(aufgabenlisteScrollPane, BorderLayout.WEST);

		tableAufgaben = new JTable();
		tableAufgaben.setGridColor(new Color(255, 255, 255));
		tableAufgaben.setBackground(new Color(255, 255, 255));
		aufgabenlisteScrollPane.setViewportView(tableAufgaben);
		tableAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAufgaben.setBorder(null);

		JPanel aufgabenstellungPanel = new JPanel();
		aufgabenstellungPanel.setBackground(new Color(255, 255, 255));
		aufgabenstellungPanel.setMinimumSize(new Dimension(100, 100));
		frame.getContentPane().add(aufgabenstellungPanel, BorderLayout.CENTER);
		GridBagLayout gbl_aufgabenstellungPanel = new GridBagLayout();
		gbl_aufgabenstellungPanel.columnWidths = new int[] { 32, 114, 0, 0, 65 };
		gbl_aufgabenstellungPanel.rowHeights = new int[] { 30, 30, 34, 150, 30 };
		gbl_aufgabenstellungPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_aufgabenstellungPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		aufgabenstellungPanel.setLayout(gbl_aufgabenstellungPanel);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setHgap(50);
		panel_5.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 1;
		aufgabenstellungPanel.add(panel_5, gbc_panel_5);

		btnVorher = new JButton("<Voherige");
		btnVorher.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel_5.add(btnVorher);
		btnVorher.setHorizontalAlignment(SwingConstants.RIGHT);

		txtAufgabentitel = new JTextField("Mathepruefung 1");
		txtAufgabentitel.setBackground(new Color(255, 255, 255));
		txtAufgabentitel.setBorder(null);
		panel_5.add(txtAufgabentitel);
		txtAufgabentitel.setForeground(new Color(51, 51, 51));
		txtAufgabentitel.setDisabledTextColor(new Color(255, 255, 255));
		txtAufgabentitel.setSelectionColor(new Color(255, 255, 255));
		txtAufgabentitel.setEditable(false);
		txtAufgabentitel.setFont(new Font("Verdana", Font.BOLD, 16));
		txtAufgabentitel.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnNchste = new JButton("N\u00E4chste>");
		btnNchste.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel_5.add(btnNchste);

		JLabel lblAufgabenstellung = new JLabel("Aufgabenstellung:");
		lblAufgabenstellung.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblAufgabenstellung = new GridBagConstraints();
		gbc_lblAufgabenstellung.anchor = GridBagConstraints.NORTH;
		gbc_lblAufgabenstellung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgabenstellung.gridx = 1;
		gbc_lblAufgabenstellung.gridy = 2;
		aufgabenstellungPanel.add(lblAufgabenstellung, gbc_lblAufgabenstellung);

		txtAufgabentext = new JTextField();
		GridBagConstraints gbc_txtAufgabentext = new GridBagConstraints();
		gbc_txtAufgabentext.gridwidth = 2;
		gbc_txtAufgabentext.fill = GridBagConstraints.BOTH;
		gbc_txtAufgabentext.insets = new Insets(0, 0, 5, 5);
		gbc_txtAufgabentext.gridx = 2;
		gbc_txtAufgabentext.gridy = 2;
		aufgabenstellungPanel.add(txtAufgabentext, gbc_txtAufgabentext);
		txtAufgabentext.setFont(new Font("Verdana", Font.BOLD, 16));
		txtAufgabentext.setColumns(10);

		JLabel lblAntworten = new JLabel("Antworten:");
		lblAntworten.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblAntworten = new GridBagConstraints();
		gbc_lblAntworten.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAntworten.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntworten.gridx = 1;
		gbc_lblAntworten.gridy = 3;
		aufgabenstellungPanel.add(lblAntworten, gbc_lblAntworten);

		JScrollPane antwortenScrollPane = new JScrollPane();
		antwortenScrollPane.setMaximumSize(new Dimension(0, 0));
		antwortenScrollPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_antwortenScrollPane = new GridBagConstraints();
		gbc_antwortenScrollPane.gridwidth = 2;
		gbc_antwortenScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_antwortenScrollPane.fill = GridBagConstraints.BOTH;
		gbc_antwortenScrollPane.gridx = 2;
		gbc_antwortenScrollPane.gridy = 3;
		aufgabenstellungPanel.add(antwortenScrollPane, gbc_antwortenScrollPane);

		antwortenTable = new JTable();
		antwortenTable.setShowGrid(false);
		antwortenTable.setSelectionBackground(SystemColor.inactiveCaptionBorder);
		antwortenTable.setRowHeight(35);
		antwortenTable.setFont(new Font("Verdana", Font.BOLD, 16));
		antwortenTable.setBackground(SystemColor.inactiveCaption);
		antwortenTable.setTableHeader(null);
		antwortenTable.setRowSelectionAllowed(false);
		antwortenScrollPane.setViewportView(antwortenTable);
		Image abgabeIcon = new ImageIcon(this.getClass().getResource("/abgabe.png")).getImage();

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 155, 187));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 121, 75, 104, 75, 150, 0 };
		gbl_panel.rowHeights = new int[] { 41, 30, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 50, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 20, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);
		// t
		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer: \r\n");
		lblMatrikelnummer.setForeground(new Color(255, 255, 255));
		lblMatrikelnummer.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.fill = GridBagConstraints.VERTICAL;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 0;
		panel_4.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		txtMatrNr = new JTextField();
		txtMatrNr.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatrNr.setForeground(Color.WHITE);
		txtMatrNr.setFont(new Font("Verdana", Font.BOLD, 12));
		txtMatrNr.setText("115462");
		txtMatrNr.setBorder(null);
		txtMatrNr.setBackground(new Color(0, 155, 187));
		txtMatrNr.setEditable(false);
		txtMatrNr.setSelectedTextColor(new Color(0, 155, 187));
		GridBagConstraints gbc_txtMatrNr = new GridBagConstraints();
		gbc_txtMatrNr.gridx = 1;
		gbc_txtMatrNr.gridy = 1;
		panel_4.add(txtMatrNr, gbc_txtMatrNr);
		txtMatrNr.setColumns(10);

		lblPrfungstitel = new JLabel("Pr\u00FCfungstitel");
		lblPrfungstitel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 2;
		gbc_lblPrfungstitel.gridy = 0;
		panel.add(lblPrfungstitel, gbc_lblPrfungstitel);
		lblPrfungstitel.setFont(new Font("Gill Sans MT", Font.BOLD, 30));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 4;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 65, 0 };
		gbl_panel_3.rowHeights = new int[] { 20, 23, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblRestzeit = new JLabel("Restzeit: ");
		lblRestzeit.setForeground(new Color(255, 255, 255));
		lblRestzeit.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblRestzeit = new GridBagConstraints();
		gbc_lblRestzeit.fill = GridBagConstraints.VERTICAL;
		gbc_lblRestzeit.insets = new Insets(0, 0, 5, 0);
		gbc_lblRestzeit.gridx = 0;
		gbc_lblRestzeit.gridy = 0;
		panel_3.add(lblRestzeit, gbc_lblRestzeit);

		txtTimer = new JTextField();
		txtTimer.setForeground(Color.WHITE);
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setFont(new Font("Verdana", Font.BOLD, 24));
		txtTimer.setBorder(null);
		txtTimer.setBackground(new Color(0, 155, 187));
		txtTimer.setEditable(false);
		GridBagConstraints gbc_txtTimer = new GridBagConstraints();
		gbc_txtTimer.gridx = 0;
		gbc_txtTimer.gridy = 1;
		panel_3.add(txtTimer, gbc_txtTimer);
		txtTimer.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 279, 205, 0 };
		gbl_panel_1.rowHeights = new int[] { 39, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.EAST;
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 0;
		panel_1.add(buttonPanel, gbc_buttonPanel);
		buttonPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.setForeground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setVgap(7);
		flowLayout.setHgap(36);
		flowLayout.setAlignment(FlowLayout.RIGHT);

		btnAbgabe = new JButton("Abgabe");
		btnAbgabe.setSize(new Dimension(50, 0));
		btnAbgabe.setMaximumSize(new Dimension(50, 29));
		btnAbgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAbgabe.setPreferredSize(new Dimension(100, 29));
		btnAbgabe.setMinimumSize(new Dimension(50, 29));
		btnAbgabe.setIcon(null);
		btnAbgabe.setBackground(SystemColor.activeCaption);
		buttonPanel.add(btnAbgabe);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(7);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);

		JLabel lblVersion = new JLabel("Version:");
		panel_2.add(lblVersion);
		lblVersion.setHorizontalAlignment(SwingConstants.LEFT);

		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(204, 204, 204));
		textField_2.setSelectedTextColor(new Color(204, 204, 204));
		textField_2.setEditable(false);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		timerZeit = 60;

		String[] antworten = new String[7];
		for (int i = 0; i < antworten.length; i++) {
			antworten[i] = "Antwort " + (i + 1);
		}

		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);

	}

	public void btnAction() {

		btnNchste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.naechste();

			}
		});

		btnVorher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.vorherige();
			}
		});

		btnAbgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
						controller.abgeben(); 
				
			}
		});

		tableAufgaben.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					controller.fuelleAufgabe();
				}

			}
			
			public void mouseReleased(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					controller.fuelleAufgabe();
				}

			}

		});

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				
				frame.dispose();
				controller.abgeben();
				
			}
		});
		
	}

	public void timerAction(int countPassed) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (count == 0) {
					timer.stop();
					zeitUm = true;
					txtTimer.setText("Zeit abgelaufen");
					if(controller.isAbgegeben() == false) {
						controller.timerAbgelaufen();
					}
				} else {

					if (count / 60 < 10) {
						txtTimer.setForeground(Color.RED);
					}

					if (count % 60 < 10) {
						txtTimer.setText("" + count / 60 + ":0" + count % 60);
						count--;
					} else {
						txtTimer.setText("" + count / 60 + ":" + count % 60);
						count--;
					}
				}
			}
		};
		timer = new Timer(delay, action);
		timer.setRepeats(true);
		// timer.setInitialDelay(0);
		timer.start();
		count = countPassed;
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

	public JTextField getTxtMatrikelnummer() {
		return txtMatrNr;
	}

	public JLabel getLblPrfungstitel() {
		return lblPrfungstitel;
	}

	public Pruefung getPruefung() {
		return pruefung;
	}
	
	public Timer getTimer() {
		return timer;
	}

	/*
	 * public static void main(String[] args) { PruefungView view = new
	 * PruefungView(); }
	 */
}
