
//import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import javax.swing.JOptionPane;
//import javax.xml.bind.DatatypeConverter;

//import org.apache.commons.codec.digest.DigestUtils;




public class Encrypt { 
	public String mdPass(String passfld) 
			  throws NoSuchAlgorithmException {
				
				String password = passfld;
			    
				MessageDigest digester = MessageDigest.getInstance("MD5");
				digester.update(password.getBytes());
		        byte[] hashSy = digester.digest();
		        StringBuffer hexString = new StringBuffer();
		        for (int i = 0; i < hashSy.length; i++) {
		            if ((0xff & hashSy[i]) < 0x10) {
		                hexString.append("0" + Integer.toHexString((0xFF & hashSy[i])));
		            }
		            else {
		                hexString.append(Integer.toHexString(0xFF & hashSy[i]));
		            }
		        }
		        
		        return hexString.toString();
	}
				
			
} 