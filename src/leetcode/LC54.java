package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
	if (matrix.length == 0 || matrix[0].length == 0) {
		return res;
	}
	int rows = matrix.length;
	int cols = matrix[0].length;
	int topx = 0;
	int topy = 0;
	int bottomx = rows - 1;
	int bottomy = cols - 1;
	while (topx <= bottomx && topy <= bottomy) {
		for (int i = topy; i <= bottomy; i++) {
			res.add(matrix[topx][i]);
		}
		for (int i = topx + 1; i <= bottomx; i++) {
			res.add(matrix[i][bottomy]);
		}
		if (topx < bottomx && topy < bottomy) {
			for (int i = bottomy - 1; i > topy; i--) {
				res.add(matrix[bottomx][i]);	
			}
			for (int i = bottomx; i > topx; i--) {
				res.add(matrix[i][topy]);
			}
		}
		topx++;
		topy++;
		bottomx--;
		bottomy--;
	}
	return res;
    }
}
