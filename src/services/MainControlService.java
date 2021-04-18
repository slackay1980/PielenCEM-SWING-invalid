package services;

import ui.AddCustomerDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {
    private LinkedHashMap controlList;

    public MainControlService(LinkedHashMap controlList) {

        this.controlList = controlList;
        setCustomerNewListener();

    }

    private void setCustomerNewListener() {
        JLabel lblCustomerNew =  (JLabel)controlList.get("lblCustomerNew");
        lblCustomerNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddCustomerDialog addCustomer = new AddCustomerDialog();
                addCustomer.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblCustomerNew.setForeground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblCustomerNew.setForeground(Color.WHITE);
            }
        });
    }

}
