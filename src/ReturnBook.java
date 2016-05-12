import java.util.*;
public class ReturnBook {
	private boolean isWorking = true;
	private BookList checkedOutBooks;
	private BookList books;
	private PatronList patrons;
	
	public ReturnBook(BookList bookList, BookList checkedOutBookList, PatronList patronList) throws IRCItemNotFoundException
	{
		books = bookList;
		checkedOutBooks = checkedOutBookList;
		patrons = patronList;
		returnSystem();
	}
	
	private void returnSystem() throws IRCItemNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Who is the Patron?");
		String patron = scan.nextLine();
		Patron currentPatron = patrons.search(patron);
		while (isWorking=true) {
			System.out.println("What book are you returning?");
			String title = scan.nextLine();
			CheckedOutBook book = (CheckedOutBook) checkedOutBooks.search(title);
			Book done = books.search(title);
			int copies = done.getCopy();
			done.setCopy(copies+1);
			double owed = currentPatron.getFines();
			currentPatron.setFines(owed+fineCalculator());
		}
		
		
	}
	
	private double fineCalculator()
	{
		System.out.println("No");
		return 0;
	}
	

}
