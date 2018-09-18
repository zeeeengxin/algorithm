package leetcode;
import java.util.*;

public class LC188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        if (k >= prices.length / 2) {
            return solve(prices);
        }
        int[] hold = new int[k+1];
        int[] release = new int[k+1];
        Arrays.fill(hold, Integer.MIN_VALUE);
        for(int i : prices) {
            for (int j = 1; j <= k; j++) {
                hold[j] = Math.max(hold[j], release[j-1] - i);
                release[j] = Math.max(release[j], hold[j] + i);

            }
        }
        return release[k];
    }
    private int solve(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
