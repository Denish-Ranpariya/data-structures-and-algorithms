package array;

/**
 * leetcode 26
 * Remove Duplicates from Sorted Array
 * for explanation one note -> arrays
 */
public class Program16 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int lastUniqueElementIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[lastUniqueElementIndex]) {
                lastUniqueElementIndex++;
                int temp = nums[lastUniqueElementIndex];
                nums[lastUniqueElementIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return lastUniqueElementIndex + 1;
    }
}
