package services;

import dao.CustomerDAO;
import dao.ForwarderDAO;
import entyties.Customer;
import entyties.Forwarder;
import entyties.User;
import ui.AcceptDlg;
import ui.InfoDlg;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.List;

public class AddForwarderService {


    private Forwarder newForwarder;

    //Controll Elemente from Form
    private JTextField txtForwarderCompanyName;
    private JTextField txtForwarderStreet;
    private JTextField txtForwarderLandPostcode;
    private JTextField txtForwarderCity;
    private JTextField txtForwarderEmploee;
    private JTextField txtForwarderTel1;
    private JTextField txtForwarderTel2;
    private JTextField txtForwarderFax;
    private JTextField txtForwarderEmail;
    private JTextField txtForwarderLogicId;
    private JTextPane textPaneForwarderNote;
    private JLabel lblCloseDialog;
    private  JLabel lblSpeichern;
    private  JLabel lblCancel;
    private JDialog dialog;



    //helpers-variables
    private boolean saved = false;

    public AddForwarderService( LinkedHashMap controlList) {


        this.txtForwarderCompanyName = (JTextField)controlList.get("txtForwarderCompanyName");
        this.txtForwarderStreet = (JTextField) controlList.get("txtForwarderStreet");
        this.txtForwarderLandPostcode = (JTextField)controlList.get("txtForwarderLandPostcode");
        this.txtForwarderCity = (JTextField) controlList.get("txtForwarderCity");
        this.txtForwarderEmploee = (JTextField) controlList.get("txtForwarderEmploee");
        this.txtForwarderTel1 = (JTextField) controlList.get("txtForwarderTel1");
        this.txtForwarderTel2 = (JTextField) controlList.get("txtForwarderTel2");
        this.txtForwarderFax = (JTextField) controlList.get("txtForwarderFax");
        this.txtForwarderEmail = (JTextField) controlList.get("txtForwarderEmail");
        this.txtForwarderLogicId = (JTextField) controlList.get("txtForwarderLogicId");
        this.textPaneForwarderNote = (JTextPane) controlList.get("textPaneForwarderNote");
        this.lblCloseDialog = (JLabel) controlList.get("lblCloseDialog");
        this.lblSpeichern = (JLabel) controlList.get("lblSpeichern");
        this.lblCancel = (JLabel) controlList.get("lblCancel");
        this.dialog= (JDialog) controlList.get("dialog");

        setListener();

    }

    private void setListener() {

        lblSpeichern.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Gecklickt");
                saveNewForwarder();
                if (saved) {
                    dialog.setVisible(false);
                    dialog.dispose();
                    InfoDlg infoDlg = new InfoDlg(false, "Der Transportunternehmer " + newForwarder.getForwarderName() +
                            " aus " + newForwarder.getForwarderCity() + " wurde erfolgreich gespeichert.", dialog.getLocation());
                    infoDlg.setModal(true);
                    infoDlg.setVisible(true);
                }
            }

        });


        lblCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AcceptDlg acceptDlg = new AcceptDlg("Wollen Sie wirklich das Fenster zumachen ?", dialog.getLocation());
                boolean answer = acceptDlg.showDlg();
                if (answer) {
                    dialog.setVisible(false);
                    dialog.dispose();
                } else {
                    dialog.setVisible(true);
                }
            }
        });
    }

        private boolean checkFieldsIfFilled() {
        boolean checked = true;
        if (txtForwarderCity.getText().equals("")) checked = false;
        if (txtForwarderCompanyName.getText().equals("")) checked = false;
        if (txtForwarderStreet.getText().equals("")) checked = false;
        if (txtForwarderLandPostcode.getText().equals("")) checked = false;
        if (txtForwarderEmail.getText().equals("")) checked = false;

        return checked;
    }

    private void setForwarderFields (Forwarder forwarder) {

        forwarder.setForwarderName(txtForwarderCompanyName.getText());
        forwarder.setForwarderStreet(txtForwarderStreet.getText());
        forwarder.setForwarderCity(txtForwarderCity.getText());
        forwarder.setForwarderLandPostCode(txtForwarderLandPostcode.getText());
        forwarder.setForwarderEmploee(txtForwarderEmploee.getText());
        forwarder.setForwarderTelefone1(txtForwarderTel1.getText());
        forwarder.setForwarderTelefone2(txtForwarderTel2.getText());
        forwarder.setForwarderTelefone3(txtForwarderFax.getText());
        forwarder.setForwarderEmail(txtForwarderEmail.getText());
        forwarder.setForwarderLogicId(txtForwarderLogicId.getText());
        forwarder.setForwarderName(textPaneForwarderNote.getText());


    }

    private void saveNewForwarder(){
        if (checkFieldsIfFilled()) {
            newForwarder = new Forwarder();
            setForwarderFields(newForwarder);
            ForwarderDAO forwarderDAO = new ForwarderDAO();
            try {
                forwarderDAO.saveForwarder(newForwarder);
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
