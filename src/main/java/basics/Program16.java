package basics;

import java.util.Scanner;

/**
 * 1
 * 2*2
 * 3*3*3
 * 4*4*4*4
 */
public class Program16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j % 2 != 0) {
                    System.out.print("*");
                } else {
                    System.out.print(i + 1);
                }
            }
            System.out.println();
        }
    }
}
