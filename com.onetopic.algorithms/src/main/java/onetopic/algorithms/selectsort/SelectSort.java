package onetopic.algorithms.selectsort;

import java.util.Comparator;

import onetopic.algorithms.common.Utils;

/**
 * 选择排序
 * 1、首先找到数组中最小的元素
 * 2、把他和第一个元素交互位置，(如何第一个是最小的，那就和自己交换)
 * 3、再次，在剩下的元素中找到最小的元素，将他和第二个元素交换位置
 * 
 * @author yinlg
 * @created 2015年10月11日 下午9:26:31
 */
public class SelectSort
{
    private SelectSort()
    {
        
    }
    
    public static void mysort(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int rightmin = i;
            
            for (int j = i + 1; j < a.length; j++)
            {
                if (Utils.less(a[j], a[rightmin]))
                {
                    rightmin = j;
                }
            }
            
            if (Utils.less(a[rightmin], a[i]))
            {
                Utils.exch(a, rightmin, i);
            }
        }
        
    }
    
    /**
     * Rearranges the array in ascending order, using the natural order.
     * 
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i + 1; j < N; j++)
            {
                if (Utils.less(a[j], a[min]))
                    min = j;
            }
            Utils.exch(a, i, min);
            assert Utils.isSorted(a, 0, i);
        }
        assert Utils.isSorted(a);
    }
    
    /**
     * Rearranges the array in ascending order, using a comparator.
     * 
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i + 1; j < N; j++)
            {
                if (Utils.less(c, a[j], a[min]))
                    min = j;
            }
            Utils.exch(a, i, min);
            assert Utils.isSorted(a, c, 0, i);
        }
        assert Utils.isSorted(a, c);
    }
    
   
    
   
    
}
