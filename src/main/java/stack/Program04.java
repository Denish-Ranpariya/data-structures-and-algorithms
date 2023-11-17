package stack;

import java.util.Stack;

/**
 * leetcode 1475. Final Prices With a Special Discount in a Shop
 * <p>
 * similar to next greater element
 * <p>
 * here we need to find next smaller element so the condition for popping the element will be changed
 */
public class Program04 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        Stack<Integer> s = new Stack<>();
        int[] nextSmallerElement = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int current = prices[i];

            if (s.isEmpty()) {
                nextSmallerElement[i] = -1;
                s.push(current);
            } else {
                // pop until the smaller element is found on top of the stack
                while (!s.isEmpty() && s.peek() > current) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    nextSmallerElement[i] = -1;
                } else {
                    nextSmallerElement[i] = s.peek();
                }
                s.push(current);
            }
        }

        int[] discountedPrices = new int[n];

        for (int i = 0; i < n; i++) {
            int discount = nextSmallerElement[i] == -1 ? 0 : nextSmallerElement[i];
            discountedPrices[i] = prices[i] - discount;
        }

        return discountedPrices;
    }
}
