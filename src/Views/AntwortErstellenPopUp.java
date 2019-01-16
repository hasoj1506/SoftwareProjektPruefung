package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Models.Antwort;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Yanek Wilken
public class AntwortErstellenPopUp {

	private JFrame frame;
	private JButton btnOk;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField;
	private JButton btnAbbrechen;

	private boolean richtig;
	private String text;
	private int punkte;

	/**
	 * @wbp.parser.constructor
	 */
	//Konstruktor für Antwort erstellen
	public AntwortErstellenPopUp(final AufgabendetailsView view) {
		onCreate();
		btnAction(view);
		addActionListeners();

	}
	//Konstruktor für Antwort bearbeiten
	public AntwortErstellenPopUp(final AufgabendetailsView view, Antwort antwort) {
		onCreate();
		btnAction(view, antwort);
		attributCheck(antwort);
	}

	public void onCreate() {

		frame = new JFrame("Antwort");
		frame.setSize(new Dimension(500, 250)); // Frame hat nicht verstellbare feste Größe
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(500, 250));
		frame.setMaximumSize(new Dimension(500, 250));
		frame.setFocusable(false);
		
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
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
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 51, 11, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("Antwort:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		lblNewLabel_2 = new JLabel("Richtig:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null); // Frame wird in der Mitte des Bildschirms erzeugt
	}

	//ActionListener für Antwort erstellen
	public void btnAction(final AufgabendetailsView view) {

		btnOk.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent arg0) {

				richtig = chckbxNewCheckBox.isSelected();
				text = textField.getText();

				if (text == ("") || text.length() == 0) {
					textField.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frame, "Der Antworttext darf nicht leer sein!");
				} else {

					Antwort antwort = new Antwort(text, richtig, view.getController().getAufgabe());

					view.getController().getModel().addRow(antwort);

					view.getAfgdTable().updateUI();

					view.getAfgdFrame().setEnabled(true);
					frame.dispose();
				}
			}
		});

	}
	//ActionListener für Antwort bearbeiten
	public void btnAction(final AufgabendetailsView view, final Antwort antwort) {

		btnOk.addActionListener(new ActionListener() { // Schließt das Fenster wenn "Ok" gedrückt wurde
				

			public void actionPerformed(ActionEvent arg0) {

				richtig = chckbxNewCheckBox.isSelected();
				text = textField.getText();

				if (text == ("") || text.length() == 0) {
					textField.setBackground(new Color(255, 102, 102));
					JOptionPane.showMessageDialog(frame, "Der Antworttext darf nicht leer sein!");
				} else {

					antwort.setAntworttext(text);
					antwort.setIstRichtig(richtig);

					view.getAfgdTable().updateUI();

					view.getAfgdFrame().setEnabled(true);
					frame.dispose();
								
				}
			}
		});
		
		

	}

	//ActionListener zum schließen des Frames
	public void addActionListeners() {
		
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
	
	//Überprüfung der geöffneten Antwort
	private void attributCheck(Antwort antwort) {
		
		this.chckbxNewCheckBox.setSelected(antwort.isIstRichtig());
		this.textField.setText(antwort.getAntworttext());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isRichtig() {
		return richtig;
	}

	public void setRichtig(boolean richtig) {
		this.richtig = richtig;
	}

	public int getPunktzahl() {
		return this.punkte;
	}

	public void setPunktzahl(int punktzahl) {
		this.punkte = punktzahl;
	}

}
