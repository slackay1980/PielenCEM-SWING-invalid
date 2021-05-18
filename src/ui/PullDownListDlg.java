package ui;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;

import dao.CustomerDAO;
import entyties.Customer;

import javax.swing.JDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class PullDownListDlg extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String searchString = null;
	private Point point;
	private JTable table;
	private List<Customer> customersLikeString = null;
	private int customerIndex;
	private DefaultTableModel tableModel;
	


	/**
	 * Create the dialog.
	 */
	public PullDownListDlg(JTextField textField) {
		
		this.textField = textField;
		setUndecorated(true);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		Object[] columnNames = {
				"ID",
                "Firmenname",
               };
		
		tableModel = new DefaultTableModel(columnNames,1);
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(1000);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		setListeners();
		
		
		
		
	}
	
	
	
	public void setListeners() {
		
		// Frame schlißt sich auf ESC
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==e.VK_ESCAPE) {
					dispose();
				}
			}
		});
		


		// Falls man auf ESC in der Tabelle druckt schlißt sich der Frame zu.
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==e.VK_ESCAPE) {
					dispose();
				}
				if (e.getKeyCode()==e.VK_ENTER) {
					customerIndex = table.getSelectedRow();
					dispose();
				}
			}
		});
	}
	
	// Dieser Method muss für jede andere TextField neu geschrieben sein
	public void retriveCustomers() {
		CustomerDAO customerDAO = new CustomerDAO();
		try {
			System.out.println(searchString);
			customersLikeString = customerDAO.getCustomersByString(textField.getText());
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Dieser Method muss für jede andere TextField neu geschrieben sein
	public void renderTableModel() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] newRow = {
				"",
                "",
               };
		for (int i = 0; i <= customersLikeString.size()-1; i++) {
			
			tableModel.addRow(newRow);
			tableModel.setValueAt(customersLikeString.get(i).getId() , i, 0);
			tableModel.setValueAt(customersLikeString.get(i).getCustomerName() , i, 1);
				
		}
	}

	public Customer showDialog() {
		point = textField.getLocationOnScreen();
		setBounds((int)point.getX(),(int)point.y+textField.getHeight()+3,textField.getWidth(),257);
		retriveCustomers();
		renderTableModel();
		setModal(true);
		setAlwaysOnTop(true);
		setVisible(true);
		if (customersLikeString!=null) {
			return (Customer) customersLikeString.get(customerIndex);
		}
		else {
			return null;
		}
	}
}
