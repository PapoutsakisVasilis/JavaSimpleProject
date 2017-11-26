import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TransactionsKiller {
	private static ArrayList<Integer> tranProcIdProd = null;//Stores all active product transactions
	
	public void TranKill() throws SQLException{
		DatabaseActions dbAction = new DatabaseActions();
		
		if (this.tranProcIdProd.size()==0) {
			
		} else {
			for (Integer indexProdIdForKill : this.tranProcIdProd) {
				dbAction.selectCustProductAON("prod_id",indexProdIdForKill, "release");
				
			}
		}
		
		
	}
	
	public void TranRemoveFromList(int indexProdId){
		
		if (tranProcIdProd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No entry In basic Indexer");
		} else {
			try {
				int index = this.tranProcIdProd.indexOf(indexProdId);
				this.tranProcIdProd.remove(index);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No entry In basic Indexer for this product Tran...");
			}

		}
	}
	
	public void TranAddToList(int indexProdId){
		this.tranProcIdProd.add(indexProdId);
		System.out.println(this.tranProcIdProd);
		
		}

}
