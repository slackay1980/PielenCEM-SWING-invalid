package services;

import dao.CustomerDAO;
import entyties.Customer;
import org.hibernate.HibernateException;
import ui.AcceptDlg;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class AddCustomerService {

    private LinkedHashMap<String,Object> controlList;
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
    private JDialog dialog;



    public AddCustomerService(LinkedHashMap controlList) {

        this.controlList = controlList;
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
        this.newCustomer_Note = (JTextPane) controlList.get(" newCustomer_Note");
        this.lblCloseDialog = (JLabel) controlList.get(" lblCloseDialog");
        this.lblSpeichern = (JLabel) controlList.get(" lblSpeichern");
        this.lblCancel = (JLabel) controlList.get(" lblCancel");
        this.dialog = (JDialog) controlList.get("dialog");
        setListener();

    }

    private void setListener() {
        if (lblSpeichern!=null) {
            lblSpeichern.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });

            lblCancel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   AcceptDlg acceptDlg = new AcceptDlg("Wollen Sie wirklich diesen Dialog schiessen ohne es gespeichert zu haben.");
                    boolean answer = acceptDlg.showDlg();
                    if (answer) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                }
            });
        }
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

    private void setCustomerFields () {

        if (checkFieldsIfFilled()) {
            Customer customer = new Customer();
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
        }

    }

    private void saveNewCustomer(Customer customer)throws HibernateException, Exception {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.saveCustomer(customer);
    }
}
