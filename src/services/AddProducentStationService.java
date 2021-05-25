package services;


import dao.ProducentStationsDAO;
import entyties.*;
import ui.AcceptDlg;
import ui.InfoDlg;
import ui.PullDownProducentList;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.List;

public class AddProducentStationService {

    private Producent producent;
    private ProducentStation newProducentStation;

    private boolean saved;

    private JLabel lblCloseDialog;
    private JTextField searchProducent;
    private JLabel lblSearch;
    private JTextField newStationName;
    private JTextField newStationStreet;
    private JTextField newStationLandPostcode;
    private JTextField newStationCity;
    private JTextField newStationEmail;
    private JTextField newStationTel1;
    private JTextPane textPaneStationNotiz;
    private JList listProducentStations;
    private JLabel lblAddStation;
    private JLabel lblCancel;
    private JDialog dialog;
    private JPanel contentPanel;

    //helper Variables

    private int userIndex;
    private List<User> sellers = null;
    private boolean listButton = true;
    private boolean savedOperationArea = false;
    boolean isSelectedOperationArea = false;
    private String selectedOperationArea;

    public AddProducentStationService(LinkedHashMap listControlls) {


        this.lblCloseDialog = (JLabel) listControlls.get("lblCloseDialog");
        this.searchProducent = (JTextField) listControlls.get("searchProducent");
        this.lblSearch = (JLabel) listControlls.get("lblSearch");
        this.newStationName = (JTextField) listControlls.get("newStationName");
        this.newStationStreet = (JTextField) listControlls.get("newStationStreet");
        this.newStationLandPostcode = (JTextField) listControlls.get("newStationLandPostcode");
        this.newStationCity = (JTextField) listControlls.get("newStationCity");
        this.newStationEmail = (JTextField) listControlls.get("newStationEmail");
        this.newStationTel1 = (JTextField) listControlls.get("newStationTel1");
        this.textPaneStationNotiz = (JTextPane) listControlls.get("textPaneStationNotiz");
        this.listProducentStations = (JList) listControlls.get("listProducentStations");
        this.lblAddStation = (JLabel) listControlls.get("lblAddStation");
        this.lblCancel = (JLabel) listControlls.get("lblCancel");
        this.dialog = (JDialog) listControlls.get("dialog");
        this.contentPanel = (JPanel) listControlls.get("contentPanel");

        setListener();


    }

    private void setListener() {
        lblAddStation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveProducentStation();
                if (saved) {
                    dialog.setVisible(false);
                    dialog.dispose();
                    InfoDlg infoDlg = new InfoDlg(false, "Der Producent " + producent.getProducentName() +
                            ", " + producent.getProducentCity() + " hat eine neue Station bekommen.  "+
                            newProducentStation.getStationName()+", "+newProducentStation.getStationCity(),dialog.getLocation());
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

        searchProducent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10) {
                    PullDownProducentList pullDown = new PullDownProducentList(searchProducent);
                    producent = pullDown.showDialog();
                    /* zu löschen */
                    if (producent!=null) {
                        fillListWithProducentStations();
                    }
                }
            }

        });
        lblSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PullDownProducentList pullDown = new PullDownProducentList(searchProducent);
                producent = pullDown.showDialog();

            }

        });

    }

    private boolean checkFieldsIfFilled() {
        boolean checked = true;
        if (newStationName.getText().equals("")) checked = false;
        if (newStationStreet.getText().equals("")) checked = false;
        if (newStationLandPostcode.getText().equals("")) checked = false;
        if (newStationCity.getText().equals("")) checked = false;
        if (producent==null) checked = false;
        return checked;
    }

    private void setProducentStationsFields() {
        newProducentStation.setStationName(newStationName.getText());
        newProducentStation.setStationStreet(newStationStreet.getText());
        newProducentStation.setStationLandPostCode(newStationLandPostcode.getText());
        newProducentStation.setStationCity(newStationCity.getText());
        newProducentStation.setStationEmploee(newStationEmail.getText());
        newProducentStation.setStationTelefone1(newStationTel1.getText());
        newProducentStation.setStationNote(textPaneStationNotiz.getText());
        newProducentStation.setProducent(producent);

    }

    private void saveProducentStation() {

        if (checkFieldsIfFilled()) {
            newProducentStation = new ProducentStation();
            setProducentStationsFields();
            ProducentStationsDAO producentStationDAO = new ProducentStationsDAO();
            try {
                producentStationDAO.saveNewStation(newProducentStation);
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

    private void fillListWithProducentStations() {
        searchProducent.setText(
                producent.getProducentName()+", "
                        +producent.getProducentLandPostCode()+" "
                        + producent.getProducentCity());
        DefaultListModel defaultListModel = (DefaultListModel) listProducentStations.getModel();
        defaultListModel.clear();
        List<ProducentStation> producentStations = (List) producent.getProducentStations();
        for (ProducentStation station :  producentStations) {
            defaultListModel.addElement(station.getStationName() + ", " + station.getStationLandPostCode() + " " +
                    station.getStationCity());
        }
    }
}
