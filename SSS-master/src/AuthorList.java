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
		addAuthors(a);
	}
	
	public void addAuthors(String[] a) {
		for(int i=0 ; i<a.length; ++i) {
			if(a[i].isEmpty() == false) {
				authors.add(new Author(a[i].trim()));
			}
			
		}
	}
	
	public void display() {
		
	}

}
