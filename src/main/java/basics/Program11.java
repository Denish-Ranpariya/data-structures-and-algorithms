package basics;

import java.util.Scanner;

/**
 *   *
 *   * *
 *  * * *
 * * * * *
 * * * * *
 *  * * *
 *   * *
 *    *
 */
public class Program11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for(int k = 0; k < n - i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
