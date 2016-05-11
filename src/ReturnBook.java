import java.util.*;
public class ReturnBook {
	private boolean isWorking = true;
	
	public ReturnBook()
	{
		
	}
	
	private void ReturnSystem()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Who is the Patron?");
		String patron = scan.nextLine();
		Patron currentPatron = PatronSearch(patron);
		while (isWorking=true)
		{
		System.out.println("What book are you returning?");
		String title = scan.nextLine();
		CheckedOutBook book = outBookSearch(title);
		Book done = bookSearch(title);
		int copies = done.getCopy();
		done.setCopy(copies+1);
		double owed = currentPatron.getFines();
		currentPatron.setFines(owed+fineCalculator());
		}
		
		
	}
	
	private Patron PatronSearch(String patron)
	{
		return ;
	}
	
	private Book bookSearch(String title)
	{
		return ;
	}
	
	private CheckedOutBook outBookSearch(String book)
	{
		return ;
	}
	
	private double fineCalculator()
	{
		System.out.println("No");
		return 0;
	}
	

}
