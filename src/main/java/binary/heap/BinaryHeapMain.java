package binary.heap;

public class BinaryHeapMain {
	public static void main(String[] args) {
		BinaryHeap newBP = new BinaryHeap(5);
		newBP.insert(10, "Min");
		newBP.insert(5, "Min");
		newBP.insert(15, "Min");
//		newBP.insert(20, "Min");
		newBP.insert(1, "Min");
		newBP.levelOrder();
		newBP.extractNode("Min");
		newBP.levelOrder();
		newBP.delete();
	}
}
