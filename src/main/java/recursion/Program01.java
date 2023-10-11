package recursion;

import java.util.Scanner;

/**
 * factorial of a number
 */
public class Program01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Value of n : ");
        int n = sc.nextInt();

        System.out.println("factorial : " + factorial(n));
    }

    private static int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
