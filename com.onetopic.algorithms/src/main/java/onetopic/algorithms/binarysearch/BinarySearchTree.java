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

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;

		else
			return x.size;
	}

	/**
	 * 根据根节点比左节点大，比右节点小，从根节点开始递归查找
	 * 
	 * @param param
	 * @return Value
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	public Value get(Node root, Key key) {
		if (root == null)
			return null;
		int cmp = root.key.compareTo(key);

		if (cmp == 0) {
			return root.val;
		} else if (cmp > 0) {
			return get(root.left, key);
		} else {
			return get(root.right, key);
		}
	}

	/**
	 * 插入和查询逻辑类似,从根节点开始,直到找到空连接,如果没有命中，则插入,如果命中，则替换val 值加1
	 * 
	 * @param param
	 * @return void
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {

		if (x == null) {
			return new Node(key, value, 1);
		}

		int cmp = x.key.compareTo(key);

		if (cmp > 0) {
			return put(x.left, key, value);
		} else if (cmp < 0) {
			return put(x.right, key, value);
		} else {
			x.val = value;
		}

		x.size = size(x.left) + size(x.right) + 1;

		return x;

	}

	public Key min() {
		return min(root).key;
	}

	public Node min(Node x) {
		if (x.left == null)
			return x;

		return min(x.left);
	}

	/**
	 * 小于或者等于Key的Key
	 * 
	 * @param param
	 * @return Key
	 */
	public Key floor(Key key) {
		Node x = floor(root, key);

		if (x == null)
			return null;

		return x.key;
	}

	/**
	 * 和根节点比如,如果Key比根节点小,继续往左子树找
	 * 如果比根节点大,则往右子树找,递归查找，直到在右子树找到小于或者等于key的key,如果没有,则根节点就是要找的值
	 * 
	 * @param param
	 * @return Node
	 */
	public Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);

		if (cmp < 0) {
			return floor(x.left, key);
		} else if (cmp == 0) {
			return x;
		}

		Node t = floor(x.right, key);

		if (t != null)
			return t;

		else
			return x;

	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	public Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.size = size(x.left) + size(x.right) + 1;

		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * 1、将指向即将被删除的节点的链接保存为t; 2、将x指向它的后继结点min(t.right)
	 * 3、将x的右链接（原本指向一颗所有节点都大于x,key的二叉查找树)指向deleteMin(t.right),也就是
	 * 在删除后所有节点仍然都大于x,key的子二叉查找树 
	 * 4、将x的左链接(本为空)设置为t.left(其下所有的键都小于被删除的节点和它的后续节点)
	 * 
	 * @param param
	 * @return Node
	 */
	public Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.size = size(x.left) + size(x.right) + 1;

		return x;
	}

}
