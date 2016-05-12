import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author kevin
 *
 */
public class BookImporter {
	/**
	 * 
	 */
	public BookImporter() {
	}
	
	public static void importBooks(BookList libraryBooks, AuthorList authors, String filename) 
	{
		File toRead = new File(filename);
		String input = "";
		Scanner scan = null;
		try {
			scan = new Scanner(toRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNextLine()) {
			input += scan.nextLine() + "\n";
		}
		
		String[] bookEntries = input.split("\n");
		for(int i=0; i < bookEntries.length; ++i) {
			String[] bookDetails = bookEntries[i].split("\\W+[||]\\W+");
			Book b = parseBook(authors,bookDetails);
			libraryBooks.add(b);
		}
	}

	private static Book parseBook(AuthorList authors, String[] bookDetails) {
		String title = bookDetails[0];
		String[] bookAuthors = bookDetails[1].split(",");
		AuthorList localAuthorList = new AuthorList(bookAuthors);
		authors.addAuthors(bookAuthors);
		int copies = Integer.parseInt(bookDetails[2]);
		
		return new Book(title,copies,localAuthorList);
	}

}
