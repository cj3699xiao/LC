package leetcode;

public class LT174 {
	    /* 
	    CA:
	    R: DFS / BFS2 (Dijkstra's) / DP?
	       DP: 
	         https://leetcode.com/problems/dungeon-game/discuss/1498636/C%2B%2B-solution-with-image-explaination
	         
	         Think reversely, start from end:
	         
	         [-2,  -3,   3],
	         [-5,  -10 , 1],
	         [10,  30,   -5]
	         
	         
	          -6    -4    -1    inf
	          -5    -10   -4    inf
	          10(0) 25(0) -5    inf
	          inf   inf   inf
	          
	          
	          M[i][j] represent the health cost (in negative) to reach princess from [i][j]
	          
	          Base case: 
	          
	          M[][] (right most) == D[i][j]
	          
	          Induction rule: 
	          M[i][j] =  Math.max (M[i + 1][j], M[i][j + 1]) + d[i][j];  If > 0 --> 0  // no extra health needed     
	          
	          TC: O(mn)
	          SC: O(mn)  
	    T
	     */
    public int calculateMinimumHP(int[][] d) {
        int[][] M = new int[d.length + 1][d[0].length + 1];
        
        // Fill the border with inf
        for (int i = 0; i <= M.length - 1; i++) {
            M[i][M[0].length - 1] = Integer.MIN_VALUE;
        }
        
        for (int i = 0; i <= M[0].length - 1; i++) {
            M[M.length - 1][i] = Integer.MIN_VALUE;
        }
        
        // Process M[][]
        M[M.length - 2][M[0].length - 2] = d[d.length - 1][d[0].length - 1] > 0 ? 0 : d[d.length - 1][d[0].length - 1];
        for (int i = M.length - 2; i >= 0; i--) {
            for (int j = M[0].length - 2; j >= 0; j--) {
                if(i == M.length - 2 && j == M[0].length - 2) continue;
                M[i][j] = Math.max(M[i + 1][j], M[i][j + 1]) + d[i][j];
                M[i][j] = Math.min(0, M[i][j]);
            }
        }
        
        return M[0][0] > 0 ? 1 : M[0][0] * (-1) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT174 a = new LT174();
		int[][] input = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		a.calculateMinimumHP(input);
	}

}
