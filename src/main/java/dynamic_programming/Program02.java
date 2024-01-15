package dynamic_programming;

import java.util.Arrays;

public class Program02 {
     //using recursion
     public int rob(int[] nums) {
         return solveUsingRecursion(nums, 0);
     }

    public int solveUsingRecursion(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        int option1 = nums[index] + solveUsingRecursion(nums, index + 2);
        int option2 = 0 + solveUsingRecursion(nums, index + 1);

        return Math.max(option1, option2);
    }

    // M-1 using recursion + memoization

    int[] dp; // step 1 - create dp array

    public int rob1(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveUsingMemoization(nums, 0);
    }

    public int solveUsingMemoization(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        // step - 3 check if answer already exists
        if (dp[index] != -1) {
            return dp[index];
        }

        int option1 = nums[index] + solveUsingMemoization(nums, index + 2);
        int option2 = 0 + solveUsingMemoization(nums, index + 1);

        dp[index] = Math.max(option1, option2); // step-2 store answer
        return dp[index];
    }

    // M-2 solve using tabulation
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // stpe-1 create dp array

        //step - 2 fill initial values according to base case
        //but base case having condition only for index out of bound hence can't be used for filling initial values
        // think about what we can fill in initial stage
        // we can't fill dp[0] as it represents answer strting from 0 till end
        // we can fill last element dp[n-1]

        dp[n - 1] = nums[n - 1]; // because as last house only possibility is to rob it

        //step - 2 fill remaining elements acording to recursive relation
        //as we have already filled n-1 we will go reverse in the loop
        for (int i = n - 2; i >= 0; i--) {
            int option1 = nums[i] + (((i + 2) < n) ? dp[i + 2] : 0);
            int option2 = 0 + dp[i + 1];

            dp[i] = Math.max(option1, option2);
        }

        return dp[0]; // 0 because we started building answer from n-1
    }

    // M-3 space optimization
    public int rob4(int[] nums) {
        int n = nums.length;

        //corner case
        if (n == 1) {
            return nums[0];
        }

        // two variables because dp[i] depends on dp[i+1] and dp[i+2]
        int next = nums[n - 1]; // represents i+1
        int nextToNext = 0; // represents i+2

        int current = 0;

        for (int i = n - 2; i >= 0; i--) {
            int option1 = nums[i] + (((i + 2) < n) ? nextToNext : 0);
            int option2 = 0 + next;

            current = Math.max(option1, option2);

            //most important - update variables
            nextToNext = next;
            next = current;
        }

        return current;
    }
}
