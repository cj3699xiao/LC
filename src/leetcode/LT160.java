package leetcode;

import leetcode.DataStructure.ListNode;

public class LT160 {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; next = null; } }
	 */
	/*
	 * CA:
	 * 
	 * R: Brote force? #1
	 * 
	 * Iterate through list A: For Each ele a, we iterate through B, check if it is
	 * interect.
	 * 
	 * If yes -> return node;
	 * 
	 * If all no --> return null;
	 * 
	 * TC: O(n * m) SC: O(1)
	 * 
	 * 
	 * # 2 hashmap(set)
	 * 
	 * Iterate though all List A nodes and put into hashset
	 * 
	 * Iterate though all List B nodes
	 * 
	 * if put into hashset failed --> intersection If all secceed, --> null
	 * 
	 * TC: O(n + m - k) SC: O(n + m - k) // n m, as A,B length; k as dup length
	 * 
	 * 
	 * # 3 observation and understand
	 * 
	 * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/
	 * 2116221/Visual-Explanation-or-One-Pass-JAVA
	 * 
	 * 
	 * 
	 * T:
	 * 
	 */
//	     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//	         // #1
//	         ListNode cur = headA;

//	         while (cur != null) {
//	             ListNode check = headB;

//	             while (check != null) {
//	                 if (cur == check) {
//	                     return cur;
//	                 }
//	                 check = check.next;
//	             }      
//	             cur = cur.next;
//	         }

//	         return null;
//	     }    

//	     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//	         // #2
//	         HashSet<ListNode> pool = new HashSet<>();

//	         ListNode curA = headA;
//	         ListNode curB = headB;

//	         while (curA != null && curB != null) {
//	             if (!pool.add(curA)) {
//	                 return curA;
//	             }

//	             if (!pool.add(curB)) {
//	                 return curB;
//	             }

//	             curA = curA.next;
//	             curB = curB.next;
//	         }

//	         ListNode rest = curA;
//	         if (curA == null) {
//	             rest = curB;
//	         }

//	         while (rest != null) {
//	             if (!pool.add(rest)) {
//	                 return rest;
//	             }

//	             rest = rest.next;
//	         }

//	         return null;
//	     }

//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode a = headA;
//		ListNode b = headB;
//		boolean[] flag = new boolean[2];
//
//		while (a != b) {
//			a = a.next;
//			b = b.next;
//
//			if (a == null) {
//				if (flag[0]) {
//					return null;
//				}
//
//				flag[0] = true;
//				a = headB;
//			}
//
//			if (b == null) {
//				if (flag[1]) {
//					return null;
//				}
//				flag[1] = true;
//				b = headA;
//			}
//
//		}
//
//		return a;
//	}

	// No need flag!!!!

	/*
	 * 
	 * 
	 * 
	 * How it is working in case of no intersection I am not getting it as for me it
	 * should end up infinite loop. Can anyone explain it to me?
	 * 
	 * 4 Hide 1 reply Reply Share Report dergyfresh's avatar dergyfresh 5 Last Edit:
	 * July 27, 2023 5:26 PM
	 * 
	 * --->>> !!!  I was thinking the same thing until I realized that since each
	 * pointer reaches the end of its list at the same time, they will both be equal
	 * to null at the end.
	 * 
	 * 6 Reply Share Report
	 * 
	 * 
	 */

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
//		boolean[] flag = new boolean[2];

		while (a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;

//             if (a == null) {
//                 if (flag[0]) {              
//                     return null;
//                 }

//                 flag[0] = true;
//                 a = headB;
//             }

//             if (b == null) {
//                 if (flag[1]) {              
//                     return null;
//                 }
//                 flag[1] = true;
//                 b = headA;
//             } 

		}

		return a;
	}

	/**
	 * 
	 * 
	 * 
	 * 8 [4,1,8,4,5] [5,6,1,8,4,5] 2 }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LT160 test = new LT160();
		ListNode dup0 = new ListNode(8);
		ListNode dup1 = new ListNode(4);
		ListNode dup2 = new ListNode(5);
		dup0.next = dup1;
		dup1.next = dup2;

		ListNode a = new ListNode(4);
		a.next = new ListNode(1);
		a.next.next = dup0;

		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(1);
		b.next.next.next = dup0;

		test.getIntersectionNode(a, b);

	}

}
