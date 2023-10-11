package recursion;

/**
 * print the index of all occurrence of a number in array
 */
public class Program11 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 10, 40, 100, 700, 10, 212};

        int target = 10;

        findOccurrences(arr, 0, target);
    }

    private static void findOccurrences(int[] arr, int index, int target) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            System.out.println(index);
        }

        findOccurrences(arr, index + 1, target);
    }
}
