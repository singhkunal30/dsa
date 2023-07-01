package doublyLinkedList;

public class CircularDoublyLinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public Node create(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		head = node;
		tail = node;
		node.next = node;
		node.prev = node;
		size = 1;
		return head;		
	}
	
	public void insert(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if(head == null) {
			create(nodeValue);
			return;
		}
		else if(location ==0) {
			node.next = head;
			node.prev = tail;
			head.prev = node;
			tail.next = node;
			head = node;
		}
		else if (location >= size) {
			node.prev = tail;
			node.next = head;
			tail.next = node;
			head.prev = node;
			tail = node;
		}
		else {
			Node tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.next;
			}
			node.next = tempNode.next;
			node.prev = tempNode;
			node.next.prev = node;
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
			for(int i=0; i<size; i++) {
				System.out.print(tempNode.value);
				if(i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
			System.out.println();
		}
	}
	
	public void reverseTraverse() {
		if(head == null) {
			System.out.println("Linked List does not exist");
		}
		else {
			Node tempNode = tail;
			for(int i=0; i<size; i++) {
				System.out.print(tempNode.value);
				if(i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.prev;
			}
			System.out.println();
		}
	}
	
	public boolean search(int nodeValue) {
		if(head == null) {
			System.out.println("Linked List does not exist");
		}
		else {
			Node tempNode = head;
			for(int i=0; i<size;i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Node value found at location: "+i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		return false;
	}
	
	public void deleteNode(int location) {
		if(head == null) {
			System.out.println("Linked list does not exist");
		}
		else if( location ==0) {
			if(size==1) {
				head.prev = null;
				head.next = null;
				head = tail = null;
				size--;
				return; 
			}
			head = head.next;
			head.prev = tail;
			tail.next = head;
			size--;
		}
		else if(location>=size) {
			if(size==1) {
				head.prev = null;
				head.next = null;
				head = tail = null;
				size--;
				return; 
			}
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
			size--;
		}
		else {
			Node tempNode = head;
			for(int i=0; i<size; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			tempNode.next.prev = tempNode;
			size--;
		}
	}
	
	public void delete() {
		Node tempNode = head;
		for(int i=0; i<size; i++) {
			tempNode.prev = null;
			tempNode = tempNode.next;
		}
		head = null;
		tail = null;
		System.out.println("Linked List had been deleted");
	}
}
