package basics;

import java.util.Scanner;

/**
 * program to check if a number is prime or not
 */
public class Program26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n to check if it is prime or not : ");
        int n = sc.nextInt();

        boolean isPrime = checkPrime(n);

        if (isPrime) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
    }

    private static boolean checkPrime(int n) {

        //because it is mathematically proven that at least one factor will appear in range from 2 tp sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
