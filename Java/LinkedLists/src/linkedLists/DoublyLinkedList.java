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
}
