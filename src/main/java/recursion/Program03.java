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
        return solve(n, 0);
    }

    // just create a recursion tree to solve this
    int solve(int totalStairs, int currentPosition) {
        if (currentPosition == totalStairs) {
            return 1;
        }

        if (currentPosition > totalStairs) {
            return 0;
        }

        return solve(totalStairs, currentPosition + 1) + solve(totalStairs, currentPosition + 2);
    }
}
