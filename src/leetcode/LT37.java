package leetcode;

import java.util.*;

public class LT37 {
    int n = 3;
    
    int[][] rows = new int[n * 3][n * 3 + 1]; // not using the first one 
    int[][] columns = new int[n * 3][n * 3 + 1];
    int[][] boxes = new int[n * 3][n * 3 + 1];
    
    boolean solved = false;
    
    char[][] board;
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    int d = Character.getNumericValue(cur);
                    placeNumber(d, i, j);
                }
            }
        }
        
        dfs(0, 0);
    }
    
    private void dfs(int r, int c) {
        if (r > n * 3 - 1) {
            solved = true;
            return;
        }
        
        int nextR = (c != 8) ? r : r + 1;
        int nextC = (c != 8) ? c + 1 : 0;
        
        char cur = board[r][c];
        if (cur != '.') { 
            dfs(nextR, nextC);
            return;
        }
        
        // Not set yet
        for (int t = 1; t <= 9; t++) {
            if (canPlace(t, r, c)) {
                placeNumber(t, r, c);
                dfs(nextR, nextC);
                if (!solved) {
                    removeNumber(t, r, c);         
                }
            }
        }
    }
    
    private boolean canPlace(int num, int r, int c) {
        int idx = (r / n) * n + c / n; // determine which box it belongs to
        return rows[r][num] + columns[c][num] + boxes[idx][num] == 0;
    }
    
    private void placeNumber(int num, int r, int c) {
        int idx = (r / n) * n + c / n;

        rows[r][num]++;
        columns[c][num]++;
        boxes[idx][num]++;
        board[r][c] = (char)(num + '0');
    }
    
    private void removeNumber(int num, int r, int c) {
        int idx = (r / n) * n + c / n;

        rows[r][num]--;
        columns[c][num]--;
        boxes[idx][num]--;
        board[r][c] = '.';    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT37 a = new LT37();
		char[][] input = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

		a.solveSudoku(input);
		int[] test = {1,2,3};
		int[] test1 = {1,2,3};
		Set<int[]> aa = new HashSet<>();
		
		aa.add(test);
		
		aa.contains(test1);
		
		System.out.println(aa.contains(test1));
	}

}
