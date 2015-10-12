package onetopic.algorithms.insertsort;

import onetopic.algorithms.common.Utils;

/**
 * 插入排序
 * 1、将每一张牌插入到其他已经有序的牌中的适合位置。
 * 2、将其余所有元素在插入之前都向右移动一位。
 * 步骤
 * 1、记住已经排好序的位置。
 * 2、取值与已经排好序的列比较，插入比他大的位置，其他元素依次向右移动一位
 * 
 * @author yinlg
 * @created 2015年10月11日 下午11:46:16
 */
public class InsertSort
{
    public static void mysort(Comparable[] a)
    {
        
        int sortLength = 1;
        
        int length = a.length;
        
        for (int i = 1; i < length; i++)
        {
            Comparable insertObject = a[i];
            
            int insertIndex = sortLength;
            for (int j = 0; j < sortLength; j++)
            {
                if (Utils.less(insertObject, a[j]))
                {
                    // fix the insert index
                    insertIndex = j;
                    break;
                }
            }
            
            for (int m = i - 1; m >= insertIndex; m--)
            {
                a[m + 1] = a[m];
                
            }
            
            a[insertIndex] = insertObject;
            
            sortLength++;
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
            for (int j = i; j > 0 && Utils.less(a[j], a[j - 1]); j--)
            {
                Utils.exch(a, j, j - 1);
            }
            assert Utils.isSorted(a, 0, i);
        }
        assert Utils.isSorted(a);
    }
    
}
