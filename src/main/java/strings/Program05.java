package strings;

import java.util.Stack;

/**
 * leetcode 1209
 * 1209. Remove All Adjacent Duplicates in String II
 * <p>
 * MMIMP
 * <p>
 * for explanation one note -> character array and string
 */
public class Program05 {

    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (charStack.isEmpty() || countStack.isEmpty() || charStack.peek() != ch) {
                charStack.push(ch);
                countStack.push(1);
            } else {
                if (countStack.peek() == k - 1) {
                    charStack.pop();
                    countStack.pop();
                } else {
                    int top = countStack.pop();
                    countStack.push(top + 1);
                }
            }
        }

        String ans = "";
        while (!charStack.isEmpty()) {
            int count = countStack.pop();
            char ch = charStack.pop();

            for (int i = 0; i < count; i++) {
                ans += ch;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans);

        return sb.reverse().toString();
    }
}
