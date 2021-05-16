package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;

public class AddCustomerStationDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public AddCustomerStationDlg() {
		setUndecorated(true);
		setBounds(100, 100, 752, 716);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 6, 834, 704);
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(-1, 1, 751, 38);
		contentPanel.add(panel);
		panel.setLayout(null);

		new ComponentMover(this, panel);

		JLabel lblCloseDialog = new JLabel("  X  ");
		lblCloseDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

		
		});
		lblCloseDialog.setForeground(new Color(255, 255, 255));
		lblCloseDialog.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCloseDialog.setBackground(new Color(255, 255, 255));
		lblCloseDialog.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseDialog.setBounds(688, 3, 49, 26);
		panel.add(lblCloseDialog);
		
		
		JLabel lblNewLabel = new JLabel("Kunden bestimmen");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(39, 68, 154, 16);
		contentPanel.add(lblNewLabel);

		JTextField searchCustomer = new JTextField();
		searchCustomer.setForeground(new Color(255, 255, 255));
		searchCustomer.setBackground(new Color(112, 128, 144));
		searchCustomer.setBounds(38, 88, 326, 26);
		contentPanel.add(searchCustomer);
		searchCustomer.setColumns(10);
		searchCustomer.setBorder(BorderFactory.createEmptyBorder());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 121, 326, 12);
		contentPanel.add(separator);
		
		JLabel lblSearch = new JLabel("Suchen");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setBounds(380, 68, 93, 58);
		contentPanel.add(lblSearch);
		
		
		setPullDownList();
		
		
		JLabel lblCompaniname = new JLabel("   Firmenname * ");
		lblCompaniname.setForeground(new Color(255, 255, 255));
		lblCompaniname.setBounds(22, 320, 121, 16);
		contentPanel.add(lblCompaniname);

		JTextField newStationName = new JTextField();
		newStationName.setForeground(new Color(255, 255, 255));
		newStationName.setBackground(new Color(112, 128, 144));
		newStationName.setBounds(32, 348, 238, 26);
		contentPanel.add(newStationName);
		newStationName.setColumns(10);
		newStationName.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblStrae = new JLabel("   Strasse *");
		lblStrae.setForeground(new Color(255, 255, 255));
		lblStrae.setBounds(22, 400, 121, 16);
		contentPanel.add(lblStrae);

		JTextField newStationStreet = new JTextField();
		newStationStreet.setBackground(new Color(112, 128, 144));
		newStationStreet.setForeground(new Color(255, 255, 255));
		newStationStreet.setColumns(10);
		newStationStreet.setBorder(BorderFactory.createEmptyBorder());
		newStationStreet.setBounds(32, 423, 238, 26);
		contentPanel.add(newStationStreet);

		JLabel lblKrzelDesLandesplz = new JLabel("  Kuerzel des Landes-PLZ *");
		lblKrzelDesLandesplz.setForeground(new Color(255, 255, 255));
		lblKrzelDesLandesplz.setBounds(27, 477, 166, 17);
		contentPanel.add(lblKrzelDesLandesplz);

		JTextField newStationLandPostcode = new JTextField();
		newStationLandPostcode.setBackground(new Color(112, 128, 144));
		newStationLandPostcode.setForeground(new Color(255, 255, 255));
		newStationLandPostcode.setColumns(10);
		newStationLandPostcode.setBounds(32, 506, 238, 26);
		newStationLandPostcode.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newStationLandPostcode);

		JLabel lblStadt = new JLabel("  Stadt *");
		lblStadt.setForeground(new Color(255, 255, 255));
		lblStadt.setBounds(22, 562, 121, 16);
		contentPanel.add(lblStadt);

		JTextField newStationCity = new JTextField();
		newStationCity.setBackground(new Color(112, 128, 144));
		newStationCity.setForeground(new Color(255, 255, 255));
		newStationCity.setColumns(10);
		newStationCity.setBounds(32, 596, 238, 26);
		newStationCity.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newStationCity);

		JLabel lblAnsprechpartner = new JLabel("  Ansprechpartner");
		lblAnsprechpartner.setForeground(new Color(255, 255, 255));
		lblAnsprechpartner.setBounds(401, 320, 121, 16);
		contentPanel.add(lblAnsprechpartner);

		JTextField newStationEmploee = new JTextField();
		newStationEmploee.setBackground(new Color(112, 128, 144));
		newStationEmploee.setForeground(new Color(255, 255, 255));
		newStationEmploee.setColumns(10);
		newStationEmploee.setBounds(409, 344, 238, 24);
		newStationEmploee.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newStationEmploee);

		JTextField newStationTel1 = new JTextField();
		newStationTel1.setForeground(new Color(255, 255, 255));
		newStationTel1.setBackground(new Color(112, 128, 144));
		newStationTel1.setColumns(10);
		newStationTel1.setBounds(407, 424, 238, 26);
		newStationTel1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newStationTel1);

		JLabel lblTelMobile = new JLabel("  Tel. Mobile");
		lblTelMobile.setForeground(new Color(255, 255, 255));
		lblTelMobile.setBounds(404, 395, 121, 16);
		contentPanel.add(lblTelMobile);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(29, 376, 257, 12);
		contentPanel.add(separator1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 453, 264, 12);
		contentPanel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(22, 538, 264, 12);
		contentPanel.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(22, 627, 264, 12);
		contentPanel.add(separator_1_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(403, 371, 257, 12);
		contentPanel.add(separator_2);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(402, 454, 264, 12);
		contentPanel.add(separator_1_2);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(402, 627, 264, 12);
		contentPanel.add(separator_1_1_2);
		
		JLabel lblNotiz = new JLabel("  Notiz");
		lblNotiz.setForeground(Color.WHITE);
		lblNotiz.setBounds(408, 477, 121, 16);
		contentPanel.add(lblNotiz);
		
		JTextPane textPaneStationNotiz = new JTextPane();
		textPaneStationNotiz.setForeground(new Color(255, 255, 255));
		textPaneStationNotiz.setBackground(new Color(112, 128, 144));
		textPaneStationNotiz.setBounds(409, 506, 251, 116);
		contentPanel.add(textPaneStationNotiz);
		
		JList listCustomerStations = new JList();
		listCustomerStations.setBackground(new Color(112, 128, 144));
		listCustomerStations.setForeground(new Color(255, 255, 255));
		listCustomerStations.setBorder(BorderFactory.createEmptyBorder());
		
		JScrollPane scrollPane = new JScrollPane(listCustomerStations);
		scrollPane.setBounds(36, 168, 611, 140);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(scrollPane);
		
		JLabel lblBereitsAngelegteStationen = new JLabel("  Bereits angelegte Stationen");
		lblBereitsAngelegteStationen.setForeground(Color.WHITE);
		lblBereitsAngelegteStationen.setBounds(39, 140, 187, 16);
		contentPanel.add(lblBereitsAngelegteStationen);
		
		JLabel lblAddStation = new JLabel("Neue Station speichern");
		lblAddStation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddStation.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddStation.setForeground(Color.WHITE);
			}
		});
		lblAddStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStation.setForeground(Color.WHITE);
		lblAddStation.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAddStation.setBounds(296, 651, 209, 38);
		contentPanel.add(lblAddStation);
		
		JLabel lblCancel = new JLabel("Abbruch");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCancel.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancel.setForeground(Color.WHITE);
			}
		});
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCancel.setBounds(517, 651, 209, 38);
		contentPanel.add(lblCancel);
		
		

		
		

	}
	
	private void setPullDownList() {
		JList list = new JList();
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(112, 128, 144));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(18, 134, 326, 139);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(18, 134, 326, 139);
		contentPanel.add(scrollPane);
	}
}
