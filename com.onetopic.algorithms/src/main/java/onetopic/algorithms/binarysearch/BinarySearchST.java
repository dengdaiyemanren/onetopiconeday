package onetopic.algorithms.binarysearch;

import java.util.NoSuchElementException;

import onetopic.algorithms.queue.Queue;

/**
 * 有序表的二分查找
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
     * 查找小于key的数量
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
			int mid = low + ( hi-low) / 2;

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
	
    /**
     * 如果val为null,及时删除，保证不存在空值
     * 找到key合适的位置，插入，其他的key往后移动
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) 
    {
    	if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 
    	if (val == null) {
            delete(key);
            return;
        }
    	
    	int i = rank(key);
    	
    	//如果已经在key里面
    	if(i < n && keys[i].compareTo(key) == 0)
    	{
    		vals[i] =val;
    		return;
    	}
    	
    	// insert new key-value pair
        if (n == keys.length) resize(2*keys.length);
    	
        for(int j =n;j>i;j--)
        {
        	keys[j] = keys[j-1];
        	vals[j] = vals[j-1];
        }
        
       keys[i] = key;
       vals[i] = val;
       n++;
       
    }
    
    public void delete(Key key) 
    {
    	if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;
        // compute rank
        int i = rank(key);
        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);
        
        
    }
    
    /**
     * Removes the smallest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }
    
    /**
     * Removes the largest key and associated value from this symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }
    
    /**
     * Returns the smallest key in this symbol table.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0]; 
    }
    
    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }
    
    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    
    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null"); 
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }
    
    /**
    * Returns the smallest key in this symbol table greater than or equal to {@code key}.
    *
    * @param  key the key
    * @return the smallest key in this symbol table greater than or equal to {@code key}
    * @throws NoSuchElementException if there is no such key
    * @throws IllegalArgumentException if {@code key} is {@code null}
    */
   public Key ceiling(Key key) {
       if (key == null) throw new IllegalArgumentException("argument to ceiling() is null"); 
       int i = rank(key);
       if (i == n) return null; 
       else return keys[i];
   }
   
   /**
    * Returns the number of keys in this symbol table in the specified range.
    *
    * @param lo minimum endpoint
    * @param hi maximum endpoint
    * @return the number of keys in this symbol table between {@code lo} 
    *         (inclusive) and {@code hi} (inclusive)
    * @throws IllegalArgumentException if either {@code lo} or {@code hi}
    *         is {@code null}
    */
   public int size(Key lo, Key hi) {
       if (lo == null) throw new IllegalArgumentException("first argument to size() is null"); 
       if (hi == null) throw new IllegalArgumentException("second argument to size() is null"); 

       if (lo.compareTo(hi) > 0) return 0;
       if (contains(hi)) return rank(hi) - rank(lo) + 1;
       else              return rank(hi) - rank(lo);
   }
   
   /**
    * Returns all keys in this symbol table in the given range,
    * as an {@code Iterable}.
    *
    * @param lo minimum endpoint
    * @param hi maximum endpoint
    * @return all keys in this symbol table between {@code lo} 
    *         (inclusive) and {@code hi} (inclusive)
    * @throws IllegalArgumentException if either {@code lo} or {@code hi}
    *         is {@code null}
    */
   public Iterable<Key> keys(Key lo, Key hi) {
       if (lo == null) throw new IllegalArgumentException("first argument to keys() is null"); 
       if (hi == null) throw new IllegalArgumentException("second argument to keys() is null"); 

       Queue<Key> queue = new Queue<Key>(); 
       if (lo.compareTo(hi) > 0) return queue;
       for (int i = rank(lo); i < rank(hi); i++) 
           queue.enqueue(keys[i]);
       if (contains(hi)) queue.enqueue(keys[rank(hi)]);
       return queue; 
   }
   
   /**
    * Returns all keys in this symbol table as an {@code Iterable}.
    * To iterate over all of the keys in the symbol table named {@code st},
    * use the foreach notation: {@code for (Key key : st.keys())}.
    *
    * @return all keys in this symbol table
    */
   public Iterable<Key> keys() {
       return keys(min(), max());
   }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
