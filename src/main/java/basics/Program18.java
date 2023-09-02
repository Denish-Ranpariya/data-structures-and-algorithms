package basics;

import java.util.Scanner;

/**
 * a
 * aba
 * abcba
 * abcdcba
 * abcdedcba
 */
public class Program18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n :");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int ascii = 97;
            for (int j = 0; j < i + 1; j++) {
                System.out.print((char) ascii++);
            }
            ascii--;
            while (ascii != 97) {
                System.out.print((char) --ascii);
            }
            System.out.println();
        }
    }
}
