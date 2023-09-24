package array;

/**
 * Add two numbers represented by two arrays - gfg
 */
public class Program14 {
    String calc_Sum(int[] a, int n, int[] b, int m) {
        // Complete the function
        int carry = 0;

        int p1 = n - 1;
        int p2 = m - 1;

        String ans = "";

        while (p1 >= 0 || p2 >= 0) {
            int result = (p1 < 0 ? 0 : a[p1]) + (p2 < 0 ? 0 : b[p2]) + carry;
            ans = result % 10 + ans;
            carry = result / 10;
            p1--;
            p2--;
        }
        if (carry != 0) {
            ans = carry + ans;
        }

        //remove front zeroes
        int frontZeroes = 0;
        for (int i = 0; i < ans.length(); i++) {
            char ch = ans.charAt(i);

            if (ch == '0') {
                frontZeroes++;
            } else {
                break;
            }
        }

        return ans.substring(frontZeroes);
    }
}
