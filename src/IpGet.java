
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.swing.JOptionPane;

 public class IpGet {
	public static String IPtest () { 
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()&&inetAddress instanceof Inet4Address) {
                    	String ipAddress=inetAddress.getHostAddress().toString();
                        return ipAddress;
                    }
                }
            }
        } catch (SocketException ex) {
        	JOptionPane.showMessageDialog(null, "Socket exception in GetIP Address of Utilities " + ex.toString());
        }
        return null; 
	}
	
	public static void checkHosts(){
			
		InetAddress localhost = null;
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    byte[] ip = localhost.getAddress();

	    for (int i = 1; i <= 254; i++)
	    {
	        try
	        {
	            ip[3] = (byte)i; 
	            InetAddress address = InetAddress.getByAddress(ip);

	            if (address.isReachable(100))
	            {
	               String output = address.toString().substring(1);
	                System.out.print(output + " is on the network");
	            }
	    }catch (Exception e) {
			// TODO: handle exception
		}

}}}


