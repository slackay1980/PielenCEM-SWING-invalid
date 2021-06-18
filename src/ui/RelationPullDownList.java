package ui;

        import java.awt.*;
        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.event.KeyAdapter;
        import java.awt.event.KeyEvent;

public class RelationPullDownList extends JDialog {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel jLabel;
    private Point point;
    private JList  table;
    private int Index=-1;
    private DefaultTableModel tableModel;



    /**
     * Create the dialog.
     */
    public RelationPullDownList(JLabel jLabel) {

        this.jLabel = jLabel;
        setUndecorated(true);

        getContentPane().setLayout(new BorderLayout(0, 0));


        final DefaultListModel model = new DefaultListModel();
        model.addElement("Relation neu anlegen");
        model.addElement("Relation ändern");
        model.addElement("Relation löschen");
        model.addElement("Option optional");

        table = new JList(model);
        table.setBorder(BorderFactory.createEmptyBorder());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        point = jLabel.getLocationOnScreen();
        scrollPane.setBounds((int)point.getX(),(int)point.y+jLabel.getHeight()+3,jLabel.getWidth(),60);
        getContentPane().add(scrollPane);

        table.setForeground(Color.WHITE);
        table.setBackground(new Color(119, 136, 153));
        // table.setShowGrid(false);

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
                    Index = table.getSelectedIndex();
                    dispose();
                }
            }
        });
    }

    public int showDialog() {
        point = jLabel.getLocationOnScreen();
        setBounds((int)point.getX()+20,(int)point.y+jLabel.getHeight()+3,jLabel.getWidth()-50,80);
        setModal(true);
        setAlwaysOnTop(true);
        setVisible(true);
        return Index;
    }
}
