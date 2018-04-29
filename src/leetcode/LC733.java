package leetcode;

import java.util.Arrays;

public class LC733 {
	 public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        if (image[sr][sc] == newColor) return image;
			dfs(image, image[sr][sc], sr, sc, newColor);
			return image;
		}
		private static int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		private static void dfs(int[][] image, int color, int x, int y, int newColor) {
			if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != color) return;
			image[x][y] = newColor;
			System.out.println(Arrays.deepToString(image));
			for (int[] dir : DIRS) {
				dfs(image, color, x + dir[0], y + dir[1], newColor);
			}
		}
}
