package searching_and_sorting;

/**
 * leetcode 540
 * Single Element in a Sorted Array
 * <p>
 * for explanation one note -> searching and sorting
 */
public class Program07 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 0) {
                if (mid != n - 1 && nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else if (mid != 0 && nums[mid] == nums[mid - 1]) {
                    end = mid - 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid != 0 && nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
