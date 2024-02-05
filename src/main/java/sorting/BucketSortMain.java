package sorting;

public class BucketSortMain {
	
	public static void main(String[] args) {
		int arr[] = {9,7,5,4,2,1,3,6,8};
		BucketSort bs = new BucketSort(arr);
		bs.printArray(arr);
		bs.bucketSort();
		bs.printArray(arr);
	}
}
