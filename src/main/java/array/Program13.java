package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral print matrix
 * <p>
 * leetcode 54
 * <p>
 * for explanation one note -> arrays
 */
public class Program13 {
    public List<Integer> spiralOrder(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;

        int dir = 0;

        int rowStart = 0, rowEnd = rows - 1, columnStart = 0, columnEnd = columns - 1;

        List<Integer> result = new ArrayList<>();

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            if (dir == 0) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    result.add(arr[rowStart][j]);
                }
                rowStart++;
            } else if (dir == 1) {
                for (int i = rowStart; i <= rowEnd; i++) {
                    result.add(arr[i][columnEnd]);
                }
                columnEnd--;
            } else if (dir == 2) {
                for (int j = columnEnd; j >= columnStart; j--) {
                    result.add(arr[rowEnd][j]);
                }
                rowEnd--;
            } else {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(arr[i][columnStart]);
                }
                columnStart++;
            }

            dir = (dir + 1) % 4;
        }
        return result;
    }
}
