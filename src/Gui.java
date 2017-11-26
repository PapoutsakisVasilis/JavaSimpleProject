import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Window.Type;

import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

public class Gui {
	
	
	
	private static JFrame frmLogInBank;
	private JTextField fldUsername;
	private JPasswordField fldPass;
	private User user = new User();
	//public static ActionListenGuiR actionListenGuiR = new ActionListenGuiR();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmLogInBank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		ActionListenGuiR.setrelogBool(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmLogInBank = new JFrame();
		frmLogInBank.setBackground(Color.DARK_GRAY);
		frmLogInBank.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLogInBank.setForeground(Color.LIGHT_GRAY);
		frmLogInBank.setType(Type.UTILITY);
		frmLogInBank.setTitle("Log In Bank System");
		frmLogInBank.setBounds(100, 100, 450, 300);
		frmLogInBank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogInBank.getContentPane().setLayout(null);
		
		fldUsername = new JTextField();
		fldUsername.setBounds(96, 29, 149, 20);
		frmLogInBank.getContentPane().add(fldUsername);
		fldUsername.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(8, 33, 86, 14);
		frmLogInBank.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(8, 63, 56, 14);
		frmLogInBank.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passCheck = "";
				
				String usern = fldUsername.getText();
				String givenPass="";
				char[] pass = fldPass.getPassword();
				givenPass = String.copyValueOf(pass);
					
					
			
				
				if (!usern.isEmpty()&&!givenPass.isEmpty()) {
					User user = new User();
					DatabaseActions action = new DatabaseActions();
					Encrypt encrypter = new Encrypt();
					try {
						passCheck = encrypter.mdPass(givenPass);
						//txtfldd.setText(passCheck);
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						user = action.selectUser(usern, passCheck);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						
					}
					if (user.getUsername()!= null) {
						User.setTravelUser(user);
						frmLogInBank.setVisible(false);
						
						GuiMain.main(null);
						
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Sorry no such a USER or you are using wrong credentials");
						fldUsername.setText(null);
						fldPass.setText("");

					}
					
					
				}else{JOptionPane.showMessageDialog(null, "Please Fill All Fields");}
				
				
				
				
			}
		});
		btnLogIn.setBounds(96, 88, 149, 23);
		frmLogInBank.getContentPane().add(btnLogIn);
		
		fldPass = new JPasswordField();
		fldPass.setBounds(96, 60, 149, 20);
		frmLogInBank.getContentPane().add(fldPass);
		
	}
	



	
	

	
}
