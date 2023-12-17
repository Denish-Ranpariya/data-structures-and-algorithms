package stack;

import java.util.Stack;

/**
 * Leetcode 71. Simplify Path
 * For explanation one note -> stack
 */
public class Program14 {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");

        int n = splits.length;

        Stack<String> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            String current = splits[i];

            if (current.equals(".") || current.isEmpty()) {
                // do nothing
            } else if (current.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(current);
            }
        }

        String result = "";
        while (!s.isEmpty()) {
            result = "/" + s.pop() + result;
        }

        return result.isEmpty() ? "/" : result;
    }
}
