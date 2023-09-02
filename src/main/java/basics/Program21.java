package basics;

import java.util.Scanner;

/**
 * ********1********
 * *******2*2*******
 * ******3*3*3******
 * *****4*4*4*4*****
 * ****5*5*5*5*5****
 */
public class Program21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - i - 2; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                if (j % 2 == 0) {
                    System.out.print(i + 1);
                } else {
                    System.out.print("*");
                }
            }

            for (int j = 0; j < 2 * n - i - 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
