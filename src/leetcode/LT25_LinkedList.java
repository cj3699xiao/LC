package leetcode;

import leetcode.DataStructure.ListNode;

public class LT25_LinkedList {
	
    public ListNode reverseKGroup(ListNode head, int k) {      
        if (k == 1) {
            return head;
        }
        
        ListNode res = new ListNode(-1);
        ListNode PN = res;
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null) {
            // Fast move 
            for (int i = 0; i <= k - 2; i++) {  // k - 1 - 1
                fast = fast.next;
                if (fast == null) {
                    // not enough, keep the rest
                    PN.next = slow;
                    return res.next; 
                }
            }
            ListNode nextStart = fast.next;
            
            // Reverse and update
            ListNode sectionStart = reverse(slow, fast);
            PN.next = sectionStart;
            PN = slow; // new tie is slow now
            fast = nextStart;
            slow = nextStart;
        }
        
        
        return res.next;
    }
    
    
    private ListNode reverse(ListNode slow, ListNode fast) {
        ListNode pre = slow;  
        ListNode cur = slow.next;
        ListNode nextOne = slow.next.next;
        
        pre.next = null; // remove the first pointing
        
        while (true) {
            // pre.next = null;
            cur.next = pre;
            
            if (cur == fast) {
                break;
            }
            pre = cur;
            cur = nextOne;
            nextOne = nextOne.next;
        }   
        return cur;
    }
	
	public static void main(String args[]) {
		LT25_LinkedList a = new LT25_LinkedList();
		ListNode s = new ListNode(1);
		s.next = new ListNode(2);
		s.next.next = new ListNode(3);
		s.next.next.next = new ListNode(4);
		s.next.next.next.next = new ListNode(5);
		a.reverseKGroup(s, 2);
	}
}
