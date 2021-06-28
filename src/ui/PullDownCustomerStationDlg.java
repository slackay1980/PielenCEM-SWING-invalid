package ui;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.table.DefaultTableModel;

import dao.CustomerStationDAO;
import dao.ProducentDAO;
import dao.ProducentStationsDAO;
import entyties.CustomerStation;
import entyties.Producent;
import entyties.ProducentStation;
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

public class PullDownCustomerStationDlg extends JDialog {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private String searchString = null;
    private Point point;
    private JTable table;
    private List<CustomerStation> customerStationsLikeString = null;
    private int customerStationIndex;
    private DefaultTableModel tableModel;



    /**
     * Create the dialog.
     */
    public PullDownCustomerStationDlg(JTextField textField) {

        this.textField = textField;
        setUndecorated(true);

        getContentPane().setLayout(new BorderLayout(0, 0));

        Object[] columnNames = {
                "ID",
                "Lieferstation",
        };

        tableModel = new DefaultTableModel(columnNames, 1);
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
                    customerStationIndex = table.getSelectedRow();
                    dispose();
                }
            }
        });
    }

    // Dieser Method muss für jede andere TextField neu geschrieben sein
    public void retriveCustomerStations() {
        CustomerStationDAO customerStationsDAO = new CustomerStationDAO();
        try {
            System.out.println(searchString);
            customerStationsLikeString = customerStationsDAO.getCustomerStationAccordToString(textField.getText());
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
        for (int i = 0; i <= customerStationsLikeString.size()-1; i++) {

            tableModel.addRow(newRow);
            tableModel.setValueAt(customerStationsLikeString.get(i).getId() , i, 0);
            tableModel.setValueAt(customerStationsLikeString.get(i).getStationName()+", "+
                    customerStationsLikeString.get(i).getStationCity(),i, 1);

        }
    }

    public CustomerStation showDialog() {
        point = textField.getLocationOnScreen();
        setBounds((int)point.getX(),(int)point.y+textField.getHeight()+3,textField.getWidth(),257);
        retriveCustomerStations();
        renderTableModel();
        setModal(true);
        setAlwaysOnTop(true);
        setVisible(true);
        if (customerStationsLikeString!=null) {
            return (CustomerStation) customerStationsLikeString.get(customerStationIndex);
        }
        else {
            return null;
        }
    }
}

