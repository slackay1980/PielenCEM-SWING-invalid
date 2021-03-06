package ui;

import services.AddForwarderService;
import services.AddRelationService;

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


public class AddRelationDlg extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtProducentStation;
	private JTextField txtCustomerStation;
	private JTextField txtDistance;
	private JTextField txtRelationField1;
	private JTextPane textRelationNotice;
	private  JLabel lblCloseDialog;
	private JLabel lblSaveRelation;
	private JLabel lblCancel;
	private LinkedHashMap<String,Object> controlList = null;
	private JTextField txtRelationField2;
	private JTextField txtRelationField3;
	private JTextField textRelationField4;
	private JCheckBox chckBoxCustom;

	private JLabel lblSearchProducentStation;
	private JLabel lblSearchCustomerStation;



	/**
	 * Create the dialog.
	 */


	public AddRelationDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 693, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Hersteller / Ladestation  eingeben* ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 45, 268, 16);
		contentPanel.add(lblNewLabel);

		txtProducentStation = new JTextField();
		txtProducentStation.setForeground(new Color(255, 255, 255));
		txtProducentStation.setBackground(new Color(112, 128, 144));
		txtProducentStation.setBounds(36, 73, 424, 26);
		contentPanel.add(txtProducentStation);
		txtProducentStation.setColumns(10);
		txtProducentStation.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblStrae = new JLabel("  Kundenstation eingeben *");
		lblStrae.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblStrae.setForeground(new Color(255, 255, 255));
		lblStrae.setBounds(36, 124, 258, 15);
		contentPanel.add(lblStrae);

		txtCustomerStation = new JTextField();
		txtCustomerStation.setBackground(new Color(112, 128, 144));
		txtCustomerStation.setForeground(new Color(255, 255, 255));
		txtCustomerStation.setColumns(10);
		txtCustomerStation.setBorder(BorderFactory.createEmptyBorder());
		txtCustomerStation.setBounds(36, 143, 439, 31);
		contentPanel.add(txtCustomerStation);

		JLabel lblDistanceKm = new JLabel("  Entfernung in km *");
		lblDistanceKm.setForeground(new Color(255, 255, 255));
		lblDistanceKm.setBounds(37, 244, 166, 16);
		contentPanel.add(lblDistanceKm);

		txtDistance = new JTextField();
		txtDistance.setBackground(new Color(112, 128, 144));
		txtDistance.setForeground(new Color(255, 255, 255));
		txtDistance.setColumns(10);
		txtDistance.setBounds(38, 275, 238, 26);
		txtDistance.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtDistance);

		JLabel lblCustonYesNo = new JLabel("  Verzollung notwendig  *");
		lblCustonYesNo.setForeground(new Color(255, 255, 255));
		lblCustonYesNo.setBounds(37, 319, 221, 16);
		contentPanel.add(lblCustonYesNo);

		JLabel lblField1 = new JLabel("  Feld 1 (optional)");
		lblField1.setForeground(new Color(255, 255, 255));
		lblField1.setBounds(36, 418, 121, 16);
		contentPanel.add(lblField1);

		txtRelationField1 = new JTextField();
		txtRelationField1.setBackground(new Color(112, 128, 144));
		txtRelationField1.setForeground(new Color(255, 255, 255));
		txtRelationField1.setColumns(10);
		txtRelationField1.setBounds(36, 443, 238, 31);
		txtRelationField1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtRelationField1);

		JLabel lblRelationNotice = new JLabel(" Notiz");
		lblRelationNotice.setForeground(new Color(255, 255, 255));
		lblRelationNotice.setBounds(366, 450, 61, 16);
		contentPanel.add(lblRelationNotice);

		textRelationNotice = new JTextPane();
		textRelationNotice.setForeground(new Color(255, 255, 255));
		textRelationNotice.setBackground(new Color(112, 128, 144));
		textRelationNotice.setBounds(367, 485, 267, 77);
		contentPanel.add(textRelationNotice);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 693, 38);
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
		lblCloseDialog.setBounds(609, 6, 49, 26);
		panel.add(lblCloseDialog);


		JSeparator separator = new JSeparator();
		separator.setBounds(36, 100, 439, 12);
		contentPanel.add(separator);

		lblSaveRelation = new JLabel("Speichern");
		lblSaveRelation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveRelation.setForeground(Color.WHITE);
		lblSaveRelation.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSaveRelation.setBackground(Color.WHITE);
		lblSaveRelation.setBounds(349, 603, 111, 26);
		lblSaveRelation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSaveRelation.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSaveRelation.setForeground(Color.WHITE);
			}

		});
		contentPanel.add(lblSaveRelation);

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
		separator_1.setBounds(37, 174, 439, 12);
		contentPanel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(37, 300, 228, 12);
		contentPanel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(37, 381, 228, 12);
		contentPanel.add(separator_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(37, 475, 228, 11);
		contentPanel.add(separator_1_1_1_1);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(367, 561, 237, 12);
		contentPanel.add(separator_1_1_1_1_1);

		DefaultListModel model = new DefaultListModel();



		JLabel lblNeuenTransportunternehmerAnlegen = new JLabel("    Relation anlegen");
		lblNeuenTransportunternehmerAnlegen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuenTransportunternehmerAnlegen.setForeground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeuenTransportunternehmerAnlegen.setBackground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setBounds(21, 6, 341, 26);
		panel.add(lblNeuenTransportunternehmerAnlegen);
		controlList.put("lblSpeichern",lblSaveRelation);
		controlList.put("lblCancel",lblCancel);

		lblSearchProducentStation = new JLabel(" Suchen");
		lblSearchProducentStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchProducentStation.setForeground(Color.WHITE);
		lblSearchProducentStation.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSearchProducentStation.setBackground(Color.WHITE);
		lblSearchProducentStation.setBounds(526, 72, 111, 26);
		contentPanel.add(lblSearchProducentStation);

		lblSearchCustomerStation = new JLabel(" Suchen");
		lblSearchCustomerStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCustomerStation.setForeground(Color.WHITE);
		lblSearchCustomerStation.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSearchCustomerStation.setBackground(Color.WHITE);
		lblSearchCustomerStation.setBounds(526, 143, 111, 26);
		contentPanel.add(lblSearchCustomerStation);

		chckBoxCustom = new JCheckBox("     JA/ NEIN");
		chckBoxCustom.setForeground(new Color(255, 255, 255));
		chckBoxCustom.setBounds(47, 347, 128, 23);
		contentPanel.add(chckBoxCustom);

		JLabel lblField2 = new JLabel("  Feld 2 (optional)");
		lblField2.setForeground(Color.WHITE);
		lblField2.setBounds(37, 507, 121, 16);
		contentPanel.add(lblField2);

		txtRelationField2 = new JTextField();
		txtRelationField2.setForeground(Color.WHITE);
		txtRelationField2.setColumns(10);
		txtRelationField2.setBorder(BorderFactory.createEmptyBorder());
		txtRelationField2.setBackground(new Color(112, 128, 144));
		txtRelationField2.setBounds(36, 531, 238, 31);
		contentPanel.add(txtRelationField2);

		JSeparator separator_1_1_1_1_2 = new JSeparator();
		separator_1_1_1_1_2.setBounds(38, 562, 228, 11);
		contentPanel.add(separator_1_1_1_1_2);

		JLabel lblRelation3 = new JLabel(" Feld 3 (optional)");
		lblRelation3.setForeground(Color.WHITE);
		lblRelation3.setBounds(371, 247, 121, 16);
		contentPanel.add(lblRelation3);

		txtRelationField3 = new JTextField();
		txtRelationField3.setForeground(Color.WHITE);
		txtRelationField3.setColumns(10);
		txtRelationField3.setBorder(BorderFactory.createEmptyBorder());
		txtRelationField3.setBackground(new Color(112, 128, 144));
		txtRelationField3.setBounds(379, 271, 238, 31);
		contentPanel.add(txtRelationField3);

		JSeparator separator_1_1_1_1_2_1 = new JSeparator();
		separator_1_1_1_1_2_1.setBounds(372, 302, 228, 11);
		contentPanel.add(separator_1_1_1_1_2_1);

		JLabel lblRelation4 = new JLabel("  Feld 4 (optional)");
		lblRelation4.setForeground(Color.WHITE);
		lblRelation4.setBounds(366, 317, 121, 16);
		contentPanel.add(lblRelation4);

		textRelationField4 = new JTextField();
		textRelationField4.setForeground(Color.WHITE);
		textRelationField4.setColumns(10);
		textRelationField4.setBorder(BorderFactory.createEmptyBorder());
		textRelationField4.setBackground(new Color(112, 128, 144));
		textRelationField4.setBounds(374, 341, 238, 31);
		contentPanel.add(textRelationField4);

		JSeparator separator_1_1_1_1_2_1_1 = new JSeparator();
		separator_1_1_1_1_2_1_1.setBounds(367, 372, 228, 11);
		contentPanel.add(separator_1_1_1_1_2_1_1);
		controlList.put("dialog", this);

		controlList = new LinkedHashMap<String,Object>();
		controlList.put("txtProducentStation",txtProducentStation);
		controlList.put("txtCustomerStation",txtCustomerStation);
		controlList.put("txtDistance",txtDistance);
		controlList.put("txtRelationField1",txtRelationField1);
		controlList.put("txtRelationField2",txtRelationField2);
		controlList.put("txtRelationField3",txtRelationField3);
		controlList.put("textRelationField4",textRelationField4);
		controlList.put("textRelationNotice",textRelationNotice);
		controlList.put("lblCloseDialog",lblCloseDialog);
		controlList.put("lblSaveRelation",lblSaveRelation);
		controlList.put("lblCancel",lblCancel);
		controlList.put("chckBoxCustom",chckBoxCustom);
		controlList.put("lblSearchProducentStation",lblSearchProducentStation);
		controlList.put("lblSearchCustomerStation",lblSearchCustomerStation);
		controlList.put("dialog",this);


		new AddRelationService(controlList);


	}

	public void showDialog() {
		setModal(true);
		setVisible(true);
	}
}

