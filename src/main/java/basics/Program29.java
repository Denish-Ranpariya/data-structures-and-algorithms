package basics;

import java.util.Scanner;

//program to count number of set bits (1 bit)
public class Program29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = sc.nextInt();

        //extract last bit and check if it is one
        int count = 0;
//        while(n > 0) {
//            int bit = n % 2;
//            if(bit == 1) {
//                count++;
//            }
//            n = n/2;
//        }

        //same method but using bitwise
        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println("Set bit count : " + count);
    }
}
