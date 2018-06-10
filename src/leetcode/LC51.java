package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        // init board
        char[][] cur = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[n * 2 - 1];
        boolean[] antiDiag = new boolean[n * 2 - 1];
        for (char[] array : cur) {
            Arrays.fill(array, '.');
        }
        nQueens(res, cur, 0, col, diag, antiDiag);
        return res;
    }
    private void nQueens(List<List<String>> res, char[][] cur, int curRow, boolean[] col, boolean[] diag, boolean[] antiDiag) {
        int n = cur.length;
        if (curRow == n) {
            getRes(res, cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diag[curRow - i + n - 1] || antiDiag[curRow + i]) continue;
            col[i] = true;
            diag[curRow - i + n - 1] = true;
            antiDiag[curRow + i] = true;
            cur[curRow][i] = 'Q';
            nQueens(res, cur, curRow + 1, col, diag, antiDiag);
            cur[curRow][i] = '.';
            col[i] = false;
            diag[curRow - i + n - 1] = false;
            antiDiag[curRow + i] = false;
        }
    }
    private void getRes(List<List<String>> res, char[][] cur) {
        List<String> list = new ArrayList<>();
        for (char[] array : cur) {
            list.add(new String(array));
        }
        res.add(list);
    }
}
