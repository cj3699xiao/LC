package leetcode;

public class LT74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // Rows
        int n = matrix[0].length; // Columns
        int s = 0;
        int e = m * n - 1;

        while (s <= e) {
            int mid = s + (e - s)/2;
            int midValue = matrix[mid / n][mid % n]; // Calculate index and get value

            if (midValue > target) {
                e = mid - 1;
            } else if (midValue < target) {
                s = mid + 1;
            } else {
                return true;
            }
        } 

        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT74 a = new LT74();
		a.searchMatrix(new int[][] {{1,1}}, 2);

	}

}
