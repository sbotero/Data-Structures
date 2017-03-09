package linkedLists;
import nodes.GenericNode;

/**
 * DoublyLinkedList class used to create a linked list
 * of GenericNode<Integer> nodes.
 * 
 * @author Sebastian Botero
 */
public class DoublyLinkedList {

	private GenericNode<Integer> head, tail;
	private boolean readForward;
	private int size;
	

	/**
	 * DoublyLinkedList class constructor creates
	 * empty linked list.
	 */
	public DoublyLinkedList() {
		
		this.head = this.tail = null;
		this.readForward = true;
		this.size = 0;
	}
	
	/**
	 * Insert Integer data to the front of the linked list
	 * 
	 * @param data Integer to be inserted
	 */
	public void insertFront(Integer data) {
		
		if (isEmpty()) {
			
			this.head = new GenericNode<Integer>(data);
			this.tail = this.head;
		} else {
			
			this.head.setPrev(new GenericNode<Integer>(data, this.head));
			this.head = this.head.getPrev();
		}

		this.size++;
	}
	
	/**
	 * Insert Integer data to the end of the linked list
	 * 
	 * @param data Integer to be inserted
	 */
	public void insertEnd(Integer data) {
		
		if (isEmpty()) {
			
			this.head = new GenericNode<Integer>(data);
			this.tail = this.head;
		} else {
			
			this.tail.setNext(new GenericNode<Integer>(data, null, this.tail));
			this.tail = this.tail.getNext();
		}

		this.size++;
	}
	
	/**
	 * Insert Integer data to list at index i.  Element inserted
	 * will be in i-th position and all following elements shifted.
	 * 
	 * If i is equal to size of list, add element to the end.
	 * 
	 * Runtime Exception: IndexOutOfBoundsException() if i is invalid.
	 * 
	 * @param i int Index in list to insert element
	 * @param data Integer to be inserted
	 */
	public void insertAtIndex(int i, Integer data) {
		
		if (i == 0) {
			insertFront(data);
		} else if ((i < 0) || (i > this.size)) {
			throw new IndexOutOfBoundsException();
		} else if (i == this.size) {
			insertEnd(data);
		} else {
		
			int currIndex = 0;
			GenericNode<Integer> curr = this.head;
			
			while (currIndex != i) {
				
				curr = curr.getNext();
				currIndex++;
			}
			
			curr.setPrev(new GenericNode<Integer>(data, curr, curr.getPrev()));
			curr.getPrev().getPrev().setNext(curr.getPrev());
		
			size++;
		}	
	}
	
	/**
	 * Search for first occurrence of Integer data in linked list and 
	 * return the index of the Integer data the list.
	 * Return -1 if not found.
	 * 
	 * @param data Integer to search for
	 * @return index Index of element in list. -1 if element is not found.
	 */
	public int search(Integer data) {
		
		GenericNode<Integer> curr = this.head;
		int index = 0;
		
		// Iterate through list and look for data match
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
	 * Remove first occurrence of Integer data from the list.
	 * 
	 * @param data Integer to be removed.
	 */
	public void delete(Integer data) {
		
		GenericNode<Integer> curr = this.head;
		
		// Search for Integer data to be deleted
		while ((curr != null) && (curr.getData().intValue() != data.intValue())) {

			curr = curr.getNext();
		}
		
		// Check if data to be deleted was found
		if (curr != null) {
			
			// Check if first element is to be deleted
			if (this.head == curr) {
				
				// Check if only 1 element in list
				if (this.head == this.tail) {
					this.head = this.tail = null;
				} else {
					
					this.head = curr.getNext();
					this.head.setPrev(null);
				}
			} else {
				
				//Check if last element is to be deleted
				if (this.tail == curr) {
					
					this.tail = this.tail.getPrev();
					this.tail.getNext().setPrev(null);
					this.tail.setNext(null);
				} else {
					
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
				}
			}
			
			size--;
		}
	}
	
	/**
	 * Delete all elements in the list.
	 */
	public void deleteAll() {
		
		this.head = this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Checks if the linked list is empty.
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
	 * Set display forward flag to true.  After this method
	 * runs, when toString() is called, list will be printed
	 * from first to last element.
	 * 
	 * Default is DisplayForward.
	 */
	public void setDisplayForward() {
		this.readForward = true;
	}
	
	/**
	 * Set display forward flag to false.  After this method
	 * runs, when toString() is called, list will be printed
	 * from last to first element.
	 * 
	 * Default is DisplayForward.
	 */
	public void setDisplayBackward() {
		this.readForward = false;
	}
	
	/**
	 * Private method create string representation of linked
	 * list from first to last element.
	 * 
	 * @return String Forward List represented as String
	 */
	private String createStringForward() {
		
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
	
	/**
	 * Private method create string representation of linked
	 * list from last to first element.
	 * 
	 * @return String Forward List represented as String
	 */
	private String createStringBackward() {
		
		String list = "";
		GenericNode<Integer> curr = this.tail;

		while (curr != null) {
			
			// If not first element, add comma as part of format
			if (curr != this.head) {
				
				list += (Integer.toString(curr.getData()) + ", ");
				curr = curr.getPrev();
			} else {
				
				list += (Integer.toString(curr.getData()));
				curr = curr.getPrev();
			}
		}
		
		return list;
	}

	/**
	 * Format data in DoublyLinkedList object to string
	 * to allow printing of information.
	 */
	public String toString() {
		
		if (this.readForward) {
			return createStringForward();
		} else {
			return createStringBackward();
		}
	}
}
