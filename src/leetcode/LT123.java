package leetcode;

import java.util.*;

public class LT123 {
//    class Info {
//        int s;
//        int e;
//        int max;
//        
//        public Info(int _s, int _e, int _max) {
//            this.s = _s;
//            this.e = _e;
//            this.max = _max;
//        }
//    }
//    
//    public int maxProfit(int[] prices) {
//        
//       ArrayList<Info> list = new ArrayList<>();
//        
//       int prevMin = prices[0];
//       int prevMinIndex = 0;
//       for (int i = 1; i < prices.length; i++) {
//            if (prices[i] >= prices[i - 1]) {
//                // Non-decreasing
//                continue;
//            } else {
//                // Decreasing
//            	if (prevMinIndex == i - 1) {
//            		prevMin = prices[i];
//                    prevMinIndex = i;
//            		continue;
//            	}
//                list.add(new Info(prevMinIndex, i - 1, prices[i - 1] - prevMin));
//                prevMin = prices[i];
//                prevMinIndex = i;
//            }
//        }
//        
//        if (prevMinIndex != prices.length -1) {
//            list.add(new Info(prevMinIndex, prices.length - 1, prices[prices.length - 1] - prevMin));
//        }
//        
//        if (list.size() == 0) {
//            return 0;
//        }
//        
//        // Create DP
//        int[][] M = new int[list.size()][list.size()];
//        
//        for (int i = M.length - 1; i >= 0; i--) {
//            for (int j = i; j <= M[0].length - 1; j++) {
//                if (i == j) {
//                    M[i][j] = list.get(i).max;
//                } else {
//                    M[i][j] = getMaxProfit(list.get(i).s, list.get(j).e, prices);
//                }
//            }
//        }
//        
//
//        
//        int res = 0;
//        for (int i = 0; i < M[0].length - 1; i++) {
//            res = Math.max(res, M[0][i] + M[i + 1][M[0].length - 1]);
//        }
//        
//        return Math.max(res, M[0][M[0].length - 1]);
//    }
	
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } 
        
        int K = 2;
        int maxProf = 0;
        
        int[][] M = new int[K + 1][prices.length];
        
        for (int k = 1; k <= K; k++) {
            int tmpMax = M[k - 1][0] - prices[0];
            
            for (int i = 1; i < prices.length; i++) {
                M[k][i] = Math.max(M[k][i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, M[k - 1][i] - prices[i]);
                maxProf = Math.max(M[k][i], maxProf);
            }
        }
        
        return maxProf;
    }
    
    
    private int getMaxProfit(int s, int e, int[] prices) {
        int minbuy = prices[s];
        int maxSell = 0;

        for(int i=s; i<= e; i++){
            maxSell = Math.max(maxSell,prices[i] - minbuy);
            minbuy = Math.min(prices[i], minbuy);
        }
        
        return maxSell;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT123 test = new LT123();
		test.maxProfit(new int[] {3,2,6,5,0,3});
		test.maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0});  // result 13

	}

}
