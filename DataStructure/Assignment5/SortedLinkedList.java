import java.util.LinkedList;

public class SortedLinkedList<E> {

	private LinkedList<E> linkedListSorted;	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SortedLinkedList() {
		linkedListSorted = new LinkedList();
	}
	
	public boolean insert(E data) {
		int i = 0;
		boolean isInserted = false;
		if(linkedListSorted.size() == 0) {
			linkedListSorted.add(data);
			isInserted = true;
		} else {
			isInserted = insertInternal(data, i);
		}
		return isInserted;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean insertInternal(E data, int i) {
		
		E value;
		if(i >= linkedListSorted.size()) {
			linkedListSorted.addLast(data);
			return false;
		}
		
		value = linkedListSorted.get(i);
		if(((Comparable)value).compareTo(data) > 0) {
			if(i == 0) {
				linkedListSorted.addFirst(data);
			}
			return true;
		} else {
			if(insertInternal(data, i+1)) {
				linkedListSorted.add(i+1, data);
			}
		}
		return false;
	}
	
	public E get(int index) {
	
		if(index < 0 || index >= linkedListSorted.size()) {
			throw new IllegalArgumentException("Wrong index value");
		}
		return linkedListSorted.get(index);
	}

	public int size() {
		return linkedListSorted.size();
	}
}
