
public class Book implements IRCItem<Book> {
	
	private String title; 
	//private String author, publisher;
	private AuthorList authors;
	private int copy, totalCopy;
	private String id;

	private PatronList checkedOutThisBook; 
	
	public Book(String title, int copies)
	{
		setAuthors(new AuthorList());
		checkedOutThisBook = new PatronList();
		setTitle(title);
		copy = copies;
	}
	
	public Book(String title, int copies, AuthorList authors)
	{
		this(title,copies);
		this.setAuthors(authors);
	}
	
	/**
	 * 
	 * @return the ability to check out this book
	 */
	public boolean canCheckOutBook() {
		if(copy > checkedOutThisBook.size()) {
			return true;
		}
		return false;
	}
	
	//aldawud mentioned that we might not want to have this here
	public void checkOut(Patron p) {
		if(canCheckOutBook()) {
			checkedOutThisBook.add(p);
		}
	}
	
	public void returnBook(Patron p) {
		checkedOutThisBook.remove(p);
	}
	
	/**
	 * @return true if books are equal to each other
	 */
	public boolean equals(Object o) {
		if(o == null) { return false; }
		if(o instanceof Author) { //might need to expand if we add more properties
			if( ((Book)o).getTitle().equals(this.getTitle()) ) {
				return true;
			}
		}
		return false;
	}	
	
	public int getCopy() {
		return copy;
	}


	public void setCopy(int copy) {
		this.copy = copy;
	}
	
	
	public int getTotalCopy() {
		return totalCopy;
	}

	public void setTotalCopy(int totalCopy) {
		this.totalCopy = totalCopy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		title = title.substring(0, 1).toUpperCase() + title.substring(1);
		this.title = title;
	}

	/**
	 * @return the authors
	 */
	public AuthorList getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(AuthorList authors) {
		this.authors = authors;
	}

	/**
	 * @return the checkedOutThisBook
	 */
	public PatronList getCheckedOutThisBook() {
		return checkedOutThisBook;
	}

	/**
	 * @param checkedOutThisBook the checkedOutThisBook to set
	 */
	public void setCheckedOutThisBook(PatronList checkedOutThisBook) {
		this.checkedOutThisBook = checkedOutThisBook;
	}

	@Override
	public int compareTo(Book o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public char getKey() {
		return Character.toUpperCase(getName().charAt(0));
	}

	@Override
	public String getName() {
		return title;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Book clone = new Book(getTitle(),copy,(AuthorList)authors.clone());
		clone.setCheckedOutThisBook((PatronList)checkedOutThisBook.clone());
		return clone;
	}


}
