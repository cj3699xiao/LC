package leetcode;

import java.util.*;

public class LT150 {

	class Solution {
	    /*
	    Assume input is correct. 
	    
	    "10","6","9","3","+","-11","*","/","*","17","+","5","+"
	                                                 x
	    
	    number stack:   
	    
	    
	    result :22
	    
	    
	    // meet number --> save in number stack
	    // meet operation --> if result is null, find last two elements in number stack, then do operation
	                      --> if result is not null, find the last one element number stack and do operation
	                      

	    Here's the step-by-step calculation of the given RPN expression ["4", "-2", "/", "2", "-3", "-", "-"]:

	Initialize an empty stack.
	Read the tokens from left to right.
	Perform operations as soon as we encounter an operator, using the last two elements from the stack as operands.
	Let's break it down:

	Token: 4

	Action: Push 4 onto the stack.
	Stack: [4]
	Token: -2

	Action: Push -2 onto the stack.
	Stack: [4, -2]
	Token: / (division)

	Action: Pop the last two elements (-2 and 4) and perform the operation 4 / -2.
	Result: -2 (since 4 / -2 = -2)
	Push the result back onto the stack.
	Stack: [-2]
	Token: 2

	Action: Push 2 onto the stack.
	Stack: [-2, 2]
	Token: -3

	Action: Push -3 onto the stack.
	Stack: [-2, 2, -3]
	Token: - (subtraction)

	Action: Pop the last two elements (-3 and 2) and perform the operation 2 - (-3).
	Result: 5 (since 2 - (-3) = 2 + 3 = 5)
	Push the result back onto the stack.
	Stack: [-2, 5]
	Token: - (subtraction)

	Action: Pop the last two elements (5 and -2) and perform the operation -2 - 5.
	Result: -7 (since -2 - 5 = -7)
	Push the result back onto the stack.
	Stack: [-7]
	    
	    CA:  string[]  --> int
	    
	    R:  iteration with logic above (brote force)
	    
	        // Length of input array is n
	        TC: O(n)
	        SC: O(n)  // the max length of the number stack (approx n/2)
	        
	    T: as above      
	    */
	    public int evalRPN(String[] tokens) {
	        ArrayDeque<Integer> numStack = new ArrayDeque<>();
	        
	        // Corner case
	        if (tokens.length == 1) {
	            return getNumber(tokens[0]);
	        }
	        
	        for (int i = 0; i < tokens.length; i++) {
	            String cur = tokens[i];
	            if (isNumber(cur)) {
	                numStack.offerLast(getNumber(cur));
	            } else {       
	                int first = numStack.pollLast();
	                int second = numStack.pollLast(); 

	                int result = doCal(cur, second, first);
	                numStack.offerLast(result);
	            }
	        }
	        
	        return numStack.pollLast();
	    }
	    
	    private boolean isNumber(String input) {
	        String[] ops = new String[] {"+","-","*","/"};
	        for (int i = 0; i < ops.length; i++) {
	            // Assume only valid number and operations is inside input array
	            if (input.equals(ops[i])) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private int getNumber(String input) {
	        boolean neg = false;
	        int res = 0;
	        for (int i = 0; i < input.length(); i++) {
	            if (input.charAt(i) == '-') {
	                neg = true;
	                continue;
	            }
	            int cur = input.charAt(i) - '0';
	            res = res * 10 + cur;
	        }
	            
	        return neg ? (res * -1): res;
	    }
	    
	    private int doCal(String input, int a, int b) {     
	        switch (input) {
	            case "+":
	                return a + b;
	            case "-":
	                return a - b;
	            case "*": 
	                return a * b;
	            default:
	                return a / b;
	        } 
	    }

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT150 a = new LT150();
		Solution b = a.new Solution();

		System.out.println(b.evalRPN(new String[] { "3", "11", "+", "5", "-" }));

	}

}
