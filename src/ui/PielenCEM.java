package ui;


import services.MainControlService;

import java.awt.*;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class PielenCEM {

	private JFrame frame;
	private final JPanel topPanel = new JPanel();
	private JLabel lblNewLabel_1;
	private JPanel contentPanel;
	private JTable table;
	private LinkedHashMap<String,Object> controlList = null;
	// private int a;
	private boolean loggedIn;

	/**
	 * Launch the application.
	 */

	/*
	 * Opisanie
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PielenCEM window = new PielenCEM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PielenCEM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		LoginDlg loginDlg = new LoginDlg();
		// loginDlg.setModal(true);
		// loginDlg.setVisible(true);

		loggedIn = loginDlg.showLoginDlg();

		// if (loggedIn==false) System.exit(0);


		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(30, 30, 1400, 805);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		contentPanel = new JPanel();
		contentPanel.setBounds(304, 50, 1096, 699);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		topPanel.setBounds(0, 0, 1400, 50);
		frame.getContentPane().add(topPanel);
		topPanel.setBackground(new Color(139, 0, 0));

		JLabel lblNewLabel = new JLabel(" X  ");
		lblNewLabel.setBounds(1351, 5, 43, 39);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});

		lblNewLabel_1 = new JLabel("   _  ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1293, 5, 46, 39);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		topPanel.setLayout(null);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		topPanel.add(lblNewLabel_1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(lblNewLabel);


		Object[] columnNames = {
				"ID",
				"Logic ID",
				"Kunde",
				"Station",
				"Ladestelle",
				"Produkt"};

		DefaultTableModel tableModel = new DefaultTableModel(columnNames,120);
		tableModel.setValueAt("String", 3, 3);

		table = new JTable(tableModel);
		table.getTableHeader().setFont(new Font("Lucida Grande",Font.BOLD,14));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());

		table.getTableHeader().setPreferredSize(new Dimension(1000,30));
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		table.getTableHeader().setBackground(new  Color(136, 156, 189));
		table.getTableHeader().setForeground(new  Color(237, 240, 245));
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new  Color(206, 218, 237));
		table.setRowHeight(25);



		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 69, 1040, 609);
		contentPanel.add(scrollPane);


		new ComponentMover(frame, topPanel);

		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(119, 136, 153));
		sidePanel.setBounds(0, 50, 304, 749);
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("PIELEN CEM");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(23, 30, 251, 41);
		sidePanel.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(171, 69, 62, 12);
		sidePanel.add(separator);

		JLabel lblOrderNew = new JLabel("- Bestellung eingeben (V)");
		lblOrderNew.setForeground(new Color(255, 255, 255));
		lblOrderNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderNew.setBounds(23, 119, 251, 30);
		sidePanel.add(lblOrderNew);


		JLabel lblOrderChange = new JLabel("- Bestellung eingeben (S)");
		lblOrderChange.setForeground(Color.WHITE);
		lblOrderChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderChange.setBounds(23, 149, 251, 30);
		sidePanel.add(lblOrderChange);


		JLabel lblOrderDelete = new JLabel("- Bestellung eingeben (Vordr.)");
		lblOrderDelete.setForeground(Color.WHITE);
		lblOrderDelete.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderDelete.setBounds(23, 180, 251, 30);
		sidePanel.add(lblOrderDelete);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(65, 209, 144, 12);
		sidePanel.add(separator_1);

		JLabel lblCustomerNew = new JLabel("- Neuen Kunden anlegen");
		lblCustomerNew.setForeground(Color.WHITE);
		lblCustomerNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerNew.setBounds(23, 222, 251, 30);
		lblCustomerNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCustomerNew.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerNew.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblCustomerNew);

		JLabel lblCustomerChange = new JLabel("- Kundendaten aendern");
		lblCustomerChange.setForeground(Color.WHITE);
		lblCustomerChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerChange.setBounds(23, 253, 251, 30);
		sidePanel.add(lblCustomerChange);

		JLabel lblCustomerStationNew = new JLabel("- Neue Station anlegen");
		lblCustomerStationNew.setForeground(Color.WHITE);
		lblCustomerStationNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerStationNew.setBounds(23, 280, 251, 30);
		lblCustomerStationNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCustomerStationNew.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerStationNew.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblCustomerStationNew);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(65, 344, 144, 12);
		sidePanel.add(separator_1_1);

		JLabel lblProducentNew = new JLabel("- Neuen Hersteller anlegen");
		lblProducentNew.setForeground(Color.WHITE);
		lblProducentNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentNew.setBounds(23, 360, 251, 30);
		lblProducentNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducentNew.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProducentNew.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProducentNew);

		JLabel lblProducentStationNew = new JLabel("- Neue Ladestation anlegen");
		lblProducentStationNew.setForeground(Color.WHITE);
		lblProducentStationNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentStationNew.setBounds(23, 418, 251, 30);
		lblProducentStationNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducentStationNew.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProducentStationNew.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProducentStationNew);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(UIManager.getColor("InternalFrame.background"));
		bottomPanel.setBounds(304, 750, 1090, 49);
		frame.getContentPane().add(bottomPanel);

		controlList = new LinkedHashMap<String,Object>();
		controlList.put("frame",frame);
		controlList.put("mainTable",table);
		controlList.put("lblOrderNew",lblOrderNew);
		controlList.put("lblOrderChange",lblOrderChange);
		controlList.put("lblOrderDelete",lblOrderDelete);
		controlList.put("lblCustomerNew",lblCustomerNew);
		controlList.put("lblCustomerChange",lblCustomerChange);
		controlList.put("lblCustomerStationNew",lblCustomerStationNew);
		controlList.put("lblProducentNew",lblProducentNew);
		controlList.put("lblProducentStationNew",lblProducentStationNew);

		JLabel lblNeuenProduct = new JLabel("- Neuen Product anlegen");
		lblNeuenProduct.setForeground(Color.WHITE);
		lblNeuenProduct.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNeuenProduct.setBounds(23, 480, 251, 30);
		sidePanel.add(lblNeuenProduct);

		JLabel lblStationRedaktieren = new JLabel("- Station redaktieren");
		lblStationRedaktieren.setForeground(Color.WHITE);
		lblStationRedaktieren.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblStationRedaktieren.setBounds(23, 311, 251, 30);
		sidePanel.add(lblStationRedaktieren);

		JLabel lblHerstellerAendern = new JLabel("- Hersteller aendern");
		lblHerstellerAendern.setForeground(Color.WHITE);
		lblHerstellerAendern.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblHerstellerAendern.setBounds(23, 392, 251, 30);
		sidePanel.add(lblHerstellerAendern);

		JLabel lblLadestationAendern = new JLabel("- Ladestation aendern");
		lblLadestationAendern.setForeground(Color.WHITE);
		lblLadestationAendern.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblLadestationAendern.setBounds(23, 452, 251, 30);
		sidePanel.add(lblLadestationAendern);

		JLabel lblProductAendern = new JLabel("- Product aendern");
		lblProductAendern.setForeground(Color.WHITE);
		lblProductAendern.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProductAendern.setBounds(23, 510, 251, 30);
		sidePanel.add(lblProductAendern);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(65, 552, 144, 12);
		sidePanel.add(separator_1_1_1);

		JLabel lblTransporteurManagement = new JLabel("- Transporteur management");
		lblTransporteurManagement.setForeground(Color.WHITE);
		lblTransporteurManagement.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTransporteurManagement.setBounds(23, 576, 251, 30);
		sidePanel.add(lblTransporteurManagement);

		JLabel lblRelationManagement = new JLabel("- Relation management");
		lblRelationManagement.setForeground(Color.WHITE);
		lblRelationManagement.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRelationManagement.setBounds(23, 607, 251, 30);
		sidePanel.add(lblRelationManagement);

		JLabel lblFrachtsatzManagement = new JLabel("- Frachtsatz management");
		lblFrachtsatzManagement.setForeground(Color.WHITE);
		lblFrachtsatzManagement.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblFrachtsatzManagement.setBounds(23, 638, 251, 30);
		sidePanel.add(lblFrachtsatzManagement);

		System.out.println((JFrame)controlList.get("frame"));
		System.out.println((JLabel)controlList.get("lblOrderNew"));



		new MainControlService(controlList);



	}
}
