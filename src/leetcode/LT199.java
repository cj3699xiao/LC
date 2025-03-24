package leetcode;

import java.util.*;

import leetcode.DataStructure.TreeNode;

public class LT199 {
    /*
    CA:
    R:  BFS
        Level tranverse (left to right), each level when finished, record the last one in queue (right view)

    T:
        Queue: |->    1
        Count: 1  
        i = 0

        Res 
    
    */
//	public List<Integer> rightSideView(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		if (root == null) {
//			return res;
//		}
//
//		// For odd and even level
//		Deque<TreeNode> queue0 = new ArrayDeque<>();
//		Deque<TreeNode> queue1 = new ArrayDeque<>();
//		queue0.addLast(root);
//
//		while (!queue0.isEmpty() || !queue1.isEmpty()) {
//			Deque<TreeNode> curQueue = queue0.size() != 0 ? queue0 : queue1;
//			Deque<TreeNode> nextQueue = queue0.size() != 0 ? queue1 : queue0;
//			int nodeCount = curQueue.size();
//			res.add(curQueue.peekLast().val);
//
//			for (int i = 0; i < nodeCount; i++) {
//				TreeNode cur = curQueue.pollFirst();
//
//				if (cur.left != null) {
//					nextQueue.addLast(cur.left);
//				}
//
//				if (cur.right != null) {
//					nextQueue.addLast(cur.right);
//				}
//			}
//		}
//
//		return res;
//	}

	/*
	 * Better solution: Recursion for all nodes,
	 * 
	 * R -> right -> left , record root, then each level we only record the first
	 * node
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		int[] maxDepth = new int[1];
		maxDepth[0] = -1;
		helper(root, 0, res, maxDepth);
		return res;
	}

	private void helper(TreeNode root, int depth, List<Integer> res, int[] maxDepth) {
		// base case
		if (root == null) {
			return;
		}
		if (depth > maxDepth[0]) {
			res.add(root.val);
			maxDepth[0] = depth;
		}

		helper(root.right, depth + 1, res, maxDepth);
		helper(root.left, depth + 1, res, maxDepth);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode input = new TreeNode(1);
		input.left = new TreeNode(2);
		input.right = new TreeNode(3);

		LT199 a = new LT199();
		a.rightSideView(input);
	}

}
