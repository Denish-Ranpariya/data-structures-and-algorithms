package recursion;

/**
 * Print all elements of array using recursion
 */
public class Program04 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,40};

        printArray(arr, 0);
    }

    private static void printArray(int[] arr, int index) {
        if(index == arr.length) {
            return;
        }

        System.out.println(arr[index]);

        printArray(arr, index + 1);
    }
}
