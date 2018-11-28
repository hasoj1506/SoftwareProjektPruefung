package Views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AufgabenDetailsController;
import Models.Aufgabe;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AufgabendetailsView {

	private JFrame frame;
	
	private JTextField afgdTitelTextField;
	private JTextField afgdFrageTextField;
	private JTextField afgdPunkteTextField;
	
	private JTable afgdTable;
	
	private JButton afgdButtonNeuAntwort;
	private JButton afgdButtonBearbeitenAntwort;
	private JButton afgdButtonLoeschenAntwort;
	private JButton afgdButtonSpeichernAufgabe;
	private JButton afgdButtonLoescheAufgabe;
	
	AufgabenDetailsController controller;

	public AufgabendetailsView() {
		onCreate();
		
		controller = new AufgabenDetailsController();
		
		afgdButtonNeuAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonBearbeitenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonLoeschenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonSpeichernAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonLoescheAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		frame.setTitle("Aufgabendetails - Neu Aufgabe");
		
	}
	
	public AufgabendetailsView(Aufgabe aufgabe) {
		
		onCreate();
		
		controller = new AufgabenDetailsController();
		
		afgdButtonNeuAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonBearbeitenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonLoeschenAntwort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonSpeichernAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdButtonLoescheAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		afgdTitelTextField.setText(aufgabe.getAufgabentitel());
		afgdFrageTextField.setText(aufgabe.getFrageStellung());
		afgdPunkteTextField.setText(String.valueOf(aufgabe.getPunktzahl()));
		
		frame.setTitle("Aufgabendetails - " + aufgabe.getAufgabentitel());
		
		
	}

	public void onCreate() {

		this.frame = new JFrame("Aufgabendetails");
		frame.setForeground(Color.WHITE);
		frame.setMinimumSize(new Dimension(850, 650));

		JPanel eingabePanel = new JPanel();
		eingabePanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(eingabePanel, BorderLayout.NORTH);
		GridBagLayout gbl_eingabePanel = new GridBagLayout();
		gbl_eingabePanel.columnWidths = new int[]{36, 95, 356, 65, 0};
		gbl_eingabePanel.rowHeights = new int[]{43, 0, 0, 0, 0, 0, 0, 0};
		gbl_eingabePanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_eingabePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_afgdFrageTextField.anchor = GridBagConstraints.NORTH;
		gbc_afgdFrageTextField.gridheight = 3;
		gbc_afgdFrageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdFrageTextField.fill = GridBagConstraints.BOTH;
		gbc_afgdFrageTextField.gridx = 2;
		gbc_afgdFrageTextField.gridy = 2;
		eingabePanel.add(afgdFrageTextField, gbc_afgdFrageTextField);
		afgdFrageTextField.setColumns(10);
		
		JLabel afgdPunkteLabel = new JLabel("Punktzahl:");
		GridBagConstraints gbc_afgdPunkteLabel = new GridBagConstraints();
		gbc_afgdPunkteLabel.anchor = GridBagConstraints.EAST;
		gbc_afgdPunkteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_afgdPunkteLabel.gridx = 1;
		gbc_afgdPunkteLabel.gridy = 5;
		eingabePanel.add(afgdPunkteLabel, gbc_afgdPunkteLabel);
		
		afgdPunkteTextField = new JTextField();
		GridBagConstraints gbc_afgdPunkteTextField = new GridBagConstraints();
		gbc_afgdPunkteTextField.insets = new Insets(0, 0, 5, 5);
		gbc_afgdPunkteTextField.anchor = GridBagConstraints.WEST;
		gbc_afgdPunkteTextField.gridx = 2;
		gbc_afgdPunkteTextField.gridy = 5;
		eingabePanel.add(afgdPunkteTextField, gbc_afgdPunkteTextField);
		afgdPunkteTextField.setColumns(10);
		
		JPanel arbeitsPanel = new JPanel();
		arbeitsPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(arbeitsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_arbeitsPanel = new GridBagLayout();
		gbl_arbeitsPanel.columnWidths = new int[]{65, 0, 125, 65, 0};
		gbl_arbeitsPanel.rowHeights = new int[]{0, 0};
		gbl_arbeitsPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_arbeitsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		arbeitsPanel.setLayout(gbl_arbeitsPanel);
		
		JLabel afgdAntwortenLabel = new JLabel("Antworten:");
		GridBagConstraints gbc_afgdAntwortenLabel = new GridBagConstraints();
		gbc_afgdAntwortenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_afgdAntwortenLabel.insets = new Insets(0, 0, 0, 5);
		gbc_afgdAntwortenLabel.gridx = 1;
		gbc_afgdAntwortenLabel.gridy = 0;
		arbeitsPanel.add(afgdAntwortenLabel, gbc_afgdAntwortenLabel);
		
		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 0;
		arbeitsPanel.add(tableScrollPane, gbc_tableScrollPane);
		
		afgdTable = new JTable();
		afgdTable.setMinimumSize(new Dimension(500, 300));
		afgdTable.setModel(new DefaultTableModel(
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
		tableScrollPane.setViewportView(afgdTable);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 70, 10));
		
		JPanel unterPanel = new JPanel();
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[]{46, 33, 54, 0, 39, 57, 0};
		gbl_unterPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_unterPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_unterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		unterPanel.setLayout(gbl_unterPanel);
		
		JSeparator buttonSeparator = new JSeparator();
		GridBagConstraints gbc_buttonSeparator = new GridBagConstraints();
		gbc_buttonSeparator.gridwidth = 6;
		gbc_buttonSeparator.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSeparator.gridx = 0;
		gbc_buttonSeparator.gridy = 1;
		unterPanel.add(buttonSeparator, gbc_buttonSeparator);
		
		afgdButtonNeuAntwort = new JButton("Neu");
		GridBagConstraints gbc_afgdButtonNeuAntwort = new GridBagConstraints();
		gbc_afgdButtonNeuAntwort.gridwidth = 2;
		gbc_afgdButtonNeuAntwort.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonNeuAntwort.insets = new Insets(0, 0, 5, 5);
		gbc_afgdButtonNeuAntwort.gridx = 0;
		gbc_afgdButtonNeuAntwort.gridy = 0;
		unterPanel.add(afgdButtonNeuAntwort, gbc_afgdButtonNeuAntwort);
		
		afgdButtonBearbeitenAntwort = new JButton("Bearbeiten");
		GridBagConstraints gbc_afgdButtonBearbeitenAntwort = new GridBagConstraints();
		gbc_afgdButtonBearbeitenAntwort.gridwidth = 2;
		gbc_afgdButtonBearbeitenAntwort.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonBearbeitenAntwort.insets = new Insets(0, 0, 5, 5);
		gbc_afgdButtonBearbeitenAntwort.gridx = 2;
		gbc_afgdButtonBearbeitenAntwort.gridy = 0;
		unterPanel.add(afgdButtonBearbeitenAntwort, gbc_afgdButtonBearbeitenAntwort);
		
		afgdButtonLoeschenAntwort = new JButton("L\u00F6schen");
		GridBagConstraints gbc_afgdButtonLoeschenAntwort = new GridBagConstraints();
		gbc_afgdButtonLoeschenAntwort.gridwidth = 2;
		gbc_afgdButtonLoeschenAntwort.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonLoeschenAntwort.insets = new Insets(0, 0, 5, 0);
		gbc_afgdButtonLoeschenAntwort.gridx = 4;
		gbc_afgdButtonLoeschenAntwort.gridy = 0;
		unterPanel.add(afgdButtonLoeschenAntwort, gbc_afgdButtonLoeschenAntwort);
		
		afgdButtonSpeichernAufgabe = new JButton("Aufgabe Speichern");
		GridBagConstraints gbc_afgdButtonSpeichernAufgabe = new GridBagConstraints();
		gbc_afgdButtonSpeichernAufgabe.gridwidth = 3;
		gbc_afgdButtonSpeichernAufgabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonSpeichernAufgabe.insets = new Insets(0, 0, 0, 5);
		gbc_afgdButtonSpeichernAufgabe.gridx = 0;
		gbc_afgdButtonSpeichernAufgabe.gridy = 2;
		unterPanel.add(afgdButtonSpeichernAufgabe, gbc_afgdButtonSpeichernAufgabe);
		
		afgdButtonLoescheAufgabe = new JButton("Aufgabe L\u00F6schen");
		GridBagConstraints gbc_afgdButtonLoescheAufgabe = new GridBagConstraints();
		gbc_afgdButtonLoescheAufgabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_afgdButtonLoescheAufgabe.gridwidth = 3;
		gbc_afgdButtonLoescheAufgabe.gridx = 3;
		gbc_afgdButtonLoescheAufgabe.gridy = 2;
		unterPanel.add(afgdButtonLoescheAufgabe, gbc_afgdButtonLoescheAufgabe);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.pack();

	}

	public JTextField getAfgdTitelTextField() {
		return afgdTitelTextField;
	}

	public void setAfgdTitelTextField(JTextField afgdTitelTextField) {
		this.afgdTitelTextField = afgdTitelTextField;
	}

	public JTextField getAfgdFrageTextField() {
		return afgdFrageTextField;
	}

	public void setAfgdFrageTextField(JTextField afgdFrageTextField) {
		this.afgdFrageTextField = afgdFrageTextField;
	}

	public JTextField getAfgdPunkteTextField() {
		return afgdPunkteTextField;
	}

	public void setAfgdPunkteTextField(JTextField afgdPunkteTextField) {
		this.afgdPunkteTextField = afgdPunkteTextField;
	}

	public JTable getAfgdTable() {
		return afgdTable;
	}

	public void setAfgdTable(JTable afgdTable) {
		this.afgdTable = afgdTable;
	}

	public static void main(String[] ar) {
		AufgabendetailsView view = new AufgabendetailsView();
	}

}
