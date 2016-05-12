import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * 
 */

/**
 * @author khinterlong
 *
 */
public class IRCList <T extends Object & IRCItem> {
	//make a map or set to index the patrons by letter
	Map<Character,LinkedList<T>> map = new HashMap<Character,LinkedList<T> >();
		
	/**
	 * 
	 */
	public IRCList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean add(T p) {
		char key = p.getKey();
		if(!map.containsKey(key)) {
			LinkedList<T> patrons = new LinkedList<T>();
			patrons.add(p);
			map.put(key, patrons); //initialize map
		} else if(map.containsKey(key) && p.compareTo(map.get(key).getFirst()) < 0) {
			//if has key and this name is earlier sorted
			map.get(key).addFirst(p); //set to newer patron
		} else { //shouldn't be first in list
			addInOrder(map.get(key), p);
		}
		//make this method add patrons sorted
		
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
		for(T person : map.get(key)) { //hopefully this foreach works with 'this'
			if(person.equals(p)) {
				return person;
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
		for(T person : map.get(key)) { //hopefully this foreach works with 'this'
			if(person.getName().equalsIgnoreCase(p)) {
				return person;
			}
		}
		throw new IRCItemNotFoundException();
	}
	
	public String toString() {
		String toReturn ="";
		for(Character key : map.keySet()) {
			LinkedList<T> patrons = map.get(key);
			for(T p : patrons) {
				toReturn += p.getName() + ", "; //this is kind of dirty because of the hanging comma
			}
		}
		return toReturn;
	}
	
	public int size() {
		int sumSize =0;
		for(Character key : map.keySet()) {
			LinkedList<T> patrons = map.get(key);
			sumSize += patrons.size();
		}
		return sumSize;
	
	}

	public void remove(Patron p) {
		char key = p.getKey();
		ListIterator<T> listIterator = map.get(key).listIterator();
		while(listIterator.hasNext()) { //hopefully this foreach works with 'this'
			T person = listIterator.next();
			if(person.equals(p)) {
				listIterator.remove();
			}
		}
		
	}

}
