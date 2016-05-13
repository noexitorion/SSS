import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * 
 */

/**
 * @author khinterlong
 *
 */
public class IRCList <T extends Object & IRCItem<T>> implements Cloneable {
	//make a map or set to index the items by letter
	Map<Character,LinkedList<T>> map = new HashMap<Character,LinkedList<T> >();
	int size =0;
	/**
	 * 
	 */
	public IRCList(Map<Character,LinkedList<T>> map) {
		this.map = new HashMap<Character,LinkedList<T> >(map);
	}
	
	public IRCList() {
		
	}
	
	
	
	public boolean add(T p) {
		char key = p.getKey();
		if(!map.containsKey(key)) {
			LinkedList<T> items = new LinkedList<T>();
			items.add(p);
			map.put(key, items); //initialize map
		} else { //shouldn't be first in list
			addInOrder(map.get(key), p);
		}
		//make this method add items sorted
		++size;
		return true;
	}
	
	private void addInOrder(LinkedList<T> linkedList, T toAdd) {
		// TODO Auto-generated method stub
		ListIterator<T> listIterator = linkedList.listIterator();
		if(listIterator.hasNext() == false) {
			listIterator.add(toAdd);
			return;
		}
		while (listIterator.hasNext()) {
			T toCheck = listIterator.next();
			int comp = toAdd.compareTo(toCheck);
			if(comp < 0) { //before
				listIterator.previous();
				listIterator.add(toAdd);
				break;
			} else if (comp ==0) { //same
				listIterator.add(toAdd);
				break;
			} else if (comp >0 && listIterator.hasNext() == false) { //after
				listIterator.add(toAdd);
				break;
			}
        }
	}
	
	public boolean has(T p) {
		try {
			return get(p) != null ? true : false;
		} catch (IRCItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public T get(T p) throws IRCItemNotFoundException {
		char key = p.getKey();
		for(T thing : map.get(key)) { //hopefully this foreach works with 'this'
			if(thing.equals(p)) {
				return thing;
			}
		}
		throw new IRCItemNotFoundException("Couldn't find" + p + " using key of " + key);
	}
	
	//this method is bad because it assumes the name is used for the key
	public T search(String p) throws IRCItemNotFoundException {
		char key = Character.toUpperCase(p.charAt(0)); 
		return search(key,p);
	}
	
	
	public T search(char key, String p) throws IRCItemNotFoundException {
		try {
			for(T person : map.get(key)) {
				String name =person.getName().toUpperCase();
				if(p.toUpperCase().compareTo(name) > 0) {
					break;
				} else if (name.equalsIgnoreCase(p)) {
					return person;
				}
			}
		} catch (Exception e) {
			
		}
		throw new IRCItemNotFoundException("Couldn't find that user");
		
	}
	
	public String toString() {
		String toReturn ="";
		Collection<Character> unsorted = map.keySet();
		List<Character> sorted = asSortedList(unsorted);
		for(Character key : sorted) {
			LinkedList<T> items = map.get(key);
			for(T p : items) {
				toReturn += p.getName() + ", "; //this is kind of dirty because of the hanging comma
			}
		}
		return toReturn;
	}
	
	public int size() {
		return size;
		/* //forcefully count all things
		int sumSize =0;
		for(Character key : map.keySet()) {
			LinkedList<T> items = map.get(key);
			sumSize += items.size();
		}
		return sumSize;
		*/
	}

	public void remove(T p) {
		char key = p.getKey();
		ListIterator<T> listIterator = map.get(key).listIterator();
		while(listIterator.hasNext()) { //hopefully this foreach works with 'this'
			T person = listIterator.next();
			if(person.equals(p)) {
				listIterator.remove();
			}
		}
		--size;
	}
	
	public void display() {
		System.out.println(this);
	}
	
	public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
	  List<T> list = new ArrayList<T>(c);
	  java.util.Collections.sort(list);
	  return list;
	}
	
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		return new IRCList<T>(map);
	}

}
