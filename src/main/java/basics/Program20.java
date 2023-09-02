package basics;

import java.util.Scanner;

/**
 *          1
 *         121
 *        12321
 *       1234321
 *      123454321
 *     12345654321
 *    1234567654321
 *   123456787654321
 *  12345678987654321
 */
public class Program20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                if (j <= i) {
                    System.out.print(j + 1);
                } else {
                    System.out.print(2 * i - j + 1);
                }
            }
            System.out.println();
        }
    }
}
