package searching_and_sorting;

/**
 * Painter's partition problem
 * same as book allocation problem
 */
public class Program11 {
    static long minTime(int[] a, int n, int k) {
        //code here

        long start = 0L;

        long sum = 0L;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        long end = sum;

        long ans = -1L;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isPossibleSolution(a, n, k, mid)) {
                //save and go to left to minimize it
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossibleSolution(int[] a, int n, int k, long mid) {
        long totalTime = 0L;

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > mid) {
                return false;
            }

            if (totalTime + a[i] > mid) {
                count++;
                totalTime = 0L;
                totalTime = a[i];

                if (count == k) {
                    return false;
                }
            } else {
                totalTime += a[i];
            }
        }

        return true;
    }
}
