package leetcode;

import leetcode.DataStructure.Node;

public class LT117 {	
    public Node connect(Node root) {   
    	Node toPair = null;
    	Node toNextLevel = null;
        for (Node start = root; start != null; start = toNextLevel) {
        	toNextLevel = null;
            for (Node cur = start; cur != null; cur = cur.next) {
            	
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right; 
                }
                
                if (cur.left != null || cur.right != null) {
                	if (toNextLevel == null) {                		
                		toNextLevel = cur.left != null ? cur.left : cur.right;
                	}
                    if (toPair != null) {
                		toPair.next = (cur.left != null) ? cur.left : cur.right;
                	} 
                    toPair = (cur.right != null) ? cur.right : cur.left;   
                } 
            }
            toPair = null;
        }

        return root;
    }
	
	public static void main(String[] args) {
//		Node root = new Node(1, new Node(2), new Node(3), null);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.right = new Node(7);
		
		Node root = new Node(-1, new Node(-7), new Node(9), null);
		root.right.left = new Node(-1);
		root.right.right = new Node(-7);
		root.right.left.right = new Node(8);
		root.right.right.left = new Node(-9);
		
		
		LT117 test = new LT117();
		test.connect(root);
		
	}

}
