package stack;

import java.util.Stack;

/**
 * Leetcode 394. Decode String
 * For explanation one note -> stack
 */
public class Program13 {
    public String decodeString(String str) {
        int n = str.length();

        Stack<String> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // opening bracket just push it
            if (ch == '[') {
                s.push("[");
            } else if (Character.isDigit(ch)) {

                // if it's a digit then check top element, if top element is also a digit then apped it to top element
                if (!s.isEmpty() && Character.isDigit(s.peek().charAt(0))) {
                    s.push(s.pop() + ch);
                } else {
                    s.push(Character.toString(ch));
                }
            } else if (ch == ']') {
                // if it's a closing bracket then pop until opening bracket and store the string
                String poppedString = "";
                while (!s.isEmpty() && !s.peek().equals("[")) {
                    poppedString += s.pop();
                }
                s.pop(); //pop opening bracket

                // check of number element
                if (!s.isEmpty()) {
                    int num = Integer.parseInt(s.pop());
                    String res = "";

                    for (int j = 0; j < num; j++) {
                        res += poppedString;
                    }
                    s.push(res);
                } else {
                    s.push(poppedString);
                }
            } else {
                // if its a character
                s.push(Character.toString(ch));
            }
        }

        // pop until stack becomes empty
        StringBuilder result = new StringBuilder();

        while (!s.isEmpty()) {
            result.append(s.pop());
        }

        // return reverse string as result
        return result.reverse().toString();
    }
}
