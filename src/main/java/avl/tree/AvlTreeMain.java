package avl.tree;

public class AvlTreeMain {
	public static void main(String[] args) {
		AvlTree avl = new AvlTree();
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		avl.insert(20);
		avl.levelOrder();
	}

}
