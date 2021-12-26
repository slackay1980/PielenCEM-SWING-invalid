package ui;



import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import dao.RelationDAO;
import entyties.Relation;

import org.hibernate.HibernateException;

import java.util.List;



public class RelationPullDownDlg  extends JDialog{


    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private String searchString = null;
    private Point point;
    private JTable table;
    private List<Relation> relationLikeString = null;
    private int relationIndex;
    private DefaultTableModel tableModel;



    /**
     * Create the dialog.
     */
    public RelationPullDownDlg(JTextField textField) {

        this.textField = textField;
        setUndecorated(true);

        getContentPane().setLayout(new BorderLayout(0, 0));

        Object[] columnNames = {
                "ID",
                "Relation",
        };

        tableModel = new DefaultTableModel(columnNames, 1);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(1000);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setListeners();




    }



    public void setListeners() {

        // Frame schlißt sich auf ESC
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==e.VK_ESCAPE) {
                    dispose();
                }
            }
        });



        // Falls man auf ESC in der Tabelle druckt schlißt sich der Frame zu.
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==e.VK_ESCAPE) {
                    dispose();
                }
                if (e.getKeyCode()==e.VK_ENTER) {
                    relationIndex = table.getSelectedRow();
                    dispose();
                }
            }
        });
    }

    // Dieser Method muss für jede andere TextField neu geschrieben sein
    public void retriveRelations() {
        RelationDAO relationDAO = new RelationDAO();
        try {
            relationLikeString= relationDAO.getRelationByString(textField.getText());
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // Dieser Method muss für jede andere TextField neu geschrieben sein
    public void renderTableModel() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Object[] newRow = {
                "",
                "",
        };
        for (int i = 0; i <= relationLikeString.size()-1; i++) {

            tableModel.addRow(newRow);
            tableModel.setValueAt(relationLikeString.get(i).getId() , i, 0);
            tableModel.setValueAt(relationLikeString.get(i).getRelationName() , i, 1);

        }
    }

    public Relation showDialog() {
        point = textField.getLocationOnScreen();
        setBounds((int)point.getX(),(int)point.y+textField.getHeight()+3,textField.getWidth(),257);
        retriveRelations();
        renderTableModel();
        setModal(true);
        setAlwaysOnTop(true);
        setVisible(true);
        if (relationLikeString!=null) {
            return (Relation) relationLikeString.get(relationIndex);
        }
        else {
            return null;
        }
    }
}
