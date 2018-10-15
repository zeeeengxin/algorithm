package leetcode;
import java.util.*;

public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || k > 9 || n < 1) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[9];
        helper(visited, 0, k, 0, cur, res, n);
        return res;
    }
    private void helper(boolean[] visited, int index, int k, int pre, List<Integer> cur, List<List<Integer>> res, int target) {
        if (index == k - 1) {
            if (target <= 9 && !visited[target - 1]) {
                cur.add(target);
                res.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        for (int i = pre + 1; i <= 9; i++) {
            if (!visited[i - 1] && target - i > i) {
                visited[i - 1] = true;
                cur.add(i);
                helper(visited, index + 1, k, i, cur, res, target - i);
                visited[i - 1] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
