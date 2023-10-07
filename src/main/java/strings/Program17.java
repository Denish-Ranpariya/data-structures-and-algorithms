package strings;

/**
 * leetcode 8. String to Integer (atoi)
 */
public class Program17 {
    public int myAtoi(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int i = 0;

        //to skip white spaces in beginning
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        //to determine sign
        boolean isNegative = false;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                isNegative = true;
            }
            i++;
        }

        int result = 0;

        //to parse the number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(i)));

            //most important condition to check if it will go above the range of int when the next operation is performed

            //if result is greater than MAX/10 then result = result * 10 will go beyond the range
            //or if result is exactly equal to MAX/10 and digit is greater than 7 result = result * 10 + digit will go beyond the range
            // in this case return MIN or MAX according to size
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return isNegative ? -result : result;
    }
}
