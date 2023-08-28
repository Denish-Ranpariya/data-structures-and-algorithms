package basics;

import java.util.Scanner;

/**
 * Numeric half pyramid
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 4
 * 1 2 3 4 5
 */
public class Program04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }
}
