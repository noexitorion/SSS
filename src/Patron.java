/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class Patron implements IRCItem<Patron> {
	private String name;
	private BookList checkedOutBooks;
	private double fines;
	
	/**
	 * 
	 */
	public Patron(String n) {
		setName(n);
		checkedOutBooks = new BookList();
	}
	
	public void display() {
		System.out.println(this);
	}
	
	/**
	 * @return the checkedOutBooks
	 */
	public BookList getCheckedOutBooks() {
		return checkedOutBooks;
	}

	/**
	 * @param checkedOutBooks the checkedOutBooks to set
	 */
	public void setCheckedOutBooks(BookList checkedOutBooks) {
		this.checkedOutBooks = checkedOutBooks;
	}

	/**
	 * @return the fines
	 */
	public double getFines() {
		return fines;
	}

	/**
	 * @param fines the fines to set
	 */
	public void setFines(double fines) {
		this.fines = fines;
	}
	
	public boolean equals(Object o) {
		if(o == null) { return false; }
		if(o instanceof Patron) {
			if( ((Patron)o).getName().equals(this.getName()) &&
					((Patron)o).getCheckedOutBooks().equals(this.getCheckedOutBooks()) &&
					((Patron)o).getFines() == this.getFines() ) {
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
		this.name = name.substring(0,1).toUpperCase() + name.substring(1);
	}

	public String toString() {
		return getName() + " has " + checkedOutBooks.size() + " books checked out and $" + getFines() + " fines.";
	}

	@Override
	public int compareTo(Patron p) {
		return getName().compareTo(p.getName());
	}

	@Override
	public char getKey() {
		return  Character.toUpperCase(getName().charAt(0));
	}
}
