import java.io.BufferedReader;

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
	public void run() {
		
	}
	
}
