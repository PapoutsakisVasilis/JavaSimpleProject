
public class Transaction {
	
	private int id_tran;
	private int id_cust;
	private int id_cust_recieve;
	private int trans_type;	
	private Double trans_ammount;
	private int from_prod_id;	
	private int to_prod_id;
	private String dateof_trans;
	
	
	
	public int getId_tran() {
		return id_tran;
	}
	
	public int getId_cust_recieve() {
		return id_cust_recieve;
	}
	public void setId_cust_recieve(int id_cust_recieve) {
		this.id_cust_recieve = id_cust_recieve;
	}
	public void setId_tran(int id_tran) {
		this.id_tran = id_tran;
	}
	public int getId_cust() {
		return id_cust;
	}
	public void setId_cust(int id_cust) {
		this.id_cust = id_cust;
	}
	public int getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(int trans_type) {
		this.trans_type = trans_type;
	}
	public Double getTrans_ammount() {
		return trans_ammount;
	}
	public void setTrans_ammount(Double trans_ammount) {
		this.trans_ammount = trans_ammount;
	}
	public int getFrom_prod_id() {
		return from_prod_id;
	}
	public void setFrom_prod_id(int from_prod_id) {
		this.from_prod_id = from_prod_id;
	}
	public int getTo_prod_id() {
		return to_prod_id;
	}
	public void setTo_prod_id(int to_prod_id) {
		this.to_prod_id = to_prod_id;
	}
	public String getDateof_trans() {
		return dateof_trans;
	}
	public void setDateof_trans(String dateof_trans) {
		this.dateof_trans = dateof_trans;
	}
	
	

}
