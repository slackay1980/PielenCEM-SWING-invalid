package ui;

import dao.ForwarderDAO;
import entyties.Forwarder;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import entyties.Forwarder;
import org.hibernate.HibernateException;

import java.util.List;



public class ForwarderPullDownDlg  extends JDialog{


        private static final long serialVersionUID = 1L;
        private JTextField textField;
        private String searchString = null;
        private Point point;
        private JTable table;
        private List<Forwarder> forwardersLikeString = null;
        private int forwarderIndex =-1;
        // private String forwarderLikeString;
        private DefaultTableModel tableModel;



        /**
         * Create the dialog.
         */
	public ForwarderPullDownDlg(JTextField textField) {

            this.textField = textField;
            setUndecorated(true);

            getContentPane().setLayout(new BorderLayout(0, 0));

            Object[] columnNames = {
                    "ID",
                    "Firmenname",
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
                        forwarderIndex = table.getSelectedRow();
                        dispose();
                    }
                }
            });
        }

        // Dieser Method muss für jede andere TextField neu geschrieben sein
        public void retriveCustomers() {
            ForwarderDAO forwarderDAO = new ForwarderDAO();
            try {
                System.out.println(searchString);
                forwardersLikeString= forwarderDAO.getForwarderByString(textField.getText());
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
            for (int i = 0; i <= forwardersLikeString.size()-1; i++) {

                tableModel.addRow(newRow);
                tableModel.setValueAt(forwardersLikeString.get(i).getId() , i, 0);
                tableModel.setValueAt(forwardersLikeString.get(i).getForwarderName() , i, 1);

            }
        }

        public Forwarder showDialog() {
            point = textField.getLocationOnScreen();
            setBounds((int)point.getX(),(int)point.y+textField.getHeight()+3,textField.getWidth(),257);
            retriveCustomers();
            renderTableModel();
            setModal(true);
            setAlwaysOnTop(true);
            setVisible(true);
            if ((forwardersLikeString.size()!=0)&&(forwarderIndex!=-1)) {
                return (Forwarder) forwardersLikeString.get(forwarderIndex);
            }
            else {
                return null;
            }
        }
}
