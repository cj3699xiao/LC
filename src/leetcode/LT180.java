package leetcode;

public class LT180 {
	/*
	 * */
    public int reverseBits(int n) {
        int[] binary = new int[32];
        int index = 31;
        int remains = n;
        
        while (remains > 0) {
            int cur = (int)Math.pow(2,index);
            if (remains >= cur) {
                binary[index] = 1;
                remains -= cur; 
            }
            index--;
        }
        
        int res = 0;
        for (int i = 0; i <= binary.length - 1; i++) {
            if (binary[i] == 1) {
                res += (int)Math.pow(2, 31 - i);
            }
        }
        
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT180 a = new LT180();
		a.reverseBits(1745221223);
	}

}
