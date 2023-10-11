package recursion;

/**
 * leetcode 70
 * <p>
 * similar to fibonacci
 * <p>
 * for explanation one note -> recursion
 * <p>
 * answer is correct but gives TLE
 * <p>
 * can be solved using DP
 */
public class Program03 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
