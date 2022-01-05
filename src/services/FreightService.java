package services;

import entyties.Forwarder;
import entyties.Relation;
import ui.ForwarderPullDownDlg;
import ui.RelationPullDownDlg;

import javax.swing.*;
import java.awt.*;
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
        this.labelProducent = (JLabel) controlList.get("labelProducent");
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
                    setForwarderOrWarning(forwarder);
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

    /* hier kommen alle Metoden */

    private void setForwarderOrWarning(Forwarder forwarder) {

        if (forwarder!=null) {
            labelSpedName.setText(forwarder.getForwarderName()); labelSpedName.setForeground(Color.GREEN);
            labelSpedStreet.setText(forwarder.getForwarderStreet());labelSpedStreet.setForeground(Color.GREEN);
            labelSpedCity.setText(forwarder.getForwarderLandPostCode() + " " + forwarder.getForwarderCity());
            labelSpedCity.setForeground(Color.GREEN);

            textFieldSpedition.setText(forwarder.getForwarderName()+" ,"+forwarder.getForwarderLandPostCode()+" "+forwarder.getForwarderCity());

        }
        else {
            labelSpedName.setText("---------"); labelSpedName.setForeground(Color.RED);
            labelSpedStreet.setText("----------");labelSpedStreet.setForeground(Color.RED);
            labelSpedCity.setText("-----------");labelSpedCity.setForeground(Color.red);

            textFieldSpedition.setText("");
        }
    }

    private void setRelationOrWarning(Relation relation) {
        if (relation!=null) {
            labelProducent.setText(relation.getProducentStation().getStationName()+" ,"+relation.getProducentStation().getStationCity());
            labelProducent.setForeground(Color.GREEN);

            labelMinus.setForeground(Color.GREEN);


            labelCustomer.setText(relation.getCustomerStation().getStationName()+" ,"+relation.getCustomerStation().getStationCity());
            labelCustomer.setForeground(Color.GREEN);

            textFieldRelation.setText(relation.getProducentStation().getStationCity()+" - "+relation.getCustomerStation().getStationCity());

        }
        else {
            labelProducent.setText("---------"); labelProducent.setForeground(Color.RED);
            labelMinus.setForeground(Color.RED);
            labelCustomer.setText("-----------");labelCustomer.setForeground(Color.red);

            textFieldRelation.setText("");
        }
    }


}
