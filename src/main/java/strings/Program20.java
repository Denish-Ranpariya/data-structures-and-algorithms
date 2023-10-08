package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 6. Zigzag Conversion
 * for explanation one note -> char arrays and strings
 */
public class Program20 {
    public String convert(String s, int numRows) {
        int n = s.length();

        if (numRows == 1) {
            return s;
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add("");
        }

        list.set(0, String.valueOf(s.charAt(0)));
        int row = 1;

        //false - top tp bottom
        //true - bottom to top
        boolean dir = false;

        for (int i = 1; i < n; i++) {
            if (row == numRows) {
                row = numRows - 2;
                dir = true;
            }

            if (row == -1) {
                row = 1;
                dir = false;
            }

            list.set(row, list.get(row) + s.charAt(i));

            if (dir) row--;
            else row++;

        }

        String ans = "";

        for (int i = 0; i < numRows; i++) {
            ans += list.get(i);
        }

        return ans;
    }
}
