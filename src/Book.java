
public class Book {
	
	private String title, author, publisher;
	private int copy;
	
	
	public Book()
	{
		
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


	

}
