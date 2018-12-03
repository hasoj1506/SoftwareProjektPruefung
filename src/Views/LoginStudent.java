package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.Label;
import java.util.GregorianCalendar;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

public class LoginStudent extends JFrame {

	private JPanel contentPane;
	private GregorianCalendar calender = new GregorianCalendar();

	int day = calender.get(GregorianCalendar.DAY_OF_MONTH);
	String dayS = String.valueOf(day);

	int month = calender.get(GregorianCalendar.MONTH) + 1;
	String monthS = String.valueOf(month);

	int year = calender.get(GregorianCalendar.YEAR);
	String yearS = String.valueOf(year);
	private JTextField textFieldBenutzername;
	private JTextField textFieldPasswort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTestat = new JLabel("Testat");
		lblTestat.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblTestat = new GridBagConstraints();
		gbc_lblTestat.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestat.gridx = 0;
		gbc_lblTestat.gridy = 0;
		panel.add(lblTestat, gbc_lblTestat);

		JLabel lblDatum = new JLabel(dayS + "." + monthS + "." + yearS);

		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 1;
		panel.add(lblDatum, gbc_lblDatum);

		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer:");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatrikelnummer.gridx = 0;
		gbc_lblMatrikelnummer.gridy = 2;
		panel.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		JLabel lblVersion = new JLabel("Version");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.insets = new Insets(0, 0, 5, 0);
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 3;
		panel.add(lblVersion, gbc_lblVersion);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblBenutzername = new JLabel("Benutzername");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.gridx = 0;
		gbc_lblBenutzername.gridy = 0;
		panel_1.add(lblBenutzername, gbc_lblBenutzername);

		textFieldBenutzername = new JTextField();
		GridBagConstraints gbc_textFieldBenutzername = new GridBagConstraints();
		gbc_textFieldBenutzername.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBenutzername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBenutzername.gridx = 1;
		gbc_textFieldBenutzername.gridy = 0;
		panel_1.add(textFieldBenutzername, gbc_textFieldBenutzername);
		textFieldBenutzername.setColumns(10);

		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 0, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 1;
		panel_1.add(lblPasswort, gbc_lblPasswort);

		textFieldPasswort = new JTextField();
		textFieldPasswort.setText("");
		GridBagConstraints gbc_textFieldPasswort = new GridBagConstraints();
		gbc_textFieldPasswort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswort.gridx = 1;
		gbc_textFieldPasswort.gridy = 1;
		panel_1.add(textFieldPasswort, gbc_textFieldPasswort);
		textFieldPasswort.setColumns(10);

		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500, 300));
		setResizable(false);

	}

}
