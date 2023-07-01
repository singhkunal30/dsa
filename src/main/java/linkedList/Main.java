package linkedList;

public class Main {
	
	public static void main(String[] args) {
//		Singly Linked List
		
		SinglyLinkedList sLL = new SinglyLinkedList();
		sLL.create(5);
//		System.out.println(sLL.head.value);
		sLL.insert(6, 0);
//		System.out.println(sLL.head.value);
		sLL.insert(8, 1);
//		System.out.println(sLL.tail.value);
		sLL.insert(10, 1);
		sLL.insert(1, 3);
		sLL.traverse();
//		sLL.searchNode(3);
//		sLL.searchNode(10);
		sLL.deleteNode(4);
		sLL.traverse();
//		sLL.delete();
//		sLL.traverse();
		
//		Circular Singly Linked List
		
//		CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();
//		cSLL.Create(5);
//		System.out.println(cSLL.head.value);
//		cSLL.insert(1,0);
//		cSLL.insert(12, 4);
//		cSLL.insert(2,2);
//		cSLL.traverse();
//		cSLL.search(12);
//		cSLL.deleteNode(3);
//		cSLL.traverse();
//		cSLL.delete();
//		cSLL.traverse();
	}
}
