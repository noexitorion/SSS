import java.util.Scanner;
import java.time.LocalDate;

public class CheckoutReturn {
	private boolean isWorking = true;
	private BookList checkedOutBooks;
	private BookList books;
	private PatronList patrons;
	
	public CheckoutReturn(BookList bookList, PatronList patronList) throws IRCItemNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		books = bookList;
		patrons = patronList;
		System.out.println("Would you like to Check Out or Return");
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("Check Out"))
		{
			Checkout();
		}
		if (response.equalsIgnoreCase("Return"))
		{
			Returner();
		}
		
		
		
	}
	
	private void Checkout() throws IRCItemNotFoundException
	{
		boolean IsWorking = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the patron");
		String patron = scan.nextLine();
		Patron currentPatron = patrons.search(patron);
		while (IsWorking == true)
		{
			System.out.println("please enter the name of the book you wish to check out");
			String title = scan.nextLine();
			Book book = books.search(title);
			int copies = book.getCopy();
			String id = book.takeNote();
			if (book.canCheckOutBook())
			{
				book.checkOut(currentPatron);
				String dueDate = LocalDate.now().plusDays(7).toString(); //return in a week
				CheckedOutBook done = new CheckedOutBook(book,currentPatron,dueDate,Integer.toString(copies));
				done.setId(id);
				currentPatron.addBookToList(done);
			}
			else
			{
				System.out.println("There are no more copies of this book");
			}
			IsWorking = cmenu();
		
		}
	}
		
	private void Returner() throws IRCItemNotFoundException
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Who is the Patron?");
		String patron = scan.nextLine();
		Patron currentPatron = patrons.search(patron);
		while (isWorking=true) {
			System.out.println("What book are you returning?");
			String title = scan.nextLine();
			Book currentBook = books.search(title);
			int copies = currentBook.getCopy();
			BookList bookl = currentPatron.getCheckedOutBooks();
			Book idBook = bookl.get(currentBook);
			String returnID= idBook.getId();
			currentBook.returnNote(returnID);
			currentBook.setCopy(copies+1);
			currentBook.returnBook(currentPatron);
			double owed = currentPatron.getFines();
			currentPatron.setFines(owed+fineCalculator());
			isWorking = vmenu();
		}
		

	}
	private double fineCalculator()
	{
		System.out.println("No");
		return 0;
	}
	
	private boolean cmenu()
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
	
	private boolean vmenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to return another book?");
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

}



