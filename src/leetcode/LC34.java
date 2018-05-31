package leetcode;

public class LC34 {
	public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length < 1) return res;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
        }
        if (nums[left] != target) return res;
        res[0] = left;
        right = nums.length - 1; // just start from first occur
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid;
            else if (nums[mid] > target) right = mid;
        }
        if (nums[right] == target) {
            res[1] = right;
        } else if (nums[left] == target) {
            res[1] = left;
        }
        return res;
    }
}
