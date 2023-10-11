package recursion;

/**
 * Find maximum element in array using recursion
 */
public class Program09 {
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, -100};

        findMax(arr, 0);
        System.out.println("maxNumber : " + max);
    }

    private static void findMax(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        max = Math.max(arr[index], max);

        findMax(arr, index + 1);
    }
}
