package stack;

import linkedList.SinglyLinkedList;

public class StackUsingLinkedList {
	
	SinglyLinkedList linkedList;
	

	public StackUsingLinkedList() {
		linkedList = new SinglyLinkedList();
	}
	
	public void push(int value) {
		linkedList.insert(value, 0);
		System.out.println("Inserted "+ value +" in Stack");
	}
	
	public boolean isEmpty() {
		if(linkedList.head == null) {
			System.out.println("Linked List is empty");
			return true;
		}
		return false;
	}
	
	public int pop() {
		if(linkedList.head == null) {
			System.out.println("Linked List is empty");
			return -1;
		}
		else {
			int result = linkedList.head.value;
			linkedList.deleteNode(0);
			return result;
		}
	}
	
	public int peek() {
		if(linkedList.head == null) {
			System.out.println("Linked List is empty");
			return -1;
		}
		else {
			return linkedList.head.value;
		}
	}
	
	public void delete() {
		linkedList.head = null;
		System.out.println("Stack is deleted");
	}
}
