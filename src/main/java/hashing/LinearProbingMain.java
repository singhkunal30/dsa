package hashing;

public class LinearProbingMain {

	public static void main(String[] args) {
		LinearProbing linearProbing = new LinearProbing(13);
		linearProbing.insert("The");
		linearProbing.insert("quick");
		linearProbing.insert("brown");
		linearProbing.insert("fox");
		linearProbing.insert("over");
		linearProbing.searchHashTable("The");
		linearProbing.delete("The");
	}

}
