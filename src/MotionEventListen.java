import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MotionEventListen extends JFrame implements MouseMotionListener {
		int moving=0;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void mouseDragged(MouseEvent eD) {
			if (ActionListenGuiR.relogBool==true) {
				
			} else {
				moving =1;
				GuiMain.timeSeter(moving);
				}
			}
			
		@Override
		public void mouseMoved(MouseEvent eM) {
			if (ActionListenGuiR.relogBool==true) {
				
						} else {
							moving =1;
							GuiMain.timeSeter(moving);
							}
						}
		//END TIMER LOCK
		
		}
