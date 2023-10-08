package strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 179. Largest Number
 * <p>
 * for explanation one note -> char arrays and strings
 */
public class Program21 {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] snums = new String[n];

        for (int i = 0; i < n; i++) {
            snums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(snums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String t1 = s1 + s2;
                String t2 = s2 + s1;

                return t2.compareTo(t1);
            }
        });

        if (snums[0].equals("0")) {
            return "0";
        }

        String ans = "";

        for (String s : snums) {
            ans += s;
        }

        return ans;
    }
}
