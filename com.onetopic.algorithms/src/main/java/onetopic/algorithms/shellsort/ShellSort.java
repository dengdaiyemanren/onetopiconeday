package onetopic.algorithms.shellsort;

import onetopic.algorithms.common.Utils;

public class ShellSort {

	public static void sort(Comparable[] a) {
		// 将a[]按升序排序

		int N = a.length;

		int h = 1;

		while (h < N / 3)
			h = h * 3 + 1;
		while (h >= 1) {
			// 将数组变成h有序
			for (int i = h; i < N; i++) {
				// 将a[i] 插入到 a[i-h],a[i-2h],a[i-3*h]之中
				for (int j = i; j >= h && Utils.less(a[j], a[j - h]); j -= h)
					Utils.exch(a, j, j - h);
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {

	}

}
