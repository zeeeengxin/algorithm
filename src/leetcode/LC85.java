package leetcode;
import java.util.*;
public class LC85 {
	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j <= cols; j++) {               
            	if (j < cols) {
            		heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            	}
                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    int index = stack.pop();
                    int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                    res = Math.max(res, heights[index] * w);
                }
                stack.push(j);
            }
        }
        return res;
    }
}
