package Views;
import javax.swing.*;
import java.awt.*;


public class Aufgabendetails {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	
	public Aufgabendetails() {
		
		this.frame = new JFrame("Aufgabendetails");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Aufgabentitel:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 7;
		gbc_label.gridy = 5;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 5;
		panel.add(textField, gbc_textField);
		
		JLabel label_1 = new JLabel("Aufgabentext:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 7;
		gbc_label_1.gridy = 6;
		panel.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 8;
		gbc_textField_1.gridy = 6;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel label_2 = new JLabel("Punktzahl:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 7;
		panel.add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 7;
		panel.add(textField_2, gbc_textField_2);
		
		JLabel label_3 = new JLabel("Antworten:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 7;
		gbc_label_3.gridy = 8;
		panel.add(label_3, gbc_label_3);
		
		table = new JTable();
		table.setPreferredSize(new Dimension(150, 400));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 8;
		gbc_table.gridy = 8;
		panel.add(table, gbc_table);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Speichern");
		btnNewButton_1.setIcon(new ImageIcon(Aufgabendetails.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("L\u00F6schen");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(1);
		flowLayout_2.setHgap(1);
		flowLayout_2.setAlignment(FlowLayout.TRAILING);
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("Neu");
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Bearbeiten");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("L\u00F6schen");
		panel_3.add(btnNewButton_4);
		
		
		
		
		frame.setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// frame.pack();
		
	}
	
	
	
	
}



