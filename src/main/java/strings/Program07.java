package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 791. Custom Sort String
 * <p>
 * custom comparator
 */
public class Program07 {
    public String customSortString(String order, String s) {
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }

        Collections.sort(charList, (c1, c2) -> order.indexOf(c1) - order.indexOf(c2));

        String ans = "";

        for (Character ch : charList) {
            ans += ch;
        }

        return ans;
    }
}
