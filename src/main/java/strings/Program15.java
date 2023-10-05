package strings;

import java.util.*;

/**
 * Leetcode 49. Group Anagrams
 * <p>
 * for explanation one note -> character array and strings
 */
public class Program15 {

    //method - 1
    //sorting each strings
    public List<List<String>> groupAnagrams0(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String currentString = strs[i];

            char[] charArray = currentString.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            if (hm.containsKey(sortedString)) {
                hm.get(sortedString).add(currentString);
            } else {
                List<String> list = new ArrayList<>();
                list.add(currentString);
                hm.put(sortedString, list);
            }
        }
        return new ArrayList<>(hm.values());
    }

    // method - 2
    // creating hashmap for each string
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<Map<Character, Integer>, List<String>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String currentString = strs[i];

            Map<Character, Integer> frequency = new HashMap<>();
            for (int j = 0; j < currentString.length(); j++) {
                char ch = currentString.charAt(j);

                if (frequency.containsKey(ch)) {
                    frequency.put(ch, frequency.get(ch) + 1);
                } else {
                    frequency.put(ch, 1);
                }
            }

            if (hm.containsKey(frequency)) {
                hm.get(frequency).add(currentString);
            } else {
                List<String> list = new ArrayList<>();
                list.add(currentString);
                hm.put(frequency, list);
            }
        }

        return new ArrayList<>(hm.values());

    }
}
