package leetcode;

import java.util.*;

public class LT130 {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    if (atEdge(i,j, board)) {
                        // visited[i][j] = true;
                        continue;
                    }
                    bfs(i, j, board, visited);
                }
            }
        }
        
    }
    
    private boolean atEdge(int i, int j, char[][] board) {
        return i == 0 || (i == board.length - 1) || j == 0 || j == board[0].length - 1;
    }
    
    private void bfs(int i, int j, char[][] board, boolean[][] visited) {
        List<int[]> tempList = new ArrayList<>();
        boolean flip = true;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {i, j});
        tempList.add(new int[] {i, j});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            
            if (atEdge(cur[0], cur[1], board)) {
                flip = false;
            }
            
            for (int[] curDir : directions) {
                int newRow = cur[0] + curDir[0];
                int newCol = cur[1] + curDir[1];
                
                if (newRow >= 0 && newRow <= board.length - 1 && newCol >= 0 && newCol <= board[0].length - 1 
                    && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                    tempList.add(new int[] {newRow, newCol});
                    q.offer(new int[] {newRow, newCol});
                }
            }
        }
        
        
        if (flip == false) {
            return;
        }
        
        for (int[] cur : tempList) {
            board[cur[0]][cur[1]] = 'X';
        }
    }
    
    
    // Other way around, can be fast in practice
    
    public class Solution {

        private char[][] board;
        private int R, C;

        public void solve(char[][] board) {

            this.board = board;

            R = board.length;
            C = board[0].length;

            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    // only iterate over the edge cells
                    if (row == 0 || col == 0 || row == R-1 || col == C-1) {
                        if (board[row][col] == 'O') {
                            rec(row, col);
                        }
                    }

                }
            }

            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (board[row][col] == 'E') {
                        board[row][col] = 'O';
                    } else if (board[row][col] == 'O') {
                        board[row][col] = 'X';
                    }
                }
            }


        }

        
        private void rec(int row, int col) {

            if (row < 0 || row >= R || col < 0 || col >= C || board[row][col] == 'X' || board[row][col] == 'E') {
                return;
            }

            board[row][col] = 'E';

            // up 
            rec(row-1, col);
            // down 
            rec(row+1, col);
            // left
            rec(row, col-1);
            // right
            rec(row, col+1);

        }

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT130 a = new LT130();
		char[][] input = new char[][] 
		   {{'X','O','X','O','X','O'},
			{'O','X','O','X','O','X'},
			{'X','O','X','O','X','O'},
			{'O','X','O','X','O','X'}};
	
		a.solve(input);

	}

}
