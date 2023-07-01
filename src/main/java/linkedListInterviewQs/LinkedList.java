package linkedListInterviewQs;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public void create(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		head = node;
		tail = node;
		size = 1;
	}
	
	public void insertNode(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		tail.next = node;
		tail = node;
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
		}
		System.out.println();
	}
	
	public void removeDups() {
	     Node temp1 = head;
         Node temp2;
         while(temp1 != null && temp1.next != null){
             temp2 = temp1;
             while(temp2.next !=null){
                 if(temp1.value == temp2.next.value){
                     temp2.next = temp2.next.next;
                     size--;
                 }
                 else {
                     temp2 = temp2.next;
                 }
             }
             temp1 = temp1.next;
         }
         tail = temp1;         
   	}
}
