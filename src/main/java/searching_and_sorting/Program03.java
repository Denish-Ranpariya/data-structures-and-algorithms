package searching_and_sorting;

/**
 * Leetcode 34
 * <p>
 * Find the First and Last Position of Element in Sorted Array
 * <p>
 * For explanation one note -> sorting and searching
 * <p>
 * similar - first occurrence, last occurrence of a number in sorted array
 */
public class Program03 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        int index1 = -1;

        while (start <= end) {
            int mid = end - (end - start) / 2;

            if (nums[mid] == target) {
                index1 = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        start = 0;
        end = n - 1;

        int index2 = -1;

        while (start <= end) {
            int mid = end - (end - start) / 2;

            if (nums[mid] == target) {
                index2 = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new int[]{index1, index2};
    }
}
