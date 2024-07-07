package leetcode;

import java.util.*;

public class LT119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] prevTwo = new int[2];
        
        for (int i = 0; i < rowIndex; i++) {            
            for (int j = 0; j <= i; j++) {
                // if (j == 0 && i == 0) {
                //     // only time that we need to add 1 at start
                //     res.add(1); 
                // } else if (j == i) {
                //     res.add(1);
                // }
                
                if (j == i) {
                    res.add(1);
                } else {
                    if (j == 0) {
                        continue;
                    }
                    
                    if (prevTwo[0] == 0) {
                        prevTwo[0] = res.get(j - 1);   
                        prevTwo[1] = res.get(j);
                    } else {
                        prevTwo[0] = prevTwo[1];
                        prevTwo[1] = res.get(j);
                    }

                    res.remove(j);
                    res.add(j, prevTwo[0] + prevTwo[1]);
                }   
            }
            prevTwo[0] = 0;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT119 test = new LT119();
		test.getRow(3);

	}

}
