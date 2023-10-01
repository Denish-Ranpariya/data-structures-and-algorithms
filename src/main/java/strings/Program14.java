package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 205. Isomorphic Strings
 */
public class Program14 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();
        Map<Character, Boolean> isMapped = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (!hm.containsKey(ch1)) {
                hm.put(ch1, ch2);
                if (isMapped.containsKey(ch2)) {
                    return false;
                }
                isMapped.put(ch2, true);
            } else {
                if (ch2 != hm.get(ch1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
