
public class Book {
	
	private String title; 
	//private String author, publisher;
	private AuthorList authors;
	private int copy;
	private PatronList checkedOutThisBook; //should be null if book is not checked out
	
	public Book(String title, int copies)
	{
		authors = new AuthorList();
		checkedOutThisBook = new PatronList();
		this.title = title;
		copy = copies;
	}
	
	public Book(String title, int copies, AuthorList authors)
	{
		this(title,copies);
		this.authors = authors;
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
			p.addBookToList(this);
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
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	/*
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	 */

	

}
