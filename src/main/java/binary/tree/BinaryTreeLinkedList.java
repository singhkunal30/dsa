package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {
	
	BinaryTreeNode root;
	
	public BinaryTreeLinkedList() {
		this.root = null;
	}
	
	void preOrder(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	void inOrder(BinaryTreeNode node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	void postOrder(BinaryTreeNode node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	void levelOrder() {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if(presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}
	
	void search(String value) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode presentNode = queue.remove();
			if(presentNode.value == value) {
				System.out.println("The value "+value+" is present in the tree");
				return;
			}
			else {
				if(presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if(presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println("The value "+value+" is not present in the tree");
	}
	
	void insert(String value) {
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;
		if(root == null) {
			root = node;
			System.out.println("Inserted new node");
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode presentNode = queue.remove();
			if(presentNode.left == null) {
				presentNode.left = node;
				System.out.println("Inserted new node");
				break;
			}
			else if(presentNode.right == null) {
				presentNode.right = node;
				System.out.println("Inserted new node");
				break;
			}
			else {
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}
	}
	
	BinaryTreeNode getDeepestNode() {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		return presentNode;
	}
	
	void deleteDeepestNode() {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode previousNode, presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.left == null) {
				previousNode.right = null;
				return;
			}
			else if(presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}
	
	void deleteNode(String value) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.value == value) {
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("The node is deleted");
				return;
			}
			else {
				if(presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if(presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println("THe node does not exist in this binary tree");
	}
	
	void deleteBinaryTree() {
		root = null;
		System.out.println("The binary tree has been successfully deleted");
	}
}