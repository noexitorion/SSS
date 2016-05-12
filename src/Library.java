import java.util.Scanner;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Library {
	private AuthorList authors;
	private PatronList patrons;
	private BookList books;
	
	/**
	 * 
	 */
	public Library() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Library lib = new Library();
		lib.authors = new AuthorList();
		lib.patrons = new PatronList();
		lib.books = new BookList();
		
		lib.importBooks("books.txt");
		lib.run();
	}
	
	private void importBooks(String file) {
		BookImporter.importBooks(books, authors, file);
		//import patrons?
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
		System.out.println("This is the number of books");
		System.out.println(books.size());
		System.out.println("This is the number of patrons");
		System.out.println(patrons.size());
	}
	
	/**
	 * 
	 */
	public void includeBook() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the book: ");
		String title = scan.nextLine();
		System.out.print("Enter the number of copies: ");
		int copies= scan.nextInt();
		scan.nextLine();
		System.out.print("Enter the authors of the book (separated by comma): ");
		String[] authorNames = scan.nextLine().split(",");
		Author[] authors = new Author[authorNames.length];
		AuthorList authorList = new AuthorList();
		for(int i=0; i < authors.length; ++i) {
			authors[i] = new Author(authorNames[i]);
			authorList.add(authors[i]);
		}
		Book book = new Book(title,copies,authorList);
		for(int i=0; i < authors.length; ++i) {
			authors[i].addBook(book);
		}
		books.add(book);
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
		//maybe save all books/authors and what not
		System.out.println("System is now shutting down.");
		System.out.println("Goodbye.");
		System.exit(0);
	}
	
	public void registerPatron() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the Patron: ");
		String name = scan.nextLine();
		
		Patron patron = new Patron(name);
		patrons.add(patron);
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
			case 1:
				includeBook();
				break;
			case 2:
				registerPatron();
			case 3:
				checkOutBook();
				break;
			case 4:
				returnBook();
				break;
			case 5:
				status();
				break;
			case 6:
				exit();
				break;
		}
	}

	private void showOptions() {
		
		String[] options = new String[] {"Include a book in the catalog",
				"Register a Patron",
				"Check out a book",
				"Return a book",
				"Status",
				"Exit" };
		System.out.println("Enter a number to pick an option:");
		for(int i=0; i < options.length; i++) {
			System.out.println((i+1) + " " + options[i]);
		}
	}
}
