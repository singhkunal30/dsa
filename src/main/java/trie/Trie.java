package trie;

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
		System.out.println("The Trie has been created");
	}
	
//	public void insert(String word) {
//		// Total 4 cases needed to be considered while inserting value in Trie
//		//1. Trie is blank
//		//2. New String prefix is common to another string prefix
//		//3. New String's prefix is already present as complete string
//		//4. New String is already present in Trie
//		TrieNode current = root;
//		for(int i=0; i<word.length(); i++) {
//			char ch = word.charAt(i);
//			TrieNode node = current.children.get(ch);
//			if(node == null) {
//				node = new TrieNode();
//				current.children.put(ch, node);
//			}
//			current = node;
//		}
//		current.endOfString = true;
//		System.out.println("The word "+ word +" has been successfully inserted in Trie");
//	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
		System.out.println("The word: "+ word +" has been successfully inserted into Trie ");
	}
	
	public boolean search(String word) {
		// Total 3 cases
		//1. String does not exist in Trie
		//2. String exists in Trie
		//3. String is a prefix of another String but it does not exist in a Trie
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null) {
				System.out.println("The word does not exist in Trie");
				return false;
			}
			current = node;
		}
		if(current.endOfString == true) {
			System.out.println("The word "+ word +" exist in Trie");
			return true;
		}
		else {
			System.out.println("The word "+ word +" does not exist in Trie but prefix of another word");
		}
		return current.endOfString;
	}
	
	public boolean deleteWord(TrieNode parentNode, String word, int index) {
		//Totat 4 cases
		//1. Some other prefix of string is same as the one that we want to delete(API, APPLE)
		//2. String is prefix of another string (API, APIS)
		//3. Other String is a prefix of this string (APIS, AP)
		//4. Not any node depends on this String(K);
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		if(currentNode.children.size()>1) {
			deleteWord(currentNode, word, index+1);
			return false;
		}
		if(index == word.length()-1) {
			if(currentNode.children.size()>=1) {
				currentNode.endOfString =false;
				return false;
			}
			else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		if(currentNode.endOfString) {
			deleteWord(currentNode, word, index+1);
			return false;
		}
		canThisNodeBeDeleted = deleteWord(currentNode, word, index+1);
		if(canThisNodeBeDeleted) {
			parentNode.children.remove(ch);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void delete(String word) {
		if(search(word) == true) {
			deleteWord(root, word, 0);
		}
	}
}
