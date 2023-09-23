package array;

import java.util.HashSet;
import java.util.Set;

/**
 * First Repeating Element - GFG
 * <p>
 * use set
 * traverse from end
 * save the ans
 */
public class Program10 {
    public static int firstRepeated(int[] arr, int n) {
        // Your code here

        int ans = -1;

        Set<Integer> hs = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            if (hs.contains(arr[i])) {
                ans = i;
            } else {
                hs.add(arr[i]);
            }
        }
        return ans == -1 ? -1 : ans + 1;
    }
}
