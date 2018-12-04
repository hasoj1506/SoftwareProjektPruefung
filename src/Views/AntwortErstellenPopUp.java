package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Models.Antwort;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AntwortErstellenPopUp{

	JFrame frame;
	JButton btnOk;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField;

	boolean richtig;
	String text;

	public AntwortErstellenPopUp(final AufgabendetailsView view) {
		onCreate();
		btnAction(view);

	}

	public AntwortErstellenPopUp(final AufgabendetailsView view, Antwort antwort) {
		onCreate();
		btnAction(view);

		this.chckbxNewCheckBox.setEnabled(antwort.isIstRichtig());
		this.textField.setText(antwort.getAntworttext());

	}

	public void onCreate() {

		frame = new JFrame("Antwort");
		frame.setSize(new Dimension(500, 250)); // Frame hat nicht verstellbare feste Größe
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(500, 250));
		frame.setMaximumSize(new Dimension(500, 250));
		frame.setFocusable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnOk = new JButton("Speichern");
		btnOk.setMinimumSize(new Dimension(100, 35));
		btnOk.setMaximumSize(new Dimension(100, 35));
		btnOk.setSize(new Dimension(100, 35));
		panel.add(btnOk);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 57, -25, 180, 61, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 11, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("Antwort:");
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
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		chckbxNewCheckBox = new JCheckBox("Richtig");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null); // Frame wird in der Mitte des Bildschirms erzeugt
	}

	public void btnAction(final AufgabendetailsView view) {

		btnOk.addActionListener(new ActionListener() { // Schließt das Fenster wenn "Ok" gedrückt wurde

			public void actionPerformed(ActionEvent arg0) {

				richtig = chckbxNewCheckBox.isSelected();
				text = textField.getText();

				view.getTableModel().insertRow(view.getTableModel().getRowCount(), new Object[] {
						view.getTableModel().getRowCount() + 1, textField.getText(), chckbxNewCheckBox.isSelected() });

				frame.dispose();
			}
		});

	}

	public void btnAction(final AufgabendetailsView view, final Antwort antwort) {

		btnOk.addActionListener(new ActionListener() { // Schließt das Fenster wenn "Ok" gedrückt wurde

			public void actionPerformed(ActionEvent arg0) {

				richtig = chckbxNewCheckBox.isSelected();
				text = textField.getText();

				view.getTableModel();

				//antwort.setAntworttext(text);
				//antwort.setIstRichtig(richtig);

				//frame.dispose();
			}
		});

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

}
