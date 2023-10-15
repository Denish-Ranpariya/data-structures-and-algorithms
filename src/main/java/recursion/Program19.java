package recursion;

/**
 * leetcode 415. Add Strings
 *
 * solved with iterative approach as well on leetcode
 */
public class Program19 {

    String result = "";
    int carry = 0;

    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        sum(num1, num2, n1 - 1, n2 - 1);
        addCarry();

        return result;
    }

    public void sum(String num1, String num2, int i, int j) {
        if (i < 0 && j < 0) {
            return;
        }

        int digit1 = (i >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(i))) : 0);
        int digit2 = (j >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(j))) : 0);

        int sum = digit1 + digit2 + carry;

        result = sum % 10 + result;
        carry = sum / 10;

        sum(num1, num2, i - 1, j - 1);
    }

    public void addCarry() {

        if (carry == 0) {
            return;
        }

        result = carry % 10 + result;
        carry = carry / 10;

        addCarry();
    }
}
