package hashing;

public class DirectChainingMain {
	
	public static void main(String[] args) {
		DirectChaining directChaining = new DirectChaining(15);
		directChaining.insertHashTable("The");
		directChaining.insertHashTable("quick");
		directChaining.insertHashTable("brown");
		directChaining.insertHashTable("fox");
		directChaining.insertHashTable("over");
		directChaining.displayHashTable();
		directChaining.searchHashTable("fox");
		directChaining.deleteKeyHashTable("The");
		System.out.println("------------------------------");
		directChaining.displayHashTable();
	}
	
	
}
