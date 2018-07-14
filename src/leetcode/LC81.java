package leetcode;

public class LC81 {
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0; 
        int right = nums.length - 1;
        while (left + 1 < right) {        	
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }
}
