package queue;

public class CircularQueueArray {
	int [] arr;
	int topOfQueue;
	int beginningOfQueue;
	int size;
	
	public CircularQueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		this.size = size;
		System.out.printf("The queue has been successfuly created of size: %d\n", size);
	}
	
	public boolean isEmpty() {
		if(topOfQueue == -1) return true;
		else return false;
	}
	
	public boolean isFull() {
		if(topOfQueue+1 == size && beginningOfQueue == 0)return true;
		else if(topOfQueue+1 == beginningOfQueue) return true;
		else return false;		
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("The queue is Full!");
			return;
		}
		else if(isEmpty()) {
			beginningOfQueue++;
			topOfQueue++;
			arr[topOfQueue] =value;
			System.out.println("The value has been successfully inserted.");
		}
		else {
			if(topOfQueue+1 == size) topOfQueue = 0;
			else topOfQueue++;
			arr[topOfQueue] =value;
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
			arr[beginningOfQueue] =0;
			if(beginningOfQueue == topOfQueue) {
				beginningOfQueue = -1;
				topOfQueue = -1;
			}
			else if(beginningOfQueue+1 == size) {
				beginningOfQueue = 0;
			}
			else beginningOfQueue++;
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
		arr= null;
		System.out.println("The queue has been successfully deleted.");
	}
}