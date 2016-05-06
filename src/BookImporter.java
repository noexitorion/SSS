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
	private static Pattern p =Pattern.compile(REGEX);;
	
	/**
	 * 
	 */
	public BookImporter() {
	}
	
	public static BookList importBooks(String filename) 
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
		Matcher m = p.matcher(input);
		BookList list = new BookList();
		while(m.find()) {
			String title = m.group(1).trim();
			int count = Integer.parseInt(m.group(2).trim());
	        Book b = new Book(title,count);
	        list.add(b);
	    }
		return list;
	}

}
