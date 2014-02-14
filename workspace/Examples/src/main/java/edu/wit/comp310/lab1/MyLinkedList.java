package edu.wit.comp310.lab1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Roll your own Singly-linked list.
 * 
 * This means that we implement ourselves.
 * 
 * The List interface is described here:
 * 
 * @see http://docs.oracle.com/javase/7/docs/api/java/util/List.html
 *
 */
public class MyLinkedList<ValueType> implements List<ValueType> {
	Node<ValueType> first;
	Node<ValueType> last;
	int size = 0;
	public static class Node<T> {
		T data;
		Node<T> next;
	}
	private Node<ValueType> getNodeAt(int index) {
		// for (initialization; continueCondition; updateRule)
		// for (int i = 0; i < size(); i++)
		int i = 0;
		Node<ValueType> current;
		for (current = first;
				current != null && i < index;
				current = current.next, i++);
		return current;
	}
	
	@Override
	public boolean add(ValueType arg0) {
		Node<ValueType> newNode = new Node<ValueType>();
		newNode.data = arg0;
		if (this.isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size++;
		return false;
	}

	@Override
	public void add(int index, ValueType arg1) {
		Node<ValueType> n = new Node<ValueType>();
		n.data = arg1;
		Node<ValueType> current = first;
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("WTF?!?");
		}
		if (index == 0){
			Node<ValueType> temp = new Node<ValueType>();
			temp = first;
			first = n;
			n.next = temp;
			size++;
		}
		
		else{
			for (int i = 0; i < index - 1; i++){
				current = current.next;
			}
			Node<ValueType> temp = current.next;
			current.next = n;
			n.next = temp;
			size++;
		}
	}

	@Override
	public boolean addAll(Collection<? extends ValueType> arg0) {
		for (Object item : arg0){
			add((ValueType) item);
		}
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends ValueType> arg1) {
		int i = arg0;
		for (Object item : arg1){
			add(i, (ValueType) item);
			i++;
		}
		return false;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
		
	}

	@Override
	public boolean contains(Object arg0) {
		Node<ValueType> current;
		for (current = first; current != null; current = current.next){
			if (current.data.equals(arg0)){
				return true;
			}
		}return false;
		
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object item : arg0){
			if(!contains(item)){
				return false;
			}
		}
		return true;
	}

	@Override
	public ValueType get(int arg0) {
		Node<ValueType> current = first;
		for (int i = 1; i <= arg0; i++){
			current = current.next;
		}
		
 		return current.data;
	}

	@Override
	public int indexOf(Object arg0) {
		Node<ValueType> current = first;
		for (int i = 0; i < size; i++){
			if (current.data.equals(arg0)){
				return i;
			}
			current = current.next;
		}
		
		/*int i = 0;
		for(ValueType item : this) {
			System.out.println(i + ": " + item);
			i++;
		}
		*/
		return -1;
		}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	@Override
	public Iterator<ValueType> iterator() {
		return new Iterator<ValueType>() {
			Node<ValueType> current = first;
			@Override
			public boolean hasNext() {
				// is there an element after current?
				return current != null;
			}
			@Override
			public ValueType next() {
				// Advance current to next
				// return current's data
				ValueType temp = current.data;
				current = current.next;
				return temp;
			}
			@Override
			public void remove() {
				// Don't bother, please
			}
		};
	}

	@Override
	public int lastIndexOf(Object arg0) {
		//for (int i = 0; i < size; i++){
			
		//}
		return size - 1;
	}

	@Override
	public ListIterator<ValueType> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ValueType> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public boolean remove(Object arg0) {
		//Node<ValueType> temp = new Node<ValueType>();
		Node<ValueType> current = first;
		//Node<ValueType> n = new Node<ValueType>();
		if(contains(arg0)){
			if(current.data.equals(arg0)) {
				first = first.next;
				size--;
			}
			else
				while (!(arg0.equals(current.data))){
					if(arg0.equals(current.next.data)) {
						current.next = current.next.next;
						size--;
						return true;
						
					}
					else
						current = current.next;
				}
			
		}
		

		return false;
	}

	@Override
	public ValueType remove(int arg0) {
		Node<ValueType> current = first;
		Node<ValueType> temp = new Node<ValueType>();
		if(arg0 == 0)
			first = first.next;
		else
			for (int i = 0; i < arg0; i++){
				if(i == arg0 - 1){
					current.next = current.next.next;
					size--;
				}
				current = current.next;
			}
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean found = false;
		for (Object item : arg0)
			while(contains(item)) {
				remove(item);
				found = true;
			}
		return found;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		for (ValueType item : this) {
			boolean found = false;
			for (Object item1 : arg0)
				if(item1.equals(item))
					found = true;
			if(!found)
				remove(item);
		}
		return false;
	}

	@Override
	public ValueType set(int arg0, ValueType arg1) {
		ValueType old = getNodeAt(arg0).data;
		getNodeAt(arg0).data = arg1;
		return old;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<ValueType> subList(int arg0, int arg1) {
		List<ValueType> list = new ArrayList<ValueType>();
		for(int i = arg0; i < arg1; i ++){
			list.add(get(i));
		}
		
		
		return list;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		int i = 0;
		for(ValueType obj : this)
		{
			arr[i] = obj;
			i++;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		String[] arr = new String[size];
		int i = 0;
		for(ValueType obj : this)
		{
			arr[i] = (String) obj;
			i++;
		}
		return (T[]) arr;
	}

}
