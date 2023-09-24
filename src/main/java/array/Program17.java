package array;

/**
 * leetcode 643
 * Maximum Average Subarray I
 * sliding window
 * for explanation one note -> arrays
 */
public class Program17 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum / (double) k;
    }
}
