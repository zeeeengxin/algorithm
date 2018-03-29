package leetcode;

import java.util.*;

public class LC417 {
	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<int[]>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0] == null) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, i, 0);
			dfs(matrix, atlantic, i, n - 1);
		}
		for (int i = 0; i < n; i++) {
			dfs(matrix, pacific, 0, i);
			dfs(matrix, atlantic, m - 1, i);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					res.add(new int[]{i, j});
				}
			}
		}
		return res;
	}
	private static int[][] DIRS = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	private static void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		for (int[] dir : DIRS) {
			int neiX = x + dir[0];
			int neiY = y + dir[1];
			if (neiX >= 0 && neiX < matrix.length && neiY >= 0 && neiY< matrix[0].length && !visited[neiX][neiY] && matrix[x][y] <= matrix[neiX][neiY]) {
				dfs(matrix, visited, neiX, neiY);
			}
		}
	}

}
