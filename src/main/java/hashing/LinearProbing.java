package hashing;

import java.util.ArrayList;

public class LinearProbing {
	String[] hashTable;
	int usedCellNumber;
	
	LinearProbing(int size){
		hashTable = new String[size];
		usedCellNumber = 0;
	}
	
	public int modASCIIHashFunction(String word, int M) {
		char ch[];
		ch = word.toCharArray();
		int i, sum;
		for(sum=0, i=0; i<word.length(); i++) {
			sum = sum +ch[i];
		}
		return sum%M;
	}
	
	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1/hashTable.length;
		return loadFactor;
	}
	
	//Rehash
	
	public void rehashKeys(String word) {
		usedCellNumber = 0;
		ArrayList<String> data = new ArrayList<>();
		for(String s: hashTable) {
			if(s != null) {
				data.add(s);
			}
		}		
		data.add(word);
		hashTable = new String[hashTable.length*2];
		for(String otherS : data) {
			//Insert in Hash Table
			insert(otherS);
		}
	}
	
	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehashKeys(word);
		}
		else {
			int index = modASCIIHashFunction(word, hashTable.length);
			for(int i = index; i<index+hashTable.length; i++) {
				int newIndex = i % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("Inserted successfully");
					break;
				}
				else {
					System.out.println("Index is already occupied");
				}
			}
		}
		usedCellNumber++;
	}
	
	public boolean searchHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for(int i=index; i<index+hashTable.length; i++) {
			int newIndex = i% hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println("Found at location: "+ newIndex);
				return true;
			}
		}
		return false;
	}
	
	public void delete(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for(int i = index; i<index+hashTable.length; i++) {
			int newIndex = i% hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println("Deleted Successfully");
				return;
			}
		}
		System.out.println("Not found");
	}
}
