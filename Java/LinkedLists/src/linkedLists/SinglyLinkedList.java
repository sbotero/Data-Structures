package linkedLists;
import nodes.GenericNode;

/**
 * SinglyLinkedList class used to create a linked list
 * of GenericNode<Integer> nodes.
 * 
 * @author Sebastian Botero
 */
public class SinglyLinkedList {
		
	private GenericNode<Integer> head, tail;
	private int size;

	/**
	 * SinglyLinkedList class constructor creates
	 * empty linked list.
	 */
	public SinglyLinkedList() {
		
		this.head = this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Insert Integer data to end of list
	 * 
	 * @param data Integer to be inserted
	 */
	public void insert(Integer data) {
		
		// Check if empty
		if (this.head == null) {
			
			this.head = new GenericNode<Integer>(data, this.head);
			this.tail = this.head;
		} else {
			
			GenericNode<Integer> temp = this.tail;
			
			this.tail = new GenericNode<Integer>(data, this.tail.getNext());
			temp.setNext(this.tail);
		}

		this.size++;
	}
	
	/**
	 * Search for Integer data in linked list and return the index
	 * of Integer data in list.
	 * Return -1 if not found.
	 * 
	 * @param data Integer to search for
	 * @return index Index of element in list. -1 if element is not found.
	 */
	public int search(Integer data) {
		
		GenericNode<Integer> curr = this.head;
		int index = 0;
		
		while ((curr != null) && (curr.getData().intValue() != data.intValue())) {
	
			curr = curr.getNext();
			index++;
		}
		
		// Check if found
		if (curr != null) {
			return index;
		} else {
			return -1;
		}
	}
	
	/**
	 * Removes Integer data from the list.
	 * 
	 * @param data Integer to be removed.
	 */
	public void delete(Integer data) {
		
		GenericNode<Integer> prev = null;
		GenericNode<Integer> curr = this.head;
		
		// Search for Integer data to be deleted
		while ((curr != null) && (curr.getData().intValue() != data.intValue())) {

			prev = curr;
			curr = curr.getNext();
		}
		
		// Found data
		if (curr != null) {
			
			// Check if first element
			if (prev == null) {
				
				// Check if only 1 element in list
				if (this.head == this.tail) {
					this.head = this.tail = null;
				} else {
					this.head = curr.getNext();
				}
			} else {
				
				//Check if last element
				if (this.tail == curr) {
					prev.setNext(curr.getNext());
					this.tail = prev;
				} else {
					prev.setNext(curr.getNext());
				}
			}
			
			size--;
		}
	}
	
	/**
	 * Returns if list is empty.
	 * 
	 * @return true if no elements in list. False if at least 1 element in least.
	 */
	public boolean isEmpty() {
		
		return (this.head == null);
	}

	/**
	 * Returns the length of the linked list
	 * 
	 * @return size Length of list
	 */
	public int length() {

		return size;
	}

	/**
	 * Format data in SinglyLinkedList object to string
	 * to allow printing of information.
	 */
	public String toString() {
		
		String list = "";
		GenericNode<Integer> curr = this.head;

		while (curr != null) {
			
			// If not last element, add comma as part of format
			if (curr != this.tail) {
				
				list += (Integer.toString(curr.getData()) + ", ");
				curr = curr.getNext();
			} else {
				
				list += (Integer.toString(curr.getData()));
				curr = curr.getNext();
			}
		}
		
		return list;
	}
}

