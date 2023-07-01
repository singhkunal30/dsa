package stack;

public class Stack {
	
	int arr[];
	int top;
	
	public Stack(int size) {
		this.arr = new int[size];
		this.top = -1;
		System.out.printf("Stack Created with size of %d",size);
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(top == -1) {
//			System.out.println("Stack is Empty");
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(top == arr.length-1) {
//			System.out.println("Stack is full");
			return true;
		}
		return false;
	}
	
	public void push(int n) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			arr[top+1] = n;
			top += 1;
			System.out.println("The value is successfully inserted");
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			int value = arr[top];
			top -= 1;
			return value;
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			int value = arr[top];
			return value;
		}
	}
	
	public void delete() {
		arr = null;
		System.out.println("Stack is deleted successfully");
	}
	
}
