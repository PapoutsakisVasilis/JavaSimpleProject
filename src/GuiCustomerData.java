import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GuiCustomerData extends JInternalFrame {
	static int counter = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableCustProd;

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public GuiCustomerData(Customer customer) throws PropertyVetoException {
		//if (counter >=3) {
	//		JOptionPane.showMessageDialog(null, "Sorry you can have only three Customer Data windows open.");
	//	} else {

	//		counter++;
	
	
			InternalFrameSizeSet customerData = new InternalFrameSizeSet();
			
			IconItems itemIcon = new IconItems("Cu D: "+customer.getlName());
			JMenuItem item = itemIcon.getItem();
			Color itemsColor = item.getBackground();
			GuiMain.toolBar.add(item);
			customerData.restoreSubcomponentFocus();
			customerData.moveToFront();
			item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (itemIcon.getTileChecker()==null||itemIcon.getTileChecker()=="noticon") {
						try {
							customerData.setIcon(true);
							itemIcon.setTileChecker("icon");
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else{
						try {
							
							customerData.setIcon(false);
							itemIcon.setTileChecker("noticon");
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					
					
				}
			});;
			customerData.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameIconified(InternalFrameEvent arg0) {
					itemIcon.setTileChecker("icon");
					customerData.setVisible(false);
					item.setBackground(itemsColor);
				}
				@Override
				public void internalFrameDeiconified(InternalFrameEvent arg0) {
					
					customerData.setVisible(true);
					item.setBackground(Color.white);
				}
				@Override
				public void internalFrameClosed(InternalFrameEvent arg0) {
					GuiMain.toolBar.remove(item);
					GuiMain.toolBar.repaint();
					itemIcon.resetIconItems();
					counter--;
					
				}
			});
			
			customerData.getContentPane().setBackground(Color.LIGHT_GRAY);
			customerData.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
			
			customerData.setTitle("Customer Data");
			customerData.setIcon(true);
			customerData.setResizable(true);
			customerData.setMaximizable(true);
			customerData.setIconifiable(true);
			customerData.setBounds(50, 50, 689, 445);
			GuiMain.desktopPane.add(customerData);
			customerData.setVisible(true);
			customerData.setSelected(true);
			MotionEventListen listen =GuiMain.getListen();
			customerData.addMouseMotionListener(listen);
			customerData.getContentPane().setLayout(null);
			
			JLabel lblCusId = new JLabel(Integer.toString(customer.getId()));
			lblCusId.setBounds(108, 0, 46, 14);
			customerData.getContentPane().add(lblCusId);
			
			JLabel lblLName = new JLabel("Last Name");
			lblLName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblLName.setBounds(32, 19, 50, 14);
			customerData.getContentPane().add(lblLName);
			
			JLabel lblCustLName = new JLabel(customer.getName());
			lblCustLName.setBounds(108, 19, 148, 14);
			customerData.getContentPane().add(lblCustLName);
			
			JLabel lblName = new JLabel("Name");
			lblName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblName.setBounds(55, 38, 27, 14);
			customerData.getContentPane().add(lblName);
			
			JLabel lblCustName = new JLabel(customer.getlName());
			lblCustName.setBounds(108, 38, 148, 14);
			customerData.getContentPane().add(lblCustName);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblAddress.setBounds(43, 57, 39, 14);
			customerData.getContentPane().add(lblAddress);
			
			JLabel lblCustAddr = new JLabel(customer.getAddress()+" "+customer.getAdNumber());
			lblCustAddr.setBounds(108, 57, 148, 14);
			customerData.getContentPane().add(lblCustAddr);
			
			JLabel lblTaxesNum = new JLabel("A\u03A6\u039C");
			lblTaxesNum.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblTaxesNum.setBounds(53, 76, 29, 14);
			customerData.getContentPane().add(lblTaxesNum);
			
			JLabel lblCustAfm = new JLabel(Integer.toString(customer.getAfm()));
			lblCustAfm.setBounds(108, 76, 148, 14);
			customerData.getContentPane().add(lblCustAfm);
			
			JLabel lblId = new JLabel("Customer Id");
			lblId.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblId.setBounds(23, 0, 59, 14);
			customerData.getContentPane().add(lblId);
			
			JLabel lblDoy = new JLabel("\u0394\u039F\u03A5");
			lblDoy.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblDoy.setBounds(55, 96, 27, 14);
			customerData.getContentPane().add(lblDoy);
			
			JLabel lblCustDoy = new JLabel(customer.getDoy());
			lblCustDoy.setBounds(108, 96, 148, 14);
			customerData.getContentPane().add(lblCustDoy);
			
			JLabel lblState = new JLabel("State");
			lblState.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblState.setBounds(56, 116, 26, 14);
			customerData.getContentPane().add(lblState);
			
			JLabel lblCustState = new JLabel(customer.getState());
			lblCustState.setBounds(108, 116, 148, 14);
			customerData.getContentPane().add(lblCustState);
			
			JLabel lblEmail = new JLabel(" E - Mail");
			lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblEmail.setBounds(36, 136, 46, 14);
			customerData.getContentPane().add(lblEmail);
			
			JLabel lblCustEmail = new JLabel(customer.geteMail());
			lblCustEmail.setBounds(108, 136, 148, 14);
			customerData.getContentPane().add(lblCustEmail);
			
			JLabel lblProductsSearch = new JLabel("Customer Products");
			lblProductsSearch.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblProductsSearch.setBounds(183, 165, 123, 14);
			customerData.getContentPane().add(lblProductsSearch);
			
			
			
			JButton btnCustProdShow = new JButton("Products");
			btnCustProdShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					DatabaseActions dbAction = new DatabaseActions();
					ArrayList<Products> allCustProd = new ArrayList<>();
					
					try {
						allCustProd = dbAction.selectCustProducts("cust_id", customer.getId(), customer);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String collumn[] = {"Prod ID", "Cust ID", "Prod Cate", "Prod Av Amount", "Prod Cur Amount", "Upd Date"};
					DefaultTableModel tableModel = new DefaultTableModel(collumn, 0);
					
					
					tableCustProd = new JTable(tableModel);
					JScrollPane scrollPane = new JScrollPane(tableCustProd);
					tableCustProd.setFillsViewportHeight(true);
				
					tableCustProd.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					
					for (Products product : allCustProd) {
						Object row[] = {
								Integer.toString(product.getProdId()),
								Integer.toString(product.getCustId()),
								Integer.toString(product.getProdCateg()),
								Double.toString(product.getProdAvAmount()),
								Double.toString(product.getProdCurAmount()),
								product.getProdLastUpdate() };
						tableModel.addRow(row);
						
						
					}
					
					tableCustProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setBounds(10, 232, 463, 165);
					scrollPane.getHorizontalScrollBar();
					customerData.getContentPane().add(scrollPane);
					
					
				}
			});
			btnCustProdShow.setBounds(316, 161, 104, 23);
			customerData.getContentPane().add(btnCustProdShow);
			
			JLabel lblCustTransactions = new JLabel("Customer Transactions");
			lblCustTransactions.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			lblCustTransactions.setBounds(183, 194, 123, 14);
			customerData.getContentPane().add(lblCustTransactions);
			
			JButton btnCustTransaShow = new JButton("Transactions");
			btnCustTransaShow.setBounds(316, 190, 104, 23);
			customerData.getContentPane().add(btnCustTransaShow);
			
			
			
			
	
		}
	}
//}
