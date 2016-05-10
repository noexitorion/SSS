/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Patron {
	private String name;
	private BookList checkedOutBooks;
	
	/**
	 * 
	 */
	public Patron(String n) {
		setName(n);
		checkedOutBooks = new BookList();
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
	
	public void addBookToList(Book b) {
		checkedOutBooks.add(b);
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
