package queue;

public class Main {
	public static void main(String[] args) {
		QueueArray q = new QueueArray(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		q.enqueue(8);
		System.out.println(q.isFull());
	}	
}
