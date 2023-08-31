package basics;

import java.util.Scanner;

/**
 * Program to get binary representation of a number
 */
public class Program06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int num = sc.nextInt();

        //method - 1
        //using reminder to obtain bits
//        StringBuilder result = new StringBuilder();
//
//        while(num != 0) {
//            int rem = num % 2;
//            result.append(rem);
//            num = num / 2;
//        }
//
//        System.out.println(result.reverse());

        //method - 2
        //using bitwise and to obtain bit
        StringBuilder result = new StringBuilder();
        while(num != 0) {
            int bit = num & 1;
            result.append(bit);
            num = num >> 1;
        }
        System.out.println(result.reverse());
    }
}
