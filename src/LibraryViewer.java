import java.awt.Graphics;

import javax.swing.JApplet;

/**
 * 
 */

/**
 * @author khinterlong
 *
 */
public class LibraryViewer extends JApplet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 70990794883271612L;

	/**
	 * 
	 */
	public LibraryViewer() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		
	}

	public void paint(Graphics g) {
		g.draw3DRect(0, 0, 100, 100, false);
	}
}
