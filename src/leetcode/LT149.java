package leetcode;

import java.util.*;

public class LT149 {
	
	  /*
    CA:
    
    R: High Level:
       DFS:
       
       Normal line: 
        
        Two points make a line
        
       Special lines:
            vertical: 
            
            horizontal  
            
            
        To verify if points on the line: 
            check all others points, if they are on this line or not. 
            
        
        TC: O(n * n * n)  // n as length of array 
        SC: O(n)
        
        
        After optimization 
        TC: O(n^2)
        
    T:
    
    
        
    */
    public int maxPoints(int[][] points) {
        int max = 0;
        // Normal lines
        
        Map<Double, Integer> slopeMap = new HashMap<>();
        for (int i = 0; i <= points.length - 1; i++) {
            // Set this point as slope point, each time we swith, we clear the map
            slopeMap.clear(); 

            for (int j = i + 1; j <= points.length - 1; j++) {
                int[] A = points[i];
                int[] B = points[j];
                
                if ((A[0] - B[0]) == 0 || (A[1] - B[1]) == 0) {
                    continue;  
                }
                
                double slope = (double)(A[0] - B[0]) / (double)(A[1] - B[1]);
                
                if (!slopeMap.containsKey(slope)) {
                    slopeMap.put(slope, 2);
                    max = Math.max(2, max);
                } else {
                    slopeMap.put(slope, slopeMap.get(slope) + 1);
                    max = Math.max(slopeMap.get(slope), max);
                }
          
                // max = Math.max(max, tryPointsOnLine(pointA, pointB, points));
            }
        }
        
        // Special Lines
        Map<Integer, Integer> vMap = new HashMap<>();
        Map<Integer, Integer> hMap = new HashMap<>();
        // Vertical
        for (int i = 0; i <= points.length - 1; i++) {
            int value = vMap.getOrDefault(points[i][1], 0);
            max = Math.max(max, value + 1);
            vMap.put(points[i][1], value + 1);
        }
        
        // Horizontal
        for (int i = 0; i <= points.length - 1; i++) {
            int value = hMap.getOrDefault(points[i][0], 0);
            max = Math.max(max, value + 1);
            hMap.put(points[i][0], value + 1);
        }
        
        return max;
    }
    
    private int tryPointsOnLine(int[] A, int[] B, int[][] points) {  
        if ((A[0] - B[0]) == 0 || (A[1] - B[1]) == 0) {
            // Not under this consideration (in special lines)
            return 0;
        } 
        int res = 2;
        double val = (double)(A[0] - B[0]) / (double)(A[1] - B[1]);
        for (int i = 0; i <= points.length - 1; i++) {
            if (points[i][0] == A[0] && points[i][1] == A[1] || points[i][0] == B[0] && points[i][1] == B[1]) {
                continue;
            }
            
            if (points[i][0] - A[0] != 0 && points[i][1] - A[1] != 0 && val == ((double)(points[i][0] - A[0]) / (double)(points[i][1] - A[1]))) {
                res++;
            }
        }

        return res;
    }
    
//    private int doCal(String input, int a, int b) {     
//        switch (input) {
//            case "+":
//            	return a;
//            case "-":
//            	return a;
//            case "*": 
//            	return a;
//            default:
//                return a / b;
//        }
//        
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT149 a = new LT149();
		a.maxPoints(new int[][]{{9,-25},{-4,1},{-1,5},{-7,7}});
		
	}

}
