package services;

import ui.AddCustomerDlg;
import ui.AddCustomerStationDlg;
import ui.AddProducentDlg;
import ui.AddProducentStationDlg;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {
   // private LinkedHashMap controlList;
    private JLabel lblCustomerNew;
    private JLabel lblCustomerStationNew;
    private JLabel lblProducentNew;
    private JLabel  lblProducentStationNew;

    public MainControlService(LinkedHashMap controlList) {

        // this.controlList = controlList;
        this.lblCustomerNew =  (JLabel) controlList.get("lblCustomerNew");
        this.lblCustomerStationNew = (JLabel) controlList.get("lblCustomerStationNew");
        this.lblProducentNew = (JLabel) controlList.get("lblProducentNew");
        this.lblProducentStationNew = (JLabel) controlList.get("lblProducentStationNew");

        setListener();

    }

    private void setListener() {

        lblCustomerNew.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    AddCustomerDlg addCustomer = new AddCustomerDlg();
                    addCustomer.setModal(true);
                    addCustomer.setVisible(true);
                }

        });

        lblCustomerStationNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddCustomerStationDlg addCustomerStation = new AddCustomerStationDlg();
                addCustomerStation.setModal(true);
                addCustomerStation.setVisible(true);
            }

        });

        lblProducentNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddProducentDlg addProducentDlg = new AddProducentDlg();
                addProducentDlg.setModal(true);
                addProducentDlg.setVisible(true);
            }

        });

        lblProducentStationNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddProducentStationDlg addProducentStationDlg = new AddProducentStationDlg();
                addProducentStationDlg.setModal(true);
                addProducentStationDlg.setVisible(true);
            }

        });


    }

}
