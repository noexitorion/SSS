/**
 * 
 */

/**
 * @author khinterlong
 *
 */
public class IRCItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1667689173779549004L;

	/**
	 * 
	 */
	public IRCItemNotFoundException() {
		super("The item you searched for could not be found.");
	}

	/**
	 * @param arg0
	 */
	public IRCItemNotFoundException(String arg0) {
		super("The item you searched for could not be found: " + arg0);
	}

	/**
	 * @param arg0
	 */
	public IRCItemNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public IRCItemNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public IRCItemNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
