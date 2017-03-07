package nodes;

/**
 * Node class stores generic type T @param data
 * and GenericNode<T> class @param next, @param prev.
 * 
 * @author Sebastian Botero
 */
public class GenericNode<T> {
	
	private T data;
	private GenericNode<T> next, prev;

	/**
	 * GenericNode<T> class constructor used to create
	 * GenericNode<T> class object.
	 * GenericNode<T> prev is set to null.
	 * 
	 * @param data T stored in Node
	 * @param next GenericNode<T> link
	 */
	public GenericNode(T data, GenericNode<T> next) {
		
		this.data = data;
		this.next = next;
		this.prev = null;
	}
	
	/**
	 * GenericNode<T> class constructor used to
	 * create GenericNode<T> class object.
	 * 
	 * @param data T stored in Node
	 * @param next GenericNode<T> link
	 * @param prev GenericNode<T> link
	 */
	public GenericNode(T data, GenericNode<T> next, GenericNode<T> prev) {
		
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Returns stored value of type T data in GenericNode<T>.
	 * 
	 * @return T data
	 */
	public T getData() {

		return data;
	}

	/**
	 * Update value stored in GenericNode<T>.
	 * 
	 * @param data T to be updated
	 */
	public void setData(T data) {

		this.data = data;
	}

	/**
	 * Returns the GenericNode<T> next object stored in GenericNode<T>.
	 * 
	 * @return GenericNode<T> next
	 */
	public GenericNode<T> getNext() {

		return next;
	}

	/**
	 * Update GenericNode<T> next object in GenericNode<T>.
	 * 
	 * @param next GenericNode<T> to be updated
	 */
	public void setNext(GenericNode<T> next) {

		this.next = next;
	}

	/**
	 * Returns the GenericNode<T> prev object stored in GenericNode<T>.
	 * 
	 * @return GenericNode<T> prev
	 */
	public GenericNode<T> getPrev() {

		return prev;
	}

	/**
	 * Update GenericNode<T> prev object in GenericNode<T>.
	 * 
	 * @param prev GenericNode<T> to be updated
	 */
	public void setPrev(GenericNode<T> prev) {

		this.prev = prev;
	}
}
