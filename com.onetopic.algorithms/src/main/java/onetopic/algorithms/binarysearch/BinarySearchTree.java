package onetopic.algorithms.binarysearch;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root; // root of BST

	private class Node {
		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int size; // number of nodes in subtree

		public Node(Key key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

}
