package stack;

import java.util.Stack;

/**
 * Leetcode 85. Maximal Rectangle
 * <p>
 * For explanation one note -> stack
 * <p>
 * with help of largest area of a histogram
 */
public class Program15 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] current = new int[col];

        int largestArea = 0;

        for (int i = 0; i < row; i++) {
            boolean isFirstRow = i == 0;

            for (int j = 0; j < col; j++) {
                int num = Character.getNumericValue(matrix[i][j]);
                current[j] = isFirstRow || num == 0 ? num : num + current[j];
            }
            int area = largestRectangleArea(current);
            largestArea = Math.max(area, largestArea);
        }

        return largestArea;
    }

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
