package strings;

import java.util.Stack;

/**
 * leetcode 1047
 * Remove All Adjacent Duplicates In String
 * <p>
 * for explanation one note -> character array and string
 */
public class Program02 {
    public String removeDuplicates(String s) {
        // using string
        // int n = s.length();

        // String ans = "";

        // for(int i = 0; i < n; i++) {
        //     char ch = s.charAt(i);

        //     int ansLength = ans.length();

        //     //last char of ans is equal to current char
        //     //remove last char from ans
        //     if(ansLength > 0 && ans.charAt(ansLength - 1) == ch) {
        //         ans = ans.substring(0, ansLength - 1);
        //     } else {
        //         ans = ans + ch;
        //     }
        // }

        // return ans;

        //using stack
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            ans = ch + ans;
        }

        return ans;
    }
}
