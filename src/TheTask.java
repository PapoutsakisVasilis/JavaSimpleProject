import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;


public class TheTask extends TimerTask{
	
	static TimerTask theTask = new TheTask() {
		
		
		@Override
		public void run() {

			int guiId = ActionListenGuiR.guiID;
			String result;
			boolean b = ActionListenGuiR.relogBool;
			if (b==true) {
				result ="true";
				
			}else{result ="false";}
			
			switch (guiId) {
			case 1:
				GuiMain.setVisible(false);
				
				break;

			default:
				break;
			}
			
			switch (result) {
			case "false":
				GuiReLog.main(null);
				ActionListenGuiR.setTaskAlive(1);
				break;

			default:
				break;
			}
			
			
		}
	};
	public static TimerTask getTheTask() {
		return theTask;
	}
	public static TimerTask getNewTheTask() {
		TheTask.theTask = new TheTask() {
			
			
			@Override
			public void run() {

				int guiId = ActionListenGuiR.guiID;
				String result;
				boolean b = ActionListenGuiR.relogBool;
				if (b==true) {
					result ="true";
					
				}else{result ="false";}
				
				switch (guiId) {
				case 1:
					GuiMain.setVisible(false);
					
					break;

				default:
					break;
				}
				
				switch (result) {
				case "false":
					GuiReLog.main(null);
					ActionListenGuiR.setTaskAlive(1);
					break;

				default:
					break;
				}
				
				
			}
		};
		return TheTask.theTask;
	}
	public static void setTheTask(TimerTask theTask) {
		TheTask.theTask = theTask;
	}
	static class theTimer extends Timer{
		static Timer timerNew = new Timer();
		static Timer timer = timerNew;

		public static Timer getTimer() {
			return timer;
		}
		public static Timer getNewTimer() {
			Timer timerNew = new Timer();
			theTimer.timer = timerNew;
			return theTimer.timer;
		}

		public static void setTimer(Timer timer) {
			theTimer.timer = timer;
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	};




	
		
		
		
	
	
	}
