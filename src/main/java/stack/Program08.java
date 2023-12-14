package stack;

import java.util.Stack;

/**
 * Leetcode 1047. Remove All Adjacent Duplicates In String
 *
 * For explanation one note -> stack
 */
public class Program08 {
    public String removeDuplicates(String str) {
        int n = str.length();

        Stack<Character> s = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            char ch = str.charAt(i);

            if(!s.isEmpty() && s.peek() == ch) {
                s.pop();
            } else {
                s.push(ch);
            }
        }

        String ans = "";

        while(!s.isEmpty()) {
            ans = s.pop() + ans;
        }


        return ans;
    }
}
