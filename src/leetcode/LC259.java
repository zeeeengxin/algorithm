package leetcode;
import java.util.Arrays;

public class LC259 {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            //if (nums[i] + nums[i+1] >= target) break; can't do this!!! [-4, -2, -1] negative nums!!!
            int end = len - 1;
            for (int j = i + 1; j < len - 1; j++) {
                //if (nums[i] + nums[j] >= target) break;
                int index = get(target - nums[i] - nums[j], nums, j + 1, end);
                res += index - j;
                if (index - j == 0) break;
                end = index;
            }
        }
        return res;
    }
    private int get(int target, int[] arr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
