package queue;

public class QueueArray {
	int [] arr;
	int topOfQueue;
	int beginningOfQueue;
	
	public QueueArray(int size) {
		this.arr = new int [size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.printf("The Queue of size %d is created.\n", size);
	}
	
	public boolean isFull() {
		if(topOfQueue == arr.length-1) return true;
		return false;
	}
	
	public boolean isEmpty() {
		if(beginningOfQueue == -1 || beginningOfQueue == arr.length)return true;
		return false;
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is Full!");
			return;
		}
		else if(isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("The value has been successfully inserted.");
		}
		else {
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("The value has been successfully inserted.");
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return -1;
		}
		else {
			int result = arr[beginningOfQueue];
			beginningOfQueue++;
			if(beginningOfQueue > topOfQueue) {
				topOfQueue = -1;
				beginningOfQueue = -1;				
			}
			return result;
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!");
			return -1;
		}
		else {
			return arr[beginningOfQueue];
		}
	}
	
	public void delete() {
		arr = null;
		System.out.println("Queue is deleted");
	}
}
