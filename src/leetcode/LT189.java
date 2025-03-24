package leetcode;

public class LT189 {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return;
        }
        
        // Start at second step
        int count = 0;
        int targetIndex = k % nums.length;
        int toMove = nums[0];
        int toReplace = nums[targetIndex];
        
        while (count < nums.length) {
            // Replace
            nums[targetIndex] = toMove;
            toMove = toReplace;
            
            // Update
            targetIndex = (targetIndex + k) % nums.length; 
            toReplace = nums[targetIndex];
            count++;
        }
        // Last time
//        nums[targetIndex] = toMove;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT189 a = new LT189();
		a.rotate(new int[]{-1,-100,3,99}, 2);
	}

}
