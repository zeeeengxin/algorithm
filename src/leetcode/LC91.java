package leetcode;

public class LC91 {
	public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] dp = new int[array.length + 1];
        if (array[0] == '0') return 0;
        dp[0] = 1; dp[1] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == '0') {
                if (array[i-1] != '1' && array[i-1] != '2') {
                    return 0;
                } else {
                    dp[i + 1] = dp[i - 1];
                }
            } else if (array[i-1] == '1' || (array[i-1] == '2' && array[i] >= '1' && array[i] <= '6')) {
                dp[i + 1] = dp[i - 1] + dp[i];
            } else {
            	dp[i + 1] = dp[i];
            }
            System.out.println(dp[i+1]);
        }       
        return dp[array.length];
    }
}
