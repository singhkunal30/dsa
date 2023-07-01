package binart.search.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeLL {
	BinaryNode root = new BinaryNode();
	
	public BinarySearchTreeLL() {
		this.root = null;
	}
	
	public BinaryNode insert(BinaryNode presentNode, int value) {
		if(presentNode == null) {
			BinaryNode node = new BinaryNode();
			node.value = value;
//			System.out.println("The value has been inserted");
			return node;
		}
		else if(value <= presentNode.value) {
			presentNode.left = insert(presentNode.left, value);
			return presentNode;
		}
		else{
			presentNode.right = insert(presentNode.right, value);
			return presentNode;
		}
	}
	
	void insert(int value) {
		root = insert(root, value);
	}
	
	public void preOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	public void postOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if(presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}
	
	public void search(BinaryNode presentNode, int value) {
		if(presentNode == null) {
			System.out.println("The value is not present in the tree");
			return;
		}
		if(value == presentNode.value) {
			System.out.println("The value has been found in the tree");
			return;
		}
		else if(value> presentNode.value) {
			search(presentNode.right, value);
		}
		else {
			search(presentNode.left, value);
		}	
	}
	
	public static BinaryNode minimumNode(BinaryNode root) {
		if(root.left == null) {
			return root;
		}
		else {
			return minimumNode(root.left);
		}
	}
	
	public BinaryNode deleteNode(BinaryNode root, int value) {
		if(root == null) {
			System.out.println("The value not found in tree");
			return null;
		}
		if(value < root.value) {
			root.left = deleteNode(root.left, value);
		}
		else if (value > root.value){
			root.right = deleteNode(root.right, value);
		}
		else {
			if(root.left != null && root.right != null) {
				BinaryNode minNodeForRight = minimumNode(root.right);
				root.value = minNodeForRight.value;
				root.right = deleteNode(root.right, minNodeForRight.value);
			}
			else if(root.left != null){
				root = root.left;
			}
			else if(root.right != null) {
				root = root.right;
				return null;
			}
		}
		return root;
	}
	
	public void delete() {
		root = null;
		System.out.println("The binary tree has been deleted successfully");
	}
}
