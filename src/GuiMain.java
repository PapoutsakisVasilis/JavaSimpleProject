import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GuiMain {

	private static JFrame mainGuiBankSys;
	private User user = new User();
	private static int theMove=0;
	
	/*
	TaskOfLock task = new TaskOfLock();
	Timer timer = new Timer();
	TheTask thetask = new TheTask();
	*/
	 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain window = new GuiMain();
					window.mainGuiBankSys.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain() {
		initialize();
		user = User.getTravelUser();
		ActionListenGuiR.setGuiID(1);
		//task.setTask(timer, thetask, 10);
		//task.tasker();
		
		JOptionPane.showMessageDialog(null, "Welcome "+ user.getUsername());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainGuiBankSys = new JFrame();
		mainGuiBankSys.setBounds(100, 100, 859, 596);
		mainGuiBankSys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGuiBankSys.getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setMaximizable(true);
		internalFrame.setResizable(true);
		internalFrame.setBounds(0, 0, 843, 192);
		mainGuiBankSys.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		MotionEventListen listen = new MotionEventListen();
		mainGuiBankSys.addMouseMotionListener(listen);;
	}
	
	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		if (b == false) {
			mainGuiBankSys.setVisible(false);
		}if (b==true) {
			mainGuiBankSys.setVisible(true);
		} 
		
	}
	/*
	public class CheckerForRelog implements KeyListener{
		
		
		

		@Override
		public void keyPressed(KeyEvent e) {
			timer.cancel();
			TaskOfLock task = new TaskOfLock();
			Timer timer = new Timer();
			TheTask thetask = new TheTask();
			
			ActionListenGuiR.setGuiID(1);
			task.setTask(timer, thetask, 10);
			task.tasker();
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			timer.cancel();
			TaskOfLock task = new TaskOfLock();
			Timer timer = new Timer();
			TheTask thetask = new TheTask();
			
			ActionListenGuiR.setGuiID(1);
			task.setTask(timer, thetask, 10);
			task.tasker();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			timer.cancel();
			TaskOfLock task = new TaskOfLock();
			Timer timer = new Timer();
			TheTask thetask = new TheTask();
			
			ActionListenGuiR.setGuiID(1);
			task.setTask(timer, thetask, 10);
			task.tasker();
		}
		
	}*/
	
	public void timeSeter(int moving){
		if (moving==1&&ActionListenGuiR.taskAlive==1) {
			TheTask.theTimer.getTimer().cancel();
			TheTask.theTask.cancel();
			ActionListenGuiR.setTaskAlive(0);
			Timer timer = new Timer();
			timer = TheTask.theTimer.getNewTimer();
			TimerTask theTask = TheTask.getNewTheTask();
			
			ActionListenGuiR.setTaskAlive(1);
			timer.schedule(theTask, 10*1000);
			
			
		}else if (ActionListenGuiR.taskAlive==0) {
			Timer timer = new Timer();
			timer = TheTask.theTimer.getNewTimer();
			TimerTask theTask = TheTask.getNewTheTask();
			
			ActionListenGuiR.setGuiID(1);
			ActionListenGuiR.setTaskAlive(1);
			timer.schedule(theTask, 10*1000);
			
		} 
		
	}
	
	class MotionEventListen extends JFrame implements MouseMotionListener {
		
	
		int moving=GuiMain.theMove;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void mouseDragged(MouseEvent eD) {
			if (ActionListenGuiR.relogBool==true) {
				
			} else {
				moving =1;
				timeSeter(moving);
				

				}
			}
			
		

		@Override
		public void mouseMoved(MouseEvent eM) {
			if (ActionListenGuiR.relogBool==true) {
				
						} else {
							moving =1;
							timeSeter(moving);
							
			
							}
						}
			
		}
	}

