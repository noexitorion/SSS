import java.util.Scanner;
import java.time.LocalDate;

public class CheckoutReturn {
	private boolean isWorking = true;
	private BookList checkedOutBooks;
	private BookList books;
	private PatronList patrons;
	
	public CheckoutReturn(BookList bookList, PatronList patronList)
	{
		books = bookList;
		patrons = patronList;		
	}
	
	public void Checkout() throws IRCItemNotFoundException
	{
		boolean IsWorking = true;
		Scanner scan = new Scanner(System.in);
		Patron currentPatron = getPatron();
		while (IsWorking == true) 
		{
			System.out.println("Please enter the name of the book you wish to check out:");
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
				System.out.println(book.getCheckedOut());
			}
			else
			{
				System.out.println("There are no more copies of this book.");
			}
			IsWorking = cmenu();
		
		}
	}
	
	public Patron getPatron() {
		boolean hasPatron = false;
		Patron currentPatron = null;
		while(hasPatron == false) {
			System.out.println("Please enter the name of the patron:");
			Scanner scan = new Scanner(System.in);
			String patron = scan.nextLine();
			try {
				currentPatron = patrons.search(patron);
				hasPatron = true;
			} catch (IRCItemNotFoundException e) {
				System.out.println(e);
				System.out.println("No user by that name was found, would you like to register '" + patron + "'?");
				String response = scan.nextLine();
				if(response.equalsIgnoreCase("yes")) {
					currentPatron = new Patron(patron);
					patrons.add(currentPatron);
					hasPatron = true;
				}
			}
		}
		return currentPatron;
	}
		
	public void Returner() throws IRCItemNotFoundException
	{
		
		Scanner scan = new Scanner(System.in);
		Patron currentPatron = getPatron();
		while (isWorking=true) {
			System.out.println("What book are you returning?");
			String title = scan.nextLine();
			Book currentBook = books.search(title);
			int copies = currentBook.getCopy();
			BookList bookl = currentPatron.getCheckedOutBooks();
			Book idBook = bookl.search(title); //checkedOutBook
			currentPatron.getCheckedOutBooks().remove(idBook);			
			String returnID= idBook.getId();
			currentBook.returnNote(returnID);
			currentBook.setCopy(copies+1);
			currentBook.returnBook(currentPatron);
			System.out.println(currentPatron.getCheckedOutBooks());
			isWorking = vmenu();
		}
		

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



