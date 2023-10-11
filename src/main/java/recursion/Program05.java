package recursion;

/**
 * Search element in array using recursion
 */
public class Program05 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};

        int target = 35;

        boolean isPresent = search(arr, 0, target);

        if (isPresent) {
            System.out.println("Present");
        } else {
            System.out.println("Not present");
        }
    }

    private static boolean search(int[] arr, int index, int target) {
        if (index == arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return search(arr, index + 1, target);
    }
}
