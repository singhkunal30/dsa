package sorting;

public class BubbleSort {
	
	void bubbleSort(int arr[]) {
		int n = arr.length;
		boolean swap = false;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					swap = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!swap)break;
		}
	}
	
	void printArray(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			System.out.println(arr[i] + ",");
		}
	}
}
