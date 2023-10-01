package searching_and_sorting;

/**
 * find missing element in sorted array
 * <p>
 * n = size of an array
 * arrays contains elements from 1 to n + 1
 * <p>
 * n = 8
 * 1 -> 9
 * 1 2 3 4 6 7 8 9
 * ans = 5
 * <p>
 * for explanation one note -> searching and sorting
 */
public class Program06 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};

        int missingNumber = findMissingNumber(arr);

        System.out.println("Missing number is : " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == mid + 1) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans == -1 ? n + 1 : ans + 1;
    }
}
