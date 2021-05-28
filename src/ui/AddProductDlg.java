package ui;

//import services.AddCustomerStationService;

import services.AddProductService;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddProductDlg extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private LinkedHashMap<String,Object> listControlls;
	private JLabel lblCloseDialog;
	private JTextField searchProducent;
	private JLabel lblSearch;
	private JTextField newProductDescription;
	private JTextField newProductDescriptionAdditional;
	private JTextField newField1;
	private JTextField newField2;
	private JLabel lblAddStation;
	private JLabel lblCancel;
	/**
	 * Create the dialog.
	 */
	public AddProductDlg() {
		setUndecorated(true);
		setBounds(100, 100, 518, 590);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 518, 590);
		contentPanel.setBackground(new Color(112, 128, 144));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 518, 40);
		contentPanel.add(panel);
		panel.setLayout(null);

		new ComponentMover(this, panel);

		JLabel lblNeueHerstellerstationAnlegen = new JLabel("Neues Produkt anlegen");
		lblNeueHerstellerstationAnlegen.setHorizontalAlignment(SwingConstants.LEFT);
		lblNeueHerstellerstationAnlegen.setForeground(Color.WHITE);
		lblNeueHerstellerstationAnlegen.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeueHerstellerstationAnlegen.setBackground(Color.WHITE);
		lblNeueHerstellerstationAnlegen.setBounds(38, 9, 366, 26);
		panel.add(lblNeueHerstellerstationAnlegen);

		lblCloseDialog = new JLabel("  X  ");
		lblCloseDialog.setForeground(new Color(255, 255, 255));
		lblCloseDialog.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCloseDialog.setBackground(new Color(255, 255, 255));
		lblCloseDialog.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseDialog.setBounds(450, 6, 49, 26);
		lblCloseDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}


		});
		panel.add(lblCloseDialog);


		JLabel lblNewLabel = new JLabel(" Hersteller/Ladewerk eingeben*");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 68, 230, 16);
		contentPanel.add(lblNewLabel);

		searchProducent = new JTextField();
		searchProducent.setForeground(new Color(255, 255, 255));
		searchProducent.setBackground(new Color(112, 128, 144));
		searchProducent.setBounds(38, 94, 326, 26);
		contentPanel.add(searchProducent);
		searchProducent.setColumns(10);
		searchProducent.setBorder(BorderFactory.createEmptyBorder());

		JSeparator separator = new JSeparator();
		separator.setBounds(28, 121, 336, 12);
		contentPanel.add(separator);

		lblSearch = new JLabel("Suchen");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setBounds(380, 68, 93, 58);
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSearch.setForeground(new Color(128, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSearch.setForeground(Color.WHITE);
			}
		});
		contentPanel.add(lblSearch);



		JLabel lblProductDescroption = new JLabel("Produktbezeichnung *");
		lblProductDescroption.setForeground(new Color(255, 255, 255));
		lblProductDescroption.setBounds(22, 166, 230, 16);
		contentPanel.add(lblProductDescroption);

		newProductDescription = new JTextField();
		newProductDescription.setForeground(new Color(255, 255, 255));
		newProductDescription.setBackground(new Color(112, 128, 144));
		newProductDescription.setBounds(31, 196, 326, 26);
		contentPanel.add(newProductDescription);
		newProductDescription.setColumns(10);
		newProductDescription.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblProductDescriptionMore = new JLabel("Produktbezeichnung zusätzlich");
		lblProductDescriptionMore.setForeground(new Color(255, 255, 255));
		lblProductDescriptionMore.setBounds(21, 248, 264, 16);
		contentPanel.add(lblProductDescriptionMore);

		newProductDescriptionAdditional = new JTextField();
		newProductDescriptionAdditional.setBackground(new Color(112, 128, 144));
		newProductDescriptionAdditional.setForeground(new Color(255, 255, 255));
		newProductDescriptionAdditional.setColumns(10);
		newProductDescriptionAdditional.setBorder(BorderFactory.createEmptyBorder());
		newProductDescriptionAdditional.setBounds(31, 271, 326, 26);
		contentPanel.add(newProductDescriptionAdditional);

		JLabel lblField1 = new JLabel("Eingabefeld 1");
		lblField1.setForeground(new Color(255, 255, 255));
		lblField1.setBounds(26, 325, 166, 17);
		contentPanel.add(lblField1);

		newField1 = new JTextField();
		newField1.setBackground(new Color(112, 128, 144));
		newField1.setForeground(new Color(255, 255, 255));
		newField1.setColumns(10);
		newField1.setBounds(31, 354, 326, 26);
		newField1.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newField1);

		JLabel lblField2 = new JLabel("Eingabefeld 2 ");
		lblField2.setForeground(new Color(255, 255, 255));
		lblField2.setBounds(21, 410, 121, 16);
		contentPanel.add(lblField2);

		newField2 = new JTextField();
		newField2.setBackground(new Color(112, 128, 144));
		newField2.setForeground(new Color(255, 255, 255));
		newField2.setColumns(10);
		newField2.setBounds(31, 444, 326, 26);
		newField2.setBorder(BorderFactory.createEmptyBorder());
		contentPanel.add(newField2);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(28, 224, 336, 12);
		contentPanel.add(separator1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 301, 336, 12);
		contentPanel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(21, 386, 343, 12);
		contentPanel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(21, 475, 336, 12);
		contentPanel.add(separator_1_1_1);


		lblAddStation = new JLabel("Neues Produkt speichern");
		lblAddStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStation.setForeground(Color.WHITE);
		lblAddStation.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAddStation.setBounds(76, 523, 230, 38);
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
		contentPanel.add(lblAddStation);

		lblCancel = new JLabel("Abbruch");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCancel.setBounds(297, 523, 209, 38);
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





		listControlls = new LinkedHashMap<String,Object>();
		listControlls.put("lblCloseDialog",lblCloseDialog);
		listControlls.put("searchProducent",searchProducent);
		listControlls.put("lblSearch",lblSearch);
		listControlls.put("newProductDescription",newProductDescription);
		listControlls.put("newProductDescriptionAdditional",newProductDescriptionAdditional);
		listControlls.put("newField1",newField1);
		listControlls.put("newField2",newField2);
		listControlls.put("lblAddStation",lblAddStation);
		listControlls.put("lblCancel",lblCancel);
		listControlls.put("contentPanel",contentPanel);
		listControlls.put("dialog",this);




		new AddProductService(listControlls);





	}
}
