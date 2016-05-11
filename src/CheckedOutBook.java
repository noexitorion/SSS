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
	public CheckedOutBook(String title, int copies, Patron patronus, String dueDate, String checkoutDate, String ID) {
		super(title, copies);
		this.setPatron(patronus);
		this.setDueDate(dueDate);
		this.setCheckoutDate(checkoutDate);
		this.setId(ID);
		
		
		// TODO Auto-generated constructor stub
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
