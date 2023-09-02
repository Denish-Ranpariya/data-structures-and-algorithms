package basics;

import java.util.Scanner;

/**
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * 16 17 18 19 20 21
 */
public class Program23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(number++);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
