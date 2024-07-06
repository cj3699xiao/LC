package leetcode;

import leetcode.DataStructure.*;
import java.util.*;

public class LT144 {
	
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        TreeNode cur = root;
        while (cur != null || stack.size() != 0) {
            if (cur == null) {
                cur = stack.pollFirst();
            }
            
            res.add(cur.val);
            
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            
            cur = cur.left;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT144 a = new LT144();
		
		TreeNode input = new TreeNode(1);
		input.right = new TreeNode(2);
		input.right.left = new TreeNode(3);
		
		a.preorderTraversal(input);
	}

}
