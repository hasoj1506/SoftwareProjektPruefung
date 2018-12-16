package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import Models.Nutzer;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Dimension;

public class PruefungEinweisungPopUp {
	private JTextField txtDauer;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private JFrame frame;

	private JButton btnNewButton;
	private Nutzer nutzer;
	private PruefungView view;

	public PruefungEinweisungPopUp(Nutzer nutzer, PruefungView view) {
		
		this.view = view;
		this.nutzer = nutzer;
		
		onCreate();
		btnAction();
		fuelleFelder();
		
		frame.toFront();
		view.getFrame().toBack();
		view.getFrame().setEnabled(false);
	}

	public void onCreate() {
		frame = new JFrame("Einweisung");
		frame.setUndecorated(true);
		frame.setSize(new Dimension(750, 540));
		frame.setMaximumSize(new Dimension(750, 540));
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(750, 540));

		JPanel headPanel = new JPanel();
		headPanel.setBackground(new Color(0, 155, 187));
		FlowLayout flowLayout = (FlowLayout) headPanel.getLayout();
		frame.getContentPane().add(headPanel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Einweisung");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 32));
		headPanel.add(lblNewLabel);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(infoPanel, BorderLayout.CENTER);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[] { 30, 0, 0, 30, 0 };
		gbl_infoPanel.rowHeights = new int[] { 30, 289, 79, 13, 0, 0 };
		gbl_infoPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_infoPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		infoPanel.setLayout(gbl_infoPanel);

		JTextArea txtrTestTestTest = new JTextArea();
		txtrTestTestTest.setEditable(false);
		txtrTestTestTest.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtrTestTestTest.setText("Willkommen zum digitalen Pr\u00FCfsystem examo!\r\n\r\n"
				+ "Bevor es los geht ein paar wichtige Informationen vorab:\r\n"
				+ "In der gleich folgenden Pr\u00FCfung findest du mehrere Aufgaben zum vorgebenen Thema.\r\n"
				+ "Links in der Liste kannst du zwischen den Aufgaben hin und her springen\r\noder du verwendest die \"Vorher\" , bzw. \"N\u00E4chste\" - Buttons. \r\n"
				+ "Die Aufgaben sind \"Multiple-Choice\". Es kann mehrere richtige Antworten \r\ngeben, bitte markiere die korrekten Antworten mit einem H\u00E4ckchen. \r\n"
				+ "Wenn du vor der vorgebenen Zeit fertig sein solltest benutze \r\nden \"Abgabe\" - Button, unten rechts. Der Timer oben rechts gibt die restliche Zeit vor. \r\n"
				+ "Wenn die Zeit vorbei ist, wird die Pr\u00FCfung automatisch abgegeben.\r\n\r\nBitte klicke erst auf \"Los geht's\", wenn der Dozent bescheid gibt.\r\n\r\n"
				+ "Bitte \u00FCberpr\u00FCfe vorher noch folgende Angaben auf ihre Richtigkeit:");
		txtrTestTestTest.setRows(4);
		GridBagConstraints gbc_txtrTestTestTest = new GridBagConstraints();
		gbc_txtrTestTestTest.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTestTestTest.fill = GridBagConstraints.BOTH;
		gbc_txtrTestTestTest.gridx = 2;
		gbc_txtrTestTestTest.gridy = 1;
		infoPanel.add(txtrTestTestTest, gbc_txtrTestTestTest);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		infoPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 18, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_7 = new JLabel("Teilnehmer:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		textField = new JTextField();
		textField.setBorder(null);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Matrikelnummer:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 0;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		textField_6 = new JTextField();
		textField_6.setBorder(null);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 0;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Dozent:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 0;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);

		textField_7 = new JTextField();
		textField_7.setBorder(null);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 5;
		gbc_textField_7.gridy = 0;
		panel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(102, 102, 102));
		separator.setBackground(new Color(102, 102, 102));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);

		JLabel lblNewLabel_1 = new JLabel("Pr\u00FCfungsbezeichnung:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtDauer = new JTextField();
		txtDauer.setBorder(null);
		GridBagConstraints gbc_txtDauer = new GridBagConstraints();
		gbc_txtDauer.insets = new Insets(0, 0, 5, 5);
		gbc_txtDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDauer.gridx = 1;
		gbc_txtDauer.gridy = 2;
		panel.add(txtDauer, gbc_txtDauer);
		txtDauer.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dauer:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBorder(null);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Punkte:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBorder(null);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Datum:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBorder(null);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Uhrzeit:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBorder(null);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 3;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Raum:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 3;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textField_5 = new JTextField();
		textField_5.setBorder(null);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 3;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		infoPanel.add(label, gbc_label);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout_1 = (FlowLayout) buttonPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		btnNewButton = new JButton("Los geht's!");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		buttonPanel.add(btnNewButton);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public void btnAction() {

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				view.getFrame().setEnabled(true);

			}
		});
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				view.getFrame().setEnabled(true);
			
			}
		});

	}

	public void fuelleFelder() {
		
		textField.setText(this.nutzer.getVorname() + " " + this.nutzer.getNachname());
		textField_6.setText(String.valueOf(this.nutzer.getNutzerId()));
		//textField_7.setText(this.nutzer.getPruefung().get);
		textField_1.setText(String.valueOf(this.nutzer.getPruefung().getDauer()) + " Minuten");
		txtDauer.setText(this.nutzer.getPruefung().getBezeichnung());
		textField_2.setText(String.valueOf(this.nutzer.getPruefung().getPunkte()));
		
		
		
	}

}
