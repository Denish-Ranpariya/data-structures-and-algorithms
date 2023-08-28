package basics;

import java.util.Scanner;

/**
 * Program to print inverted half pyramid
 * <p>
 * * * * * *
 * * * * *
 * * * *
 * * *
 * *
 */
public class Program03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
