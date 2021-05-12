package services;

import dao.CustomerDAO;
import dao.UserDAO;
import entyties.Customer;
import entyties.User;
import org.hibernate.HibernateException;
import ui.AcceptDlg;
import ui.InfoDlg;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.List;

public class AddCustomerService {

    //Varables for save the new Customer
    private User seller;
    private Customer newCustomer;

    //Controll Elemente from Form
    private JTextField newCustomer_CompanyName;
    private JTextField newCustomer_Street;
    private JTextField newCustomer_LandPostcode;
    private JTextField newCustomer_City;
    private JTextField newCustomer_Emploee;
    private JTextField newCustomer_tel1;
    private JTextField newCustomer_tel2;
    private JTextField newCustomer_Fax;
    private JTextField newCustomer_Email;
    private JTextField newCustomer_LogicId;
    private JTextPane newCustomer_Note;
    private JLabel lblCloseDialog;
    private  JLabel lblSpeichern;
    private  JLabel lblCancel;
    private  JLabel lblV;
    private JDialog dialog;
    private JList sellerList;


    //helpers-variables
    private int userIndex;
    private List<User> sellers = null;
    private boolean listButton = true;
    private boolean saved = false;
    boolean userSelected = false;






    public AddCustomerService(LinkedHashMap controlList) {


        this.newCustomer_CompanyName = (JTextField) controlList.get("newCustomer_CompanyName");
        this.newCustomer_Street = (JTextField) controlList.get("newCustomer_Street");
        this.newCustomer_LandPostcode = (JTextField) controlList.get("newCustomer_LandPostcode");
        this.newCustomer_City = (JTextField) controlList.get("newCustomer_City");
        this.newCustomer_Emploee = (JTextField) controlList.get("newCustomer_Emploee");
        this.newCustomer_tel1 = (JTextField) controlList.get("newCustomer_tel1");
        this.newCustomer_tel2 = (JTextField) controlList.get("newCustomer_tel2");
        this.newCustomer_Fax = (JTextField) controlList.get("newCustomer_Fax");
        this.newCustomer_Email = (JTextField) controlList.get("newCustomer_Email");
        this.newCustomer_LogicId = (JTextField) controlList.get("newCustomer_LogicId");
        this.newCustomer_Note = (JTextPane) controlList.get("newCustomer_Note");
        this.lblCloseDialog = (JLabel) controlList.get("lblCloseDialog");
        this.lblSpeichern = (JLabel) controlList.get("lblSpeichern");
        this.lblCancel =  (JLabel) controlList.get("lblCancel");
        this.dialog = (JDialog) controlList.get("dialog");
        this.sellerList = (JList) controlList.get("sellerList");
        this.lblV = (JLabel) controlList.get("lblV");

        setListener();


    }

