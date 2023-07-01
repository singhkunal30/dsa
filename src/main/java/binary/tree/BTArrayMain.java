package binary.tree;

public class BTArrayMain {
	public static void main(String[] args) {
		BinaryTreeArray bt = new BinaryTreeArray(10);
		bt.insert("N1");
		bt.insert("N2");
		bt.insert("N3");
		bt.insert("N4");
		bt.insert("N5");
		bt.insert("N6");
		bt.insert("N7");
		bt.insert("N8");
		bt.insert("N9");
		bt.insert("N10");
		bt.insert("N11");
//		bt.preOrder(1);
//		bt.inOrder(1);
		bt.postOrder(1);
	}
}
