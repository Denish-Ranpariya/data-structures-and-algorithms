package recursion;

/**
 * Find minimum element in array using recursion
 */
public class Program06 {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, -100};

        int min = findMin(arr, 0);
        System.out.println("Min : " + min);
    }

    private static int findMin(int[] arr, int index) {
        if (index == arr.length) {
            return min;
        }

        min = Math.min(arr[index], min);

        return findMin(arr, index + 1);
    }
}
