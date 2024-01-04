package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 767. Reorganize String
 * <p>
 * For explanation -> one note -> heaps
 */
public class Program10 {
    public String reorganizeString(String s) {
        int n = s.length();

        // calculation of frequencies
        int[] frequency = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            frequency[ch - 97]++;
        }

        // add pair of non-zero frequency elements to priority queue
        PriorityQueue<Info> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                char ch = (char) (i + 97);
                pq.add(new Info(ch, frequency[i]));
            }
        }

        String result = "";

        // each time remove two elements of max frequencies
        while (pq.size() > 1) {
            Info p1 = pq.remove();
            Info p2 = pq.remove();

            result += Character.toString(p1.ch) + p2.ch; // add to result

            //decrement frequency by 1
            p1.freq--;
            p2.freq--;

            // if non-zero than add again to heap
            if (p1.freq != 0) {
                pq.add(p1);
            }

            if (p2.freq != 0) {
                pq.add(p2);
            }
        }

        if (pq.size() == 0) {
            return result;
        }

        // if there is one pair remaining in max heap then it should 1

        Info last = pq.remove();

        if (last.freq == 1) {
            result += last.ch;
            return result;
        }

        return "";
    }
}

class Info implements Comparable<Info> {
    char ch;
    int freq;

    public Info(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Info that) {
        return this.freq - that.freq;
    }
}
