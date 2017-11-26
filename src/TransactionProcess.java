import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class TransactionProcess extends JInternalFrame {
	
	
	static int counter = 0;
	static MotionEventListen listen=GuiMain.getListen();
	public int indProdId=0;
	
	
	

	
	
			public int getIndProdId() {
		return indProdId;
	}

			InternalFrameSizeSet tranProc = new InternalFrameSizeSet();

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public TransactionProcess(User user, Customer customer, Products product) throws PropertyVetoException{
		indProdId = product.getProdId();
		
		getContentPane().setLayout(null);
		
		//if (counter >=3) {
		//		JOptionPane.showMessageDialog(null, "Sorry you can have only three Customer Data windows open.");
		//	} else {

		//		counter++;
		
		
		int idOfCustomer = customer.getId();
		// icon set
		IconItems itemIcon = new IconItems("Tran Proc: "+customer.getlName());
		JMenuItem item = itemIcon.getItem();
		Color itemsColor = item.getBackground();
		GuiMain.toolBar.add(item);
		tranProc.restoreSubcomponentFocus();
		tranProc.moveToFront();
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (itemIcon.getTileChecker()==null||itemIcon.getTileChecker()=="noticon") {
					try {
						tranProc.setIcon(true);
						itemIcon.setTileChecker("icon");
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					try {
						
						tranProc.setIcon(false);
						itemIcon.setTileChecker("noticon");
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
		});;
		tranProc.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameIconified(InternalFrameEvent arg0) {
				itemIcon.setTileChecker("icon");
				tranProc.setVisible(false);
				item.setBackground(itemsColor);
			}
			@Override
			public void internalFrameDeiconified(InternalFrameEvent arg0) {
				
				tranProc.setVisible(true);
				item.setBackground(Color.white);
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				GuiMain.toolBar.remove(item);
				GuiMain.toolBar.repaint();
				itemIcon.resetIconItems();
				counter--;
				DatabaseActions dbAction = new DatabaseActions();
				try {
					dbAction.selectCustProductAON("prod_id", product.getProdId(), "release");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		// icon set end
		tranProc.getContentPane().setBackground(Color.LIGHT_GRAY);
		tranProc.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		tranProc.setTitle("Customer Datas");
		tranProc.setIcon(true);
		tranProc.setResizable(true);
		tranProc.setMaximizable(true);
		tranProc.setIconifiable(true);
		tranProc.setBounds(50, 50, 689, 445);
		
		tranProc.setVisible(true);
		tranProc.setSelected(true);
		GuiMain.desktopPane.add(tranProc);
		// listen mouse
		//MotionEventListen listen =GuiMain.getListen();
		tranProc.addMouseMotionListener(listen);
		// listen mouse end 
		tranProc.getContentPane().setLayout(null);
		
		

	}

}
