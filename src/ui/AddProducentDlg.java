package ui;

import services.AddProducentService;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import services.AddCustomerService;


import java.awt.Font;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;


public class AddProducentDlg extends JDialog {



	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField newProducent_CompanyName;
	private JTextField newProducent_Street;
	private JTextField newProducent_LandPostCode;
	private JTextField newProducent_City;
	private JTextField newProducent_Emploee;
	private JTextField newProducent_tel1;
	private JTextField newProducent_tel2;
	private JTextField newProducent_Fax;
	private JTextField newProducent_Email;
	private JTextField newProducent_LogicId;
	private JTextPane newProducent_Note;
	private  JLabel lblCloseDialog;
	// private JLabel lblSpeichern;
	// private JLabel lblCancel;
	private LinkedHashMap<String,Object> controlList = null;



	/**
	 * Create the dialog.
	 */
	public AddProducentDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 704, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		
		JLabel lblNeuenHerstellerAnlegen = new JLabel("     Neuen Hersteller anlegen");
		lblNeuenHerstellerAnlegen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuenHerstellerAnlegen.setForeground(Color.WHITE);
		lblNeuenHerstellerAnlegen.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeuenHerstellerAnlegen.setBackground(Color.WHITE);
		lblNeuenHerstellerAnlegen.setBounds(17, 6, 469, 26);
		panel.add(lblNeuenHerstellerAnlegen);

		JLabel lblNewLabel = new JLabel("  Firmenname * ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 45, 121, 16);
		contentPanel.add(lblNewLabel);

		newProducent_CompanyName = new JTextField();
		newProducent_CompanyName.setForeground(new Color(255, 255, 255));
		newProducent_CompanyName.setBackground(new Color(112, 128, 144));
		newProducent_CompanyName.setBounds(36, 73, 238, 26);
		contentPanel.add(newProducent_CompanyName);
		newProducent_CompanyName.setColumns(10);
		newProducent_CompanyName.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblnewProducent_CompanyName = new JLabel("  Strasse *");
		lblnewProducent_CompanyName.setForeground(new Color(255, 255, 255));
		lblnewProducent_CompanyName.setBounds(36, 123, 121, 16);
		contentPanel.add(lblnewProducent_CompanyName);

		newProducent_Street = new JTextField();
		newProducent_Street.setBackground(new Color(112, 128, 144));
		newProducent_Street.setForeground(new Color(255, 255, 255));
		newProducent_Street.setColumns(10);
		newProducent_Street.setBorder(BorderFactory.createEmptyBorder());
		newProducent_Street.setBounds(36, 143, 238, 31);
		contentPanel.add(newProducent_Street);

		JLabel lblKrzelDesLandesplz = new JLabel("  Kuerzel des Landes-PLZ *");
		lblKrzelDesLandesplz.setForeground(new Color(255, 255, 255));
		lblKrzelDesLandesplz.setBounds(36, 193, 166, 16);
		contentPanel.add(lblKrzelDesLandesplz);

		newProducent_LandPostCode = new JTextField();
		newProducent_LandPostCode.setBackground(new Color(112, 128, 144));
		newProducent_LandPostCode.setForeground(new Color(255, 255, 255));
		newProducent_LandPostCode.setColumns(10);
		newProducent_LandPostCode.setBounds(37, 224, 238, 26);
		newProducent_LandPostCode.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_LandPostCode);

		JLabel lblStadt = new JLabel("  Stadt *");
		lblStadt.setForeground(new Color(255, 255, 255));
		lblStadt.setBounds(36, 268, 121, 16);
		contentPanel.add(lblStadt);

