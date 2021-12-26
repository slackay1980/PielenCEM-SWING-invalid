package services;

import entyties.Forwarder;
import entyties.Relation;
import ui.ForwarderPullDownDlg;
import ui.RelationPullDownDlg;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;


public class FreightService {
    private JTextField textFieldSpedition, textFieldRelation;

    private JLabel labelSpedName, labelSpedStreet,labelSpedCity,labelProducent,labelMinus,labelCustomer;

    private JTable table;

    private JButton buttonOk,buttonCancel,buttonBut1,buttonBut2,buttonBut3;

    private Forwarder forwarder;
    private Relation relation;

    public FreightService(LinkedHashMap<String,Object> controlList) {

        this.textFieldSpedition = (JTextField) controlList.get("textFieldSpedition");
        this.textFieldRelation = (JTextField) controlList.get("textFieldRelation");
        this.labelSpedName = (JLabel) controlList.get("labelSpedName");
        this.labelSpedStreet = (JLabel) controlList.get("labelSpedStreet");
        this.labelSpedCity = (JLabel) controlList.get("labelSpedCity");
        this.labelSpedCity = (JLabel) controlList.get("labelProducent");
        this.labelMinus = (JLabel) controlList.get("labelMinus");
        this.labelCustomer = (JLabel) controlList.get("labelCustomer");
        this.table = (JTable) controlList.get("table");
        this.buttonOk = (JButton) controlList.get("buttonOk");
        this.buttonCancel = (JButton) controlList.get("buttonCancel");
        this.buttonBut1 = (JButton) controlList.get("buttonBut1");
        this.buttonBut2 = (JButton) controlList.get("buttonBut2");
        this.buttonBut3 = (JButton) controlList.get("buttonBut3");

        handlerToControlElementsBind();

    }

    /* hier alle Buttons und Edits mit Handler belegen */
    private void handlerToControlElementsBind() {

        textFieldSpedition.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    ForwarderPullDownDlg pullDown = new ForwarderPullDownDlg(textFieldSpedition);
                    forwarder = pullDown.showDialog();
                }
            }

        });

        textFieldRelation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    RelationPullDownDlg pullDown = new RelationPullDownDlg(textFieldRelation);
                    relation = pullDown.showDialog();
                }
            }

        });

    }

    private void XXX() {

    }

    /* hier kommen alle Metoden */
}
