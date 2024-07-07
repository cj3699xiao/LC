package leetcode;

public class LT151 {
    public String reverseWords(String s) {
        char[] array = new char[s.length()];
        int count = 0;
        
        // #1 Reverse whole input String
        for (int i = s.length() - 1, cur = 0; i >= 0; i--) { 
            if (s.charAt(i) == ' ' && i != s.length() - 1 && s.charAt(i + 1) == ' ' || s.charAt(i) == ' ' && cur == 0) {
                // Continues spaces, skip || Leading space
                continue;
            } 
            array[cur] = s.charAt(i);
            cur++;
            count++;
        }
        
        if (array[count - 1] == ' ') {
            count--; // Remove the single trailing space
        }
        
        // #2 Reverse each world one by one
        int end = 0;
        int start = 0;
        char tmp;
        
        while (end <= count - 1) {
            if (end == count - 1 || array[end + 1] == ' ') {
                // Do reverse
                int target = end + 2; // Skip space
                while (start < end) {  
                    tmp = array[start];
                    array[start] = array[end];
                    array[end] = tmp;

                    start++;
                    end--;
                }
                
                start = target;
                end = target;
            } else {
                end++;
            }
        }
        
        return new String(array, 0, count);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT151 a = new LT151();
		
		System.out.println(a.reverseWords("a good   example"));
//		System.out.println(a.reverseWords("F R  I   E    N     D      S      "));
		
		// sky
		// kyy
		// aky
		//  2
		// Test why StringBuilder is O(n) on delete
//		StringBuilder res = new StringBuilder("a good   example");
//		int start = 0, end = 2;
////        res.deleteCharAt(start);
//        res.insert(start, 'a');

	}

}
