

public class RPG extends Patron {
	
	private int level, exp, totalBook;
	private String title;
	String[] leveList;
	int[] expCurve;
	
	public RPG()
	{
		super("Test");
		setExp();
	}
	
	public void setExp()
	{
		for (int i=1; i<25; i++)
		{
			expCurve[i]=i^2;
		}
	}
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public int getTotalBook() {
		return totalBook;
	}


	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

}
