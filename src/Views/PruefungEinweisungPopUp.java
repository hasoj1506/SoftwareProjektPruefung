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
import Models.Student;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Dimension;

//Firat Aslan
public class PruefungEinweisungPopUp {
	private JTextField txtDauer;
	private JTextField textField_1;
	private JTextField txtPunkte;
	private JTextField txtTeilnehmer;
	private JTextField txtMatrikelnr;

	private JFrame frame;

	private JButton btnNewButton;
	private Student student;
	private PruefungView view;
	private JTextField textField;

	public PruefungEinweisungPopUp(Student student, PruefungView view) {

		this.view = view;
		this.student = student;

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
		// frame.setSize(new Dimension(750, 540));
		// frame.setMaximumSize(new Dimension(750, 540));
		// frame.setResizable(false);
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
		gbl_infoPanel.rowHeights = new int[] { 30, 289, 30, 79, 30, 0, 0 };
		gbl_infoPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_infoPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		infoPanel.setLayout(gbl_infoPanel);

		JTextArea txtrTestTestTest = new JTextArea();
		txtrTestTestTest.setEditable(false);
		txtrTestTestTest.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtrTestTestTest.setText("Willkommen zum digitalen Pr\u00FCfsystem examo!\r\n\r\nBevor es los geht ein paar wichtige Informationen vorab:\r\nIn der gleich folgenden Pr\u00FCfung findest Du mehrere Aufgaben zum vorgegebenen Thema.\r\nLinks in der Liste kannst Du zwischen den Aufgaben hin- und herspringen\r\noder Du verwendest die \"Vorherige-/N\u00E4chste-Buttons\". \r\nDie Aufgaben sind \"Multiple-Choice\". Es kann mehrere richtige Antworten \r\ngeben, bitte markiere die korrekten Antworten mit einem H\u00E4kchen. \r\nWenn Du vor der vorgegebenen Zeit fertig bist, benutze den \"Abgabe-Button\" unten rechts.\r\nDer Timer oben rechts gibt die restliche Zeit vor. \r\nWenn die Zeit vorbei ist, wird die Pr\u00FCfung automatisch abgegeben.\r\n\r\nBitte klicke erst auf \"Los geht's\", wenn der Dozent dazu auffordert.\r\n\r\nBitte \u00FCberpr\u00FCfe vorher noch folgende Angaben auf ihre Richtigkeit:");
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
		gbc_panel.gridy = 3;
		infoPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 18, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_7 = new JLabel("Teilnehmer:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		txtTeilnehmer = new JTextField();
		txtTeilnehmer.setEditable(false);
		txtTeilnehmer.setBorder(null);
		GridBagConstraints gbc_txtTeilnehmer = new GridBagConstraints();
		gbc_txtTeilnehmer.insets = new Insets(0, 0, 5, 5);
		gbc_txtTeilnehmer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTeilnehmer.gridx = 1;
		gbc_txtTeilnehmer.gridy = 0;
		panel.add(txtTeilnehmer, gbc_txtTeilnehmer);
		txtTeilnehmer.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Matrikelnummer:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 0;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		txtMatrikelnr = new JTextField();
		txtMatrikelnr.setEditable(false);
		txtMatrikelnr.setBorder(null);
		GridBagConstraints gbc_txtMatrikelnr = new GridBagConstraints();
		gbc_txtMatrikelnr.insets = new Insets(0, 0, 5, 5);
		gbc_txtMatrikelnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatrikelnr.gridx = 3;
		gbc_txtMatrikelnr.gridy = 0;
		panel.add(txtMatrikelnr, gbc_txtMatrikelnr);
		txtMatrikelnr.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pr\u00FCfung:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtDauer = new JTextField();
		txtDauer.setEditable(false);
		txtDauer.setBorder(null);
		GridBagConstraints gbc_txtDauer = new GridBagConstraints();
		gbc_txtDauer.insets = new Insets(0, 0, 5, 0);
		gbc_txtDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDauer.gridx = 5;
		gbc_txtDauer.gridy = 0;
		panel.add(txtDauer, gbc_txtDauer);
		txtDauer.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(102, 102, 102));
		separator.setBackground(new Color(102, 102, 102));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 2;
		panel.add(lblStatus, gbc_lblStatus);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(null);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dauer:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBorder(null);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Gesamtpunkte:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtPunkte = new JTextField();
		txtPunkte.setEditable(false);
		txtPunkte.setBorder(null);
		GridBagConstraints gbc_txtPunkte = new GridBagConstraints();
		gbc_txtPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPunkte.gridx = 5;
		gbc_txtPunkte.gridy = 2;
		panel.add(txtPunkte, gbc_txtPunkte);
		txtPunkte.setColumns(10);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 5;
		infoPanel.add(label, gbc_label);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout_1 = (FlowLayout) buttonPanel.getLayout();
		flowLayout_1.setHgap(25);
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
				view.getFrame().setAlwaysOnTop(true);
				view.getController().fuelleAufgabenTabelle();
				view.timerAction(view.getPruefung().getDauer() * 60);

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

		txtTeilnehmer.setText(this.student.getVorname() + " " + this.student.getNachname());
		txtMatrikelnr.setText(String.valueOf(this.student.getMatrikelNr()));
		textField_1.setText(String.valueOf(this.student.getPruefung().getDauer()) + " Minuten");
		txtDauer.setText(this.student.getPruefung().getBezeichnung());
		txtPunkte.setText(String.valueOf(this.student.getPruefung().getPunkte()));
		
		if(this.student.getPruefung().isFreigegeben() == true) {
			textField.setText("Freigegeben");
		}else {
			textField.setText("Gesperrt");
		}
		
		
	}

}
