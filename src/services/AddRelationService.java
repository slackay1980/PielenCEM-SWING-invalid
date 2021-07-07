package services;

import dao.ProducentStationsDAO;
import dao.RelationDAO;
import entyties.CustomerStation;
import entyties.ProducentStation;
import entyties.Relation;
import ui.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class AddRelationService {

    // Control Elements
    private JTextField txtProducentStation;
    private JTextField txtCustomerStation;
    private JTextField txtDistance;
    private JTextField txtRelationField1;
    private JTextPane textRelationNotice;
    private  JLabel lblCloseDialog;
    private JLabel lblSaveRelation;
    private JLabel lblCancel;
    private JTextField txtRelationField2;
    private JTextField txtRelationField3;
    private JTextField textRelationField4;
    private JCheckBox chckBoxCustom;
    private JLabel lblSearchProducentStation;
    private JLabel lblSearchCustomerStation;
    private JDialog dialog;

    // Helper
    private CustomerStation customerStation = null;
    private ProducentStation producentStation = null;
    private Relation relation = null;
    private RelationDAO relationDAO;
    private boolean saved;

    public AddRelationService(LinkedHashMap<String,Object> controlList) {
        this.txtProducentStation  = (JTextField)controlList.get("txtProducentStation");
        this.txtCustomerStation  = (JTextField)controlList.get("txtCustomerStation");
        this.txtDistance  = (JTextField)controlList.get("txtDistance");
        this.txtRelationField1  = (JTextField)controlList.get("txtRelationField1");
        this.textRelationNotice  = (JTextPane) controlList.get("textRelationNotice");
        this.txtRelationField2  = (JTextField)controlList.get("txtRelationField2");
        this.txtRelationField3  = (JTextField)controlList.get("txtRelationField3");
        this.textRelationField4  = (JTextField)controlList.get("textRelationField4");
        this.lblCloseDialog  = (JLabel)controlList.get("lblCloseDialog");
        this.lblSaveRelation  = (JLabel)controlList.get("lblSaveRelation");
        this.lblCancel  = (JLabel)controlList.get("lblCancel");
        this.chckBoxCustom = (JCheckBox)controlList.get("chckBoxCustom");
        this.lblSearchProducentStation = (JLabel) controlList.get("lblSearchProducentStation");
        this.lblSearchCustomerStation = (JLabel) controlList.get("lblSearchCustomerStation");
        this.dialog = (JDialog)controlList.get("dialog");

        this.relationDAO = new RelationDAO();

        setListener();

    }

    private void setListener() {
        txtCustomerStation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownCustomerStationDlg pullDownCustomerStations = new PullDownCustomerStationDlg(txtCustomerStation);
                    customerStation = pullDownCustomerStations.showDialog();
                    txtCustomerStation.setText(customerStation.getStationName() +", "+customerStation.getStationCity());
                    checkRelationIfExist();
                }
            }

        });

        lblSearchCustomerStation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownCustomerStationDlg pullDownCustomerStations = new PullDownCustomerStationDlg(txtCustomerStation);
                    customerStation = pullDownCustomerStations.showDialog();
                    txtCustomerStation.setText(customerStation.getStationName() +", "+customerStation.getStationCity());
                    checkRelationIfExist();
                }
            }

        });

        txtProducentStation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownProducentStationList producentStationList = new PullDownProducentStationList(txtProducentStation);
                    producentStation = producentStationList.showDialog();
                    txtProducentStation.setText(producentStation.getStationName()+", "+producentStation.getStationCity());
                    checkRelationIfExist();

                }
            }

        });

        lblSearchProducentStation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownProducentStationList producentStationList = new PullDownProducentStationList(txtProducentStation);
                    producentStation = producentStationList.showDialog();
                    txtProducentStation.setText(producentStation.getStationName()+", "+producentStation.getStationCity());
                    checkRelationIfExist();


                }
            }

        });

        lblSaveRelation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveRelation();
                if (saved) {
                    dialog.setVisible(false);
                    dialog.dispose();
                    InfoDlg infoDlg = new InfoDlg(false, "Neue Relation wurde angelegt " + "\n" +
                            relation.getProducentStation().getStationName()+", "+relation.getProducentStation().getStationCity() +
                            " - " +
                            relation.getCustomerStation().getStationName() + ", " + relation.getCustomerStation().getStationCity()
                            ,dialog.getLocation());
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
        if (customerStation==null) checked = false;
        if (producentStation==null) checked = false;
        if (txtDistance.getText().equals("")) checked = false;
        return checked;
    }

    private boolean setFields (Relation relation) {

        String str = txtDistance.getText();
        Integer distance;
        try
        {
            distance = Integer.parseInt(str);
        } catch(NumberFormatException e)
        {
            new InfoDlg(true, "Die Entfernung muss eine ganze Zahl sein.",dialog.getLocation()).setVisible(true);
            return false;
        }
        relation.setDistance(distance );
        relation.setIfCustom(chckBoxCustom.isSelected());
        relation.setCustomerStation(customerStation);
        relation.setProducentStation(producentStation);

        return true;

    }

    private void saveRelation() {

        if (checkFieldsIfFilled()) {
            relation = new Relation();
            setFields(relation);

            try {
                if (relationDAO.ifRelationExist(customerStation,producentStation)==true) {
                    InfoDlg infoDlg = new InfoDlg(true,
                            "Diese Relation ist bereits angelegt. Sie können einfach zu Frachtdefenition springen.", dialog.getLocation());
                    infoDlg.setModal(true);
                    infoDlg.setVisible(true);
                    return;
                }
            }catch(Exception e) {
                e.printStackTrace();
                InfoDlg infoDlg = new InfoDlg(true, "Fehler beim Daten lesen", dialog.getLocation());
                infoDlg.setModal(true);
                infoDlg.setVisible(true);
            }
            try {
                relationDAO.saveRelation(relation);
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

    private boolean checkRelationsIfExistHelper() throws Exception {
        boolean answer = false;
        if ((customerStation!=null) & (producentStation!=null)) {
            answer = relationDAO.ifRelationExist(customerStation,producentStation);
        }
        return answer;

    }

    private void checkRelationIfExist() {
        try {
            if (checkRelationsIfExistHelper()==true) {
                producentStation = null;
                customerStation = null;
                txtProducentStation.setText("");
                txtCustomerStation.setText("");
                new InfoDlg(true, "Die Relation existiert bereits", dialog.getLocation()).showDlg();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            new InfoDlg(true, "Kann keine Daten aus Datenbank lesen", dialog.getLocation()).showDlg();

        }
    }



}

