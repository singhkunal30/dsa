package hashing;

import java.util.ArrayList;

public class DoubleHashing {
	String[] hashTable;
	int usedCellNumber;
	
	DoubleHashing(int size){
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
			int x = modASCIIHashFunction(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for(int i=0; i<hashTable.length;i++) {
				int newIndex = (x+i*y)%hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word + " has been inserted successfully");
					break;
				}
				else {
					System.out.println(newIndex+" is already occupied.");
				}
			}
			usedCellNumber++;
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
	
	public int addAllDigitsTogether(int sum) {
		int value =0;
		while(sum>0) {
			value = sum%10;
			sum = sum/10;
		}
		return value;
	}
	
	public int secondHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int i, sum;
		for(sum=0, i=0; i<x.length(); i++) {
			sum += ch[i];
		}
		while(sum > hashTable.length) {
			sum = addAllDigitsTogether(sum);
		}
		return sum%M;
	}
}
