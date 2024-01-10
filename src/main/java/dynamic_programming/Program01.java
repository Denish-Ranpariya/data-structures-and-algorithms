package dynamic_programming;

import java.util.Arrays;

/**
 * For explanation one note -> dynamic programming
 */
public class Program01 {
    //     method - 1 : recursion + memoization
    int[] dp;

    public int fib(int n) {
        dp = new int[n + 1]; // step 1 : create dp array
        Arrays.fill(dp, -1);
        return solveUsingMemoization(n);
    }

    int solveUsingMemoization(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // step 3 : check before recursive call
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solveUsingMemoization(n - 1) + solveUsingMemoization(n - 2); // step 2 : store result in dp array
        return dp[n];
    }

    //method - 2 : tabulation method
    public int fib2(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1]; // step - 1 create dp array

        dp[0] = 0;
        dp[1] = 1; // step - 2 fill initial values according to base case

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // step - 3 fill remaining values according to recursive relation
        }

        return dp[n];
    }

    // method - 3 : Tabulation method with space optimization
    public int fib1(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 0;
        int current = 1;

        int ans = 0;

        for (int i = 2; i <= n; i++) {
            ans = prev + current;
            prev = current;
            current = ans;
        }

        return ans;
    }

}
