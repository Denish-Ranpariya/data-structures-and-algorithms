package stack;

import java.util.Stack;

/**
 * Leetcode 20. Valid Parentheses
 */
public class Program01 {
    public boolean isValid(String str) {
        int n = str.length();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            //if it is opening then push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // if it is closing then check the top element for opening and pop it
                if (ch == ')') {
                    if (!s.isEmpty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        return false;
                    }
                } else if (ch == '}') {
                    if (!s.isEmpty() && s.peek() == '{') {
                        s.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (!s.isEmpty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        // at the end if the stack is empty then Parentheses are balanced
        return s.isEmpty();
    }
}
