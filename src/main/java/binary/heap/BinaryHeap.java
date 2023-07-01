package binary.heap;

public class BinaryHeap {
	int arr[];
	int sizeOfTree;
	
	public BinaryHeap(int size) {
		arr = new int[size+1];
		this.sizeOfTree = 0;
		System.out.println("The binary heap has been created");
	}
	
	public boolean isEmpty() {
		if(sizeOfTree == 0) return true;
		return false;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("The binary heap is empty");
			return Integer.valueOf(null);
		}
		return arr[1];
	}
	
	public int sizeOfBinaryHeap() {
		return sizeOfTree;
	}
	
	public void levelOrder() {
		for(int i=1; i<=sizeOfTree; i++) {
			System.out.println(arr[i]+ " ");
		}
		System.out.println("\n");
	}
	
	//Heapify for insert
	public void heapifyForBottomToTop(int index, String heapType) {
		int parentIndex = index/2;
		if(index <= 1) {
			return;
		}
		if(heapType == "Min") {
			if(arr[index] < arr[parentIndex]) {
				int temp = arr[parentIndex];
				arr[parentIndex] = arr[index];
				arr[index] = temp;
			}
		}
		else if(heapType == "Max") {
			if(arr[index] > arr[parentIndex]) {
				int temp = arr[parentIndex];
				arr[parentIndex] = arr[index];
				arr[index] = temp;
			}
		}
		heapifyForBottomToTop(parentIndex, heapType);
	}
	
	public void insert(int value, String typeHeap) {
		arr[sizeOfTree+1] = value;
		sizeOfTree++;
		heapifyForBottomToTop(sizeOfTree, typeHeap);
		System.out.println("The value has been successfully inserted in heap");
	}
	
	public void heapifyFromTopToBottom(int index, String heapType) {
		int left = index*2;
		int right =  index*2 + 1;
		int swapChild = left;
		if(sizeOfTree<left) {
			return;
		}
		if(heapType == "Min") {
			if(sizeOfTree == left) {
				if(arr[index] > arr[left]) {
					int temp = arr[index];
					arr[index] = arr[left];
					arr[left] = temp;
				}
				return;
			}
			else {
				if(arr[left] < arr[right])swapChild = left;
				else swapChild = right;
				if(arr[index] > arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		}
		else if(heapType == "Max") {
			if(sizeOfTree == left) {
				if(arr[index] < arr[left]) {
					int temp = arr[index];
					arr[index] = arr[left];
					arr[left] = temp;
				}
				return ;
			}
			else {
				if(arr[left] > arr[right]) swapChild = left;
				else swapChild = right;
				if(arr[index] < arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		}
		heapifyFromTopToBottom(swapChild, heapType);
	}
	
	public int extractNode(String heapType) {
		if(isEmpty()) return -1;
		int temp = arr[1];
		arr[1] = arr[sizeOfTree];
		sizeOfTree--;
		heapifyFromTopToBottom(1, heapType);
		return temp;
	}
	
	public void delete() {
		arr = null;
		System.out.println("The binary heap has been deleted");
	}
}
