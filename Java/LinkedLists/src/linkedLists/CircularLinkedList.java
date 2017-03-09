package linkedLists;
import nodes.GenericNode;

/**
 * CircularLinkedList class used to create a linked list
 * of GenericNode<String> nodes.
 * 
 * @author Sebastian Botero
 */
public class CircularLinkedList {

	private GenericNode<String> head, tail;
	private int size;

	
	/**
	 * CircularLinkedList class constructor creates
	 * empty linked list.
	 */
	public CircularLinkedList() {
		
		this.head = this.tail = null;
		this.size = 0;
	}

	
	/**
	 * Search for first occurrence Integer data in linked list and 
	 * return the index of Integer data in list.
	 * Return -1 if not found.
	 * 
	 * @param data String to search for
	 * @return index Index of element in list. -1 if element is not found.
	 */
	public int search(String data) {
		
		GenericNode<String> curr = this.head;
		boolean found = false;
		int index = 0;
		
		if (!isEmpty()) {
			
			// Check first element matches data
			if (curr.getData().equals(data)) {
				found = true;
			}
			
			curr = curr.getNext();
			
			// Iterate through all items while looking for String data in list
			while (curr != this.head && !found) {
				
				if (curr.getData().equals(data)) {
					found = true;
				}
				
				curr = curr.getNext();
				index++;
			}
		}
		
		if (found) {
			return index;
		} else {
			return -1;
		}
	}
	
	
	/**
	 * Insert String data to end of list
	 * 
	 * @param data Integer to be inserted
	 */
	public void insert(String data) {
		
		
		if (isEmpty()) {
			
			this.head = new GenericNode<String>(data);
			this.head.setNext(this.head);
			this.tail = this.head;
		} else {
			
			GenericNode<String> temp = this.tail;
			
			this.tail = new GenericNode<String>(data);
			temp.setNext(this.tail);
			this.tail.setNext(this.head);
		}

		this.size++;
	}

	
	/**
	 * Remove first occurrence of String data from the list.
	 * 
	 * @param data String to be removed.
	 */
	public void delete(String data) {
		
		GenericNode<String> prev = null;
		GenericNode<String> curr = this.head;
		boolean found = false, firstElement = false;

		if (!isEmpty()) {
			
			// Check first element to be deleted
			if (curr.getData().equals(data)) {
				
				// Check if only 1 element in list
				if (this.head == this.tail) {
					this.head = this.tail = null;
				} else {
					
					this.head = curr.getNext();
					this.tail.setNext(this.head);
				}

				firstElement = true;
				size--;
			}
			
			if (!firstElement) {
			
				// Search for element to be deleted
				prev = curr;
				curr = curr.getNext();
				
				while (curr != this.head && !found) {
					
					if (curr.getData().equals(data)) {
						found = true;
						break;
					}
					
					prev = curr;
					curr = curr.getNext();
				}
			}
		
			if (found) {
					
				//Check if last element is to be deleted
				if (prev == this.tail) {
					prev.setNext(curr.getNext());
					this.tail = prev;
				} else {
					prev.setNext(curr.getNext());
				}
				
				size--;
			}
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
	 * Returns the length of the linked list.
	 * 
	 * @return size Length of list
	 */
	public int length() {

		return size;
	}

	
	/**
	 * Format data in CircularLinkedList object to string
	 * to allow printing of information.
	 */
	public String toString() {
		 
		 return toString(this.head);
	}
	
	
	/**
	 * Private method uses recursive approach to create string representation of
     * CircularLinkedList.
     * Serves as helper method to toString().
	 * 
	 * @param curr GenericNode<String> Current head of list
	 * @return result String representation of data in nodes from front to end
	 */
	private String toString(GenericNode<String> curr) {
	       
	        String result = "";

	        if(!isEmpty()) {
	        	
	            if ( curr.getNext() != this.head ) {
	                result += "'" + curr.getData() + "'" + ", " + toString(curr.getNext());
	            } else {
	                result += "'" + curr.getData() + "'";
	            }
	        }
	        
	        return  result;
	  }
}
