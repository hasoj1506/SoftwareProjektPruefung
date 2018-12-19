package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Models.Antwort;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//Josah Weber
public class NutzerErstellenPopUp {

	String vorname;
	String nachname;
	String benutzername;
	String passwort;

	JFrame frmNutzer;
	JButton btnOk;
	private JLabel lblVorname;
	private JTextField textFieldVorname;
	private JLabel lblNachname;
	private JTextField textFieldNachname;
	private Pruefung pruefung;
	private JButton btnAbbrechen;

	/**
	 * @wbp.parser.constructor
	 */

	// Konstruktor zum neu-erstellen eines Nutzers
	public NutzerErstellenPopUp(final PruefungsDetails view, Pruefung pruefung) {
		this.pruefung = pruefung;
		onCreate();
		btnActionNeu(view, pruefung);
		addActionListeners();

	}

	// Konstruktor zum bearbeiten eines Nutzers
	public NutzerErstellenPopUp(final PruefungsDetails view, Pruefung pruefung, Nutzer nutzer) {
		this.pruefung = pruefung;
		onCreate();
		btnActionBearbeiten(view, pruefung, nutzer);

		this.textFieldVorname.setText(nutzer.getVorname());
		this.textFieldNachname.setText(nutzer.getNachname());

	}

	public void onCreate() {

		frmNutzer = new JFrame("Nutzer");
		frmNutzer.setSize(new Dimension(500, 250)); // Frame hat nicht
													// verstellbare feste Größe
		frmNutzer.setResizable(false);
		frmNutzer.setMinimumSize(new Dimension(500, 250));
		frmNutzer.setMaximumSize(new Dimension(500, 250));
		frmNutzer.setFocusable(false);
		
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frmNutzer.setIconImage(icon1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmNutzer.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAbbrechen = new JButton("Abbrechen");
		panel.add(btnAbbrechen);

		btnOk = new JButton("Speichern");
		btnOk.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOk.setMinimumSize(new Dimension(100, 35));
		btnOk.setMaximumSize(new Dimension(100, 35));
		btnOk.setSize(new Dimension(100, 35));
		panel.add(btnOk);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frmNutzer.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 45, 11, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Verdana", Font.BOLD, 16));
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 1;
		gbc_lblVorname.gridy = 1;
		panel_1.add(lblVorname, gbc_lblVorname);

		textFieldVorname = new JTextField();
		GridBagConstraints gbc_textFieldVorname = new GridBagConstraints();
		gbc_textFieldVorname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVorname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVorname.gridx = 2;
		gbc_textFieldVorname.gridy = 1;
		panel_1.add(textFieldVorname, gbc_textFieldVorname);
		textFieldVorname.setColumns(10);

		lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.EAST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.gridx = 1;
		gbc_lblNachname.gridy = 2;
		panel_1.add(lblNachname, gbc_lblNachname);

		textFieldNachname = new JTextField();
		GridBagConstraints gbc_textFieldNachname = new GridBagConstraints();
		gbc_textFieldNachname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNachname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNachname.gridx = 2;
		gbc_textFieldNachname.gridy = 2;
		panel_1.add(textFieldNachname, gbc_textFieldNachname);
		textFieldNachname.setColumns(10);

		frmNutzer.setDefaultCloseOperation(frmNutzer.DISPOSE_ON_CLOSE);
		frmNutzer.setVisible(true);
		frmNutzer.pack();
		frmNutzer.setLocationRelativeTo(null); // Frame wird in der Mitte des
												// Bildschirms erzeugt
	}

	public JFrame getFrmNutzer() {
		return frmNutzer;
	}

	
	//ActionListener zum schließen des Frames
	public void addActionListeners() {
	
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNutzer.dispose();
			}
		});
		
	
	}
	

	
	// ActionListener für den Fall, dass ein Nutzer bearbeitet wird
	public void btnActionBearbeiten(final PruefungsDetails view, final Pruefung pruefung, final Nutzer nutzer) {

		btnOk.addActionListener(new ActionListener() { // Schließt das Fenster
														// wenn "Ok" gedrückt
														// wurde

			public void actionPerformed(ActionEvent arg0) {

				// Werte aus den Feldern holen
				vorname = textFieldVorname.getText();
				nachname = textFieldNachname.getText();
				
				//Benutzernamen generieren
				Random zufall = new Random(); // neues Random Objekt, namens zufall
				int zufallsZahl = zufall.nextInt(10000); //Ganzahlige Zufallszahl zwischen 0 und 10000
				benutzername = vorname + nachname + String.valueOf(zufallsZahl);
				passwort = benutzername;
				
				//Standard-Farbfüllung der Felder
				textFieldVorname.setBackground(Color.WHITE);
				textFieldNachname.setBackground(Color.WHITE);
				
				//Nutzer die Daten zuweisen, sofern korrekt eingegeben
				if (vorname.length() <= 0) {
					textFieldVorname.setBackground(Color.RED);
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Vornamen korrekt eingeben!");
				} else if (nachname.length() <= 0) {
					textFieldNachname.setBackground(Color.RED);
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Nachnamen korrekt eingeben!");
				} else {
					nutzer.setVorname(vorname);
					nutzer.setNachname(nachname);
					nutzer.setBenutzername(benutzername);
					nutzer.setPasswort(passwort);

					view.getPruefungsDetailController().fuelleTeilnehmerTable(pruefung);

					frmNutzer.dispose();
				}
			}
		});

	}

	// ActionListener für den Fall, dass ein neuer Nutzer angelegt wird
	public void btnActionNeu(final PruefungsDetails view, final Pruefung pruefung) {

		btnOk.addActionListener(new ActionListener() { // Schließt das Fenster
														// wenn "Ok" gedrückt
														// wurde

			public void actionPerformed(ActionEvent arg0) {
				
				// Werte aus den Feldern holen
				vorname = textFieldVorname.getText();
				nachname = textFieldNachname.getText();
				
				//Benutzernamen generieren
				Random zufall = new Random(); // neues Random Objekt, namens zufall
				int zufallsZahl = zufall.nextInt(10000); //Ganzahlige Zufallszahl zwischen 0 und 10000
				benutzername = vorname + nachname + String.valueOf(zufallsZahl);
				passwort = benutzername;
				
				//Standard-Farbfüllung der Felder
				textFieldVorname.setBackground(Color.WHITE);
				textFieldNachname.setBackground(Color.WHITE);
				
				//Nutzer die Daten zuweisen, sofern korrekt eingegeben
				if (vorname.length() <= 0) {
					textFieldVorname.setBackground(Color.RED);
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Vornamen korrekt eingeben!");
				} else if (nachname.length() <= 0) {
					textFieldNachname.setBackground(Color.RED);
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Nachnamen korrekt eingeben!");
				} else {
					Nutzer nutzer = new Nutzer(vorname, nachname, benutzername, passwort, false);
					nutzer.setPruefung(pruefung);
					pruefung.addNutzer(nutzer);
					view.getPruefungsDetailController().fuelleTeilnehmerTable(pruefung);

					frmNutzer.dispose();
				}

			}
		});

	}

}
