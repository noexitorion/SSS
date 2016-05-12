/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Author implements IRCItem<Author> {
	private String name;
	private BookList booksInLibrary;
	/**
	 * No argument constructor
	 */
	public Author() {
		booksInLibrary = new BookList();
	}
	
	/**
	 * initialize Author with name
	 */
	public Author(String name) {
		this.name = name;
	}
	
	/**
	 * @return true if authors are equal to each other
	 */
	public boolean equals(Object o) {
		if(o == null) { return false; }
		if(o instanceof Author) {
			if( ((Author)o).getName().equals(this.getName()) ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void display() {
		System.out.println("Author is " + this);
	}
	
	public String toString() {
		return name;
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

	@Override
	public int compareTo(Author o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}

	@Override
	public char getKey() {
		return Character.toUpperCase(getName().charAt(0));
	}

}