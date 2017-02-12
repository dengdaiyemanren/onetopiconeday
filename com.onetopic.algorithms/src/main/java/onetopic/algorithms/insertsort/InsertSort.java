package onetopic.algorithms.insertsort;

import onetopic.algorithms.common.Utils;

/**
 * 插入排序
 * 1、将每一张牌插入到其他已经有序的牌中的适合位置。
 * 2、将其余所有元素在插入之前都向右移动一位。
 * 步骤
 * 1、记住已经排好序的位置。
 * 2、取值与已经排好序的列比较，插入比他大的位置，其他元素依次向右移动一位
 * 例子：
 * 3,4,9,8
 * 步骤1:
 * 1)确定已经排好序的队列，初始为1，排序队列为3，未排序的为4,9,8
 * 2)开始查找剩下的队列中比已经排好序的比他大的值，插入它的前面，排序队列为3,4,未排序队列为9,8
 * 3)直到遍历完剩下的队列的所有值，3,4,9 | 8->3,4,8,9
 * @author yinlg
 * @created 2015年10月11日 下午11:46:16
 */
public class InsertSort
{
    public static void mysort(Comparable[] a)
    {
        
        int sortedSize = 1;
        
        int length = a.length;
        
        //剩下未排序的队列
        for (int i = 1; i < length; i++)
        {
            Comparable insertObject = a[i];
            
            int insertIndex = sortedSize;
            
            //遍历已经排好序的数组,找到比待插入元素大的位置
            for (int j = 0; j < sortedSize; j++)
            {
                if (Utils.less(insertObject, a[j]))
                {
                    // 确定好待插入的位置
                    insertIndex = j;
                    break;
                }
            }
            
            //>=insertIndex后面的已经排序序列都往后挪动一位
            for (int m = i - 1; m >= insertIndex; m--)
            {
                a[m + 1] = a[m];
                
            }
            
            a[insertIndex] = insertObject;
            
            sortedSize++;
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
