package queue;

import linkedList.SinglyLinkedList;

public class QueueLinkedList {
	SinglyLinkedList list;
	
	public QueueLinkedList() {
		list = new SinglyLinkedList();
		System.out.println("Queue is successfully created");
	}
	
	public boolean isEmpty() {
		if(list.head==null) return true;
		else return false;
	}
	
	public void enqueue(int value) {
		list.insert(value, list.size);
		System.out.println("The value has been successfully inserted.");
	}
	
	public int dequeue() {
		int value = -1;
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return value;
		}
		else {
			value = list.head.value;
			list.deleteNode(0);
		}
		return value;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return -1;
		}
		else return list.head.value;
	}
	
	public void delete() {
		list.delete();
		System.out.println("Queue has been successfully deleted");
	}
}
