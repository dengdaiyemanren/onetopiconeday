package onetopic.algorithms.binarysearch;

/**
 * 二分查找
 * 
 * @author yinlg
 * @created 2017年2月26日 上午8:32:17
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	//初始容量
	private static final int INIT_CAPACITY = 2;
	
	//key的数组
	private Key[] keys;
	//value的数组
	private Value[] vals;
	
	//size的大小
	private int n = 0;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}
		
	 /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }  
	
    /**
     *  重置
     * @param param 新数组大小capacity >n
     * @return void
     */
    private void resize(int capacity)
    {
    	assert capacity >= n;
    	
    	Key[] tempK = (Key[]) new Comparable[capacity];
    	Value[] tempV = (Value[]) new Comparable[capacity];
    	
    	for(int i=0;i<n;i++)
    	{
    		tempK[i] = keys[i];
    		tempV[i] = vals[i];
    	}
    	
    	keys = tempK;
    	vals = tempV;
    }
   
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size()
    {
        return n;
    }
	
    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    
    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (isEmpty()) return null;
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) 
        	return vals[i];
        return null;
    } 
    
    /**
     * 查找小于key的索引
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key)
    {
    	if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 
    	
    	int low = 0,hi = n -1;
    	
		while (low <= hi) {
			int mid = low + (low + hi) / 2;

			int cmp = key.compareTo(keys[mid]);

			// key > keys[mid],low = mid+1
			if (cmp > 0) {
				low = mid + 1;
			}
			// key < keys[mid],hi = mid-1
			else if (cmp < 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
    	
    	return low;
    }
	
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
