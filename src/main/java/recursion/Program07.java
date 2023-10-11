package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * find all even elements in an array and store in a list
 */
public class Program07 {
    public static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{10, 21, 31, 40, 321};

        findEvenNumbers(arr, 0);

        System.out.println("Even numbers");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static void findEvenNumbers(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] % 2 == 0) {
            result.add(arr[index]);
        }

        findEvenNumbers(arr, index + 1);
    }
}
