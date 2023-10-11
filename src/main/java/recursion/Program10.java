package recursion;

/**
 * return first index of a number in given array
 */
public class Program10 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};

        int target = 30;

        int index = search(arr, 0, target);

        System.out.println("Index :" + index);
    }

    private static int search(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return search(arr, index + 1, target);
    }
}
