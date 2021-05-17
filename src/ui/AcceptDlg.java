package ui;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

public class AcceptDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextPane textPane;
	private boolean accepted;


	/**
	 * Create the dialog.
	 */
	public AcceptDlg(String infoString, Point point) {
		setUndecorated(true);
		int x = point.x;
		int y = point.y;
		System.out.println(x+" "+y);
		setBounds(x+40, y+60, 477, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		


		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 477, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBounds(0, 56, 477, 320);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAnmelden = new JLabel("JA");
		lblAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnmelden.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnmelden.setForeground(new Color(128,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				accepted = true;
				setVisible(false);
				dispose();
				
			}
		});
		lblAnmelden.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnmelden.setForeground(new Color(255, 255, 255));
		lblAnmelden.setFont(new Font("Avenir", Font.BOLD, 20));
		lblAnmelden.setBounds(121, 256, 115, 44);
		panel_1.add(lblAnmelden);
		
		textPane = new JTextPane();
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		textPane.setText(infoString);
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setBackground(new Color(112, 128, 144));
		textPane.setBounds(55, 85, 376, 177);
		panel_1.add(textPane);
		
		JLabel lblNein = new JLabel("NEIN");
		lblNein.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accepted = false;
				setVisible(false);
				dispose();
				
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNein.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNein.setForeground(new Color(128,0,0));
			}
		});
		lblNein.setHorizontalAlignment(SwingConstants.CENTER);
		lblNein.setForeground(Color.WHITE);
		lblNein.setFont(new Font("Avenir", Font.BOLD, 20));
		lblNein.setBounds(248, 256, 115, 44);
		panel_1.add(lblNein);
		
	}
	
	public boolean showDlg( ) {
		setModal(true);
		setVisible(true);
		return accepted;
	}
}
