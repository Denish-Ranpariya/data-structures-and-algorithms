package basics;

import java.util.Scanner;

public class Program01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        System.out.println("Number : " + num);
        System.out.println("String : " + str);
    }
}
