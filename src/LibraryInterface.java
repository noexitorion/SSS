import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LibraryInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 70990794883271612L;
	protected static JButton addBook;
	protected static JButton checkoutBook;
	protected static JButton returnBook;
	protected static JButton goHome;
	protected static Library library;
	protected static LibraryLogin home;
	protected Patron user;
	/**
	 * @param lib 
	 * 
	 */
	

	public LibraryInterface(Library lib, LibraryLogin mainpage) {
		super("Library Functions");
		library = lib;
		home = mainpage;
	}
	
	public void setUser(Patron p) {
		user = p;
	}
	
	public void init() {
		createFrame();
		setVisible(true);
	}
	
	public void createFrame()
	{
		JPanel buttons = new JPanel(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("");   
		emptyLabel.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(emptyLabel, BorderLayout.CENTER);

		ButtonHandler bh = new ButtonHandler(library);
        addBook = new JButton("Add Book");
        checkoutBook = new JButton("Checkout Book");
        returnBook = new JButton("Return Book");
        goHome = new JButton("Back");
        
        addBook.addActionListener(bh);
        checkoutBook.addActionListener(bh);
        returnBook.addActionListener(bh);
        goHome.addActionListener(bh);

        buttons.add(addBook);
        buttons.add(checkoutBook);
        buttons.add(returnBook);
        buttons.add(goHome);
        add(buttons);
		pack();
	}
		
	private class ButtonHandler implements ActionListener {
		private Library lib;
		public ButtonHandler(Library l) {
			lib =l;
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == addBook) {
				try {
					String title = JOptionPane.showInputDialog("Enter the Book's title.").trim();
					int copies = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of copies."));
					String[] authors = JOptionPane.showInputDialog("Enter the Authors separated by comma.").split(",");
					lib.includeBook(title, copies, authors);
					//go to new window good login
				} catch (Exception e) {
					System.out.println("Failed to add book.");
					JOptionPane.showMessageDialog(rootPane, "Failed to add book.");					
					//name not found
				}
			} else if (ae.getSource() == checkoutBook) {
				try {
					String title = JOptionPane.showInputDialog("What book are you checking out?.").trim();
					Book book = lib.getBooks().search(title);
					lib.checkoutBook(user, book);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, "Failed to checkout book.");
				}
			} else if (ae.getSource() == returnBook) {
				try {
					String title = JOptionPane.showInputDialog("What book are you returning?.").trim();
					Book book = lib.getBooks().search(title);
					lib.returnBook(user, book);
				} catch (IRCItemNotFoundException e) {
					JOptionPane.showMessageDialog(rootPane, "Failed to return book!");
				}
			} else if (ae.getSource() == goHome) {
				setVisible(false);
				home.setVisible(true);
			}
			
		}
		
	}

}
