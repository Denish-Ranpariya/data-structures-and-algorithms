package recursion;

/**
 * recursively double each element in array
 */
public class Program08 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};

        doubleArray(arr, 0);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void doubleArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        arr[index] = 2 * arr[index];

        doubleArray(arr, index + 1);
    }
}
