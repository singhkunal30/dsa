package sorting;

import binary.heap.BinaryHeap;

public class HeapSort {
	
	int [] arr = null;
	
	public HeapSort(int [] arr) {
		this.arr = arr;
	}
	
	public void sort() {
		BinaryHeap bh = new BinaryHeap(arr.length);
		for(int i=0; i<arr.length; i++) {
			bh.insert(arr[i], "Min");
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = bh.extractNode("Min");
		}
	}
	
	void printArr() {
		for(int i: arr) {
			System.out.print(i+ "  ");
		}
	}	
	
	public static void main(String[] args) {
		int arr[] = {2,7,3,1,4,8,9};
		HeapSort hs = new HeapSort(arr);
		hs.sort();
		hs.printArr();
	}
}
