package basics;

import java.util.Scanner;

/**
 * Program to print half pyramid
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 */
public class Program02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
