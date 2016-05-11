import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author kevin
 *
 */
public class BookImporter {
	private static final String REGEX = "([a-z,A-Z,\\s]+)(\\d+)";
	private static Pattern p =Pattern.compile(REGEX);
/**
 * The format for reading books will likely 
 * change to a format where it can be dealt 
 * with using only arrays. For example
 * Book Title || author1, author2 || copies
 * Then split using "||"
 */
	
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
			String[] bookDetails = bookEntries[i].split("||");
			Book b = parseBook(authors,bookDetails);
			libraryBooks.add(b);
		}
	}

	private static Book parseBook(AuthorList authors, String[] bookDetails) {
		String title = bookDetails[0];
		String[] bookAuthors = bookDetails[1].split(",");
		AuthorList localAuthorList = new AuthorList(bookAuthors);
		authors.addAuthors(bookAuthors);
		int copies = Integer.parseInt(bookDetails[3]);
		
		return new Book(title,copies,localAuthorList);
	}

}
