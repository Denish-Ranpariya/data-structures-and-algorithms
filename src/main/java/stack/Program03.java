package stack;

import java.util.Stack;

/**
 * GFG Next Greater Element
 * <p>
 * MIMP
 */
public class Program03 {
    public static long[] nextLargerElement(long[] arr, int n) {

        // array to store the result
        long[] result = new long[n];

        Stack<Long> s = new Stack<>();


        // iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            long current = arr[i];

            // if the stack is empty then store -1 as the next greater element and push the current element
            if (s.isEmpty()) {
                result[i] = -1;
                s.push(current);
            } else {
                // pop until the greater element found on top of the stack
                while (!s.isEmpty() && s.peek() <= current) {
                    s.pop();
                }

                // if the stack is empty store -1 as next greater element else store the element on top of the stack
                if (s.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = s.peek();
                }

                // push current element to the stack
                s.push(current);
            }
        }

        return result;
    }
}
