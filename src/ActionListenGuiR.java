import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenGuiR {
		protected static int guiID;
		public static int taskAlive;
		protected static boolean relogBool;
		public boolean getrelogBool() {
			return relogBool;
		}





		public static void setTaskAlive(int taskAlive) {
			ActionListenGuiR.taskAlive = taskAlive;
		}





		public static void setrelogBool(boolean b) {
			relogBool = b;
			System.out.println(relogBool + " " + b);
		}

	    

	        
	    
		public int getGuiID() {
			return guiID;
		}





		public static void setGuiID(int guiId) {
			guiID = guiId;
			System.out.println(guiID + " " + guiId);
		}




}
