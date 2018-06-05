package leetcode;
import java.util.*;
public class LC40 {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtracking(candidates, target, res, cur, 0);
        return res;
    }
    private static void backtracking(int[] array, int target, List<List<Integer>> res, List<Integer> cur, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
		    return;
        }
        for (int i = index; i < array.length && target >= array[i]; i++) {
            if (i > index && array[i] == array[i-1]) continue;
            cur.add(array[i]);            
            backtracking(array, target - array[i], res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
