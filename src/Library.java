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
	private BookList books;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Library lib = new Library();
		lib.al = new AuthorList();
		lib.pl = new PatronList();
		lib.books = new BookList();
		Patron p1 = new Patron("A");
		Patron p2 = new Patron("B");
		Patron p3 = new Patron("C");
		lib.pl.add(p2);
		lib.pl.add(p3);
		lib.pl.add(p1);
		try {
			Patron toCheck = lib.pl.get(p3);
			System.out.println(toCheck);
		} catch (IRCItemNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(lib.pl);
		
		//lib.importBooks("books.txt");
		//lib.run();
	}
	
	private void importBooks(String file) {
		BookImporter.importBooks(books, al, file);
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
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the book: ");
		String title = scan.nextLine();
		System.out.println("Enter the number of copies: ");
		int copies= scan.nextInt();
		System.out.println("Enter the authors of the book (separated by comma): ");
		String[] authors = scan.nextLine().split(",");
		AuthorList authorlist = new AuthorList(authors);
		Book b = new Book(title,copies,authorlist);
		//add the book to each of the authors
		books.add(b);
	}
	
	/**
	 * 
	 */
	public void checkOutBook() {
		//needs to look through the booklist and find the name of the book to checkout
		//need to be given a patron
		//only do follow through this if the Book isn't checked out now
		//The book should be added to the patron's booklist
		//the patron should be set as the person who checked out the book inside of Book
	}
	
	/**
	 * 
	 */
	public void returnBook() {
		//needs to look through the booklist and find the name of the book to checkout
		//need to be given a patron
		//remove Book from patron's booklist
		//set the person who checked out the book to null
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
			exit();
			break;
		}
	}

	private void showOptions() {
		
		String[] options = new String[] {"Include a book in the catalog",
				"Check out a book",
				"Return a book",
				"Status",
				"Exit" };
		System.out.println("Enter a number to pick an option:");
		for(int i=0; i < options.length; i++) {
			System.out.println((i+1) + " " + options[i]);
		}
	}
	
	private void showStatus()
	{
		System.out.println("This is the number of books");
		System.out.println(books.size());
		System.out.println("This is the number of patrons");
		System.out.println(pl.size());
	}
	
}
