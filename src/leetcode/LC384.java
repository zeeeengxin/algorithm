package leetcode;
import java.util.*;
public class LC384 {
    int[] nums;
    public LC384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = Arrays.copyOf(this.nums, this.nums.length);
        for (int i = res.length - 1; i >= 0; i--) {
            int index = (int)(Math.random() * (i + 1));
            int tmp = res[index];
            res[index] = res[i];
            res[i] = tmp;
        }
        return res;
    }
}
