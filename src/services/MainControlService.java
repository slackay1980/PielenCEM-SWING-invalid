package services;

import ui.AddCustomerDlg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {
   // private LinkedHashMap controlList;
    private JLabel lblCustomerNew;

    public MainControlService(LinkedHashMap controlList) {

        // this.controlList = controlList;
        this.lblCustomerNew =  (JLabel) controlList.get("lblCustomerNew");
        System.out.println(lblCustomerNew.getText());
        setCustomerNewListener();

    }

    private void setCustomerNewListener() {

            lblCustomerNew.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked");
                    AddCustomerDlg addCustomer = new AddCustomerDlg();
                    addCustomer.setModal(true);
                    addCustomer.setVisible(true);
                }

            });

    }

}
