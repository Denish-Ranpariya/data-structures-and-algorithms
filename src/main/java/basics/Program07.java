package basics;

import java.util.Scanner;

/**
 * binary string to decimal number
 */
public class Program07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a binary string : ");
        String binaryString = scanner.nextLine();
        int result = 0;
        int n = binaryString.length();
        for(int i = n - 1; i >= 0; i--) {
            int bit = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
            result += (int) (bit * (Math.pow(2, n - i - 1)));
        }
        System.out.println(result);
    }
}