		newProducent_City = new JTextField();
		newProducent_City.setBackground(new Color(112, 128, 144));
		newProducent_City.setForeground(new Color(255, 255, 255));
		newProducent_City.setColumns(10);
		newProducent_City.setBounds(39, 304, 238, 26);
		newProducent_City.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_City);

		JLabel lblAnsprechpartner = new JLabel("  Ansprechpartner");
		lblAnsprechpartner.setForeground(new Color(255, 255, 255));
		lblAnsprechpartner.setBounds(35, 367, 121, 16);
		contentPanel.add(lblAnsprechpartner);

		newProducent_Emploee = new JTextField();
		newProducent_Emploee.setBackground(new Color(112, 128, 144));
		newProducent_Emploee.setForeground(new Color(255, 255, 255));
		newProducent_Emploee.setColumns(10);
		newProducent_Emploee.setBounds(43, 391, 238, 31);
		newProducent_Emploee.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_Emploee);

		JLabel lblTelBro = new JLabel("  Tel. Buero");
		lblTelBro.setForeground(new Color(255, 255, 255));
		lblTelBro.setBounds(418, 41, 121, 16);
		contentPanel.add(lblTelBro);

		newProducent_tel1 = new JTextField();
		newProducent_tel1.setForeground(new Color(255, 255, 255));
		newProducent_tel1.setBackground(new Color(112, 128, 144));
		newProducent_tel1.setColumns(10);
		newProducent_tel1.setBounds(421, 74, 238, 26);
		newProducent_tel1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_tel1);
		
		JLabel lblTelMobile = new JLabel("  Tel. Mobile");
		lblTelMobile.setForeground(new Color(255, 255, 255));
		lblTelMobile.setBounds(421, 116, 121, 16);
		contentPanel.add(lblTelMobile);

		newProducent_tel2 = new JTextField();
		newProducent_tel2.setForeground(new Color(255, 255, 255));
		newProducent_tel2.setBackground(new Color(112, 128, 144));
		newProducent_tel2.setColumns(10);
		newProducent_tel2.setBounds(421, 151, 238, 26);
		newProducent_tel2.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_tel2);

		

		JLabel lblnewProducent_Fax = new JLabel("  Fax");
		lblnewProducent_Fax.setForeground(new Color(255, 255, 255));
		lblnewProducent_Fax.setBounds(421, 193, 166, 16);
		contentPanel.add(lblnewProducent_Fax);

		newProducent_Fax = new JTextField();
		newProducent_Fax.setForeground(new Color(255, 255, 255));
		newProducent_Fax.setBackground(new Color(112, 128, 144));
		newProducent_Fax.setColumns(10);
		newProducent_Fax.setBounds(421, 219, 238, 31);
		newProducent_Fax.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_Fax);

		JLabel lblEmail = new JLabel("  Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(421, 272, 121, 16);
		contentPanel.add(lblEmail);

		newProducent_Email = new JTextField();
		newProducent_Email.setForeground(new Color(255, 255, 255));
		newProducent_Email.setBackground(new Color(112, 128, 144));
		newProducent_Email.setColumns(10);
		newProducent_Email.setBounds(421, 308, 238, 26);
		newProducent_Email.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_Email);

		JLabel lblKundennummerLogic = new JLabel("Lieferanten Nummer Logic");
		lblKundennummerLogic.setForeground(new Color(255, 255, 255));
		lblKundennummerLogic.setBounds(422, 362, 185, 16);
		contentPanel.add(lblKundennummerLogic);

		newProducent_LogicId = new JTextField();
		newProducent_LogicId.setForeground(new Color(255, 255, 255));
		newProducent_LogicId.setBackground(new Color(112, 128, 144));
		newProducent_LogicId.setColumns(10);
		newProducent_LogicId.setBounds(417, 393, 238, 26);
		newProducent_LogicId.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newProducent_LogicId);

		JLabel lblNewLabel_1 = new JLabel(" Notiz");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(36, 451, 61, 16);
		contentPanel.add(lblNewLabel_1);

		newProducent_Note = new JTextPane();
		newProducent_Note.setForeground(new Color(255, 255, 255));
		newProducent_Note.setBackground(new Color(112, 128, 144));
		newProducent_Note.setBounds(37, 486, 267, 77);
		contentPanel.add(newProducent_Note);

		

		

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

		DefaultListModel model = new DefaultListModel();


		controlList = new LinkedHashMap<String,Object>();
		controlList.put("newProducent_CompanyName",newProducent_CompanyName);
		controlList.put("newProducent_Street",newProducent_Street);
		controlList.put("newProducent_LandPostcode",newProducent_LandPostCode);
		controlList.put("newProducent_City",newProducent_City);
		controlList.put("newProducent_Emploee",newProducent_Emploee);
		controlList.put("newProducent_tel1",newProducent_tel1);
		controlList.put("newProducent_tel2",newProducent_tel2);
		controlList.put("newProducent_Fax",newProducent_Fax);
		controlList.put("newProducent_Email",newProducent_Email);
		controlList.put("newProducent_LogicId",newProducent_LogicId);
		controlList.put("newProducent_Note",newProducent_Note);
		controlList.put("lblCloseDialog",lblCloseDialog);
		controlList.put("lblSpeichern",lblSpeichern);
		controlList.put("lblCancel",lblCancel);
		controlList.put("dialog", this);

		System.out.println("Metka");
		System.out.println(lblSpeichern );
		System.out.println(lblCancel);




		System.out.println((JLabel) controlList.get("lblSpeichern"));
		System.out.println((JLabel) controlList.get("lblCancel"));

	new AddProducentService(controlList);


	}
}

