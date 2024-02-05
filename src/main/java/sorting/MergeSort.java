package sorting;

public class MergeSort {
	
	static void merge(int arr[], int l, int m , int r) {
		
		int n1 = m-l+1;
		int n2 = r-m;
		
		int left[] = new int [n1];
		int right[] = new int [n2];
		
		for(int i=0; i<n1; i++) {
			left[i] = arr[l+i];
		}
		
		for (int i = 0; i < n2; i++) {
			right[i] = arr[m+1+i];
		}
		
		int i=0, j=0;
		int k =l;
		while(i<n1 && j<n2) {
			if(left[i]<right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j<n2) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
	
	static void sort(int arr[], int l, int r) {
		
		if(l<r) {
			int m = (l+r)/2;
			
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	static void printArr(int arr[]) {
		for(int i: arr) {
			System.out.print(i+ "  ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {9,2,5,3,7,3,6,4,8};
		sort(arr, 0, arr.length-1);
		printArr(arr);
		
	}

}
