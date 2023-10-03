package searching_and_sorting;

/**
 * BOOK ALLOCATION PROBLEM
 * MMMMMIMP
 * <p>
 * for explanation, see video and refer notes from one note -> sorting and searching
 */
public class Program10 {
    public static int findPages(int[] a, int n, int m) {
        //Your code here

        if (m > n) {
            return -1;
        }

        int start = 0;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int end = sum;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossibleSolution(a, n, m, mid)) {
                //save and go to left to minimize ans
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossibleSolution(int[] a, int n, int m, int mid) {
        int count = 0;
        int totalPages = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > mid) {
                return false;
            }

            if (totalPages + a[i] > mid) {
                count++;
                totalPages = 0;
                totalPages = a[i];

                if (count == m) {
                    return false;
                }
            } else {
                totalPages += a[i];
            }
        }

        return true;
    }
}
