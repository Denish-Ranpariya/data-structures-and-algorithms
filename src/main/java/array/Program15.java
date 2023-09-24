package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Factorials of large numbers
 * MMIMP
 * for explanation one note -> arrays
 */
public class Program15 {
    static ArrayList<Integer> factorial(int N) {
        //code here

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);

        for (int i = 2; i <= N; i++) {
            list = multiply(list, i);
        }

        Collections.reverse(list);
        return list;
    }

    static ArrayList<Integer> multiply(ArrayList<Integer> list, int x) {
        int carry = 0;

        for (int i = 0; i < list.size(); i++) {
            int result = list.get(i) * x + carry;
            list.set(i, result % 10);
            carry = result / 10;
        }

        while (carry != 0) {
            int result = carry % 10;
            list.add(result);
            carry = carry / 10;
        }

        return list;
    }
}
