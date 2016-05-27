import java.awt.Graphics;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author khinterlong
 *
 */
public class LibraryLogin extends JFrame  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 70990794883271612L;
	protected static JButton login;
	protected static JButton register;
	protected static Library library;
	/**
	 * @param lib 
	 * 
	 */
	

	public LibraryLogin(Library lib) {
		super("Library Checkout");
		library = lib;
	}
	
	
	public void init() {
		createFrame();

		
	}
	
	public void createFrame()
	{
		
		JPanel buttons = new JPanel(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("");   
		emptyLabel.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(emptyLabel, BorderLayout.CENTER);

		ButtonHandler bh = new ButtonHandler(library, this);
        login = new JButton("Log In");
        register = new JButton("Register Patron");
        login.addActionListener(bh);
        register.addActionListener(bh);

        buttons.add(login);
        buttons.add(register);
        add(buttons);
		pack();
		setVisible(true);	
	}
	
	
	public static void main(String[] args) {
		final Library lib = new Library();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LibraryLogin libview = new LibraryLogin(lib);
                libview.init();
            }
        });
    }
	
	public void paint(Graphics g) {

	}
		
	private class ButtonHandler implements ActionListener {
		private Library lib;
		private LibraryLogin main;
		public ButtonHandler(Library l, LibraryLogin m) {
			lib =l;
			main = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			String name = JOptionPane.showInputDialog("Enter the Patron's name.");
			if(ae.getSource() == login) {
				try {
					Patron p = lib.getPatrons().search(name);
					LibraryInterface menu = new LibraryInterface(lib, main);
					setVisible(false);
					menu.init();
					menu.setUser(p);
					//go to new window good login
				} catch (IRCItemNotFoundException e) {
					JOptionPane.showMessageDialog(rootPane, "Can't log in. No account found!");
					//name not found
				}
			} else if (ae.getSource() == register) {
				try {
					lib.getPatrons().search(name);
					JOptionPane.showMessageDialog(rootPane, "Patron already exists!");
				} catch (IRCItemNotFoundException e) {
					lib.registerPatron(name);
				}
			}
			
		}
		
	}
	
	
}
