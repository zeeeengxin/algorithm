package leetcode;

public class LC4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int one = (len + 1) / 2;
        int two = (len + 2) / 2;
        if (len % 2 == 1) {
            return helper(nums1, nums2, one);
        } else {
            return (helper(nums1, nums2, one) + helper(nums1, nums2, two)) / 2.0;
        }
    }
    private static int helper(int[] nums1, int[] nums2, int k) {
    	System.out.println("initial k is " + k);
        int left1 = 0;
        int left2 = 0;
        while (left1 < nums1.length && left2 < nums2.length) {
            if (k == 1) {
            	if (nums1[left1] < nums2[left2]) {
            		System.out.println("return " + nums1[left1]);
            		return nums1[left1];
            	} else {
            		System.out.println("return " + nums2[left2]);
            		return nums2[left2];
            	}
            }
            int mid1 = Integer.MAX_VALUE;
            int mid2 = Integer.MAX_VALUE;
            if (left1 + k / 2 - 1 < nums1.length) {
                mid1 = nums1[left1 + k / 2 - 1];
            }
            if (left2 + k - k / 2 - 1 < nums2.length) {
                mid2 = nums2[left2 + k - k / 2 - 1];
            }
            if (mid1 < mid2) {
                left1 = left1 + k / 2;
                k = k - k / 2;
            } else {
                left2 = left2 + k - k / 2;
                k = k / 2;
            }
            System.out.println("k is " + k);
            System.out.println("left1 is " + left1 + " mid1 is " + mid1);
            System.out.println("left2 is " + left2 + " mid2 is " + mid2);
        }
        if (left1 < nums1.length) {
    		System.out.println("return " + nums1[left1 + k - 1]);
            return nums1[left1 + k - 1];
        } else {
    		System.out.println("return " + nums2[left2 + k - 1]);
            return nums2[left2 + k - 1];
        }
    }
}
