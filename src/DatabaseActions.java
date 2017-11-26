import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.omg.CORBA.portable.ValueInputStream;

import com.mysql.fabric.xmlrpc.base.Value;
import com.mysql.jdbc.ResultSetMetaData;

public class DatabaseActions {
	
	public String isConnected() throws SQLException{
		Connection connection = DBUtils.getConnection();
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		return stmt.toString();
	}
	
	public ArrayList<String> selectUsers() throws SQLException {
		ArrayList<String> names = new ArrayList<>();
		Connection connection = DBUtils.getConnection();
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet result = stmt.executeQuery("SELECT * FROM users");

		while (result.next()) {
			names.add(result.getString("lname"));
		}
		connection.close();
		return names;
	}
	
	
	
	public User selectUser(String usern, String pass) throws SQLException{
		Connection connection = DBUtils.getConnection();
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		User user = new User();
		ResultSet result = stmt.executeQuery("SELECT * FROM users WHERE username = '"+usern+"' AND password = '"+pass+"'");
		
		result.first();
		user.setId(result.getInt("id"));
		user.setBankUserid(result.getInt("bankuserid"));
		user.setsName(result.getString("name"));
		user.setlName(result.getString("lname"));
		user.setStAtus(result.getInt("status"));
		user.setUsername(result.getString("username"));
		
		connection.close();
		return user;
	}
	
	public void insertUser(String fname, String lname) throws SQLException{
		Connection connection = DBUtils.getConnection();
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		stmt.execute("INSERT INTO users (fname, lname) VALUE ('"+fname+"', '"+lname+"')");
		
		connection.close();
	}
	

}
