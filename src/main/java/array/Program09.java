package array;

/**
 * Leetcode 287.
 * Find the Duplicate Number
 * MMIMP
 * using marking index method
 */
public class Program09 {

    public int findDuplicate(int[] nums) {
        int l = nums.length;

        for (int i = 0; i < l; i++) {
            int num = nums[i];
            int index = Math.abs(num);

            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = -nums[index];
            }
        }

        return -1;
    }
}
