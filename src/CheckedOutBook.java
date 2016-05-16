import java.time.LocalDate;

/**
 * 
 */

/**
 * @author khinterlong and aliao
 *
 */
public class CheckedOutBook extends Book {

	private Patron patron;
	private String dueDate, checkoutDate;
	private String id;
	
	/**
	 * 
	 */
	public CheckedOutBook(Book b, Patron patronus, String dueDate, String ID) {
		//what is the ID? should it be an attribute of the patron or the checkoutbook
		super(b.getTitle(), 1,b.getAuthors());
		String checkoutDate = LocalDate.now().toString();
		this.setPatron(patronus);
		this.setDueDate(dueDate);
		this.setCheckoutDate(checkoutDate);
		this.setId(ID);
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
