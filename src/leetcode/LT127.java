package leetcode;

import java.util.*;

public class LT127 {
    class Info {
        String word;
        Set<String> path;
        
        public Info(String _word) {
            word = new String(_word);
            path = new HashSet<>();
            path.add(word);
        }
        
        public void copyPath(Set<String> copy) {
            for (String cur : copy) {
                path.add(cur);
            }
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.offerFirst(new Info(beginWord));
        
        while (!q.isEmpty()) {
            Info cur = q.pollLast();
            
            for (int i = 0; i < wordList.size(); i++) {
                if (isValid(cur.word, wordList.get(i)) && cur.path.add(wordList.get(i))) {
                    if (wordList.get(i).equals(endWord)) {
                        return cur.path.size();
                    } else {
                        Info candidate = new Info(wordList.get(i));
                        cur.path.remove(wordList.get(i));
                        candidate.copyPath(cur.path);
                        q.offerFirst(candidate);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private boolean isValid(String a, String b) {
        if (a.equals(b) || a.length() != b.length()) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT127 a = new LT127();
		List<String> input = new ArrayList<>(Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"}) );
		a.ladderLength("hit", "cog", input);
		
		int[][] x = new int[][] {{1,0}, {0,1}};
		Queue<int[]> xx = new ArrayDeque<>();
		


	}

}
