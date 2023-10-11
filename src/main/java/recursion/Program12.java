package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * return list of digits in a number
 */
public class Program12 {
    public static List<Integer> digits = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        getDigits(n);

        for (int digit : digits) {
            System.out.print(digit + " ");
        }
    }

    private static void getDigits(int n) {
        if (n == 0) {
            return;
        }

        getDigits(n / 10);

        digits.add(n % 10);
    }
}
