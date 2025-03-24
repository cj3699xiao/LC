package leetcode;

public class LT215 {
	
    /*
    CA: input: int[] nums, int k
        output: int k th largest element
    R:
        Sol 1: 
            High level: Using Priority Queue to find the kth largest element.
            
            1. create size k min heap
            2. iterate through all elements in nums, each as cur
                2.1 if heap size < k, add element into heap
                2.2 if heap size == k, compare top element in heap and cur
                    2.2.1 if cur <= heap.top, pass
                    2.2.2 if cur > heap.top, pop heap's top, add cur into heap
            3. return the top of heap 

        TC: O(n lgk ) // each iteration(n), pop and sink (lgk), add and swim (lgk).
        SC: O(k)

        //

 filling the hole made by our removal of the maximum element by moving another item in the heap to its location only serves to create a hole elsewhere -- except in one case. If we move the last element in the array (the right-most leaf in the deepest level of the tree), the tree is again made complete. 

        Sol 2:

        High level: Bucket sort, create array of size (max from nums - min from nums + 1)

        1. Iterate through all elements find min and max, create array as bucket O(n)

        2. iterate through all elements, count elements by its value O(n)

        3. iterate backward from Bucket array, count the K th larget and return  O(k)
        
        // r as max - min 
        TC: O(n + k)
        SC: O(r)
    T: 
    nums = [3,2,1,5,6,4], k = 2
                         c
        5 <- root 
        |
        6
        
    
    -> 5 




     */

    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
    //         public int compare(Integer a, Integer b) { 
    //             if (a > b) {
    //                 return 1;
    //             } else {
    //                 return -1;
    //             }
    //         }
    //     });

    //     for (int i = 0; i < nums.length; i++) {
    //         if (heap.size() < k) {
    //             heap.add(nums[i]);
    //         } else {
    //             if (heap.peek() < nums[i]) {
    //                 heap.poll();
    //                 heap.add(nums[i]);
    //             } 
    //         }
    //     }
    //     return heap.peek();
    // }

	// Sol 2
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        int[] record = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            record[cur - min]++;
        }
        
        int res = 0;
        int index = record.length - 1;
        for (int i = 0; i <= k - 1; i++) {
            if (record[index] == 0) {
                while (record[index] == 0) {
                    // Assume k is less than length of input
                    index--;
                }
            } 
            res = index + min;
            record[index]--;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {3,2,3,1,2,4,5,5,6};
		LT215 test = new LT215();
		test.findKthLargest(a, 2);
	}

}
