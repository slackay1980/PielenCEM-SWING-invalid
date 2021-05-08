package services;

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


    }

    private void setListener() {
        lblSpeichern.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        lblCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }

    private boolean checkFieldsIfFilled() {


        return true;
    }

    private void setCustomerFields () {


    }
}
