package services;

import javax.swing.*;
import java.util.LinkedHashMap;

public class AddRelationService {
    private JTextField txtProducentStation;
    private JTextField txtCustomerStation;
    private JTextField txtDistance;
    private JTextField txtRelationField1;
    private JTextPane textRelationNotice;
    private  JLabel lblCloseDialog;
    private JLabel lblSaveRelation;
    private JLabel lblCancel;
    private JTextField txtRelationField2;
    private JTextField txtRelationField3;
    private JTextField textRelationField4;

    public AddRelationService(LinkedHashMap<String,Object> controlList) {
        this.txtProducentStation  = (JTextField)controlList.get("txtProducentStation");
        this.txtCustomerStation  = (JTextField)controlList.get("txtCustomerStation");
        this.txtDistance  = (JTextField)controlList.get("txtDistance");
        this.txtRelationField1  = (JTextField)controlList.get("txtRelationField1");
        this.textRelationNotice  = (JTextField)controlList.get("textRelationNotice");
        this.  = (JTextField)controlList.get("");


        this.  = (JLabel)controlList.get("");
        this.  = (JLabel)controlList.get("");
        this.  = (JLabel)controlList.get("");
        this.  = (JLabel)controlList.get("");

    }
}
