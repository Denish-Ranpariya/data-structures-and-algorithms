package dynamic_programming;

import java.util.Arrays;

/**
 * Leetcode 322 : Coin change
 * MMMMIMP
 *
 */
public class Program03 {
     // using recursion
     public int coinChange(int[] coins, int amount) {
         int result = solveUsingRecursion(coins, amount);
         return result == Integer.MAX_VALUE ? -1 : result;
     }

    public int solveUsingRecursion(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }

        // calculate the min nuo of coints required to create given amount
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            // do recursive call only if amount is valid
            if (amount >= coins[i]) {
                int recursionAns = solveUsingRecursion(coins, amount - coins[i]);

                // calculate min only if it's not int max
                if (recursionAns != Integer.MAX_VALUE) {
                    int ans = 1 + recursionAns;
                    min = Math.min(min, ans);
                }
            }
        }

        return min;
    }


     // M-1 : using memoization
     int[] dp; // step-1 create dp array, 1-D because only 1 param is changing in recursion

    public int coinChange1(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = solveUsingMemo(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int solveUsingMemo(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // step - 3 : check if ans is there in dp array or not
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            if (amount >= coins[i]) {
                int recursionAns = solveUsingMemo(coins, amount - coins[i]);

                if (recursionAns != Integer.MAX_VALUE) {
                    int ans = 1 + recursionAns;
                    min = Math.min(min, ans);
                }
            }
        }

        // step - 2 : store ans in dp array
        dp[amount] = min;
        return dp[amount];
    }

    // M-2 solve using tabulation
    public int coinChange2(int[] coins, int amount) {
        // step - 1 create dp array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // fill array with int max because of condition at label #here

        dp[0] = 0; // step - 2 : fill initial values according to base case

        // step - 3 : loop to fill remaining values
        for (int j = 1; j <= amount; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {

                if (j >= coins[i]) {
                    int recursionAns = dp[j - coins[i]];

                    if (recursionAns != Integer.MAX_VALUE) { // #here
                        int ans = 1 + recursionAns;
                        min = Math.min(min, ans);
                    }
                }
            }
            dp[j] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    // M-3 using space optimization
    // dp[j] depends on dp[j - coins[i]]
    // here coins[i] can be anything based on coins array
    // so space optimization can not be done
}
