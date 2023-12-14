package stack;

import java.util.Stack;

/**
 * GFG - Count the Reversals
 *
 * For explanation one note -> stack
 */
public class Program07 {
    int countRev(String str) {
        int n = str.length();

        // if odd length then impossible to balance
        if (n % 2 == 1) {
            return -1;
        }

        Stack<Character> s = new Stack<>();

        // iterate through string and remove balanced pairs
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '{') {
                s.push(ch);
            } else {
                if (!s.isEmpty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(ch);
                }
            }
        }

        int count = 0;

        while (!s.isEmpty()) {
            //remove top 2 elements
            char ch1 = s.pop();
            char ch2 = s.pop();

            // if both are same "((" or "))" then it will take one reversal to balance
            if (ch1 == ch2) {
                count += 1;
            } else {
                // if both are not same ")(" then it will take two reversal to balance
                count += 2;
            }
        }

        return count;
    }
}
