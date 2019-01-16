package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Student;

//Victoria Meier
public class NutzerErstellenPopUp {

	String vorname;
	String nachname;
	int matrikelnummer;

	JFrame frmNutzer;
	JButton btnOk;
	private JLabel lblVorname;
	private JTextField textFieldVorname;
	private JLabel lblNachname;
	private JTextField textFieldNachname;
	private Pruefung pruefung;
	private JButton btnAbbrechen;
	private JLabel lblMatrikelnummer;
	private JTextField textFieldMatrikelNr;
	private DatabaseService db;

	/**
	 * @wbp.parser.constructor
	 */

	// Konstruktor zum neu-erstellen eines Nutzers
	public NutzerErstellenPopUp(final PruefungsDetails view, Pruefung pruefung) {
		this.pruefung = pruefung;
		onCreate();
		btnActionNeu(view, pruefung);

	}

	// Konstruktor zum bearbeiten eines Nutzers
	public NutzerErstellenPopUp(final PruefungsDetails view, Pruefung pruefung, Student student) {
		this.pruefung = pruefung;
		onCreate();
		btnActionBearbeiten(view, pruefung, student);

		this.textFieldVorname.setText(student.getVorname());
		this.textFieldNachname.setText(student.getNachname());
		this.textFieldMatrikelNr.setText(String.valueOf(student.getMatrikelNr()));

	}

	public void onCreate() {

		frmNutzer = new JFrame("Nutzer");
		frmNutzer.setSize(new Dimension(500, 250));
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

		btnOk = new JButton("Speichern");
		btnOk.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOk.setMinimumSize(new Dimension(100, 35));
		btnOk.setMaximumSize(new Dimension(100, 35));
		btnOk.setSize(new Dimension(100, 35));
		panel.add(btnOk);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel.add(btnAbbrechen);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frmNutzer.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 45, 11, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Verdana", Font.PLAIN, 16));
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
		lblNachname.setFont(new Font("Verdana", Font.PLAIN, 16));
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

		lblMatrikelnummer = new JLabel("Matrikelnr.:");
		lblMatrikelnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatrikelnummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.EAST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 3;
		panel_1.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		textFieldMatrikelNr = new JTextField();
		textFieldMatrikelNr.setColumns(10);
		GridBagConstraints gbc_textFieldMatrikelNr = new GridBagConstraints();
		gbc_textFieldMatrikelNr.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMatrikelNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMatrikelNr.gridx = 2;
		gbc_textFieldMatrikelNr.gridy = 3;
		panel_1.add(textFieldMatrikelNr, gbc_textFieldMatrikelNr);

		frmNutzer.setDefaultCloseOperation(frmNutzer.DISPOSE_ON_CLOSE);
		frmNutzer.setVisible(true);
		frmNutzer.pack();
		frmNutzer.setLocationRelativeTo(null);
	}

	public JFrame getFrmNutzer() {
		return frmNutzer;
	}

	// ActionListener für den Fall, dass ein Nutzer bearbeitet wird
	public void btnActionBearbeiten(final PruefungsDetails view, final Pruefung pruefung, final Student student) {
		
		//Wenn speichern geklickt wird
		btnOk.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent arg0) {

				// Werte aus den Feldern holen
				vorname = textFieldVorname.getText();
				nachname = textFieldNachname.getText();

				try {
					matrikelnummer = Integer.parseInt(textFieldMatrikelNr.getText());
				} catch (Exception e) {
					matrikelnummer = 0;
				}

				// Standard-Farbfüllung der Felder
				textFieldVorname.setBackground(Color.WHITE);
				textFieldNachname.setBackground(Color.WHITE);
				textFieldMatrikelNr.setBackground(Color.WHITE);

				// Nutzer die Daten zuweisen, sofern korrekt eingegeben
				if (vorname.length() <= 0) {
					textFieldVorname.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Vornamen korrekt eingeben!");
				} else if (nachname.length() <= 0) {
					textFieldNachname.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Nachnamen korrekt eingeben!");
				} else if (matrikelnummer == 0) {
					textFieldMatrikelNr.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Matrikelnummer korrekt eingeben!");
				} else {
					student.setVorname(vorname);
					student.setNachname(nachname);
					student.setMatrikelNr(matrikelnummer);
					student.setIstImportiert(false);

					view.getPruefungsDetailController().fuelleTeilnehmerTable(pruefung);

					frmNutzer.dispose();
				}
			}
		});
		
		//Wenn abbrechen geklickt wird
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNutzer.dispose();
			}
		});

	}

	// ActionListener für den Fall, dass ein neuer Nutzer angelegt wird
	public void btnActionNeu(final PruefungsDetails view, final Pruefung pruefung) {
		
		//wenn speichern geklickt wird
		btnOk.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent arg0) {

				// Werte aus den Feldern holen
				vorname = textFieldVorname.getText();
				nachname = textFieldNachname.getText();

				try {
					matrikelnummer = Integer.parseInt(textFieldMatrikelNr.getText());
				} catch (Exception e) {
					matrikelnummer = 0;
				}

				// Standard-Farbfüllung der Felder
				textFieldVorname.setBackground(Color.WHITE);
				textFieldNachname.setBackground(Color.WHITE);
				textFieldMatrikelNr.setBackground(Color.WHITE);

				// Nutzer die Daten zuweisen, sofern korrekt eingegeben
				if (vorname.length() <= 0) {
					textFieldVorname.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Vornamen korrekt eingeben!");
				} else if (nachname.length() <= 0) {
					textFieldNachname.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Nachnamen korrekt eingeben!");
				} else if (matrikelnummer == 0) {
					textFieldMatrikelNr.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmNutzer, "Bitte Matrikelnummer korrekt eingeben!");
				} else {
					Student student = new Student(vorname, nachname, matrikelnummer);
					student.setIstImportiert(false);
					student.setPruefung(pruefung);
					pruefung.addStudent(student);

					view.getPruefungsDetailController().fuelleTeilnehmerTable(pruefung);

					frmNutzer.dispose();
				}

			}
		});
		
		//wenn abbrechen geklickt wird
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNutzer.dispose();
			}
		});

	}

}
