package onetopic.algorithms.binarysearch;

import onetopic.algorithms.queue.Queue;

/**
 * 基于链表的顺序查找
 * 
 * @author yinlg
 * @created 2017年2月26日 下午11:39:55
 */
public class SequentialSearchST<Key, Value> {

	private int n; // number of key-value pairs
	private Node first; // the linked list of key-value pairs

	// a helper linked list data type
	private class Node {
		private Key key;
		private Value val;
		private Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public SequentialSearchST() {
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 *
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns true if this symbol table is empty.
	 *
	 * @return {@code true} if this symbol table is empty; {@code false}
	 *         otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns true if this symbol table contains the specified key.
	 *
	 * @param key
	 *            the key
	 * @return {@code true} if this symbol table contains {@code key};
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException
	 *             if {@code key} is {@code null}
	 */
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key in this symbol table.
	 *
	 * @param key
	 *            the key
	 * @return the value associated with the given key if the key is in the
	 *         symbol table and {@code null} if the key is not in the symbol
	 *         table
	 * @throws IllegalArgumentException
	 *             if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting
	 * the old value with the new value if the symbol table already contains the
	 * specified key. Deletes the specified key (and its associated value) from
	 * this symbol table if the specified value is {@code null}.
	 *
	 * @param key
	 *            the key
	 * @param val
	 *            the value
	 * @throws IllegalArgumentException
	 *             if {@code key} is {@code null}
	 */
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}

		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		n++;
	}

	/**
	 * Removes the specified key and its associated value from this symbol table
	 * (if the key is in this symbol table).
	 *
	 * @param key
	 *            the key
	 * @throws IllegalArgumentException
	 *             if {@code key} is {@code null}
	 */
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");
		first = delete(first, key);
	}

	// delete key in linked list beginning at Node x
	// warning: function call stack too large if table is large
	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		if (key.equals(x.key)) {
			n--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	/**
	 * Returns all keys in the symbol table as an {@code Iterable}. To iterate
	 * over all of the keys in the symbol table named {@code st}, use the
	 * foreach notation: {@code for (Key key : st.keys())}.
	 *
	 * @return all keys in the symbol table
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}

}
