package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;

public class LoginAbfrage {

	private JFrame frame;
	private JButton btnProfessor;
	private JButton btnStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAbfrage window = new LoginAbfrage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAbfrage() {
		initialize();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 30, 0, 0, 0, 30, 0};
		gbl_panel_1.rowHeights = new int[] {0, 70};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(25, 10));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		
		btnStudent = new JButton("Student");
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStudent.setPreferredSize(new Dimension(150, 40));
		btnStudent.setMinimumSize(new Dimension(99, 29));
		btnStudent.setMaximumSize(new Dimension(99, 29));
		GridBagConstraints gbc_btnStudent = new GridBagConstraints();
		gbc_btnStudent.insets = new Insets(0, 0, 0, 5);
		gbc_btnStudent.gridx = 2;
		gbc_btnStudent.gridy = 0;
		panel_1.add(btnStudent, gbc_btnStudent);
		
		btnProfessor = new JButton("Professor");
		btnProfessor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProfessor.setPreferredSize(new Dimension(150, 40));
		GridBagConstraints gbc_btnProfessor = new GridBagConstraints();
		gbc_btnProfessor.insets = new Insets(0, 0, 0, 5);
		gbc_btnProfessor.gridx = 4;
		gbc_btnProfessor.gridy = 0;
		panel_1.add(btnProfessor, gbc_btnProfessor);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 5;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblIchBin = new JLabel("Ich bin:");
		lblIchBin.setFont(new Font("Tahoma", Font.PLAIN, 37));
		GridBagConstraints gbc_lblIchBin = new GridBagConstraints();
		gbc_lblIchBin.fill = GridBagConstraints.VERTICAL;
		gbc_lblIchBin.gridx = 0;
		gbc_lblIchBin.gridy = 0;
		panel_2.add(lblIchBin, gbc_lblIchBin);
		
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void addActionListeners(){
		
		btnStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LoginStudent studentView = new LoginStudent();
			}
		});
		
		btnStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LoginPruefungsverwaltung pruefungView = new LoginPruefungsverwaltung();
			}
		});
	}

}
