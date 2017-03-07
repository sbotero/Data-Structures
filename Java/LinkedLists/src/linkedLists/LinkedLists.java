package linkedLists;

public class LinkedLists {

	public static void main(String[] args) {
		
		SinglyLinkedList a = new SinglyLinkedList();
		a.insert(5);
		a.insert(6);
		a.insert(7);
		System.out.println(a.search(6));
		System.out.println(a.length());
		System.out.println(a);
		a.delete(6);
		System.out.println(a);
	}

}
