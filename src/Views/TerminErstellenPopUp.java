package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Models.Antwort;
import Models.Pruefung;
import Models.Termin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Josah Weber
public class TerminErstellenPopUp {

	JFrame frmTermin;
	JButton btnOk;
	private JLabel lblDatum;
	private JLabel lblRaum;
	private JTextField textFieldDatum;

	boolean richtig;
	String datum;
	String uhrzeit;
	String raum;
	private JLabel lblUhrzeit;
	private JTextField textFieldUhrzeit;
	private JTextField textFieldRaum;
	private Pruefung pruefung;

	/**
	 * @wbp.parser.constructor
	 */
	public TerminErstellenPopUp(final PruefungsDetails view, Pruefung pruefung) {
		this.pruefung = pruefung;
		onCreate();
		btnAction(view);

	}

	public TerminErstellenPopUp(final PruefungsDetails view, Pruefung pruefung, Termin termin) {
		this.pruefung = pruefung;
		onCreate();
		btnAction(view);

		this.textFieldDatum.setText(termin.getDatum());
		this.textFieldUhrzeit.setText(termin.getUhrzeit());
		this.textFieldRaum.setText(termin.getRaum());

	}

	public void onCreate() {

		frmTermin = new JFrame("Termin");
		frmTermin.setSize(new Dimension(500, 250)); // Frame hat nicht verstellbare feste Gr��e
		frmTermin.setResizable(false);
		frmTermin.setMinimumSize(new Dimension(500, 250));
		frmTermin.setMaximumSize(new Dimension(500, 250));
		frmTermin.setFocusable(false);

		JPanel panel = new JPanel();
		frmTermin.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnOk = new JButton("Speichern");
		btnOk.setMinimumSize(new Dimension(100, 35));
		btnOk.setMaximumSize(new Dimension(100, 35));
		btnOk.setSize(new Dimension(100, 35));
		panel.add(btnOk);

		JPanel panel_1 = new JPanel();
		frmTermin.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 45, 11, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblDatum = new JLabel("Datum:");
		lblDatum.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.EAST;
		gbc_lblDatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatum.gridx = 1;
		gbc_lblDatum.gridy = 1;
		panel_1.add(lblDatum, gbc_lblDatum);

		textFieldDatum = new JTextField();
		GridBagConstraints gbc_textFieldDatum = new GridBagConstraints();
		gbc_textFieldDatum.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDatum.gridx = 2;
		gbc_textFieldDatum.gridy = 1;
		panel_1.add(textFieldDatum, gbc_textFieldDatum);
		textFieldDatum.setColumns(10);

		lblUhrzeit = new JLabel("Uhrzeit:");
		GridBagConstraints gbc_lblUhrzeit = new GridBagConstraints();
		gbc_lblUhrzeit.anchor = GridBagConstraints.EAST;
		gbc_lblUhrzeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeit.gridx = 1;
		gbc_lblUhrzeit.gridy = 2;
		panel_1.add(lblUhrzeit, gbc_lblUhrzeit);

		textFieldUhrzeit = new JTextField();
		GridBagConstraints gbc_textFieldUhrzeit = new GridBagConstraints();
		gbc_textFieldUhrzeit.anchor = GridBagConstraints.WEST;
		gbc_textFieldUhrzeit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUhrzeit.gridx = 2;
		gbc_textFieldUhrzeit.gridy = 2;
		panel_1.add(textFieldUhrzeit, gbc_textFieldUhrzeit);
		textFieldUhrzeit.setColumns(10);

		lblRaum = new JLabel("Raum:");
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
		frmTermin.setLocationRelativeTo(null); // Frame wird in der Mitte des Bildschirms erzeugt
	}

	public void btnAction(final PruefungsDetails view) {

		btnOk.addActionListener(new ActionListener() { // Schlie�t das Fenster wenn "Ok" gedr�ckt wurde

			public void actionPerformed(ActionEvent arg0) {

				datum = textFieldDatum.getText();
				uhrzeit = textFieldUhrzeit.getText();
				raum = textFieldRaum.getText();
				Termin termin = new Termin(datum, uhrzeit, raum, pruefung);

				pruefung.addTermin(termin);
				view.getPruefungsDetailController().fuelleTermineTable(pruefung);

				frmTermin.dispose();
			}
		});

	}

}
