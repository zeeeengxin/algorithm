package leetcode;
import java.util.*;

public class LC131 {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        boolean[][] isP = new boolean[s.length()][s.length()];
        getP(isP, s);
        List<String> cur = new ArrayList<>();
        backtracking(s, res, cur, isP, 0);
        return res;
    }
    private void backtracking(String s, List<List<String>> res, List<String> cur, boolean[][] isP, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isP[index][i]) {
                cur.add(s.substring(index, i + 1));
                backtracking(s, res, cur, isP, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private void getP(boolean[][] isP, String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isP[j + 1][i - 1])) {
                    isP[j][i] = true;
                }
            }
        }
        System.out.println(Arrays.deepToString(isP));
    }
}
