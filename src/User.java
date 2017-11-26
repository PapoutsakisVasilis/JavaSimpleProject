
import java.sql.SQLException;
import java.util.ArrayList;



public class User {
	DatabaseActions db = new DatabaseActions();
	
	
	private int id;
	private int bankUserid;
	private String sName;
	private String lName;
	private int stAtus;
	private String username;
	private String password;
	
	
	
	public int getBankUserid() {
		return bankUserid;
	}



	public void setBankUserid(int bankUserid) {
		this.bankUserid = bankUserid;
	}



	public User(){
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getsName() {
		return sName;
	}



	public void setsName(String sName) {
		this.sName = sName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public int getStAtus() {
		return stAtus;
	}



	public void setStAtus(int stAtus) {
		this.stAtus = stAtus;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	private static User travelUser;
	public static void userSetter(User user){
		setTravelUser(user);
		
		
	}



	public static User getTravelUser() {
		return travelUser;
	}



	public static void setTravelUser(User travelUser) {
		User.travelUser = travelUser;
	}

	


}
	
	
	
		