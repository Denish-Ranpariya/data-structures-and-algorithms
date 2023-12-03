package stack;

import java.util.Stack;

/**
 * Leetcode 32. Longest Valid Parentheses
 */
public class Program06 {
    public int longestValidParentheses(String s) {

        //for characters
        Stack<Character> cs = new Stack<>();

        //to keep track of last invalid index
        Stack<Integer> is = new Stack<>();

        //last invalid index is -1 initially
        is.push(-1);
        int n = s.length();

        int max = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            //if opening bracket push it to character stack and index to index stack
            if (ch == '(') {
                cs.push(ch);
                is.push(i);
            } else {
                //closing bracket

                //check for opening bracket on top in character stack
                if (!cs.isEmpty() && cs.peek() == '(') {

                    //pop from both the stacks
                    cs.pop();
                    is.pop();

                    //calculate length
                    int len = i - is.peek();
                    max = Math.max(max, len);

                } else {
                    //it's an invalid index, so push it to index stack
                    is.push(i);
                }
            }
        }

        return max;
    }
}
