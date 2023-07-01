package linkedList;

public class SinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	//Method for creating singly linked list
	public Node create(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	//Method for inserting an element in a singly linked list
	public void insert(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if(head == null) {
			create(nodeValue);
			return;
		}
		else if(location == 0) {
			node.next = head;
			head = node;
		}
		else if(location >= size) {
			node.next = null;
			tail.next = node;
			tail = node;
		}
		else {
			Node tempNode = head;
			int index = 0;
			while(index < location-1) {
				tempNode = tempNode.next;
				index++;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}
		size +=1;
	}
	
	//Method to traverse singly linked list
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
	
	//Method to find node in singly linked list
	public boolean searchNode(int nodeValue) {
		if(head != null) {
			Node tempNode = head;
			for(int i=0; i<size; i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Found the node at location: " +(i+1)+ "\n");
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found");
		return false;
	}
	
	//Method to delete node in singly linked list
	public void deleteNode(int location) {
		if(head == null) {
			System.out.println("The linked list does not exist");
			return;
		}
		else if(location == 0) {
			head = head.next;
			size--;
			if(size == 0) {
				tail = null;
			}
		}
		else if(location >= size) {
			Node tempNode = head;
			for(int i=0; i<size-1 ;i++) {
				tempNode = tempNode.next;
			}
			if(tempNode == head) {
				tail = head = null ;
				size--;
				return;
			}
			tempNode.next = null;
			tail = tempNode;
			size--;
		}
		else {
			Node tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
	}
	
	//Method to delete entire linked list
	public void delete() {
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully");
	}
}
