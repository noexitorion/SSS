
public interface IRCItem<T> extends Comparable<T> {
	char getKey();
	String getName();
	int compareTo(T o);
	//generally the method body for compareTo should be:
	/*
	{
		return getName().compareTo(o.getName());
	}
	*/
}
