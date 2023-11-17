package stack;

import java.util.Stack;

/**
 * Leetcode 84. Largest Rectangle in Histogram
 */
public class Program05 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // we will store the indices in the stack
        Stack<Integer> s = new Stack<>();

        // next smaller element
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                s.push(i);
                right[i] = n;
            } else {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    right[i] = n;
                } else {
                    right[i] = s.peek();
                }
                s.push(i);
            }
        }

        s.clear();

        // prev smaller element
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                left[i] = -1;
            } else {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = s.peek();
                }
                s.push(i);
            }
        }

        //calculate the maximum area

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            //important
            int width = right[i] - left[i] - 1;
            int area = height * width;

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
