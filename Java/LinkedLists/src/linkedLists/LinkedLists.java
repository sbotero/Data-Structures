package linkedLists;

public class LinkedLists {

	public static void main(String[] args) {
		
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertFront(5);
		a.insertFront(6);
		a.insertFront(7);
		a.insertEnd(6);
		a.insertEnd(8);
		System.out.println(a);
		a.setDisplayBackward();
		System.out.println(a);
		a.setDisplayForward();
		
		System.out.println(a.search(6));
		System.out.println(a.length());
		a.delete(7);
		System.out.println(a);
		a.insertAtIndex(2, 9);
		System.out.println(a);
		System.out.println(a.length());
	}

}
