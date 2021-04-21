package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

public class InfoDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextPane textPane;


	/**
	 * Create the dialog.
	 */
	public InfoDlg(Boolean isWarning, String infoString) {
		setUndecorated(true);
		setBounds(100, 100, 477, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		


		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 477, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" X ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(425, 6, 35, 44);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBounds(0, 56, 477, 320);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("  !!!  ");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 71));
		lblLogin.setBounds(159, 6, 168, 91);
		panel_1.add(lblLogin);
		
		JLabel lblAnmelden = new JLabel(" OK ");
		lblAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnmelden.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnmelden.setForeground(new Color(128,0,0));
			}
		});
		lblAnmelden.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnmelden.setForeground(new Color(255, 255, 255));
		lblAnmelden.setFont(new Font("Avenir", Font.BOLD, 20));
		lblAnmelden.setBounds(189, 259, 115, 44);
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

		if (isWarning) {
			textPane.setForeground(Color.red);
		}else {
			textPane.setForeground(Color.green);
		}
		
		
	}
}
