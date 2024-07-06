package leetcode;

import leetcode.DataStructure.TreeNode;


public class LT105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = { -1 };
        
        return helper(preorder, inorder, preIndex, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder,int[] preIndex, int start, int end){ 
        if (end == start) {
            preIndex[0]++;
            return new TreeNode(inorder[start]);
        } else if (end < start) {
            return null;
        }
        
        int cur = preorder[++preIndex[0]];
        int pivot = start;
        while (inorder[pivot] != cur) {
            pivot++;
        } 
        
        TreeNode res = new TreeNode(cur);
        res.left = helper(preorder, inorder, preIndex, start, pivot - 1);
        res.right = helper(preorder, inorder, preIndex, pivot + 1, end);
    
        return res;
    }
    
    public static void main(String args[]) {
    	LT105 A = new LT105();
    	int[] pre = {3,9,20,15,7};
    	int[] in = {9,3,15,20,7};
    	
    	A.buildTree(pre, in);
    	
    }

}
