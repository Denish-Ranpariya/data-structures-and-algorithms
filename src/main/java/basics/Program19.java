package basics;

import java.util.Scanner;

/**
 * 1234567
 * 2    7
 * 3   7
 * 4  7
 * 5 7
 * 67
 * 7
 */
public class Program19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n :");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i == 0 || j == i + 1 || j == n) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
