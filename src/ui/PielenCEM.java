package ui;

import services.AddCustomerService;
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
	private int a;
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

		topPanel.setBounds(0, 0, 1400, 50);
		frame.getContentPane().add(topPanel);
		topPanel.setBackground(new Color(139, 0, 0));
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));


		JLabel lblNewLabel = new JLabel("  X  ");
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
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		topPanel.add(lblNewLabel_1);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		topPanel.add(lblNewLabel);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(304, 50, 1096, 699);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
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
		 
		 JLabel lblOrderNew = new JLabel("- Bestellung eingeben");
		 lblOrderNew.setForeground(new Color(255, 255, 255));
		 lblOrderNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblOrderNew.setBounds(23, 119, 251, 30);
		 sidePanel.add(lblOrderNew);

		 
		 JLabel lblOrderChange = new JLabel("- Bestellung aendern");
		 lblOrderChange.setForeground(Color.WHITE);
		 lblOrderChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblOrderChange.setBounds(23, 149, 251, 30);
		 sidePanel.add(lblOrderChange);

		 
		 JLabel lblOrderDelete = new JLabel("- Bestellung loeschen");
		 lblOrderDelete.setForeground(Color.WHITE);
		 lblOrderDelete.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblOrderDelete.setBounds(23, 180, 251, 30);
		 sidePanel.add(lblOrderDelete);
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(65, 222, 144, 12);
		 sidePanel.add(separator_1);
		 
		 JLabel lblCustomerNew = new JLabel("- Neuen Kunden anlegen");
		 lblCustomerNew.setForeground(Color.WHITE);
		 lblCustomerNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblCustomerNew.setBounds(23, 246, 251, 30);
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
		 lblCustomerChange.setBounds(23, 283, 251, 30);
		 sidePanel.add(lblCustomerChange);
		 
		 JLabel lblCustomerStationNew = new JLabel("- Neue Station anlegen");
		 lblCustomerStationNew.setForeground(Color.WHITE);
		 lblCustomerStationNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblCustomerStationNew.setBounds(23, 325, 251, 30);
		 sidePanel.add(lblCustomerStationNew);
		 
		 JSeparator separator_1_1 = new JSeparator();
		 separator_1_1.setBounds(65, 367, 144, 12);
		 sidePanel.add(separator_1_1);
		 
		 JLabel lblForwarderNew = new JLabel("- Neue Spedition anlegen");
		 lblForwarderNew.setForeground(Color.WHITE);
		 lblForwarderNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblForwarderNew.setBounds(23, 390, 251, 30);
		 sidePanel.add(lblForwarderNew);
		 
		 JLabel lblForwarderChange = new JLabel("- Speditiondaten aendern");
		 lblForwarderChange.setForeground(Color.WHITE);
		 lblForwarderChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		 lblForwarderChange.setBounds(23, 427, 251, 30);
		 sidePanel.add(lblForwarderChange);
		 
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
		controlList.put("lblForwarderNew",lblForwarderNew);
		controlList.put("lblForwarderChange",lblForwarderChange);

		System.out.println((JFrame)controlList.get("frame"));
		System.out.println((JLabel)controlList.get("lblOrderNew"));
		new MainControlService(controlList);



	}


}
