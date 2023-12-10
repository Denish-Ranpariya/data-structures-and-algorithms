package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * GFG - First non-repeating character in a stream
 * For explanation one note -> queue
 */
public class Program05 {
    public String FirstNonRepeating(String s) {
        int n = s.length();

        Queue<Character> q = new LinkedList<>();

        Map<Character, Integer> hm = new HashMap<>();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }

            q.add(ch);

            while (!q.isEmpty()) {
                char character = q.peek();

                int frequency = hm.get(character);

                if (frequency == 1) {
                    ans.append(character);
                    break;
                } else {
                    q.remove();
                }
            }

            if (q.isEmpty()) {
                ans.append("#");
            }
        }

        return ans.toString();
    }
}
