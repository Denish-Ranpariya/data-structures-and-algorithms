package array;

/**
 * leetcode - 724
 * Find Pivot Index
 * for explanation
 * one note -> array
 */
public class Program08 {

    public int pivotIndexMethod1(int[] nums) {

        //method - 1 using prefix sums
        int n = nums.length;

        int[] prefixSum = new int[n];
        int[] prefixSumRev = new int[n];

        //calculating prefix sums
        prefixSum[0] = 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        //calculatin prefix sum in reverse
        prefixSumRev[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            prefixSumRev[i] = prefixSumRev[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == prefixSumRev[i]) {
                return i;
            }
        }

        return -1;
    }

    public int pivotIndexMethod2(int[] nums) {
        int n = nums.length;

        int leftSum = 0;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
