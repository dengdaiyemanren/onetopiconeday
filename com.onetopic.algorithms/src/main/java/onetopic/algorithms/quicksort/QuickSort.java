package onetopic.algorithms.quicksort;

import onetopic.algorithms.common.StdIn;
import onetopic.algorithms.common.StdOut;
import onetopic.algorithms.common.StdRandom;
import onetopic.algorithms.common.Utils;
import onetopic.algorithms.mergesort.MergeSort;

/**
 * 快速排序算法
 * @author yinlg
 * @created 2016年12月3日 下午10:59:03
 */
public class QuickSort {
	
	public void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	public void sort(Comparable[] a, int low, int high) {

		if(high<= low) return;
		
		int j = partition(a,low,high);
		
		sort(a,low,j-1);
		sort(a,j,high);
		
	}
	
	/**
	 * 分割方法，以第一个元素	v做为参考，分成两部分，第一份<=v,第二部分>=v,返回v移动后的坐标
	 * 
	 * 示例：
	 * 初始值：d, f, a, b,h,k
	 * d -> f,a,b,h,k
	 * 从low+1开始扫描选出第一个比d大的元素f,从high开始扫描选出比d小的元素b
	 * 交换f,b ,结果d,b,a,f,h,k,i=1,j=3
	 * 继续从i+1,j-1开始扫描，扫描出i=2,j=2,退出，得结果d,b,a,f,h,k,把low =0 与i=2交换，得出a,b,d,f,h,k,有序排序。
	 * @param Comparable []
	 * @param low int
	 * @param high int
	 * @return int
	 */
	public int partition(Comparable [] a,int low, int high)
	{
		Comparable k = a[low];//切分元素
		int pos=low;
		int i = low;
		int j = high+1 ;
		
		while(true)
		{
			
			while(Utils.less(a[++i], k))
			if(i == high) break;
			
			while(Utils.less(k, a[--j]))
			if(j == low) break;
			if(i>=j) break;
			
			//调换位置
			Utils.exch(a, i, j);
		}
		
		//把第一个元素调换位置
		Utils.exch(a, pos, j);
		
		return i;
	}

	public static void main(String[] args) {
		
		QuickSort quickSort = new QuickSort();
		
		String[] oriStr = new String[]{"d","b","c","f"};
        MergeSort.sort(oriStr);
        
        for(int i=0;i<oriStr.length;i++)
        {
        	System.out.println(oriStr[i]);
        }

	}

}
