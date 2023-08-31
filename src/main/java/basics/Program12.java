package basics;

import java.util.Scanner;

/**
 *     *
 *    * *
 *   *   *
 *  *     *
 * *       *
 */
public class Program12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");

        int n = sc.nextInt();

        for(int i = 0; i < n ; i++ ) {
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
