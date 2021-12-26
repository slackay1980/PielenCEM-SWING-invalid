package services;

import ui.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class MainControlService {

        private  JFrame frame;
		private JTable table;
		private JLabel lblOrderNew1;
        private JLabel lblOrderNew2;
        private JLabel lblOrderNew3;
        private JLabel lblCustomerNew;
        private JLabel lblCustomerChange;
        private JLabel lblCustomerStationNew;
        private JLabel lblCustomerStationChange;
        private JLabel lblProducentNew;
        private JLabel lblProducentChange;
        private JLabel lblProducentStationNew;
        private JLabel lblProducentStationChange;
        private JLabel lblProductNew;
        private JLabel lblProductChange;
        private JLabel lblForwarderAdd;
        private JLabel lblForwarderChange;
        private JLabel lblRelationManagement;
        private JLabel lblFreightManagement;


    public MainControlService(LinkedHashMap controlList) {

        this.frame =  (JFrame) controlList.get("frame");
        this.table = (JTable) controlList.get("table");

        this.lblOrderNew1 =  (JLabel) controlList.get("lblOrderNew1");
        this.lblOrderNew2 = (JLabel) controlList.get("lblOrderNew2");
        this.lblOrderNew3 = (JLabel) controlList.get("lblOrderNew3");


        this.lblCustomerNew = (JLabel) controlList.get("lblCustomerNew");
        this.lblCustomerChange = (JLabel) controlList.get("lblCustomerChange");
        this.lblCustomerStationNew = (JLabel) controlList.get("lblCustomerStationNew");
        this.lblCustomerStationChange = (JLabel) controlList.get("lblCustomerStationChange");

        this.lblProducentNew = (JLabel) controlList.get("lblProducentNew");
        this.lblProducentChange = (JLabel) controlList.get("lblProducentChange");
        this.lblProducentStationNew = (JLabel) controlList.get("lblProducentStationNew");
        this.lblProducentStationChange = (JLabel) controlList.get("lblProducentStationChange");
        this.lblProductNew = (JLabel) controlList.get("lblProductNew");
        this.lblProductChange = (JLabel) controlList.get("lblProductChange");

        this.lblForwarderAdd = (JLabel) controlList.get("lblForwarderAdd");
        this.lblForwarderChange = (JLabel) controlList.get("lblForwarderChange");
        this.lblRelationManagement = (JLabel) controlList.get("lblRelationManagement");
        this.lblFreightManagement = (JLabel) controlList.get("lblFreightManagement");




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

        lblProductNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddProductDlg addProductDlg = new AddProductDlg();
                addProductDlg.setModal(true);
                addProductDlg   .setVisible(true);
            }

        });

        lblForwarderAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                AddForwarderDlg addForwarderDlg = new AddForwarderDlg();
                addForwarderDlg.setModal(true);
                addForwarderDlg   .setVisible(true);
            }

        });



        lblFreightManagement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                FreightPullDownList freightPullDownList = new FreightPullDownList(lblFreightManagement);
                int i = freightPullDownList.showDialog();
                switch (i) {
                    case 0: new FreightDlg().showDialog();break;
                    case 1: new FreightDlg().showDialog();break;
              }

            }

        });


        lblRelationManagement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                RelationOnMainWindowPullDownList relationOnMainWindowPullDownList = new RelationOnMainWindowPullDownList(lblRelationManagement);
                int i = relationOnMainWindowPullDownList.showDialog();
                switch (i) {
                    case 0: new AddRelationDlg().showDialog();break;
                    case 1: new AddRelationDlg().showDialog();break;
                }

            }

        });



    }

}
