package ui;

import dao.UserDAO;
import entyties.User;
import org.hibernate.HibernateException;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class LoginDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField loginTextField;
	private JTextField passwordtextField;
	private JPasswordField passwordField;
	private JLabel loginInfo;
	private boolean loggedIn = false;
	private List<User> users = null;


	private void mySetText(String  myText, User user) {

		loginInfo.setText(myText + user.getName());
		loginInfo.paintImmediately(loginInfo.getVisibleRect());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



	}

	private User checkLogin(String login, String password, List<User> users ) {
		User user = null;
		int i = 0;
		while (i < users.size())
		{
			System.out.println(users.get(i).getLogin());
			System.out.println(users.get(i).getPassword());

			if ((login.equals(users.get(i).getLogin())) && (password.equals(users.get(i).getPassword())))
			{
				user = new User();
				user.setId(users.get(i).getId());
				user.setName(users.get(i).getName());
				user.setSurname(users.get(i).getSurname());
				user.setLogin(users.get(i).getLogin());
				user.setPassword(users.get(i).getPassword());
				user.setShortName(users.get(i).getShortName());
				i=users.size();
			}
			i++;

		}
		return user;
	}


	/**
	 * Create the dialog.
	 */
	public LoginDlg() {
		setUndecorated(true);

		setBounds(100, 100, 477, 376);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// calculate the new location of the window
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		setLocation(x,y);

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
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblLogin.setBounds(6, 70, 115, 44);
		panel_1.add(lblLogin);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		loginTextField.setHorizontalAlignment(SwingConstants.LEFT);
		loginTextField.setForeground(new Color(240, 248, 255));
		loginTextField.setBackground(new Color(112, 128, 144));
		loginTextField.setBounds(140, 81, 229, 29);
		loginTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
		panel_1.add(loginTextField);
		loginTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 105, 229, 12);
		panel_1.add(separator);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPassword.setBounds(6, 150, 115, 44);
		panel_1.add(lblPassword);
		
		passwordtextField = new JPasswordField();

		passwordtextField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordtextField.setForeground(new Color(240, 248, 255));
		passwordtextField.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		passwordtextField.setColumns(10);
		passwordtextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
		passwordtextField.setBackground(new Color(112, 128, 144));
		passwordtextField.setBounds(140, 161, 229, 29);
		panel_1.add(passwordtextField);
		passwordtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) checkUserSetAktiv();
			}
		});


		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(140, 185, 229, 12);
		panel_1.add(separator_1);
		
		JLabel lblAnmelden = new JLabel("Anmelden");
		lblAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnmelden.setForeground(new Color(128,0,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnmelden.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				checkUserSetAktiv();
			}
		});
		lblAnmelden.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnmelden.setForeground(Color.WHITE);
		lblAnmelden.setFont(new Font("Avenir", Font.BOLD, 20));
		lblAnmelden.setBounds(219, 258, 115, 44);
		panel_1.add(lblAnmelden);
		
		JLabel lblAbbruch = new JLabel("Abbruch");
		lblAbbruch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAbbruch.setForeground(new Color(128,0,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAbbruch.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		lblAbbruch.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbbruch.setForeground(Color.WHITE);
		lblAbbruch.setFont(new Font("Avenir", Font.BOLD, 20));
		lblAbbruch.setBounds(346, 258, 115, 44);
		panel_1.add(lblAbbruch);
		
		loginInfo = new JLabel("");
		loginInfo.setHorizontalAlignment(SwingConstants.CENTER);
		loginInfo.setForeground(Color.WHITE);
		loginInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		loginInfo.setBounds(57, 18, 350, 44);
		panel_1.add(loginInfo);



		try {
			users = new UserDAO().getAllUsers();

		}
		catch (ExceptionInInitializerError e){
			InfoDlg ed = new InfoDlg(true, "Es ist ein interner Javafehler pasiert. Das Programm wird zugemacht.",getLocation());
			e.printStackTrace();
			ed.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ed.setModal(true);
			ed.setVisible(true);

		}
		catch (HibernateException e) {
			InfoDlg ed = new InfoDlg(true, "Es ist ein Fehler bei Verbindung zu Datenbank pasiert. Das Programm wird zugemacht.",getLocation());
			e.printStackTrace();
			ed.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ed.setModal(true);
			ed.setVisible(true);
		} catch (Exception e) {
			InfoDlg ed = new InfoDlg(true, "Es ist ein unbekanter Fehler pasiert. Das Programm wird zugemacht.",getLocation());
			e.printStackTrace();
			ed.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ed.setModal(true);
			ed.setVisible(true);
		}
		
		
	}

	private void checkUserSetAktiv() {
		User user = checkLogin(loginTextField.getText(), passwordtextField.getText(), users);
		if (user != null) {
			System.out.println(user.getRole());
			mySetText("Hallo ", user);
			entyties.AktivUser.userId = user.getId();
			entyties.AktivUser.userLogin = user.getLogin();
			entyties.AktivUser.userName = user.getName();
			entyties.AktivUser.userPassword = user.getPassword();
			entyties.AktivUser.userShortName = user.getShortName();
			entyties.AktivUser.userSurName = user.getSurname();
			loggedIn = true;
			dispose();
		}
		loginInfo.setText("Falsche Eingaben");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public boolean showLoginDlg() {
		setModal(true);
		setVisible(true);
		return loggedIn;
	}
}
