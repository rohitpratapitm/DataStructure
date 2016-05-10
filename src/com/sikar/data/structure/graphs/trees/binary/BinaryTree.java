package com.sikar.data.structure.graphs.trees.binary;

class Node {

	private Node leftChild;

	private Node rightChild;

	private int data;

	public Node(int data) {

		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(int leftChild) {
		this.leftChild = new Node(leftChild);
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(int rightChild) {
		this.rightChild = new Node(rightChild);
	}
}

public class BinaryTree {

	private Node mRoot;

	public BinaryTree(int aData) {

		this.mRoot = new Node(aData);
	}

	public void addNode(int key, String value) {

	}

	// This is nothing but REVERSE INORDER traversal
	public void swapNodeWithAllTheGreaterValues(Node node) {

	}

	public void bfs(Node root) {

	}

	public boolean isBinarySearchTree(Node aNode) {
		
		return false;
	}

	//TODO Print Left view, right view, top view and botto view.
	
	//TODO Print Corner Nodes
	
	//TODO BFS,DFS
	// In the sorted order...smallest first(left most), then parent , then right
	// etc.
	public void inOrderTraversal(Node focusNode) {

		if (focusNode != null) {

			inOrderTraversal(focusNode.getLeftChild());

			System.out.println(focusNode);

			inOrderTraversal(focusNode.getRightChild());
		}
	}

	// without sorting
	public void preOrderTraversal(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preOrderTraversal(focusNode.getLeftChild());

			preOrderTraversal(focusNode.getRightChild());
		}
	}

	//
	public void postOrderTraversal(Node focusNode) {

		if (focusNode != null) {

			postOrderTraversal(focusNode.getLeftChild());

			postOrderTraversal(focusNode.getRightChild());

			System.out.println(focusNode);
		}
	}

	public int checkHeight(Node aNode) {

		if (aNode == null) {
			return 0;
		}

		int heightOfLeftSubTree = checkHeight(aNode.getLeftChild());
		if (heightOfLeftSubTree == -1) {
			return -1;
		}

		int heightOfRightSubTree = checkHeight(aNode.getRightChild());
		if (heightOfRightSubTree == -1) {
			return -1;
		}

		// compare if height of left subtree and right subtree is less than 1
		int diff = heightOfLeftSubTree - heightOfRightSubTree;

		if (Math.abs(diff) > 1) {
			return -1;
		} else {// get the height, add +1 for root
			return Math.max(heightOfLeftSubTree, heightOfRightSubTree) + 1;
		}
	}

	/**
	 * A tree is a binary tree when difference between the height of left
	 * subtree and right sub tree is MAXIMUM 1.
	 * 
	 * @param aNode
	 * @return
	 */
	public boolean isBinaryTree(Node aNode) {

		if (checkHeight(aNode) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String args[]) {

		BinaryTree binaryTree = new BinaryTree(20);

		binaryTree.mRoot.setLeftChild(10);
		binaryTree.mRoot.setRightChild(30);

		binaryTree.mRoot.getRightChild().setRightChild(50);

		binaryTree.mRoot.getLeftChild().setLeftChild(9);
		binaryTree.mRoot.getLeftChild().setRightChild(11);

		binaryTree.mRoot.getLeftChild().getRightChild().setLeftChild(8);

		// binaryTree.mRoot.getLeftChild().getLeftChild().getLeftChild().setLeftChild(6);

		binaryTree.mRoot.getLeftChild().getRightChild().getLeftChild().setRightChild(7);

		System.out.println(binaryTree.isBinaryTree(binaryTree.mRoot));
	}
}
