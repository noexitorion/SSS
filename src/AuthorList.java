import java.util.LinkedList;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class AuthorList {
	private LinkedList<Author> authors;
	/**
	 * 
	 */
	public AuthorList() {
		authors = new LinkedList<Author>();
	}
	
	public AuthorList(String[] a) {
		for(int i=0 ; i<a.length; ++i) {
			authors.add(new Author(a[i]));
		}
	}
	
	public void display() {
		
	}

}
