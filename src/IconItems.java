import javax.swing.JMenuItem;

public class IconItems extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JMenuItem item = null;
	static String tileChecker = null;
	
	IconItems(String title){
		
		item = new JMenuItem(title);
		
		
	}
	
	public static String getTileChecker() {
		return tileChecker;
	}


	public static void setTileChecker(String tileChecker) {
		IconItems.tileChecker = tileChecker;
	}
	
	public static JMenuItem getItem() {
		return item;
	}
	
	public static void resetIconItems() {
		IconItems.tileChecker = null;
		IconItems.item = null;
	}

}
