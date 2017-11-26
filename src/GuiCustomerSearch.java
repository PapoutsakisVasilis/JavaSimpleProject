import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class GuiCustomerSearch extends JInternalFrame {
	static int counter = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIndexSearch;
	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public GuiCustomerSearch() throws PropertyVetoException {
		if (counter >=1) {
			JOptionPane.showMessageDialog(null, "Sorry you can have only one Customer search open.");
		} else {

		counter++;
		
		
		InternalFrameSizeSet inFrameSearchCus = new InternalFrameSizeSet();
		
		
		
		IconItems itemIcon = new IconItems("Customer Search");
		JMenuItem item = itemIcon.getItem();
		Color itemsColor = item.getBackground();
		GuiMain.toolBar.add(item);
		inFrameSearchCus.restoreSubcomponentFocus();
		inFrameSearchCus.moveToFront();
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (itemIcon.getTileChecker()==null||itemIcon.getTileChecker()=="noticon") {
					try {
						inFrameSearchCus.setIcon(true);
						itemIcon.setTileChecker("icon");
					
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					try {
						
						inFrameSearchCus.setIcon(false);
						itemIcon.setTileChecker("noticon");
						
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
		});;
		inFrameSearchCus.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameIconified(InternalFrameEvent arg0) {
				itemIcon.setTileChecker("icon");
				inFrameSearchCus.setVisible(false);
				item.setBackground(itemsColor);
			}
			@Override
			public void internalFrameDeiconified(InternalFrameEvent arg0) {
				
				inFrameSearchCus.setVisible(true);
				item.setBackground(Color.white);
				
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				counter--;
				GuiMain.toolBar.remove(item);
				GuiMain.toolBar.repaint();
				itemIcon.resetIconItems();
				
			}
		});
		
		
		
		inFrameSearchCus.getContentPane().setLayout(null);
		inFrameSearchCus.setTitle("Customer Search");
		inFrameSearchCus.setIcon(true);
		inFrameSearchCus.setResizable(true);
		inFrameSearchCus.setMaximizable(true);
		inFrameSearchCus.setIconifiable(true);
		inFrameSearchCus.setBounds(34, 34, 300, 200);
		GuiMain.desktopPane.add(inFrameSearchCus);
		MotionEventListen listen =GuiMain.getListen();
		inFrameSearchCus.addMouseMotionListener(listen);
		
		
		JComboBox<ComboItem> cmbIndSearch = new JComboBox<ComboItem>();
		cmbIndSearch.addItem(new ComboItem("Customer ID", "1"));
		cmbIndSearch.addItem(new ComboItem("Cus E-Mail", "2"));
		cmbIndSearch.addItem(new ComboItem("AFM", "3"));
		cmbIndSearch.setBounds(84, 11, 174, 27);
		inFrameSearchCus.getContentPane().add(cmbIndSearch);
		
		
		
		JLabel lblCreteria = new JLabel("Search By");
		lblCreteria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreteria.setBounds(9, 17, 73, 14);
		inFrameSearchCus.getContentPane().add(lblCreteria);
		
		txtIndexSearch = new JTextField();
		txtIndexSearch.setBounds(83, 62, 175, 27);
		inFrameSearchCus.getContentPane().add(txtIndexSearch);
		txtIndexSearch.setColumns(10);
		
		JLabel lblSearchIndex = new JLabel("Search Index");
		lblSearchIndex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchIndex.setBounds(9, 68, 73, 14);
		inFrameSearchCus.getContentPane().add(lblSearchIndex);
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = cmbIndSearch.getSelectedItem();
				String value = ((ComboItem)item).getValue();
				int idNum=0;
				int aFm=0;
				String collumn;
				String eMail=null;
				Customer customer = new Customer();
				
				
				DatabaseActions dbActions = new DatabaseActions();
				switch (value) {
				case "1": 
					try {
						idNum = Integer.parseInt(txtIndexSearch.getText());
						
						
					} catch (Exception noinput) {
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
						
					}
					
					collumn = "id";
					try {
						customer=dbActions.selectCustomer(collumn, String.valueOf(idNum));
						GuiCustomerData customerData = new  GuiCustomerData(customer);
						
					} catch (SQLException | PropertyVetoException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					}
					
				
				
					
					break;
					
				case "2": 
					try {
						eMail = txtIndexSearch.getText();
					} catch (Exception noinput) {
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					}
					
					collumn = "email";
					try {
						customer=dbActions.selectCustomer(collumn, eMail);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					}
				
					break;
					
				case "3": 
					try {
						aFm = Integer.parseInt(txtIndexSearch.getText());
					} catch (Exception noinput) {
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					}
					
					collumn = "afm";
					try {
						customer=dbActions.selectCustomer(collumn, String.valueOf(aFm));
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					}
				
					break;

				default:
					JOptionPane.showMessageDialog(null, "Sorry there is no such a Customer");
					break;
				}
			}
		});
		btnSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSearchCustomer.setBounds(143, 109, 115, 23);
		inFrameSearchCus.getContentPane().add(btnSearchCustomer);
		inFrameSearchCus.setVisible(true);
		
		
		
		
		
		
		
		
		}
		
		
		
	}
	
	

}
