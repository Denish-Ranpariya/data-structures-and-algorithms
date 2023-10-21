package recursion;

/**
 * leetcode 198. House Robber
 * <p>
 * with recursion will give TLE, can be solved using DP
 * <p>
 * for explanation one note -> recursion
 */
public class Program16 {
    public int rob(int[] nums) {
        return solve(nums, 0);
    }

    private int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        // rob house at index
        int option1 = nums[index] + solve(nums, index + 2);

        // not robbing house at index
        int option2 = solve(nums, index + 1);

        // find max amount out of these two options
        return Math.max(option1, option2);
    }
}
