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

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

import Models.Pruefung;
import Models.Termin;

//Marco Penner
public class TerminErstellenPopUp {

	String datum;
	String uhrzeit;
	String raum;

	JFrame frmTermin;
	JButton btnOk;
	private JLabel lblDatum;
	private JLabel lblRaum;
	private DatePicker datePicker;
	private JLabel lblUhrzeit;
	private TimePicker timePicker;
	private JTextField textFieldRaum;

	private Pruefung pruefung;
	private JButton btnAbbrechen;

	/**
	 * @wbp.parser.constructor
	 */

	// Konstruktor zum neu-erstellen eines Termins
	public TerminErstellenPopUp(final PruefungsDetails view, Pruefung pruefung) {

		this.pruefung = pruefung;
		onCreate();
		btnActionNeu(view, pruefung);
	}

	// Konstruktor zum bearbeiten eines Termin
	public TerminErstellenPopUp(final PruefungsDetails view, Pruefung pruefung, Termin termin) {

		this.pruefung = pruefung;
		onCreate();
		btnActionBearbeiten(view, pruefung, termin);
		fuelleTerminPopUp(termin);
	}

	public void onCreate() {

		frmTermin = new JFrame("Termin");
		frmTermin.setSize(new Dimension(500, 250));
		frmTermin.setResizable(false);
		frmTermin.setMinimumSize(new Dimension(500, 250));
		frmTermin.setMaximumSize(new Dimension(500, 250));
		frmTermin.setFocusable(false);
		frmTermin.setLocationRelativeTo(null);

		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frmTermin.setIconImage(icon1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmTermin.getContentPane().add(panel, BorderLayout.SOUTH);
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
		frmTermin.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 45, 11, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblDatum = new JLabel("Datum:");
		lblDatum.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblDatum.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.EAST;
		gbc_lblDatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatum.gridx = 1;
		gbc_lblDatum.gridy = 1;
		panel_1.add(lblDatum, gbc_lblDatum);

		datePicker = new DatePicker();
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.gridx = 2;
		gbc_datePicker.gridy = 1;
		panel_1.add(datePicker, gbc_datePicker);

		lblUhrzeit = new JLabel("Uhrzeit:");
		lblUhrzeit.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUhrzeit = new GridBagConstraints();
		gbc_lblUhrzeit.anchor = GridBagConstraints.EAST;
		gbc_lblUhrzeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeit.gridx = 1;
		gbc_lblUhrzeit.gridy = 2;
		panel_1.add(lblUhrzeit, gbc_lblUhrzeit);

		timePicker = new TimePicker();
		GridBagConstraints gbc_timePicker = new GridBagConstraints();
		gbc_timePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_timePicker.insets = new Insets(0, 0, 5, 5);
		gbc_timePicker.gridx = 2;
		gbc_timePicker.gridy = 2;
		panel_1.add(timePicker, gbc_timePicker);

		lblRaum = new JLabel("Raum:");
		lblRaum.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRaum.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblRaum = new GridBagConstraints();
		gbc_lblRaum.anchor = GridBagConstraints.EAST;
		gbc_lblRaum.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaum.gridx = 1;
		gbc_lblRaum.gridy = 3;
		panel_1.add(lblRaum, gbc_lblRaum);

		textFieldRaum = new JTextField();
		textFieldRaum.setColumns(10);
		GridBagConstraints gbc_textFieldRaum = new GridBagConstraints();
		gbc_textFieldRaum.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRaum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRaum.gridx = 2;
		gbc_textFieldRaum.gridy = 3;
		panel_1.add(textFieldRaum, gbc_textFieldRaum);

		frmTermin.setDefaultCloseOperation(frmTermin.DISPOSE_ON_CLOSE);
		frmTermin.setVisible(true);
		frmTermin.pack();
		frmTermin.setLocationRelativeTo(null);
	}

	public JFrame getFrmTermin() {
		return frmTermin;
	}

	public void fuelleTerminPopUp(Termin termin) {

		this.datePicker.setText(termin.getDatum());
		this.timePicker.setText(termin.getUhrzeit());
		this.textFieldRaum.setText(termin.getRaum());
	}

	// ActionListener beim Bearbeiten eines Termins
	public void btnActionBearbeiten(final PruefungsDetails view, final Pruefung pruefung, final Termin termin) {

		// wenn speichern geklickt wird
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// Werte der Felder holen
				datum = datePicker.getText();
				uhrzeit = timePicker.getText();
				raum = textFieldRaum.getText();

				// Standard-Füllfarben
				datePicker.setBackground(Color.WHITE);
				timePicker.setBackground(Color.WHITE);
				textFieldRaum.setBackground(Color.WHITE);

				// Bei gültigen Eingaben Termin bearbeiten
				if (datum.length() == 0) {
					datePicker.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte das Datum eingeben!");
				} else if (uhrzeit.length() == 0) {
					timePicker.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte die Uhrzeit eingeben!");
				} else if (raum.length() <= 0) {
					textFieldRaum.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte den Raum im korrekten Format eingeben!");
				} else {
					termin.setDatum(datum);
					termin.setUhrzeit(uhrzeit);
					termin.setRaum(raum);

					view.getPruefungsDetailController().fuelleTermineTable(pruefung);

					frmTermin.dispose();
				}
			}
		});

		// wenn abbrechen geklickt wird
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTermin.dispose();
			}
		});

	}

	// ActionListener beim Erstellen eines Termins
	public void btnActionNeu(final PruefungsDetails view, final Pruefung pruefung) {

		// wenn speichern geklickt wird
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// Werte der Felder holen
				datum = datePicker.getText();
				uhrzeit = timePicker.getText();
				raum = textFieldRaum.getText();

				// Standard-Füllfarben
				datePicker.setBackground(Color.WHITE);
				timePicker.setBackground(Color.WHITE);
				textFieldRaum.setBackground(Color.WHITE);

				// Bei gültigen Eingaben Termin erstellen
				if (datum.length() == 0) {
					datePicker.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte das Datum eingeben!");
				} else if (uhrzeit.length() == 0) {
					timePicker.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte die Uhrzeit eingeben!");
				} else if (raum.length() <= 0) {
					textFieldRaum.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frmTermin, "Bitte den Raum im korrekten Format eingeben!");
				} else {
					Termin termin = new Termin(datum, uhrzeit, raum, pruefung);

					pruefung.addTermin(termin);
					view.getPruefungsDetailController().fuelleTermineTable(pruefung);

					frmTermin.dispose();
				}
			}
		});

		// wenn abbrechen geklickt wird
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTermin.dispose();
			}
		});

	}

}
