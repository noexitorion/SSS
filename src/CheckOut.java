
import java.time.LocalDate;
import java.util.*;
public class CheckOut {
	private boolean IsWorking = true;
	
	public CheckOut() throws NoBookFoundException, NoPatronFoundException
	{
		checkoutBook();
	}
	
	private void checkoutBook() throws NoBookFoundException, NoPatronFoundException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the patron");
		String patron = scan.nextLine();
		Patron currentPatron = patronSearch(patron);
		while (IsWorking == true)
		{
			System.out.println("please enter the name of the book you wish to check out");
			String title = scan.nextLine();
			Book book = bookSearch(title);
			int copies = book.getCopy();
			/**
			 * REMINDER: DO A BETTER WAY OF CHECKING POSITIVES
			 * From Kevin: this is implemented in the book class - see below
			 */
			if (book.canCheckOutBook())
			{
				book.checkOut(currentPatron);
				String dueDate = LocalDate.now().plusDays(7).toString(); //return in a week
				CheckedOutBook done = new CheckedOutBook(book,currentPatron,dueDate,Integer.toString(copies));
				currentPatron.addBookToList(done);
			}
			else
			{
				System.out.println("There are no more copies of this book");
			}
			IsWorking = Menu();
		
		}
		
		
		
	}
	
	private boolean Menu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to check out another book?");
		String response = scan.nextLine();
		if (response.equals("yes"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * REMINDER: FIGURE OUT HOW TO SEARCH/SORT
	 * Implement these in the booklist and patronlist
	 */
	private Book bookSearch(String title) throws NoBookFoundException
	{
		
		return ;
	}
	private Patron patronSearch(String patronus) throws NoPatronFoundException
	{
		
		return ;
	}

}
