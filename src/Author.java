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
	 * initialize Author with name
	 */
	public Author(String name) {
		booksInLibrary = new BookList();
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
	
	public void addBook(Book b) {
		booksInLibrary.add(b);
	}
	
	/**
	 * 
	 */
	public void display() {
		System.out.println("Author is " + this);
	}
	
	/**
	 * @return the booksInLibrary
	 */
	public BookList getBooksInLibrary() {
		return booksInLibrary;
	}

	/**
	 * @param booksInLibrary the booksInLibrary to set
	 */
	public void setBooksInLibrary(BookList booksInLibrary) {
		this.booksInLibrary = booksInLibrary;
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