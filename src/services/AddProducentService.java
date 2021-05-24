package services;

import dao.CustomerDAO;
import dao.ProducentDAO;
import dao.UserDAO;
import entyties.Customer;
import entyties.Producent;
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

public class AddProducentService {

    //Varables for save the new Producent
    private Producent newProducent;

    //Controll Elemente from Form
    private JTextField newProducent_CompanyName;
    private JTextField newProducent_Street;
    private JTextField newProducent_LandPostcode;
    private JTextField newProducent_City;
    private JTextField newProducent_Emploee;
    private JTextField newProducent_tel1;
    private JTextField newProducent_tel2;
    private JTextField newProducent_Fax;
    private JTextField newProducent_Email;
    private JTextField newProducent_LogicId;
    private JTextPane newProducent_Note;
    private JLabel lblCloseDialog;
    private  JLabel lblSpeichern;
    private  JLabel lblCancel;
    private JDialog dialog;


    //helpers-variables
    private boolean saved;







    public AddProducentService(LinkedHashMap controlList) {


        this.newProducent_CompanyName = (JTextField) controlList.get("newProducent_CompanyName");
        this.newProducent_Street = (JTextField) controlList.get("newProducent_Street");
        this.newProducent_LandPostcode = (JTextField) controlList.get("newProducent_LandPostcode");
        this.newProducent_City = (JTextField) controlList.get("newProducent_City");
        this.newProducent_Emploee = (JTextField) controlList.get("newProducent_Emploee");
        this.newProducent_tel1 = (JTextField) controlList.get("newProducent_tel1");
        this.newProducent_tel2 = (JTextField) controlList.get("newProducent_tel2");
        this.newProducent_Fax = (JTextField) controlList.get("newProducent_Fax");
        this.newProducent_Email = (JTextField) controlList.get("newProducent_Email");
        this.newProducent_LogicId = (JTextField) controlList.get("newProducent_LogicId");
        this.newProducent_Note = (JTextPane) controlList.get("newProducent_Note");
        this.lblCloseDialog = (JLabel) controlList.get("lblCloseDialog");
        this.lblSpeichern = (JLabel) controlList.get("lblSpeichern");
        this.lblCancel =  (JLabel) controlList.get("lblCancel");
        this.dialog = (JDialog) controlList.get("dialog");


        setListener();


    }

    private void setListener() {

        lblSpeichern.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    saveNewProducent();
                    if (saved) {
                        dialog.setVisible(false);
                        dialog.dispose();
                        InfoDlg infoDlg = new InfoDlg(false, "Der Hersteller " + newProducent.getProducentName() +
                                ", " + newProducent.getProducentCity() + " wurde erfolgreich gespeichert.",dialog.getLocation());
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

            }

    private boolean checkFieldsIfFilled() {
        boolean checked = true;
        if (newProducent_CompanyName.getText().equals("")) checked = false;
        if (newProducent_Street.getText().equals("")) checked = false;
        if (newProducent_LandPostcode.getText().equals("")) checked = false;
        if (newProducent_City.getText().equals("")) checked = false;
        if (newProducent_LogicId.getText().equals("")) checked = false;

        return checked;
    }

    private void setProducentFields (Producent producent) {

        producent.setProducentName(newProducent_CompanyName.getText());
        producent.setProducentStreet(newProducent_Street.getText());
        producent.setProducentLandPostCode(newProducent_LandPostcode.getText());
        producent.setProducentCity(newProducent_City.getText());
        producent.setProducentEmploee(newProducent_Emploee.getText());
        producent.setProducentTelefone1(newProducent_tel1.getText());
        producent.setProducentTelefone2(newProducent_tel2.getText());
        producent.setProducentTelefone3(newProducent_Fax.getText());
        producent.setProducentEmail(newProducent_Email.getText());
        producent.setProducentLogicId(newProducent_LogicId.getText());
        producent.setProducentNote(newProducent_Note.getText());



    }

    private void saveNewProducent(){
        if (checkFieldsIfFilled()) {
            newProducent = new Producent();
            setProducentFields(newProducent);
            ProducentDAO producentDAO = new ProducentDAO();
            try {
                producentDAO.saveProducent(newProducent);
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


}
