package trie;

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
		System.out.println("The Trie has been created");
	}
	
	public void insert(String word) {
		// Total 4 cases needed to be considered while inserting value in Trie
		//1. Trie is blank
		//2. New String prefix is common to another string prefix
		//3. New String's prefix is already present as complete string
		//4. New String is already present in Trie
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
		System.out.println("The word "+ word +" has been successfully inserted in Trie");
	}
}
