package leetcode;
import java.util.*;

import leetcode.DataStructure.TreeNode;

public class LT145 {
    class Info {
        TreeNode node;
        boolean left;
        boolean right;
        
        Info(TreeNode n, boolean l, boolean r) {
            this.node = n;
            left = l;
            right = r;
        }
    }
    
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<Info> stack = new ArrayDeque<>();
//        Info cur = new Info(root, false, false);
//        
//        while (cur != null || !stack.isEmpty()) {
//            if (cur.node == null) {
//                cur = stack.pollLast();
//                continue;
//            }
//            
//            if (cur.left && cur.right) {
//                // went through left & right
//                res.add(cur.node.val);
//                cur = stack.pollLast();
//                continue;
//            } else if (cur.left && !cur.right) {
//                stack.offerLast(new Info(cur.node, true, true));
//                cur = new Info(cur.node.right, false, false);
//                continue;
//            } else {
//                // not go left yet
//                stack.offerLast(new Info(cur.node, true, false));
//                cur = new Info(cur.node.left, false, false);
//                continue;
//            }     
//        }   
//        return res;
//    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if (root == null) {
            return res;
        }
        
        ArrayDeque<Info> stack = new ArrayDeque<>();
        Info cur = new Info(root, false, false);

        while (cur != null || stack.size() != 0) {  
            if (!cur.left && cur.node.left != null) {
                // Not visit left and has left node to visit
                stack.offerFirst(new Info(cur.node, true, false));
                // Put in stack as we visited left already
                cur = new Info(cur.node.left, false, false);
                // Go visited Left node that is not been visited its left and right
            } else if (!cur.right && cur.node.right != null) {
                // Not visit right and has right node to visit
                stack.offerFirst(new Info(cur.node, true, true));
                // Since we passed check for left, then it must be visited/no node to visit. And we will visit right
                cur = new Info(cur.node.right, false, false);
            } else {
                res.add(cur.node.val); 
                cur = stack.pollFirst();
            }
        }
        
        return res;
    }
    
    public static void main(String args[]) {
    	TreeNode a = new TreeNode(1);
    	a.right = new TreeNode(2);
    	a.right.left = new TreeNode(3);
    	LT145 test = new LT145();
    	test.postorderTraversal(a);
    	
    }

}
