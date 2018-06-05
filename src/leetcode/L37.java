package leetcode;

import java.util.Arrays;

public class L37 {
	public static void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for (int x = 0; x < 9; x++) {
        	for (int y = 0; y < 9; y++) {
        		 if (board[x][y] != '.') {
        	            int num = board[x][y] - '0';        	            
        	            rows[x][num-1] = true; 
        	            cols[y][num-1] = true; 
        	            blocks[x / 3 * 3 + y / 3][num-1] = true;
        		 }
        	}
        }
        solve(board, 0, rows, cols, blocks);
    }
    private static boolean solve(char[][] board, int pos, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        if (pos == 81) return true;
        int x = pos / 9;
        int y = pos % 9;
        if (board[x][y] != '.') {      
            return solve(board, pos + 1, rows, cols, blocks);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, i, x, y, rows, cols, blocks)) {               
                    rows[x][i-1] = true; 
                    cols[y][i-1] = true; 
                    blocks[x / 3 * 3 + y / 3][i-1] = true;
                    board[x][y] = (char)(i + '0');
            		//System.out.println(Arrays.deepToString(board));
                    if (solve(board, pos + 1, rows, cols, blocks)) return true;
                    rows[x][i-1] = false; 
                    cols[y][i-1] = false; 
                    blocks[x / 3 * 3 + y / 3][i-1] = false;  
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }
    private static boolean isValid(char[][] board, int num, int i, int j, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
        if (rows[i][num-1] || cols[j][num-1] || blocks[i / 3 * 3 + j / 3][num-1]) {
            return false;
        }
        return true;
    }
}
