package doublyLinkedList;

public class Main {
	
	public static void main(String[] args) {
		
//		Doubly Linked List
		DoublyLinkedList dLL = new DoublyLinkedList();
		dLL.create(5);
		System.out.println(dLL.head.value);
		dLL.insert(1, 0);
		dLL.insert(2, 3);
		dLL.insert(4, 2);
		dLL.traverse();
		dLL.deleteNode(1);
		dLL.traverse();
		
//		Circular Doubly Linked List
//		CircularDoublyLinkedList cdLL = new CircularDoublyLinkedList();
//		cdLL.create(5);
//		cdLL.insert(2, 0);
//		cdLL.insert(3, 2);
//		cdLL.insert(22, 1);
//		cdLL.insert(12, 2);
//		cdLL.traverse();
//		cdLL.deleteNode(5);
//		cdLL.traverse();
	}
}
