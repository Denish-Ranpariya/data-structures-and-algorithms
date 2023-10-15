package recursion;

/**
 * print all sub arrays recursively
 */
public class Program21 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        iterateOverArray(arr, 0);
    }

    private static void iterateOverArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        printSubArray(arr, index, index);
        System.out.println();

        iterateOverArray(arr, index + 1);
    }

    private static void printSubArray(int[] arr, int start, int end) {
        if (end == arr.length) {
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        printSubArray(arr, start, end + 1);
    }
}
