package Views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Aufgabendetails {

	private JFrame frame;
	private JTextField afgdTitelTextField;
	private JTextField afgdFrageTextField;
	private JTextField afgdPunkteTextField;
	private JTable table;

	public Aufgabendetails() {
		onCreate();
	}

	public void onCreate() {

		this.frame = new JFrame("Aufgabendetails");

		JPanel eingabePanel = new JPanel();
		frame.getContentPane().add(eingabePanel, BorderLayout.NORTH);
		GridBagLayout gbl_eingabePanel = new GridBagLayout();
		gbl_eingabePanel.columnWidths = new int[]{20, 95, 356, 65, 0};
		gbl_eingabePanel.rowHeights = new int[]{0, 0, 59, 0, 0};
		gbl_eingabePanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_eingabePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		eingabePanel.setLayout(gbl_eingabePanel);
		
		JLabel afgdTitelLabel = new JLabel("Aufgabentitel:");
		GridBagConstraints gbc_afgdTitelLabel = new GridBagConstraints();
		gbc_afgdTitelLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdTitelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdTitelLabel.gridx = 1;
		gbc_afgdTitelLabel.gridy = 1;
		eingabePanel.add(afgdTitelLabel, gbc_afgdTitelLabel);
		
		afgdTitelTextField = new JTextField();
		GridBagConstraints gbc_afgdTitelTextField = new GridBagConstraints();
		gbc_afgdTitelTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdTitelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdTitelTextField.gridx = 2;
		gbc_afgdTitelTextField.gridy = 1;
		eingabePanel.add(afgdTitelTextField, gbc_afgdTitelTextField);
		afgdTitelTextField.setColumns(10);
		
		JLabel afgdFrageLabel = new JLabel("Fragestellung:");
		GridBagConstraints gbc_afgdFrageLabel = new GridBagConstraints();
		gbc_afgdFrageLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdFrageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdFrageLabel.gridx = 1;
		gbc_afgdFrageLabel.gridy = 2;
		eingabePanel.add(afgdFrageLabel, gbc_afgdFrageLabel);
		
		afgdFrageTextField = new JTextField();
		afgdFrageTextField.setText("\r\n");
		GridBagConstraints gbc_afgdFrageTextField = new GridBagConstraints();
		gbc_afgdFrageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdFrageTextField.fill = GridBagConstraints.BOTH;
		gbc_afgdFrageTextField.gridx = 2;
		gbc_afgdFrageTextField.gridy = 2;
		eingabePanel.add(afgdFrageTextField, gbc_afgdFrageTextField);
		afgdFrageTextField.setColumns(10);
		
		JLabel afgdPunkteLabel = new JLabel("Punktzahl:");
		GridBagConstraints gbc_afgdPunkteLabel = new GridBagConstraints();
		gbc_afgdPunkteLabel.anchor = GridBagConstraints.EAST;
		gbc_afgdPunkteLabel.insets = new Insets(0, 0, 0, 5);
		gbc_afgdPunkteLabel.gridx = 1;
		gbc_afgdPunkteLabel.gridy = 3;
		eingabePanel.add(afgdPunkteLabel, gbc_afgdPunkteLabel);
		
		afgdPunkteTextField = new JTextField();
		GridBagConstraints gbc_afgdPunkteTextField = new GridBagConstraints();
		gbc_afgdPunkteTextField.insets = new Insets(0, 0, 0, 5);
		gbc_afgdPunkteTextField.anchor = GridBagConstraints.WEST;
		gbc_afgdPunkteTextField.gridx = 2;
		gbc_afgdPunkteTextField.gridy = 3;
		eingabePanel.add(afgdPunkteTextField, gbc_afgdPunkteTextField);
		afgdPunkteTextField.setColumns(10);
		
		JPanel arbeitsPanel = new JPanel();
		frame.getContentPane().add(arbeitsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_arbeitsPanel = new GridBagLayout();
		gbl_arbeitsPanel.columnWidths = new int[]{65, 0, 125, 65, 0};
		gbl_arbeitsPanel.rowHeights = new int[]{0, 0, 0};
		gbl_arbeitsPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_arbeitsPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		arbeitsPanel.setLayout(gbl_arbeitsPanel);
		
		JLabel afgdAntwortenLabel = new JLabel("Antworten:");
		GridBagConstraints gbc_afgdAntwortenLabel = new GridBagConstraints();
		gbc_afgdAntwortenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdAntwortenLabel.insets = new Insets(0, 0, 0, 5);
		gbc_afgdAntwortenLabel.gridx = 1;
		gbc_afgdAntwortenLabel.gridy = 1;
		arbeitsPanel.add(afgdAntwortenLabel, gbc_afgdAntwortenLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		arbeitsPanel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nummer", "Antwort", "Richtig"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 65, 10));
		
		JPanel panel = new JPanel();
		buttonPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 1;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.pack();

	}

	public static void main(String[] ar) {
		Aufgabendetails view = new Aufgabendetails();
	}

}
