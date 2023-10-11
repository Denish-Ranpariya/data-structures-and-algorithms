package recursion;

import java.util.Scanner;

/**
 * fibonacci series
 */
public class Program02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Value of n : ");
        int n = sc.nextInt();

        System.out.println("ans : " + fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
