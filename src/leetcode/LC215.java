package leetcode;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int pivotIndex = (int)(Math.random() * (end - start + 1)) + start;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
            } else if (nums[right] >= pivot) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        swap(nums, left, end);
        if (left == nums.length - k) {
            return nums[left];
        }
        if (left < nums.length - k) {
            System.out.println("call quickselect " + (left + 1) + ", " + end);
            return quickSelect(nums, k, left + 1, end);
        }
        System.out.println("call quickselect " + start + ", " + (left - 1));
        return quickSelect(nums, k, start, left - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
