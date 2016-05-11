/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Patron {
	private String name;
	/**
	 * 
	 */
	public Patron(String n) {
		setName(n);
	}
	
	public void display() {
		
	}
	
	public boolean equals(Object o) {
		if(o == null) { return false; }
		if(o instanceof Author) {
			if( ((Patron)o).getName().equals(this.getName()) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
