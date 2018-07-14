package leetcode;

public class LC87 {
	public boolean isScramble(String s1, String s2) {        
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n = arr1.length;
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = arr1[i] == arr2[j];
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int l = 1; l < len; l++) {
                        if (dp[i][j][l] && dp[i+l][j+l][len-l] || dp[i][j+len-l][l] && dp[i+l][j][len-l]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                   // dp[i][j][len] = false; // No this line!!!!!!! will make everything false!! can't do it!
                }              
            }   
        }
        return dp[0][0][n];
    }
}
