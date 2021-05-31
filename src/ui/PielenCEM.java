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

		JLabel lblOrderNew1 = new JLabel("- Bestellung eingeben (V)");
		lblOrderNew1.setForeground(new Color(255, 255, 255));
		lblOrderNew1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderNew1.setBounds(23, 83, 251, 30);
		lblOrderNew1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrderNew1.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrderNew1.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblOrderNew1);


		JLabel lblOrderNew2 = new JLabel("- Bestellung eingeben (S)");
		lblOrderNew2.setForeground(Color.WHITE);
		lblOrderNew2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderNew2.setBounds(23, 113, 251, 30);
		lblOrderNew2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrderNew2.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrderNew2.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblOrderNew2);


		JLabel lblOrderNew3 = new JLabel("- Bestellung eingeben (Vordr.)");
		lblOrderNew3.setForeground(Color.WHITE);
		lblOrderNew3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOrderNew3.setBounds(23, 144, 251, 30);
		lblOrderNew3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrderNew3.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOrderNew3.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblOrderNew3);



		JLabel lblCustomerNew = new JLabel("- Neuen Kunden anlegen");
		lblCustomerNew.setForeground(Color.WHITE);
		lblCustomerNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerNew.setBounds(23, 186, 251, 30);
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
		lblCustomerChange.setBounds(23, 217, 251, 30);
		lblCustomerChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCustomerChange.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerChange.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblCustomerChange);

		JLabel lblCustomerStationNew = new JLabel("- Neue Station anlegen");
		lblCustomerStationNew.setForeground(Color.WHITE);
		lblCustomerStationNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerStationNew.setBounds(23, 244, 251, 30);
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

		JLabel lblCustomerStationChange = new JLabel("- Station redaktieren");
		lblCustomerStationChange.setForeground(Color.WHITE);
		lblCustomerStationChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCustomerStationChange.setBounds(23, 275, 251, 30);
		lblCustomerStationChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCustomerStationChange.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerStationChange.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblCustomerStationChange);

		JLabel lblProducentNew = new JLabel("- Neuen Hersteller anlegen");
		lblProducentNew.setForeground(Color.WHITE);
		lblProducentNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentNew.setBounds(23, 324, 251, 30);
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



		JLabel lblProducentChange = new JLabel("- Hersteller aendern");
		lblProducentChange.setForeground(Color.WHITE);
		lblProducentChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentChange.setBounds(23, 356, 251, 30);
		lblProducentChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducentChange.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProducentChange.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProducentChange);

		JLabel lblProducentStationNew = new JLabel("- Neue Ladestation anlegen");
		lblProducentStationNew.setForeground(Color.WHITE);
		lblProducentStationNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentStationNew.setBounds(23, 382, 251, 30);
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



		JLabel lblProducentStationChange = new JLabel("- Ladestation aendern");
		lblProducentStationChange.setForeground(Color.WHITE);
		lblProducentStationChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProducentStationChange.setBounds(23, 416, 251, 30);
		lblProducentStationChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducentStationChange.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProducentStationChange.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProducentStationChange);

		JLabel lblProductNew = new JLabel("- Neuen Product anlegen");
		lblProductNew.setForeground(Color.WHITE);
		lblProductNew.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProductNew.setBounds(23, 444, 251, 30);
		lblProductNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProductNew.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProductNew.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProductNew);

		JLabel lblProductChange = new JLabel("- Product aendern");
		lblProductChange.setForeground(Color.WHITE);
		lblProductChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblProductChange.setBounds(23, 474, 251, 30);
		lblProductChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProductChange.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProductChange.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblProductChange);


		JLabel lblForwarderAdd = new JLabel("- Transporteur anlegen");
		lblForwarderAdd.setForeground(Color.WHITE);
		lblForwarderAdd.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblForwarderAdd.setBounds(23, 540, 251, 30);
		lblForwarderAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForwarderAdd.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblForwarderAdd.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblForwarderAdd);

		JLabel lblTransporteurChange = new JLabel("- Transporteur aendern");
		lblTransporteurChange.setForeground(Color.WHITE);
		lblTransporteurChange.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTransporteurChange.setBounds(23, 576, 251, 30);
		sidePanel.add(lblTransporteurChange);

		JLabel lblRelationManagement = new JLabel("- Relation management");
		lblRelationManagement.setForeground(Color.WHITE);
		lblRelationManagement.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRelationManagement.setBounds(23, 607, 251, 30);
		lblRelationManagement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRelationManagement.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRelationManagement.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblRelationManagement);

		JLabel lblFreightManagement = new JLabel("- Frachtsatz management");
		lblFreightManagement.setForeground(Color.WHITE);
		lblFreightManagement.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblFreightManagement.setBounds(23, 638, 251, 30);
		lblFreightManagement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFreightManagement.setForeground(new Color(139, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFreightManagement.setForeground(Color.WHITE);
			}
		});
		sidePanel.add(lblFreightManagement);


		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(UIManager.getColor("InternalFrame.background"));
		bottomPanel.setBounds(304, 750, 1090, 49);
		frame.getContentPane().add(bottomPanel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(65, 173, 144, 12);
		sidePanel.add(separator_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(65, 516, 144, 12);
		sidePanel.add(separator_1_1_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(65, 308, 144, 12);
		sidePanel.add(separator_1_1);


		controlList = new LinkedHashMap<String,Object>();
		controlList.put("frame",frame);
		controlList.put("mainTable",table);
		controlList.put("lblOrderNew1",lblOrderNew1);
		controlList.put("lblOrderNew2",lblOrderNew2);
		controlList.put("lblOrderNew3",lblOrderNew3);

		controlList.put("lblCustomerNew",lblCustomerNew);
		controlList.put("lblCustomerChange",lblCustomerChange);
		controlList.put("lblCustomerStationNew",lblCustomerStationNew);
		controlList.put("lblCustomerStationChange",lblCustomerStationChange);

		controlList.put("lblProducentNew",lblProducentNew);
		controlList.put("lblProducentChange",lblProducentChange);
		controlList.put("lblProducentStationNew",lblProducentStationNew);
		controlList.put("lblProducentStationChange",lblProducentStationChange);
		controlList.put("lblProductNew",lblProductNew);
		controlList.put("lblProductChange",lblProductChange);

		controlList.put("lblForwarderAdd",lblForwarderAdd);
		controlList.put("lblForwarderChange",lblTransporteurChange);
		controlList.put("lblRelationManagement",lblRelationManagement);
		controlList.put("lblFreightManagement",lblFreightManagement);



		new MainControlService(controlList);



	}
}
