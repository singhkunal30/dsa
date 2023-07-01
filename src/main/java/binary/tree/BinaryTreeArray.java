package binary.tree;

public class BinaryTreeArray {
	String [] arr;
	int lastIndexUsed;
	
	public BinaryTreeArray(int size) {
		arr = new String [size+1];
		this.lastIndexUsed =0;
		System.out.println("Blank binary Tree of size "+size+" has been created");
	}
	
	boolean isFull() {
		if(arr.length-1 == lastIndexUsed)return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	void insert(String value) {
		if(!isFull()) {
			arr[lastIndexUsed+1] = value;
			lastIndexUsed++;
			System.out.println("The value "+value+" has been inserted");
		}
		else {
			System.out.println("The binary tree is full");
		}
	}
	
	void preOrder(int index) {
		if(index >lastIndexUsed) {
			return;
		}
		System.out.println(arr[index]+" ");
		preOrder(index*2);
		preOrder(index*2+1);
	}
	
	void inOrder(int index) {
		if(index>lastIndexUsed)return;
		inOrder(index*2);
		System.out.println(arr[index]+" ");		
		inOrder(index*2+1);
	}
	
	void postOrder(int index) {
		if(index>lastIndexUsed)return;
		preOrder(index*2);
		preOrder(index*2+1);	
		System.out.println(arr[index]+" ");	
	}
	
	void levelOrder() {
		for(int i=0; i<lastIndexUsed; i++) {
			System.out.println(arr[i]+" ");
		}
	}
	
	public int search(String value) {
		for(int i=0; i<lastIndexUsed; i++) {
			if(value == arr[i]) {
				System.out.println("The value found at index: "+ i);
				return i;
			}
		}
		System.out.println("The value not found in BT");
		return -1;
	}
	
	public void deleteNode(String value) {
		int location = search(value);
		if(location == -1) return;
		arr[location] = arr[lastIndexUsed];
		lastIndexUsed--;
		System.out.println("The node has been deleted successfully");
	}
	
	public void delete() {
		try {
			arr = null;
			System.out.println("The array has been deleted");
		} catch (Exception e) {
			System.out.println("There was some error while deleting the binary tree");
		}
	}
	
}
