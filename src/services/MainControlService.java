package services;

import ui.AddCustomerDlg;
import ui.AddCustomerStationDlg;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {
   // private LinkedHashMap controlList;
    private JLabel lblCustomerNew;
    private JLabel lblCustomerStationNew;

    public MainControlService(LinkedHashMap controlList) {

        // this.controlList = controlList;
        this.lblCustomerNew =  (JLabel) controlList.get("lblCustomerNew");
        this.lblCustomerStationNew = (JLabel) controlList.get("lblCustomerStationNew");

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


    }

}