    private void setListener() {

        lblSpeichern.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    saveNewCustomer();
                    if (saved) {
                        dialog.setVisible(false);
                        dialog.dispose();
                        InfoDlg infoDlg = new InfoDlg(false, "Der Kunde " + newCustomer.getCustomerName() +
                                ", " + newCustomer.getCustomerCity() + " wurde erfolgreich gespeichert.",dialog.getLocation());
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

        lblV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listButton) {
                    lblV.setText(" X");
                    listButton = false;
                    userSelected = false;
                    sellerList.setEnabled(true);
                    jListFillWithSellers();
                    // Doppelclick abfangen
                    sellerList.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            if (userSelected == false) {
                                boolean firstClick = true;
                                if (evt.getClickCount() == 2) {

                                    // Double-click detected
                                    if (firstClick == true) {
                                        userIndex = sellerList.getSelectedIndex();

                                        if (userIndex >= 0) {
                                            seller = (User) sellers.get(userIndex);
                                            DefaultListModel defaultListModel = (DefaultListModel) sellerList.getModel();
                                            defaultListModel.clear();
                                            defaultListModel.addElement(seller.getName() + " " + seller.getSurname());
                                            firstClick = false;
                                            userSelected = true;
                                        }
                                    }
                                }
                            }
                        }
                    });
                    sellerList.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if(e.getKeyChar() == KeyEvent.VK_ENTER) {

                                if (userSelected == false) {
                                    userIndex = sellerList.getSelectedIndex();

                                    if (userIndex >= 0) {
                                        seller = (User) sellers.get(userIndex);
                                        DefaultListModel defaultListModel = (DefaultListModel) sellerList.getModel();
                                        defaultListModel.clear();
                                        defaultListModel.addElement(seller.getName() + " " + seller.getSurname());
                                        userSelected = true;
                                    }
                                }
                            }
                        }
                    });



                }
                else {
                    lblV.setText(" V");
                    listButton = true;
                    userSelected = true;
                    DefaultListModel defaultListModel = (DefaultListModel) sellerList.getModel();
                    defaultListModel.clear();
                    seller = null;
                    sellerList.setEnabled(false);
                }

            }
        });
    }

    private boolean checkFieldsIfFilled() {
        boolean checked = true;
        if (newCustomer_CompanyName.getText().equals("")) checked = false;
        if (newCustomer_Street.getText().equals("")) checked = false;
        if (newCustomer_LandPostcode.getText().equals("")) checked = false;
        if (newCustomer_City.getText().equals("")) checked = false;
        if (newCustomer_LogicId.getText().equals("")) checked = false;

        return checked;
    }

    private void setCustomerFields (Customer customer) {

            customer.setCustomerName(newCustomer_CompanyName.getText());
            customer.setCustomerStreet(newCustomer_Street.getText());
            customer.setCustomerLandPostCode(newCustomer_LandPostcode.getText());
            customer.setCustomerCity(newCustomer_City.getText());
            customer.setCustomerEmploee(newCustomer_Emploee.getText());
            customer.setCustomerTelefone1(newCustomer_tel1.getText());
            customer.setCustomerTelefone2(newCustomer_tel2.getText());
            customer.setCustomerTelefone3(newCustomer_Fax.getText());
            customer.setCustomerEmail(newCustomer_Email.getText());
            customer.setCustomerLogicId(newCustomer_LogicId.getText());
            customer.setCustomerNote(newCustomer_Note.getText());
            customer.setUser(seller);


    }

    private void saveNewCustomer(){
        if (checkFieldsIfFilled()) {
            newCustomer = new Customer();
            setCustomerFields(newCustomer);
            CustomerDAO customerDAO = new CustomerDAO();
            try {
                customerDAO.saveCustomer(newCustomer);
                saved = true;
            } catch (Exception e) {
                e.printStackTrace();
                InfoDlg infoDlg = new InfoDlg(true,"Fehler beim Speichern",dialog.getLocation());
                infoDlg.setModal(true);
                infoDlg.setVisible(true);
            }
        }
        else {
            saved = false;
            InfoDlg infoDlg = new InfoDlg(false,"Sie müssen allle Felder ausfühlen",dialog.getLocation());
            infoDlg.setModal(true);
            infoDlg.setVisible(true);
        }
    }

    private void jListFillWithSellers() {

        try {
            sellers = new UserDAO().getAllSeller();
        }
        catch (HibernateException e)  {
          InfoDlg infoDlg = new InfoDlg(true,"Probleme mit Verbindung zum Datenbank",dialog.getLocation());
          infoDlg.setModal(true);
          infoDlg.setVisible(true);
        }
        catch (Exception e)  {
            InfoDlg infoDlg = new InfoDlg(true,"Allgemeines Problem",dialog.getLocation());
            infoDlg.setModal(true);
            infoDlg.setVisible(true);
        }

        DefaultListModel model = (DefaultListModel) sellerList.getModel();
        for (User user : sellers) {
          model.addElement(user.getName()+" "+user.getSurname());
        }
        sellerList.repaint();

    }
}
