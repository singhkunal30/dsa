package hashing;

public class DoubleHashingMain {
	
	public static void main(String[] args) {
		DoubleHashing doubleHashing = new DoubleHashing(10);
		doubleHashing.insert("THE");
		doubleHashing.insert("Fox");
		doubleHashing.insert("is");
		doubleHashing.insert("dead");
	}

}
