package leetcode;
import java.util.*;
public class LC46 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, res, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int n : nums) {
                cur.add(n);
            }
            res.add(cur);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, res, index + 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
