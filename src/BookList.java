import java.util.LinkedList;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class BookList {
	private LinkedList<Book> books;
	/**
	 * 
	 */
	public BookList() {
		books = new LinkedList<Book>();
	}
	
	public void add(Book b) {
		books.add(b);
	}

}
