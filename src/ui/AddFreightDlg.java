package ui;

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


public class AddFreightDlg extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRelation;
	private JTextField txtForwarder;
	private JTextField txtFreigtPerTo;
	private JTextField txtWhenStartPerTo;
	private JLabel lblCloseDialog;
	private JLabel lblSaveFreight;
	private JLabel lblCancel;
	private LinkedHashMap<String,Object> controlList = null;
	private JTextField txtFieldOptionalPerTo;
	private JTextField txtFreightFlatrate;
	private JTextField textWhenAgreedFlatrate;
	private JTextField textWhenAgreedPerTo;
	private JTextField textWhenStartFlatrate;
	private JTextField txtFieldOptionalFlatrate;



	/**
	 * Create the dialog.
	 */
	
	
	public AddFreightDlg() {
		controlList = new LinkedHashMap<String,Object>();
		setUndecorated(true);
		setBounds(100, 100, 693, 714);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRelation = new JLabel(" Relation  eingeben* ");
		lblRelation.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblRelation.setForeground(new Color(255, 255, 255));
		lblRelation.setBounds(36, 68, 268, 16);
		contentPanel.add(lblRelation);

		txtRelation = new JTextField();
		txtRelation.setForeground(new Color(255, 255, 255));
		txtRelation.setBackground(new Color(112, 128, 144));
		txtRelation.setBounds(36, 96, 424, 26);
		contentPanel.add(txtRelation);
		txtRelation.setColumns(10);
		txtRelation.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblForwarder = new JLabel("  Transporteur eingeben *");
		lblForwarder.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblForwarder.setForeground(new Color(255, 255, 255));
		lblForwarder.setBounds(36, 147, 258, 15);
		contentPanel.add(lblForwarder);

		txtForwarder = new JTextField();
		txtForwarder.setBackground(new Color(112, 128, 144));
		txtForwarder.setForeground(new Color(255, 255, 255));
		txtForwarder.setColumns(10);
		txtForwarder.setBorder(BorderFactory.createEmptyBorder());
		txtForwarder.setBounds(36, 166, 439, 31);
		contentPanel.add(txtForwarder);

		JLabel lblFreightPerTo = new JLabel("  Fracht €/To");
		lblFreightPerTo.setForeground(new Color(255, 255, 255));
		lblFreightPerTo.setBounds(37, 282, 166, 16);
		contentPanel.add(lblFreightPerTo);

		txtFreigtPerTo = new JTextField();
		txtFreigtPerTo.setBackground(new Color(112, 128, 144));
		txtFreigtPerTo.setForeground(new Color(255, 255, 255));
		txtFreigtPerTo.setColumns(10);
		txtFreigtPerTo.setBounds(38, 311, 238, 26);
		txtFreigtPerTo.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtFreigtPerTo);

		JLabel lblWhenAgreed = new JLabel("  Wann und mit wem Vereinbart  *");
		lblWhenAgreed.setForeground(new Color(255, 255, 255));
		lblWhenAgreed.setBounds(37, 357, 221, 16);
		contentPanel.add(lblWhenAgreed);

		JLabel lblSinceWhen = new JLabel("  Ab wann gültig");
		lblSinceWhen.setForeground(new Color(255, 255, 255));
		lblSinceWhen.setBounds(36, 456, 121, 16);
		contentPanel.add(lblSinceWhen);

		txtWhenStartPerTo = new JTextField();
		txtWhenStartPerTo.setBackground(new Color(112, 128, 144));
		txtWhenStartPerTo.setForeground(new Color(255, 255, 255));
		txtWhenStartPerTo.setColumns(10);
		txtWhenStartPerTo.setBounds(36, 481, 238, 26);
		txtWhenStartPerTo.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(txtWhenStartPerTo);

		JLabel lblSinceWhenFlatrate = new JLabel("  Ab wann gültig");
		lblSinceWhenFlatrate.setForeground(new Color(255, 255, 255));
		lblSinceWhenFlatrate.setBounds(367, 456, 126, 16);
		contentPanel.add(lblSinceWhenFlatrate);

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
		separator.setBounds(36, 123, 439, 12);
		contentPanel.add(separator);

		lblSaveFreight = new JLabel("Speichern");
		lblSaveFreight.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveFreight.setForeground(Color.WHITE);
		lblSaveFreight.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSaveFreight.setBackground(Color.WHITE);
		lblSaveFreight.setBounds(353, 662, 111, 26);
		lblSaveFreight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSaveFreight.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSaveFreight.setForeground(Color.WHITE);
			}

		});
		contentPanel.add(lblSaveFreight);

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
		lblCancel.setBounds(516, 662, 111, 26);
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
		separator_1.setBounds(37, 197, 439, 12);
		contentPanel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(37, 338, 228, 12);
		contentPanel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(37, 419, 228, 12);
		contentPanel.add(separator_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(37, 513, 228, 11);
		contentPanel.add(separator_1_1_1_1);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(367, 513, 237, 12);
		contentPanel.add(separator_1_1_1_1_1);

		DefaultListModel model = new DefaultListModel();


		controlList = new LinkedHashMap<String,Object>();
		controlList.put("lblForwarderCompanyName",txtRelation);
		controlList.put("lblForwarderStreet",txtForwarder);
		controlList.put("lblForwarderLandPostcode",txtFreigtPerTo);
		controlList.put("lblForwarderEmploee",txtWhenStartPerTo);
		controlList.put("lblCloseDialog",lblCloseDialog);
		
		JLabel lblNeuenTransportunternehmerAnlegen = new JLabel("    Fracht eingeben");
		lblNeuenTransportunternehmerAnlegen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeuenTransportunternehmerAnlegen.setForeground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeuenTransportunternehmerAnlegen.setBackground(Color.WHITE);
		lblNeuenTransportunternehmerAnlegen.setBounds(21, 6, 341, 26);
		panel.add(lblNeuenTransportunternehmerAnlegen);
		controlList.put("lblSpeichern",lblSaveFreight);
		controlList.put("lblCancel",lblCancel);
		
		JLabel lblSearchProducentStation = new JLabel(" Suchen");
		lblSearchProducentStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchProducentStation.setForeground(Color.WHITE);
		lblSearchProducentStation.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSearchProducentStation.setBackground(Color.WHITE);
		lblSearchProducentStation.setBounds(526, 72, 111, 26);
		contentPanel.add(lblSearchProducentStation);
		
		JLabel lblSearchCustomerStation = new JLabel(" Suchen");
		lblSearchCustomerStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCustomerStation.setForeground(Color.WHITE);
		lblSearchCustomerStation.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSearchCustomerStation.setBackground(Color.WHITE);
		lblSearchCustomerStation.setBounds(526, 143, 111, 26);
		contentPanel.add(lblSearchCustomerStation);
		
		JCheckBox chckFreightPerTo = new JCheckBox("     Fracht per To");
		chckFreightPerTo.setForeground(new Color(255, 255, 255));
		chckFreightPerTo.setBounds(36, 232, 190, 23);
		chckFreightPerTo.setBackground(new Color(112, 128, 144));
		contentPanel.add(chckFreightPerTo);
		
		JLabel lblFeldoptionalPerTo = new JLabel("  Feld 2 (optional)");
		lblFeldoptionalPerTo.setForeground(Color.WHITE);
		lblFeldoptionalPerTo.setBounds(37, 545, 121, 16);
		contentPanel.add(lblFeldoptionalPerTo);
		
		txtFieldOptionalPerTo = new JTextField();
		txtFieldOptionalPerTo.setForeground(Color.WHITE);
		txtFieldOptionalPerTo.setColumns(10);
		txtFieldOptionalPerTo.setBorder(BorderFactory.createEmptyBorder());
		txtFieldOptionalPerTo.setBackground(new Color(112, 128, 144));
		txtFieldOptionalPerTo.setBounds(36, 569, 238, 31);
		contentPanel.add(txtFieldOptionalPerTo);
		
		JSeparator separator_1_1_1_1_2 = new JSeparator();
		separator_1_1_1_1_2.setBounds(38, 600, 228, 11);
		contentPanel.add(separator_1_1_1_1_2);
		
		JLabel lblFreightFlatrate = new JLabel("   Freight €");
		lblFreightFlatrate.setForeground(Color.WHITE);
		lblFreightFlatrate.setBounds(367, 282, 121, 16);
		contentPanel.add(lblFreightFlatrate);
		
		txtFreightFlatrate = new JTextField();
		txtFreightFlatrate.setForeground(Color.WHITE);
		txtFreightFlatrate.setColumns(10);
		txtFreightFlatrate.setBorder(BorderFactory.createEmptyBorder());
		txtFreightFlatrate.setBackground(new Color(112, 128, 144));
		txtFreightFlatrate.setBounds(377, 311, 238, 27);
		contentPanel.add(txtFreightFlatrate);
		
		JSeparator separator_1_1_1_1_2_1 = new JSeparator();
		separator_1_1_1_1_2_1.setBounds(372, 337, 228, 11);
		contentPanel.add(separator_1_1_1_1_2_1);
		
		JLabel lblWhenAgreed_1 = new JLabel("   Wann und mit wem Vereinbart  *");
		lblWhenAgreed_1.setForeground(Color.WHITE);
		lblWhenAgreed_1.setBounds(366, 357, 238, 16);
		contentPanel.add(lblWhenAgreed_1);
		
		textWhenAgreedFlatrate = new JTextField();
		textWhenAgreedFlatrate.setForeground(Color.WHITE);
		textWhenAgreedFlatrate.setColumns(10);
		textWhenAgreedFlatrate.setBorder(BorderFactory.createEmptyBorder());
		textWhenAgreedFlatrate.setBackground(new Color(112, 128, 144));
		textWhenAgreedFlatrate.setBounds(370, 386, 238, 31);
		contentPanel.add(textWhenAgreedFlatrate);
		
		JSeparator separator_1_1_1_1_2_1_1 = new JSeparator();
		separator_1_1_1_1_2_1_1.setBounds(366, 419, 228, 11);
		contentPanel.add(separator_1_1_1_1_2_1_1);
		
		JCheckBox chckFreightFlatrate = new JCheckBox("     Fracht pauschal");
		chckFreightFlatrate.setForeground(Color.WHITE);
		chckFreightFlatrate.setBounds(366, 232, 190, 23);
		chckFreightFlatrate.setBackground(new Color(112, 128, 144));
		contentPanel.add(chckFreightFlatrate);
		
		textWhenAgreedPerTo = new JTextField();
		textWhenAgreedPerTo.setForeground(Color.WHITE);
		textWhenAgreedPerTo.setColumns(10);
		textWhenAgreedPerTo.setBorder(BorderFactory.createEmptyBorder());
		textWhenAgreedPerTo.setBackground(new Color(112, 128, 144));
		textWhenAgreedPerTo.setBounds(38, 393, 238, 26);
		contentPanel.add(textWhenAgreedPerTo);
		
		textWhenStartFlatrate = new JTextField();
		textWhenStartFlatrate.setForeground(Color.WHITE);
		textWhenStartFlatrate.setColumns(10);
		textWhenStartFlatrate.setBorder(BorderFactory.createEmptyBorder());
		textWhenStartFlatrate.setBackground(new Color(112, 128, 144));
		textWhenStartFlatrate.setBounds(366, 483, 238, 26);
		contentPanel.add(textWhenStartFlatrate);
		
		JLabel lblFeldoptional_1 = new JLabel("  Feld 2 (optional)");
		lblFeldoptional_1.setForeground(Color.WHITE);
		lblFeldoptional_1.setBounds(368, 545, 121, 16);
		contentPanel.add(lblFeldoptional_1);
		
		txtFieldOptionalFlatrate = new JTextField();
		txtFieldOptionalFlatrate.setForeground(Color.WHITE);
		txtFieldOptionalFlatrate.setColumns(10);
		txtFieldOptionalFlatrate.setBorder(BorderFactory.createEmptyBorder());
		txtFieldOptionalFlatrate.setBackground(new Color(112, 128, 144));
		txtFieldOptionalFlatrate.setBounds(367, 569, 238, 31);
		contentPanel.add(txtFieldOptionalFlatrate);
		
		JSeparator separator_1_1_1_1_2_2 = new JSeparator();
		separator_1_1_1_1_2_2.setBounds(369, 600, 228, 11);
		contentPanel.add(separator_1_1_1_1_2_2);
		controlList.put("dialog", this);

		// new AddForwarderService(controlList);


	}

	public void showDialog() {
		setModal(true);
		setVisible(true);
	}
}

