package leetcode;

public class LT167 {
	/**
	CA:  Return two index(index + 1) that corresponding elements have sum with target value
	R:  
	  -->   <--   Answer is guaranteed
	 s       e
	  
	    If sum is less than target --> s
	    else <-- e

	    // n as total number of elements in input array
	    TC: O(n) 
	    SC: O(1)
	T:
	 */

	class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        int start = 0;
	        int end = numbers.length - 1;

	        while (start < end) {
	            int sum = numbers[start] + numbers[end];
	            if (sum > target) {
	                end--;
	            } else if (sum < target) {
	                start++;
	            } else {
	                return new int[]{start + 1, end + 1};
	            }
	            
	            
	        }
	        
	        return  new int[]{-1, -1};
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
