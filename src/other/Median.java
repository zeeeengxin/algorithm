package other;

import java.util.Arrays;

public class Median {
	public double median(int[] a, int[] b) {
		int len = a.length + b.length;
	      int one = (len + 1) / 2;
	      int two = (len + 2) / 2;
	      if (len % 2 == 1) {
	           return (double) quickSelect(a, b, one, 0, len - 1);
	      } else {
	           return (quickSelect(a, b, one, 0, len - 1) + quickSelect(a, b, two, 0, len - 1)) / 2.0;
	      }
	}
	// find the kth smallest element in two arrays
	private int quickSelect(int[] a, int[] b, int k, int left, int right) {
		int pivotIndex = left + (int)Math.random() * (right - left + 1);
		int pivot = getNum(a, b, pivotIndex);
		System.out.println("index is " + pivotIndex + " pivot is " + pivot);
		swapTwoNum(a, b, pivotIndex, right);
		System.out.println("before sort, a is " + Arrays.toString(a) + " b is " + Arrays.toString(b));
		int pos = getPosition(a, b, left, right, pivot);
		System.out.println("a is " + Arrays.toString(a) + " b is " + Arrays.toString(b));
		if (pos == k - 1) {
			return getNum(a, b, pos);
		} else if (pos < k - 1) {
			return quickSelect(a, b, k, pos + 1, right);
		} else {
			return quickSelect(a, b, k, left, pos - 1);
		}
	}
	private int getPosition(int[] a, int[] b, int left, int right, int pivot) {
		int i = left;
		int j = right - 1;
		while (i <= j) {
			if (getNum(a, b, i) < pivot) {
				i++;
			} else if (getNum(a, b, j) >= pivot) {
				j--;
			} else {
				swapTwoNum(a, b, i, j);
				i++;
				j--;
			}
		}
		System.out.println("i is " + i + " right is " + right);
		swapTwoNum(a, b, i, right);
		return i;
	}
	private void swapTwoNum(int[] a, int[] b, int i, int j) {
		int iNum = getNum(a, b, i);
		setNum(a, b, i, getNum(a, b, j));
		setNum(a, b, j, iNum);
	}
	private void setNum(int[] a, int[] b, int index, int target) {
		if (index >= a.length) {
			b[index-a.length] = target;
		} else {
			a[index] = target;
		}
	}
	private int getNum(int[] a, int[] b, int index) {
		if (index >= a.length) {
			return b[index-a.length];
		} else {
			return a[index];
		}
	}

}
