package services;

import dao.ProductDAO;
import entyties.ProducentStation;
import entyties.Product;
import ui.AcceptDlg;
import ui.InfoDlg;
import ui.PullDownProducentStationList;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

public class AddProductService {

    private ProducentStation producentStation;
    private Product product;

    private JTextField searchProducentStation;
    private JLabel lblSearch;
    private JTextField newProductDescription;
    private JTextField newProductDescriptionAdditional;
    private JTextField newField1;
    private JTextField newField2;
    private JLabel lblCloseDialog;
    private JLabel lblAddStation;
    private JLabel lblCancel;
    private JDialog dialog;

    private boolean saved;


    public AddProductService (LinkedHashMap listControlls) {

       this.lblCloseDialog = (JLabel) listControlls.get("lblCloseDialog");
       this.searchProducentStation = (JTextField)  listControlls.get("searchProducent");
       this.lblSearch = (JLabel) listControlls.get("lblSearch");
       this.newProductDescription = (JTextField) listControlls.get("newProductDescription");
       this.newProductDescriptionAdditional = (JTextField) listControlls.get("newProductDescriptionAdditional");
       this.newField1 = (JTextField) listControlls.get("newField1");
       this.newField2 = (JTextField) listControlls.get("newField2");
       this.lblAddStation = (JLabel) listControlls.get("lblAddStation");
       this.lblCancel = (JLabel) listControlls.get("lblCancel");
       this.dialog = (JDialog) listControlls.get("dialog");

       setListener();

    }

    private void setListener() {
        lblAddStation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveProduct();
                if (saved) {
                    dialog.setVisible(false);
                    dialog.dispose();
                    InfoDlg infoDlg = new InfoDlg(false, "Die Ladestation " + producentStation.getStationName() +
                            ", " + producentStation.getStationCity() + " hat ein neues Product bekommen.  "+
                            product.getProductName(),dialog.getLocation());
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

        searchProducentStation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownProducentStationList pullDown = new PullDownProducentStationList(searchProducentStation);
                    producentStation = pullDown.showDialog();
                    if (producentStation != null) {
                        searchProducentStation.setText(producentStation.getStationName()
                                                        +", "+ producentStation.getStationCity());
                        searchProducentStation.setEditable(false);
                    }else {
                        searchProducentStation.setText("");
                    }

                }
            }

        });
        lblSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PullDownProducentStationList pullDown = new PullDownProducentStationList(searchProducentStation);
                producentStation = pullDown.showDialog();
                if (producentStation != null) {
                    searchProducentStation.setText(producentStation.getStationName()
                            +", "+ producentStation.getStationCity());
                    searchProducentStation.setEditable(false);
                }else {
                    searchProducentStation.setText("");
                }

            }

        });

    }


    private boolean checkFieldsIfFilled() {
        boolean checked = true;
        if (newProductDescription.getText().equals("")) checked = false;
        if (producentStation==null) checked = false;
        return checked;
    }

    private void setProductFields() {

        product.setProducentStation(producentStation);

        product.setProductName(newProductDescription.getText());
        product.setProductNameMore(newProductDescriptionAdditional.getText());
        product.setField1(newField1.getText());
        product.setField2(newField2.getText());

    }

    private void saveProduct() {

        if (checkFieldsIfFilled()) {
            product = new Product();
            setProductFields();
            ProductDAO productDAO = new ProductDAO();
            try {
                productDAO.saveNewProduct(product);
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
}
