import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class TaskOfLock {
	
	
	 
	 public static void setTask( Timer timer, TimerTask task, int seconds) {
		 
		   if (ActionListenGuiR.relogBool == true||ActionListenGuiR.taskAlive==1) {
			   
			
			}else{
				ActionListenGuiR.setTaskAlive(1);
			   timer.schedule(task, seconds);
			    
			}
	}

	
		  
		

	  }
	    
 
	  
	 



