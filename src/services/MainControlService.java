package services;

import ui.AddCustomerDlg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {
    private LinkedHashMap controlList;
    private JLabel lblCustomerNew;

    public MainControlService(LinkedHashMap controlList) {

        this.controlList = controlList;
        this.lblCustomerNew =  (JLabel)controlList.get("lblCustomerNew");
        setCustomerNewListener();

    }

    private void setCustomerNewListener() {
        if (lblCustomerNew!=null) {
            lblCustomerNew.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked");
                    AddCustomerDlg addCustomer = new AddCustomerDlg();
                    addCustomer.setModal(true);
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

}
