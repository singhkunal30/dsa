package doublyLinkedList;

public class DoublyLinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public Node create(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		node.prev = null;
		head = node;
		tail = node;
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
		else if(location == 0) {
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		}
		else if(location >= size) {
			node.next = null;
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		else {
			Node tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.next;
			}
			node.next = tempNode.next;
			tempNode.next = node;
			node.prev = tempNode;
			node.next.prev = node;
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
	
	public void reverseTraverse() {
		if(head == null) {
			System.out.println("Linked List does not exist");
		}
		else {
			Node tempNode = tail;
			for(int i=0; i<size;i++) {
				System.out.print(tempNode.value);
				if(i != size-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.prev;
			}
		}
		System.out.println();
	}
	
	public boolean search(int nodeValue) {
		if(head != null) {
			Node tempNode = head;
			for(int i=0; i<size; i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Node value found at location: "+ i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node value not found");
		return false;
	}
	
	public void deleteNode(int location) {
		if(head == null) {
			System.out.println("Linked list does not exist");
		}
		else if(location == 0) {
			if(size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			}
			else {
				head = head.next;
				head.prev = null;
				size--;
			}
		}
		else if(location >= size-1) {
			Node tempNode = tail.prev;
			if(size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			}
			else {
				tempNode.next = null;
				tail = tempNode;
				size--;
			}
		}
		else {
			Node tempNode = head;
			for(int i=0; i< location-1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			tempNode.next.prev = tempNode;
			size--;
		}
	}
	
	  public void delete() {
		    Node tempNode = head;
		    for (int i =0; i< size; i++) {
		      tempNode.prev = null;
		      tempNode = tempNode.next;
		    }
		    head = null;
		    tail = null;
		    System.out.println("The Linked list has been deleted!");
		  }
}
