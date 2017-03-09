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

	
	
}
