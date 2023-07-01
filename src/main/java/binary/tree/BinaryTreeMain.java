package binary.tree;

public class BinaryTreeMain {
	public static void main(String[] args) {
		BinaryTreeLinkedList binaryTree = new BinaryTreeLinkedList();
		BinaryTreeNode n1 = new BinaryTreeNode();
		n1.value = "N1";
		BinaryTreeNode n2 = new BinaryTreeNode();
		n2.value = "N2";
		BinaryTreeNode n3 = new BinaryTreeNode();
		n3.value = "N3";
		BinaryTreeNode n4 = new BinaryTreeNode();
		n4.value = "N4";
		BinaryTreeNode n5 = new BinaryTreeNode();
		n5.value = "N5";
		BinaryTreeNode n6 = new BinaryTreeNode();
		n6.value = "N6";
		BinaryTreeNode n7 = new BinaryTreeNode();
		n7.value = "N7";
		BinaryTreeNode n8 = new BinaryTreeNode();
		n8.value = "N8";
		BinaryTreeNode n9 = new BinaryTreeNode();
		n9.value = "N9";
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		
		binaryTree.root = n1;
//		binaryTree.preOrder(binaryTree.root);
//		System.out.println();
//		binaryTree.inOrder(binaryTree.root);
//		System.out.println();
//		binaryTree.postOrder(binaryTree.root);
//		System.out.println();
		binaryTree.levelOrder();
		System.out.println();
//		binaryTree.search("N5");
		binaryTree.insert("N10");
		System.out.println("Deepest Node: " + binaryTree.getDeepestNode().value);
//		binaryTree.deleteDeepestNode();
		binaryTree.deleteNode("N4");
		binaryTree.levelOrder();
		binaryTree.deleteBinaryTree();
		binaryTree.levelOrder();
	}
}
