package services;

import ui.PullDownListDlg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddCustomerStationService {

    // private LinkedHashMap<String,Object> listControlls;
    private JLabel lblCloseDialog;
    private JTextField searchCustomer;
    private JLabel lblSearch;
    private JTextField newStationName;
    private JTextField newStationStreet;
    private JTextField newStationLandPostcode;
    private JTextField newStationCity;
    private JTextField newStationEmploee;
    private JTextField newStationTel1;
    private JTextPane textPaneStationNotiz;
    private JList listCustomerStations;
    private JLabel lblAddStation;
    private JLabel lblCancel;
    private JDialog dialog;
    private JPanel contentPanel;


    public AddCustomerStationService(LinkedHashMap listControlls) {

        //this.listControlls = new LinkedHashMap<String, Object>();
        this.lblCloseDialog = (JLabel) listControlls.get("lblCloseDialog");
        this.searchCustomer = (JTextField) listControlls.get("searchCustomer");
        this.lblSearch = (JLabel) listControlls.get("lblSearch");
        this.newStationName = (JTextField) listControlls.get("newStationName");
        this.newStationStreet = (JTextField) listControlls.get("newStationStreet");
        this.newStationLandPostcode = (JTextField) listControlls.get("newStationLandPostcode");
        this.newStationCity = (JTextField) listControlls.get("newStationCity");
        this.newStationEmploee = (JTextField) listControlls.get("newStationEmploee");
        this.newStationTel1 = (JTextField) listControlls.get("newStationTel1");
        this.textPaneStationNotiz = (JTextPane) listControlls.get("textPaneStationNotiz");
        this.listCustomerStations = (JList) listControlls.get("listCustomerStations");
        this.lblAddStation = (JLabel) listControlls.get("lblAddStation");
        this.lblCancel = (JLabel) listControlls.get("lblCancel");
        this.dialog = (JDialog) listControlls.get("dialog");
        this.contentPanel = (JPanel) listControlls.get("contentPanel");

        setListener();


    }

    private void setListener() {
        /*
            searchCustomer.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        System.out.println("Typed");
                        setPullDownList();
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {
                   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                       System.out.println("Pressed");
                        setPullDownList();
                   }
                }

            });
         */
            searchCustomer.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode()==10) {
                        PullDownListDlg pullDown = new PullDownListDlg(searchCustomer);
                        pullDown.showDialog();
                    }
                }

            });
            lblSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked");
                    setPullDownList();
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }
            });
    }

    private boolean checkFieldsIfFilled() {
        return true;
    }

    private void saveCustomerStation() {

    }

    private void setPullDownList() {

        JDialog pullDownDialog = new JDialog();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(112, 128, 144));
        panel.setBounds(18 , 134, 326, 139);
        contentPanel.add(panel);

        panel.setLayout(null);
        JList list = new JList();
        list.setForeground(new Color(255, 255, 255));
        list.setBackground(new Color(112, 128, 144));
        list.setModel(new AbstractListModel() {
            String[] values = new String[]{"Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach", "Pfordt SA", "Michel SAS", "Aspach"};

            public int getSize() {
                return values.length;
            }

            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(18, 134, 326, 139);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(18, 134, 326, 139);
        panel.add(scrollPane);

    }


}
