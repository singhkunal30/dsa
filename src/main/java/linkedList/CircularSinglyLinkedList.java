package linkedList;

public class CircularSinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public Node Create(int nodeValue) {
		Node node = new Node();
		head = new Node();
		node.value = nodeValue;
		node.next = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	public void insert(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if(head == null) {
			Create(nodeValue);
			return;
		}
		if(location == 0) {
			node.next = head;
			head = node;
			tail.next = head;			
		}
		else if(location>=size) {
			tail.next = node;
			tail = node;
			tail.next = head;
		}
		else {
			Node tempNode = new Node();
			tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.next;
			}
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}
	
	public void traverse() {
		if(head == null) {
			System.out.println("Linked List does not exist");
		}
		else {
			Node tempNode = head;
			for(int i=0; i<size;i++) {
				System.out.print(tempNode.value);
				if(i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println();
	}
	
	public boolean search(int nodeValue) {
		if(head != null) {
			Node tempNode = head;
			for(int i=0; i<size; i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Node found at location: "+ i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found");
		return false;
	}
	
	public void deleteNode(int location) {
		if(head == null) {
			System.out.println("Linked List doesn't exist");
			return;
		}
		else if(location == 0) {
				head = head.next;
				tail = head;
				size--;
				if(size == 0) {
					tail = null;
					head.next = null;
					head = null;
				}
		}
		else if(location >= size) {
			Node tempNode = head;
			for(int i=0; i<size-1;i++) {
				tempNode = tempNode.next;
			}
			if(tempNode == head) {
				head.next = null;
				head = null;
				size--;
				return;
			}
			tail = tempNode;
			tail.next = head;
			size--;
		}
		else {
			Node tempNode = head;
			for(int i=0; i<location-1;i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
	}
	
	public void delete() {
		head = null;
		tail = null;
		System.out.println("Linked List deleted succeddfully");
	}
}
