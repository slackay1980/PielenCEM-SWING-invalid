package ui;

import services.AddForwarderService;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// import services.AddForwarderService;


import java.awt.Font;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;


public class AddForwarderDlg extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtForwarderCompanyName;
	private JTextField txtForwarderStreet;
	private JTextField txtForwarderLandPostcode;
	private JTextField txtForwarderCity;
	private JTextField txtForwarderEmploee;
	private JTextField txtForwarderTel1;
	private JTextField txtForwarderTel2;
	private JTextField txtForwarderFax;
	private JTextField txtForwarderEmail;
	private JTextField txtForwarderLogicId;
	private JTextPane textPaneForwarderNote;
	private  JLabel lblCloseDialog;
	private JLabel lblSpeichern;
	private JLabel lblCancel;
	private LinkedHashMap<String,Object> controlList = null;



	/**
	 * Create the dialog.
	 */
	public AddForwarderDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 704, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Spedition / Transportunternehmer  * ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 45, 268, 16);
		contentPanel.add(lblNewLabel);

		txtForwarderCompanyName = new JTextField();
		txtForwarderCompanyName.setForeground(new Color(255, 255, 255));
		txtForwarderCompanyName.setBackground(new Color(112, 128, 144));
		txtForwarderCompanyName.setBounds(36, 73, 238, 26);
		contentPanel.add(txtForwarderCompanyName);
		txtForwarderCompanyName.setColumns(10);
		txtForwarderCompanyName.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblStrae = new JLabel("  Strasse *");
		lblStrae.setForeground(new Color(255, 255, 255));
		lblStrae.setBounds(36, 123, 121, 16);
		contentPanel.add(lblStrae);

		txtForwarderStreet = new JTextField();
		txtForwarderStreet.setBackground(new Color(112, 128, 144));
		txtForwarderStreet.setForeground(new Color(255, 255, 255));
		txtForwarderStreet.setColumns(10);
		txtForwarderStreet.setBorder(BorderFactory.createEmptyBorder());
		txtForwarderStreet.setBounds(36, 143, 238, 31);
		contentPanel.add(txtForwarderStreet);

		JLabel lblKrzelDesLandesplz = new JLabel("  Kuerzel des Landes-PLZ *");
		lblKrzelDesLandesplz.setForeground(new Color(255, 255, 255));
		lblKrzelDesLandesplz.setBounds(36, 193, 166, 16);
		contentPanel.add(lblKrzelDesLandesplz);

		txtForwarderLandPostcode = new JTextField();
		txtForwarderLandPostcode.setBackground(new Color(112, 128, 144));
		txtForwarderLandPostcode.setForeground(new Color(255, 255, 255));
		txtForwarderLandPostcode.setColumns(10);
		txtForwarderLandPostcode.setBounds(37, 224, 238, 26);
		txtForwarderLandPostcode.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderLandPostcode);

		JLabel lblStadt = new JLabel("  Stadt *");
		lblStadt.setForeground(new Color(255, 255, 255));
		lblStadt.setBounds(36, 268, 121, 16);
		contentPanel.add(lblStadt);

		txtForwarderCity = new JTextField();
		txtForwarderCity.setBackground(new Color(112, 128, 144));
		txtForwarderCity.setForeground(new Color(255, 255, 255));
		txtForwarderCity.setColumns(10);
		txtForwarderCity.setBounds(39, 304, 238, 26);
		txtForwarderCity.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderCity);

		JLabel lblAnsprechpartner = new JLabel("  Ansprechpartner");
		lblAnsprechpartner.setForeground(new Color(255, 255, 255));
		lblAnsprechpartner.setBounds(35, 367, 121, 16);
		contentPanel.add(lblAnsprechpartner);

		txtForwarderEmploee = new JTextField();
		txtForwarderEmploee.setBackground(new Color(112, 128, 144));
		txtForwarderEmploee.setForeground(new Color(255, 255, 255));
		txtForwarderEmploee.setColumns(10);
		txtForwarderEmploee.setBounds(43, 391, 238, 31);
		txtForwarderEmploee.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderEmploee);

		JLabel lblTelBro = new JLabel("  Tel. Buero");
		lblTelBro.setForeground(new Color(255, 255, 255));
		lblTelBro.setBounds(418, 41, 121, 16);
		contentPanel.add(lblTelBro);

		txtForwarderTel1 = new JTextField();
		txtForwarderTel1.setForeground(new Color(255, 255, 255));
		txtForwarderTel1.setBackground(new Color(112, 128, 144));
		txtForwarderTel1.setColumns(10);
		txtForwarderTel1.setBounds(421, 74, 238, 26);
		txtForwarderTel1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderTel1);

		txtForwarderTel2 = new JTextField();
		txtForwarderTel2.setForeground(new Color(255, 255, 255));
		txtForwarderTel2.setBackground(new Color(112, 128, 144));
		txtForwarderTel2.setColumns(10);
		txtForwarderTel2.setBounds(421, 151, 238, 26);
		txtForwarderTel2.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderTel2);

		JLabel lblTelMobile = new JLabel("  Tel. Mobile");
		lblTelMobile.setForeground(new Color(255, 255, 255));
		lblTelMobile.setBounds(421, 116, 121, 16);
		contentPanel.add(lblTelMobile);

		JLabel lblFax = new JLabel("  Fax");
		lblFax.setForeground(new Color(255, 255, 255));
		lblFax.setBounds(421, 193, 166, 16);
		contentPanel.add(lblFax);

		txtForwarderFax = new JTextField();
		txtForwarderFax.setForeground(new Color(255, 255, 255));
		txtForwarderFax.setBackground(new Color(112, 128, 144));
		txtForwarderFax.setColumns(10);
		txtForwarderFax.setBounds(421, 219, 238, 31);
		txtForwarderFax.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderFax);

		JLabel lblEmail = new JLabel("  Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(421, 272, 121, 16);
		contentPanel.add(lblEmail);

		txtForwarderEmail = new JTextField();
		txtForwarderEmail.setForeground(new Color(255, 255, 255));
		txtForwarderEmail.setBackground(new Color(112, 128, 144));
		txtForwarderEmail.setColumns(10);
		txtForwarderEmail.setBounds(421, 304, 238, 26);
		txtForwarderEmail.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderEmail);

		JLabel lblKundennummerLogic = new JLabel("  Kundennummer Logic");
		lblKundennummerLogic.setForeground(new Color(255, 255, 255));
		lblKundennummerLogic.setBounds(422, 362, 166, 16);
		contentPanel.add(lblKundennummerLogic);

		txtForwarderLogicId = new JTextField();
		txtForwarderLogicId.setForeground(new Color(255, 255, 255));
		txtForwarderLogicId.setBackground(new Color(112, 128, 144));
		txtForwarderLogicId.setColumns(10);
		txtForwarderLogicId.setBounds(417, 393, 238, 26);
		txtForwarderLogicId.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtForwarderLogicId);

		JLabel lblNewLabel_1 = new JLabel(" Notiz");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(36, 451, 61, 16);
		contentPanel.add(lblNewLabel_1);

		textPaneForwarderNote = new JTextPane();
		textPaneForwarderNote.setForeground(new Color(255, 255, 255));
		textPaneForwarderNote.setBackground(new Color(112, 128, 144));
		textPaneForwarderNote.setBounds(37, 486, 267, 77);
		contentPanel.add(textPaneForwarderNote);

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

		JLabel lblNeuenTransportunternehmerAnlegen = new JLabel("  Neuen Transportunternehmer anlegen");
		lblNeuenTransportunternehmerAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeuenTransportunternehmerAnlegen.setForeground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeuenTransportunternehmerAnlegen.setBackground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setBounds(21, 6, 341, 26);
		panel.add(lblNeuenTransportunternehmerAnlegen);

		JSeparator separator = new JSeparator();
		separator.setBounds(36, 98, 228, 12);
		contentPanel.add(separator);

		lblSpeichern = new JLabel("Speichern");
		lblSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeichern.setForeground(Color.WHITE);
		lblSpeichern.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSpeichern.setBackground(Color.WHITE);
		lblSpeichern.setBounds(349, 603, 111, 26);
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

		lblCancel = new JLabel("Abbruch");
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
		lblCancel.setBounds(512, 603, 111, 26);
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
		controlList.put("txtForwarderCompanyName",txtForwarderCompanyName);
		controlList.put("txtForwarderStreet",txtForwarderStreet);
		controlList.put("txtForwarderLandPostcode",txtForwarderLandPostcode);
		controlList.put("txtForwarderCity",txtForwarderCity);
		controlList.put("txtForwarderEmploee",txtForwarderEmploee);
		controlList.put("txtForwarderTel1",txtForwarderTel1);
		controlList.put("txtForwarderTel2",txtForwarderTel2);
		controlList.put("txtForwarderFax",txtForwarderFax);
		controlList.put("txtForwarderEmail",txtForwarderEmail);
		controlList.put("txtForwarderLogicId",txtForwarderLogicId);
		controlList.put("textPaneForwarderNote",textPaneForwarderNote);
		controlList.put("lblCloseDialog",lblCloseDialog);
		controlList.put("lblSpeichern",lblSpeichern);
		controlList.put("lblCancel",lblCancel);
		controlList.put("dialog", this);




		new AddForwarderService(controlList);


	}
}

