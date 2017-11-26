import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiReLog {

	private JFrame reLogFrame;
	

	private JTextField fldUsername;
	private JPasswordField fldPass;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiReLog window = new GuiReLog();
					window.reLogFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiReLog() {
		initialize();
		ActionListenGuiR.setrelogBool(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		reLogFrame = new JFrame();
		reLogFrame.setBackground(Color.DARK_GRAY);
		reLogFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		reLogFrame.setForeground(Color.LIGHT_GRAY);
		reLogFrame.setType(Type.UTILITY);
		reLogFrame.setTitle("Log In Bank System");
		reLogFrame.setBounds(100, 100, 450, 300);
		reLogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reLogFrame.getContentPane().setLayout(null);
		
		fldUsername = new JTextField();
		fldUsername.setBounds(96, 29, 149, 20);
		reLogFrame.getContentPane().add(fldUsername);
		fldUsername.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(8, 33, 86, 14);
		reLogFrame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(8, 63, 56, 14);
		reLogFrame.getContentPane().add(lblPassword);
		
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
						int guiId = ActionListenGuiR.guiID;
						ActionListenGuiR.setrelogBool(false);
						reLogFrame.setVisible(false);
						switch (guiId) {
						case 1:
							ActionListenGuiR.taskAlive = 0;
							GuiMain.setVisible(true);
							break;

						default:
							break;
						}
						
						
						
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Sorry no such a USER or you are using wrong credentials");
						fldUsername.setText(null);
						fldPass.setText("");

					}
					
					
				}else{JOptionPane.showMessageDialog(null, "Please Fill All Fields");}
				
				
				
				
			}
		});
		btnLogIn.setBounds(96, 88, 149, 23);
		reLogFrame.getContentPane().add(btnLogIn);
		
		fldPass = new JPasswordField();
		fldPass.setBounds(96, 60, 149, 20);
		reLogFrame.getContentPane().add(fldPass);
		
	}

	

	
	
	

	

	
}
