import java.awt.Graphics;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author khinterlong
 *
 */
public class LibraryViewer extends JApplet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 70990794883271612L;

	/**
	 * 
	 */
	

	public LibraryViewer() {
		createFrame();
		
	
	}
	
	
	public void init() {
		
	}
	
	public static void createFrame()
	{
		JFrame libraryFrame = new JFrame("Library Checkout");
		
		libraryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("");   
		emptyLabel.setPreferredSize(new Dimension(500, 500));
		libraryFrame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		libraryFrame.add(new textReader());

		libraryFrame.pack();
		libraryFrame.setVisible(true);	
	}
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame();
            }
        });
    }
		
		


	public void paint(Graphics g) {
		g.draw3DRect(0, 0, 100, 100, false);
	}
	
	  
	
	
}
