package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 2325. Decode the Message
 * <p>
 * for explanation one note -> char arrays and string
 * <p>
 * mapping
 */
public class Program06 {

    public String decodeMessage(String key, String message) {
        int n = key.length();

        Map<Character, Character> hm = new HashMap<>();

        char start = 'a';

        for (int i = 0; i < n; i++) {

            if (hm.size() == 26) {
                break;
            }

            char ch = key.charAt(i);

            if (ch == ' ') {
                continue;
            }


            if (!hm.containsKey(ch)) {
                hm.put(ch, (start++));
            }
        }

        n = message.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            char ch = message.charAt(i);
            ans = ans + (ch == ' ' ? " " : hm.get(ch));
        }

        return ans;
    }
}
