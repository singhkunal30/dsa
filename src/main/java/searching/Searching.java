package searching;

public class Searching {
	
	static int linearSearch(int [] arr, int value) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == value) {
				System.out.println("Value found at "+ i +" position");
				return 1;
			}
		}
		System.out.println("Value not found");
		return -1;
	}
	
	static int binarySearch(int [] arr, int value) {
		int start = 0;
		int end = arr.length-1;
		int middle = (start+end)/2;
		
		while(arr[middle]!=value && start<=end) {
			if(value<arr[middle]) {
				end=middle-1;
			}
			else {
				start = middle+1;
			}
			middle = (start+end)/2;
		}
		if(arr[middle] ==value) {
			System.out.println("Value found at "+ middle +" position");
			return middle;
		}else {
			System.out.println("Value not found");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,4,5,6,8,10,24,53};
		binarySearch(arr, 11);
	}

}
