package ui;
import services.FreightService;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.util.LinkedHashMap;

public class FreightDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private LinkedHashMap<String,Object> controlList = null;



	public FreightDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 747, 777);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Spedition");
		lblNewLabel.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 82, 182, 37);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(39, 121, 279, 45);
		contentPanel.add(textField);

		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblRelation.setBounds(39, 214, 182, 37);
		contentPanel.add(lblRelation);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 252, 280, 45);
		contentPanel.add(textField_1);

		
		JLabel lblNewLabel_1 = new JLabel("Spedition");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(415, 69, 182, 27);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Strasse");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(415, 103, 182, 27);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Land-PLZ Stadt");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(415, 139, 182, 27);
		contentPanel.add(lblNewLabel_1_2);



		JLabel lblNewLabel_1_3 = new JLabel("Ladewerk");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(415, 208, 264, 27);
		contentPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("-");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(415, 240, 264, 27);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("KundenStation ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setFont(new Font("PingFang TC", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(415, 271, 264, 27);
		contentPanel.add(lblNewLabel_1_2_1);


		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(20, 310, 695, 12);
		contentPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 747, 45);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		new ComponentMover(this,panel);
		
		JLabel lblNewLabel_2 = new JLabel(" X ");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();	
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(641, 6, 87, 33);
		panel.add(lblNewLabel_2);
		
		Object[] columnNames = {
				"Position",
				"<html><center>Fracht per<br>Tonne</html>",
				"<html>Notiz zu <br>Frachtvereinbarung</html>",
				"<html><center>Fracht <br> <center>pauschal</html>",
				"<html><center>Notiz zu <br> <center>Vrachtvereinbarung</html>",
				"Sonstiges"};

		DefaultTableModel tableModel = new DefaultTableModel(columnNames,12);
		
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:red;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>aktuell</b><html>", 0, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>1. Period"
				+ "</b><html>", 1, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>2. Period"
				+ "</b><html>", 2, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>3. Period"
				+ "</b><html>", 3, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>4. Period"
				+ "</b><html>", 4, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>5. Period"
				+ "</b><html>", 5, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>6. Period"
				+ "</b><html>", 6, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>7. Period"
				+ "</b><html>", 7, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>8. Period"
				+ "</b><html>", 8, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>9. Period"
				+ "</b><html>", 9, 0);
		tableModel.setValueAt("<html><style>\n"
				+ "  body {color:green;}\n"
				+ "  p {color:blue;}\n"
				+ "</style><b>10. Period"
				+ "</b><html>", 10, 0);
		
		
		table = new JTable(tableModel);
		table.getTableHeader().setFont(new Font("Lucida Grande",Font.PLAIN,14));
		table.getTableHeader().setPreferredSize(new Dimension(1000,40));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(190);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.setGridColor(new Color(211,211,211));
		table.setRowHeight(25);
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 349, 714, 341);
		contentPanel.add(scrollPane);
		
		JButton btnNewButton = new JButton("Knopf ...");
		btnNewButton.setBounds(488, 696, 117, 29);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Knopf ...");
		btnNewButton_1.setBounds(617, 696, 117, 29);
		contentPanel.add(btnNewButton_1);
		
		JButton btnKnopf = new JButton("Knopf ...");
		btnKnopf.setBounds(355, 696, 117, 29);
		contentPanel.add(btnKnopf);
	

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

				JButton okButton = new JButton("Speichern");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);



		controlList.put("textFieldSpedition",textField);
		controlList.put("textFieldRelation",textField_1);
		controlList.put("labelSpedName",lblNewLabel_1);
		controlList.put("labelSpedStreet",lblNewLabel_1_1);
		controlList.put("labelSpedCity",lblNewLabel_1_2);
		controlList.put("labelProducent",lblNewLabel_1_3);
		controlList.put("labelMinus",lblNewLabel_1_1_1);
		controlList.put("labelCustomer",lblNewLabel_1_2_1);
		controlList.put("table",table);
		controlList.put("buttonOk",okButton);
		controlList.put("buttonCancel",cancelButton);
		controlList.put("buttonBut1",btnNewButton);
		controlList.put("buttonBut2",btnNewButton_1);
		controlList.put("buttonBut3",btnKnopf);


		new FreightService(controlList);


	}

	public void showDialog() {
		setModal(true);
		setVisible(true);
	}
}
