import java.util.LinkedList;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class AuthorList extends IRCList<Author> {

	/**
	 * 
	 */
	public AuthorList() {
		
	}
	
	public AuthorList(String[] a) {
		addAuthors(a);
	}
	
	public void addAuthors(String[] a) {
		for(int i=0 ; i<a.length; ++i) {
			if(a[i].isEmpty() == false) {
				add(new Author(a[i].trim()));
			}
			
		}
	}


}
