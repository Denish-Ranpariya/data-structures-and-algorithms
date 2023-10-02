package searching_and_sorting;

/**
 * Exponential binary search
 * <p>
 * For explanation one note -> searching and sorting
 * <p>
 * search in a long sorted array
 */
public class Program09 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 11, 13, 14, 15, 56, 70};

        int target = 70;

        int index = exponentialSearch(arr, target);

        System.out.println("found at index : " + index);
    }

    private static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        int i = 1;

        // while element at index i is less than or equal to target jump by double
        while (i < arr.length - 1 && arr[i] <= target) {
            i = i * 2;
        }

        // start = i / 2
        // end = minimum of (n - 1) and i
        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), target);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
