package stack;

import java.util.Stack;

/**
 * Leetcode 1003. Check If Word Is Valid After Substitutions
 * to understand the question one note -> stack
 */
public class Program12 {
    public boolean isValid(String str) {
        int n = str.length();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            s.push(ch); //push current char to stack

            // pop top 3 element check if it's "abc"
            if (s.size() >= 3) {
                char first = s.pop();
                char second = s.pop();
                char third = s.pop();

                String top = "" + third + second + first;

                //if not "abc" then push it again to stack
                if (!top.equals("abc")) {
                    s.push(third);
                    s.push(second);
                    s.push(first);
                }
            }
        }

        // at last if stack becomes empty then it is valid
        return s.isEmpty();
    }
}
