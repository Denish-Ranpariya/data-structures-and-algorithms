package searching_and_sorting;

/**
 * Leetcode 33
 * <p>
 * Search in Rotated Sorted Array
 * <p>
 * MMMIMP
 * <p>
 * first find pivot element sub-problem MMIMP
 * <p>
 * then binary search
 * <p>
 * for explanation see YouTube video of Aditya Verma
 */
public class Program05 {

    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivotElementIndex = findPivotElement(nums);
        if (pivotElementIndex == -1) {
            return -1;
        }

        int firstHalfResult = searchElement(nums, 0, pivotElementIndex - 1, target);

        if (firstHalfResult != -1) {
            return firstHalfResult;
        }

        return searchElement(nums, pivotElementIndex, n - 1, target);
    }

    private int findPivotElement(int[] nums) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int nextIndex = (mid + 1) % n;
            int prevIndex = (mid + n - 1) % n;
            if (nums[mid] < nums[nextIndex] && nums[mid] < nums[prevIndex]) {
                return mid;
            } else {
                if (nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
                    return start;
                } else if (nums[start] <= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    private int searchElement(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
