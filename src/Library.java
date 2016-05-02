import java.io.BufferedReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Library {
	private String input;
	private BufferedReader buffer;
	private AuthorList al;
	private PatronList pl;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Library lib = new Library();
		lib.importBooks("books.txt");
		lib.run();
	}
	
	private void importBooks(String file) {
		
	}

	/**
	 * 
	 */
	public Library() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param s
	 * @return
	 */
	public String getString(String s) {
		String toReturn = "";
		//do something
		return toReturn;
	}

	/**
	 * 
	 */
	public void status() {
		
	}
	
	/**
	 * 
	 */
	public void includeBook() {
		
	}
	
	/**
	 * 
	 */
	public void checkOutBook() {
		
	}
	
	/**
	 * 
	 */
	public void returnBook() {
		
	}
	
	/**
	 * 
	 */
	public void exit() {
		//give the program a chance to shut down gracefully
	}
	
	/**
	 * 
	 */
	public void run() {
		boolean promptAgain = true;
		Scanner scan = new Scanner(System.in);
		int response;
		while(promptAgain) {
			showOptions();
			System.out.print(">");
			response = scan.nextInt();
			doAction(response);
		}
	}

	private void doAction(int response) {
		switch(response) {
		case 0:
			includeBook();
			break;
		case 1:
			checkOutBook();
			break;
		case 2:
			returnBook();
			break;
		case 3:
			status();
			break;
		case 4:
			
			break;
		}
		
	}

	private void showOptions() {
		String[] options = new String[] {"Include a book in the catalog",
				"Check out a book",
				"Return a book",
				"Status",
				"Exit" };
		System.out.println("Enter one of the following options:");
		for(int i=0; i < options.length; i++) {
			System.out.println((i+1) + " " + options[i]);
		}
	}
	
}
