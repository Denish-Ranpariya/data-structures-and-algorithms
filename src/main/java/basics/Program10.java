package basics;

import java.util.Scanner;

/**
 * Program to print reverse pyramid pattern
 *
 * * * * * *
 *  * * * *
 *   * * *
 *    * *
 *     *
 */
public class Program10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");

        int n = sc.nextInt();

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
