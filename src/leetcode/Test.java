package leetcode;
import java.util.*;

public class Test {
	
	    class Info {
	        int index;
	        int dif;
	    
	        public Info (int _index, int _dif) {
	        this.index = _index;
	        this.dif = _dif;
	        }
	    }

	    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
	        Queue<Info> pq1 = new PriorityQueue<>(new Comparator<Info>() {
	            @Override
	            public int compare(Info a, Info b) {
	                if (a.dif < b.dif) return -1;
	                else if (b.dif > a.dif) return 1;
	                else return 0;
	            }
	        });
	        
	        int sum1 = 0;
	        int sum2 = 0;
	        
	        for (int i = 0; i < reward1.length; i++) {
	            int dif = reward1[i] - reward2[i];
	            if (pq1.size() < k) {
	                pq1.offer(new Info(i, dif));
	                sum1 += reward1[i];
	            } else {
	                if (dif > pq1.peek().dif) {
	                    Info remove = pq1.poll();
	                    sum1 -= reward1[remove.index];
	                    sum2 += reward2[remove.index];
	                    
	                    pq1.offer(new Info(i, dif));
	                    sum1 += reward1[i];
	                } else {
	                    sum2 += reward2[i];
	                }
	            }
	        }       
	        return sum1 + sum2;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test();
		int[] r1 = {1,3,3,1,2,3};
		int[] r2 = {2,2,1,2,1,2};
	
		a.miceAndCheese(r1, r2, 4);
	}

}
