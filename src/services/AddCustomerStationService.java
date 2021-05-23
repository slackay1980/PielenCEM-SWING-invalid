package services;

import dao.CustomerDAO;
import dao.CustomerStationDAO;
import entyties.Customer;
import entyties.CustomerStation;

import ui.AcceptDlg;
import ui.InfoDlg;
import ui.PullDownListDlg;

import javax.swing.*;

import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AddCustomerStationService {

    private Customer customer;
    private CustomerStation newCustomerStation;

    private boolean saved;

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


    public AddCustomerStationService(   LinkedHashMap listControlls) {

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

        lblAddStation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveCustomerStation();
                if (saved) {
                    dialog.setVisible(false);
                    dialog.dispose();
                    InfoDlg infoDlg = new InfoDlg(false, "Der Kunde " + customer.getCustomerName() +
                            ", " + customer.getCustomerCity() + " hat eine neue Station bekommen. /c "+
                            newCustomerStation.getStationName()+", "+newCustomerStation.getStationCity(),dialog.getLocation());
                    infoDlg.setModal(true);
                    infoDlg.setVisible(true);
                }
            }

        });


        lblCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AcceptDlg acceptDlg = new AcceptDlg("Wollen Sie wirklich das Fenster zumachen ?",dialog.getLocation());
                boolean answer = acceptDlg.showDlg();
                if (answer) {
                    dialog.setVisible(false);
                    dialog.dispose();
                }
                else {
                    dialog.setVisible(true);
                }
            }
        });
        /*
            searchCustomer.addKeyListener(new KeyAdapter() {
                @Override
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
                   if (customer!=null) {
                       fillListWithCustomerStations();
                   }
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
        boolean checked = true;
        if (newStationName.getText().equals("")) checked = false;
        if (newStationStreet.getText().equals("")) checked = false;
        if (newStationLandPostcode.getText().equals("")) checked = false;
        if (newStationCity.getText().equals("")) checked = false;
        if (customer==null) checked = false;
        return checked;
    }

    private void renderStations() {

    }

    private void setCustomerStationsFields() {
        newCustomerStation.setStationName(newStationName.getText());
        newCustomerStation.setStationStreet(newStationStreet.getText());
        newCustomerStation.setStationLandPostCode(newStationLandPostcode.getText());
        newCustomerStation.setStationCity(newStationCity.getText());
        newCustomerStation.setStationEmploee(newStationEmploee.getText());
        newCustomerStation.setStationTelefone1(newStationTel1.getText());
        newCustomerStation.setStationNote(textPaneStationNotiz.getText());
        newCustomerStation.setCustomer(customer);
    }

    private void saveCustomerStation() {

        if (checkFieldsIfFilled()) {
            newCustomerStation = new CustomerStation();
            setCustomerStationsFields();
            CustomerStationDAO customerStationDAO = new CustomerStationDAO();
            try {
                customerStationDAO.saveNewStation(newCustomerStation);
                saved = true;
            } catch (Exception e) {
                e.printStackTrace();
                InfoDlg infoDlg = new InfoDlg(true, "Fehler beim Speichern", dialog.getLocation());
                infoDlg.setModal(true);
                infoDlg.setVisible(true);
            }
        } else {
            saved = false;
            InfoDlg infoDlg = new InfoDlg(false, "Sie müssen allle Felder ausfühlen", dialog.getLocation());
            infoDlg.setModal(true);
            infoDlg.setVisible(true);
        }

    }

    private void fillListWithCustomerStations() {
        searchCustomer.setText(
                customer.getCustomerName()+", "
                +customer.getCustomerLandPostCode()+" "
                + customer.getCustomerCity());
        DefaultListModel defaultListModel = (DefaultListModel) listCustomerStations.getModel();
        defaultListModel.clear();
        List<CustomerStation> customerStations = (List) customer.getCustomerStations();
        for (CustomerStation station :  customerStations) {
            defaultListModel.addElement(station.getStationName() + ", " + station.getStationLandPostCode() + " " +
                    station.getStationCity());
        }
    }



}