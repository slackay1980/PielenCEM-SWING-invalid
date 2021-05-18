package services;

import entyties.Customer;
import ui.PullDownListDlg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddCustomerStationService {

    private Customer customer;

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
                        customer = pullDown.showDialog();
                        /* zu löschen */
                        newStationName.setText(customer.getCustomerName());
                        newStationStreet.setText(customer.getCustomerStreet());
                    }
                }

            });
            lblSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    PullDownListDlg pullDown = new PullDownListDlg(searchCustomer);
                    customer = pullDown.showDialog();

                }

            });
    }

    private boolean checkFieldsIfFilled() {
        return true;
    }

    private void saveCustomerStation() {

    }




}
