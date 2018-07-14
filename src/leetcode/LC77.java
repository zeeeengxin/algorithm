package leetcode;
import java.util.*;

public class LC77 {
	public static List<List<Integer>> combine(int n, int k) {
      	List<List<Integer>> res = new ArrayList<>();
       	if (n < k) return res;
        Integer[] cur = new Integer[k];
        for (int i = 0; i < k; i++) {
		    cur[i] = 0;
        }
        int i = 0;
        while (i >= 0) {
            cur[i]++;
            if (cur[i] > n) {
                i--;
            } else if (i == k - 1) {
                res.add(new ArrayList<>(Arrays.asList(cur)));
            } else {
                i++;
                cur[i] = cur[i-1];
            }
        }
        System.out.println(res);
        return res;	
    }
}
