package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 242
 * valid anagram
 */
public class Program10 {
    public boolean isAnagram(String s, String t) {

        //method - 1
        //using sorting

        // char[] s1 = s.toCharArray();
        // char[] t1 = t.toCharArray();

        // Arrays.sort(s1);
        // Arrays.sort(t1);

        // return Arrays.equals(s1,t1);

        //method 2
        //using hash map

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> hme : hm.entrySet()) {
            if (hme.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
