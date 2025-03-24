package leetcode;
import java.util.*;

public class LT670 {
    public int maximumSwap(int num) {
        // cur & prev only track the digit, thus <= 9
        int prev = -1;
        int cur = -1;
        int max = 0;
        int res = num;
        int count = 0;
        // index1 pivot, index2 max
        int index1 = -1, index2 = -1;
        int val1 = -1;
        
        while (num > 0) {
            cur = num % 10;
            if (cur < prev || count == 0) {
            	// Descending
                index1 = count;
                val1 = cur;
                
                if (max < cur) {
                    max = cur;
                    index2 = count;
                }
            }

            count++;
            num /= 10;
            prev = cur;
        }

        if (index1 == -1) {
            // No descending found
            return num;
        }

        // Swap
        res = res - (int)(val1 * Math.pow(10, index1)) - (int)(max * Math.pow(10,index2));
        res = res + (int)(val1 * Math.pow(10, index2)) + (int)(max * Math.pow(10,index1));

        return res;
    }
    
    public static void main(String[] args) {
    	LT670 a = new LT670();
    	a.maximumSwap(9812345);
    }

}
