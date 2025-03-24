package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class LT310 {
	// https://leetcode.com/problems/minimum-height-trees/
	/*
	 * 
    iteration all node as root for BFS:
        each BFS iteration:
            Maintain globle min height and res list, 
            if current is > globle min height -> skip 
            if current is < globle min height (at end of it) -> clean up list, add this root to res and update min height
            if == -> add this root to res
        
        // n as total nodes
        TC: O(n^2) // each node iteration through all
        SC: O(n) 
    T:
	 * 
	 * 
	 * */
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        // Build adjacent map
//        HashMap<Integer,List<Integer>> map = new HashMap<>();
//        for (int[] cur : edges) {
//            if (map.containsKey(cur[0])) {
//                map.get(cur[0]).add(cur[1]);
//            } else {
//                map.put(cur[0], new ArrayList<Integer>());
//                map.get(cur[0]).add(cur[1]);
//            }
//
//            if (map.containsKey(cur[1])) {
//                map.get(cur[1]).add(cur[0]);
//            } else {
//                map.put(cur[1], new ArrayList<Integer>());
//                map.get(cur[1]).add(cur[0]);
//            }
//        }
//        
//        int[] minH = {Integer.MAX_VALUE};
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//        	bfs(minH, map, res, n);
//        }
//        
//        return null;
//    }
    
    private void bfs(int[] minH, HashMap<Integer, List<Integer>> map, List<Integer> res, int root) {
    	int h = 0;
    	Queue<Integer> queue = new ArrayDeque<>();
    	queue.offer(root);
    	HashSet<Integer> visited = new HashSet<>();
    	visited.add(root);
    	
    	while (!queue.isEmpty()) {
    		int count = queue.size();
    		h++;
    		if (h > minH[0]) {
    			// No need to continue
    			break;
    		}
    		for (int i = 0; i < count; i++) {
    			List<Integer> adj = map.get(queue.poll());
    			for (int cur : adj) {
    				if (visited.add(cur)) {    					
    					queue.add(cur);
    				}
    			}
    		}
    	}
    	
    	if (h == minH[0]) {
    		res.add(root);
    	} else if (h < minH[0]){
    		minH[0] = h;
    		res.clear();
    		res.add(root);
    	}
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[n];
        for (int[] e : edges) {
            int v = e[0], u = e[1];
            graph[v].add(u);
            graph[u].add(v);
            indegree[v]++;
            indegree[u]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int v = 0; v < n; v++) {
            if (indegree[v] <= 1) {
                queue.offer(v);
            }
        }
        
        List<Integer> layer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                layer.add(v);
                for (int u : graph[v]) {
                    if (--indegree[u] == 1) {
                        queue.add(u);
                    }
                }
            }
        }
        return layer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] input = {{1,0},{1,2},{1,3}};
       LT310 a = new LT310();
       a.findMinHeightTrees(4, input);
	}

}
