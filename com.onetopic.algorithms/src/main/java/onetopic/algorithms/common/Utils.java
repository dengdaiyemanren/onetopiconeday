package onetopic.algorithms.common;

import java.util.Comparator;

public class Utils
{
    
    /***************************************************************************
     * Check if array is sorted - useful for debugging.
     ***************************************************************************/
    
    // is the array a[] sorted?
    public static boolean isSorted(Comparable[] a)
    {
        return isSorted(a, 0, a.length - 1);
    }
    
    // is the array sorted from a[lo] to a[hi]
    public static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }
    
    // is the array a[] sorted?
    public static boolean isSorted(Object[] a, Comparator c)
    {
        return isSorted(a, c, 0, a.length - 1);
    }
    
    // is the array sorted from a[lo] to a[hi]
    public static boolean isSorted(Object[] a, Comparator c, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i - 1]))
                return false;
        return true;
    }
    
    /***************************************************************************
     * Helper sorting functions.
     ***************************************************************************/
    
    // is v < w ?
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    
    // is v < w ?
    public static boolean less(Comparator c, Object v, Object w)
    {
        return c.compare(v, w) < 0;
    }
    
    // exchange a[i] and a[j]
    public static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    
    
}
