package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 12. Integer to Roman
 * <p>
 * done with 2 methods
 * check submissions on leetcode
 */
public class Program19 {
    public String intToRoman(int num) {
        Map<Integer, Character> hm = new HashMap<>();

        hm.put(1, 'I');
        hm.put(5, 'V');
        hm.put(10, 'X');
        hm.put(50, 'L');
        hm.put(100, 'C');
        hm.put(500, 'D');
        hm.put(1000, 'M');

        String ans = "";

        int i = 0;
        while (num != 0) {
            String currentString = "";

            int digit = num % 10;

            int multiplier = (int) Math.pow(10, i++);

            int number = digit * multiplier;

            if (digit == 4 || digit == 9) {
                currentString += hm.get(multiplier);
                currentString += hm.get(number + multiplier);
            } else {
                if (digit == 1 || digit == 5) {
                    currentString += hm.get(number);
                }

                if (digit == 2 || digit == 3) {
                    for (int j = 0; j < digit; j++) {
                        currentString += hm.get(number / digit);
                    }
                }

                if (digit == 6 || digit == 7 || digit == 8) {
                    currentString += hm.get(multiplier * 5);

                    for (int j = 0; j < digit - 5; j++) {
                        currentString += hm.get(number / digit);
                    }
                }
            }

            num = num / 10;
            ans = currentString + ans;
        }

        return ans;
    }
}
