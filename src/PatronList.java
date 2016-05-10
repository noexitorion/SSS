import java.util.LinkedList;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class PatronList {
	private LinkedList<Patron> patrons;
	/**
	 * 
	 */
	public PatronList() {
		patrons = new LinkedList<Patron>();
	}
	
	public void add(Patron p) {
		patrons.add(p);
	}
	
	public void remove(Patron p) {
		patrons.remove(p);
	}
	
	public int size() {
		return patrons.size();
	}

}
