package ui;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import services.AddCustomerService;


import java.awt.Font;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;


public class AddCustomerDlg extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField newCustomer_CompanyName;
	private JTextField newCustomer_Street;
	private JTextField newCustomer_LandPostcode;
	private JTextField newCustomer_City;
	private JTextField newCustomer_Emploee;
	private JTextField newCustomer_tel1;
	private JTextField newCustomer_tel2;
	private JTextField newCustomer_Fax;
	private JTextField newCustomer_Email;
	private JTextField newCustomer_LogicId;
	private JTextPane newCustomer_Note;
	private  JLabel lblCloseDialog;
	// private JLabel lblSpeichern;
	// private JLabel lblCancel;
	private LinkedHashMap<String,Object> controlList = null;



	/**
	 * Create the dialog.
	 */
	public AddCustomerDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 704, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("  Firmenname * ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 45, 121, 16);
		contentPanel.add(lblNewLabel);

		newCustomer_CompanyName = new JTextField();
		newCustomer_CompanyName.setForeground(new Color(255, 255, 255));
		newCustomer_CompanyName.setBackground(new Color(112, 128, 144));
		newCustomer_CompanyName.setBounds(36, 73, 238, 26);
		contentPanel.add(newCustomer_CompanyName);
		newCustomer_CompanyName.setColumns(10);
		newCustomer_CompanyName.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblStrae = new JLabel("  Strasse *");
		lblStrae.setForeground(new Color(255, 255, 255));
		lblStrae.setBounds(36, 123, 121, 16);
		contentPanel.add(lblStrae);

		newCustomer_Street = new JTextField();
		newCustomer_Street.setBackground(new Color(112, 128, 144));
		newCustomer_Street.setForeground(new Color(255, 255, 255));
		newCustomer_Street.setColumns(10);
		newCustomer_Street.setBorder(BorderFactory.createEmptyBorder());
		newCustomer_Street.setBounds(36, 143, 238, 31);
		contentPanel.add(newCustomer_Street);

		JLabel lblKrzelDesLandesplz = new JLabel("  Kuerzel des Landes-PLZ *");
		lblKrzelDesLandesplz.setForeground(new Color(255, 255, 255));
		lblKrzelDesLandesplz.setBounds(36, 193, 166, 16);
		contentPanel.add(lblKrzelDesLandesplz);

		newCustomer_LandPostcode = new JTextField();
		newCustomer_LandPostcode.setBackground(new Color(112, 128, 144));
		newCustomer_LandPostcode.setForeground(new Color(255, 255, 255));
		newCustomer_LandPostcode.setColumns(10);
		newCustomer_LandPostcode.setBounds(37, 224, 238, 26);
		newCustomer_LandPostcode.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_LandPostcode);

		JLabel lblStadt = new JLabel("  Stadt *");
		lblStadt.setForeground(new Color(255, 255, 255));
		lblStadt.setBounds(36, 268, 121, 16);
		contentPanel.add(lblStadt);

		newCustomer_City = new JTextField();
		newCustomer_City.setBackground(new Color(112, 128, 144));
		newCustomer_City.setForeground(new Color(255, 255, 255));
		newCustomer_City.setColumns(10);
		newCustomer_City.setBounds(39, 304, 238, 26);
		newCustomer_City.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_City);

		JLabel lblAnsprechpartner = new JLabel("  Ansprechpartner");
		lblAnsprechpartner.setForeground(new Color(255, 255, 255));
		lblAnsprechpartner.setBounds(35, 367, 121, 16);
		contentPanel.add(lblAnsprechpartner);

		newCustomer_Emploee = new JTextField();
		newCustomer_Emploee.setBackground(new Color(112, 128, 144));
		newCustomer_Emploee.setForeground(new Color(255, 255, 255));
		newCustomer_Emploee.setColumns(10);
		newCustomer_Emploee.setBounds(43, 391, 238, 31);
		newCustomer_Emploee.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_Emploee);

		JLabel lblTelBro = new JLabel("  Tel. Buero");
		lblTelBro.setForeground(new Color(255, 255, 255));
		lblTelBro.setBounds(418, 41, 121, 16);
		contentPanel.add(lblTelBro);

		newCustomer_tel1 = new JTextField();
		newCustomer_tel1.setForeground(new Color(255, 255, 255));
		newCustomer_tel1.setBackground(new Color(112, 128, 144));
		newCustomer_tel1.setColumns(10);
		newCustomer_tel1.setBounds(421, 74, 238, 26);
		newCustomer_tel1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_tel1);

		newCustomer_tel2 = new JTextField();
		newCustomer_tel2.setForeground(new Color(255, 255, 255));
		newCustomer_tel2.setBackground(new Color(112, 128, 144));
		newCustomer_tel2.setColumns(10);
		newCustomer_tel2.setBounds(421, 151, 238, 26);
		newCustomer_tel2.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_tel2);

		JLabel lblTelMobile = new JLabel("  Tel. Mobile");
		lblTelMobile.setForeground(new Color(255, 255, 255));
		lblTelMobile.setBounds(421, 116, 121, 16);
		contentPanel.add(lblTelMobile);

		JLabel lblFax = new JLabel("  Fax");
		lblFax.setForeground(new Color(255, 255, 255));
		lblFax.setBounds(421, 193, 166, 16);
		contentPanel.add(lblFax);

		newCustomer_Fax = new JTextField();
		newCustomer_Fax.setForeground(new Color(255, 255, 255));
		newCustomer_Fax.setBackground(new Color(112, 128, 144));
		newCustomer_Fax.setColumns(10);
		newCustomer_Fax.setBounds(421, 219, 238, 31);
		newCustomer_Fax.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_Fax);

		JLabel lblEmail = new JLabel("  Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(421, 272, 121, 16);
		contentPanel.add(lblEmail);

		newCustomer_Email = new JTextField();
		newCustomer_Email.setForeground(new Color(255, 255, 255));
		newCustomer_Email.setBackground(new Color(112, 128, 144));
		newCustomer_Email.setColumns(10);
		newCustomer_Email.setBounds(421, 308, 238, 26);
		newCustomer_Email.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_Email);

		JLabel lblKundennummerLogic = new JLabel("  Kundennummer Logic");
		lblKundennummerLogic.setForeground(new Color(255, 255, 255));
		lblKundennummerLogic.setBounds(422, 362, 166, 16);
		contentPanel.add(lblKundennummerLogic);

		newCustomer_LogicId = new JTextField();
		newCustomer_LogicId.setForeground(new Color(255, 255, 255));
		newCustomer_LogicId.setBackground(new Color(112, 128, 144));
		newCustomer_LogicId.setColumns(10);
		newCustomer_LogicId.setBounds(417, 393, 238, 26);
		newCustomer_LogicId.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newCustomer_LogicId);

		JLabel lblNewLabel_1 = new JLabel(" Notiz");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(36, 451, 61, 16);
		contentPanel.add(lblNewLabel_1);

		newCustomer_Note = new JTextPane();
		newCustomer_Note.setForeground(new Color(255, 255, 255));
		newCustomer_Note.setBackground(new Color(112, 128, 144));
		newCustomer_Note.setBounds(37, 486, 267, 77);
		contentPanel.add(newCustomer_Note);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 704, 38);
		contentPanel.add(panel);
		panel.setLayout(null);

		new ComponentMover(this, panel);

		lblCloseDialog = new JLabel("  X  ");
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
		lblCloseDialog.setBounds(638, 6, 49, 26);
		panel.add(lblCloseDialog);

		JSeparator separator = new JSeparator();
		separator.setBounds(36, 98, 228, 12);
		contentPanel.add(separator);

		JLabel lblSpeichern = new JLabel("Speichern");
		lblSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeichern.setForeground(Color.WHITE);
		lblSpeichern.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSpeichern.setBackground(Color.WHITE);
		lblSpeichern.setBounds(442, 619, 111, 26);
		lblSpeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSpeichern.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSpeichern.setForeground(Color.WHITE);
			}

		});
		contentPanel.add(lblSpeichern);

		JLabel lblCancel = new JLabel("Abbruch");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCancel.setBackground(Color.WHITE);
		lblCancel.setBounds(575, 619, 111, 26);
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
		contentPanel.add(lblCancel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 174, 228, 12);
		contentPanel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(36, 249, 228, 12);
		contentPanel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(36, 330, 228, 12);
		contentPanel.add(separator_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(36, 422, 228, 11);
		contentPanel.add(separator_1_1_1_1);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(37, 562, 237, 12);
		contentPanel.add(separator_1_1_1_1_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(421, 99, 228, 12);
		contentPanel.add(separator_2);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(421, 176, 228, 12);
		contentPanel.add(separator_1_2);

		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(421, 250, 228, 12);
		contentPanel.add(separator_1_1_2);

		JSeparator separator_1_1_1_2 = new JSeparator();
		separator_1_1_1_2.setBounds(421, 332, 228, 12);
		contentPanel.add(separator_1_1_1_2);

		JSeparator separator_1_1_1_1_2 = new JSeparator();
		separator_1_1_1_1_2.setBounds(418, 421, 228, 12);
		contentPanel.add(separator_1_1_1_1_2);

		JLabel lblZustndigerBetreuer = new JLabel("  Betreuer");
		lblZustndigerBetreuer.setForeground(Color.WHITE);
		lblZustndigerBetreuer.setBounds(421, 451, 166, 16);
		contentPanel.add(lblZustndigerBetreuer);

		JSeparator separator_1_1_1_1_2_1 = new JSeparator();
		separator_1_1_1_1_2_1.setBounds(418, 562, 228, 12);
		contentPanel.add(separator_1_1_1_1_2_1);

		JLabel lblV = new JLabel("  V");
		lblV.setForeground(Color.WHITE);
		lblV.setBounds(575, 451, 32, 16);
		lblV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblV.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblV.setForeground(Color.WHITE);
			}

		});
		contentPanel.add(lblV);

		JSeparator separator_1_1_1_1_2_2 = new JSeparator();
		separator_1_1_1_1_2_2.setBounds(575, 470, 24, 12);
		contentPanel.add(separator_1_1_1_1_2_2);

		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(112, 128, 144));
		list.setBounds(418, 483, 228, 80);
		list.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(418, 483, 228, 80);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		list.setEnabled(false);
		contentPanel.add(scrollPane);


		controlList = new LinkedHashMap<String,Object>();
		controlList.put("newCustomer_CompanyName",newCustomer_CompanyName);
		controlList.put("newCustomer_Street",newCustomer_Street);
		controlList.put("newCustomer_LandPostcode",newCustomer_LandPostcode);
		controlList.put("newCustomer_City",newCustomer_City);
		controlList.put("newCustomer_Emploee",newCustomer_Emploee);
		controlList.put("newCustomer_tel1",newCustomer_tel1);
		controlList.put("newCustomer_tel2",newCustomer_tel2);
		controlList.put("newCustomer_Fax",newCustomer_Fax);
		controlList.put("newCustomer_Email",newCustomer_Email);
		controlList.put("newCustomer_LogicId",newCustomer_LogicId);
		controlList.put("newCustomer_Note",newCustomer_Note);
		controlList.put("lblCloseDialog",lblCloseDialog);
		controlList.put("lblSpeichern",lblSpeichern);
		controlList.put("lblCancel",lblCancel);
		controlList.put("sellerList",list);
		controlList.put("lblV",lblV);
		controlList.put("dialog", this);

		System.out.println("Metka");
		System.out.println(lblSpeichern );
		System.out.println(lblCancel);




		System.out.println((JLabel) controlList.get("lblSpeichern"));
		System.out.println((JLabel) controlList.get("lblCancel"));

		new AddCustomerService(controlList);


	}
}

