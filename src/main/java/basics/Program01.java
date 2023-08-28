package basics;

import java.util.Scanner;

/**
 * Program to print a hollow rectangle pattern
 */
public class Program01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}
