package hashing;

import java.util.ArrayList;

public class QuadraticProbing {
	String[] hashTable;
	int usedCellNumber;
	
	QuadraticProbing(int size){
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
		if(loadFactor>=0.75) {
			rehashKeys(word);
		}
		else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int counter = 0;
			for(int i=index; i<index+hashTable.length;i++) {
				int newIndex = (index + (counter*counter))%hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word + " has been inserted successfully");
					break;
				}
				else {
					System.out.println(newIndex+" is already occupied.");
				}
			}
			counter++;
		}
	}
	
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("hashTable does not exists");
			return;
		}
		else {
			System.out.println("-----HashTable------");
			for(int i=0; i<hashTable.length; i++) {
				System.out.println("Index "+ i + ", key: " + hashTable[i]);
			}
		}
	}
}
