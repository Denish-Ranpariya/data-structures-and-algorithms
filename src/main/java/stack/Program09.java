package stack;

import java.util.Stack;

/**
 * GFG - The Celebrity Problem
 * MMIMP
 * for explanation one note -> stack
 */
public class Program09 {
    int celebrity(int[][] m, int n) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int a = s.pop();
            int b = s.pop();

            if (m[a][b] == 1) {
                // a is not celeb
                s.push(b);
            } else {
                // b is not celeb
                s.push(a);
            }
        }

        //potential celeb
        int pot = s.pop();

        for (int i = 0; i < n; i++) {
            if (pot != i) {
                if (m[pot][i] != 0 || m[i][pot] != 1) {
                    return -1;
                }
            }

        }

        return pot;
    }
}
