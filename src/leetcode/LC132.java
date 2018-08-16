package leetcode;

public class LC132 {
	public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] isP = new boolean[s.length()][s.length()];
        int[][] dp = new int[s.length()][s.length()];
        getP(isP, s);
        for (int col = 0; col < s.length(); col++) {
            for (int row = col; row >= 0; row--) {
                if (!isP[row][col]) {               
                    int min = col - row;
                    for (int i = row; i < col; i++) {
                        if (isP[row][i]) {
                            min = Math.min(min, dp[i+1][col]);
                        }
                    }
                    dp[row][col] = min + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
    private void getP(boolean[][] isP, String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isP[j + 1][i - 1])) {
                    isP[j][i] = true;
                }
            }
        }
    }
}
