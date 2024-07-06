package leetcode.dataStructureQuestion;

import java.util.HashMap;

/* LeetCode question 146
 * https://leetcode.com/problems/lru-cache/
 * 
 * */

public class LRUCache {
	
    HashMap<Integer, ListNode> map;
    int capacity;
    int count; 
    ListNode head;
    ListNode tail;
    
    
    public LRUCache(int _capacity) {
        if (_capacity <= 0) {
            throw new IllegalArgumentException();
        }
        capacity = _capacity;
        map = new HashMap<>();      
    }
    
    public int get(int key) {
        int toReturn = -1;
        if (map.get(key) != null) {
            ListNode cur = map.get(key);
            toReturn = cur.val;
            
            removeNode(cur);
            addNode(cur.key, cur.val);
        } 
        
        return toReturn;
    }
    
    public void put(int key, int value) {
        if (map.get(key) == null) {
            // Add new one
            if (count == capacity) {
                // Need to remove LRU one, where head is pointing.
                removeLRUNode();
                addNode(key, value);           
            } else {
                // Normal add 
                addNode(key, value);
            }
            
        } else {
            // Update exist one, also update recent used LinkedList
            removeNode(map.get(key));
            addNode(key, value);
        }
        
    }
    
    private void removeNode(ListNode node) {
    	if (node == head) {
    		removeLRUNode();
    	} else {
    		if(node == tail) {
    			tail = node.prev;
    		}
    		
    		node.prev.next = node.next;
    		node.prev = null;
    		node.next = null;
    		
            map.remove(node.key);
            count--;
    	}
    	


    }
    
    private void removeLRUNode() {
        map.remove(head.key);
        ListNode newHead = head.next;
        head.next = null;
        head = newHead;
        count--;
    }
    
    private void addNode(int key, int value){
        // Normal add 
        if (count == 0) {
            // First one
            ListNode newNode = new ListNode(key, value, null, null);

            // Update head & tail
            head = newNode;
            tail = newNode;

            // Update map 
            map.put(key, newNode);          
        } else {
            // More than one
            ListNode newNode = new ListNode(key, value, tail, null);

            // Update last one's next, and update tail
            tail.next = newNode;
            tail = newNode;
            map.put(key, newNode);
        } 
        count++;
    }
    
    class ListNode {
        ListNode next;
        ListNode prev;
        int val;
        int key;
        
        ListNode(int _key, int _val, ListNode _prev, ListNode _next) {
            key = _key;
            val = _val;
            next = _next;
            prev = _prev;
        }
    }

	public static void main(String[] args) {
		LRUCache test = new LRUCache(2);
		
		// [null,null,null,1,null,-1,null,-1,3,4]
//		test.put(1, 1);
//		test.put(2, 2);
//		System.out.print(test.get(1));
//		test.put(3, 3);
//		System.out.print(test.get(2));
//		test.put(4, 4);
//		System.out.print(test.get(1));
//		System.out.print(test.get(3));
//		System.out.print(test.get(4));
		
		// ["LRUCache","put","put","get","get","put","get","get","get"]
		// [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
		test.put(2, 1);
		test.put(3, 2);
		System.out.print(test.get(3));
		System.out.print(test.get(2));
		test.put(4, 3);
		System.out.print(test.get(2));
		System.out.print(test.get(3));
		System.out.print(test.get(4));
		
	}

}
