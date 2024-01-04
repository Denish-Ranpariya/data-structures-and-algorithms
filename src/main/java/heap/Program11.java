package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 1405. Longest Happy String
 * <p>
 * similar to previous one
 */
public class Program11 {
    public String longestDiverseString(int a, int b, int c) {

        // add non-zero pairs to max heap
        PriorityQueue<Pairr> pq = new PriorityQueue<>(Collections.reverseOrder());

        if (a != 0) {
            pq.add(new Pairr('a', a));
        }

        if (b != 0) {
            pq.add(new Pairr('b', b));
        }

        if (c != 0) {
            pq.add(new Pairr('c', c));
        }

        StringBuilder result = new StringBuilder();

        // remove top 2 pair from max heap
        while (pq.size() > 1) {
            Pairr p1 = pq.remove();
            Pairr p2 = pq.remove();

            // append to result according to frequency
            if (p1.freq >= 2) {
                result.append(p1.ch).append(p1.ch);
                p1.freq--;
                p1.freq--;
            } else {
                result.append(p1.ch);
                p1.freq--;
            }

            if (p2.freq >= 2 && p1.freq <= p2.freq) { // only IMP condition (save as much as pair with smaller frequency)
                result.append(p2.ch).append(p2.ch);
                p2.freq--;
                p2.freq--;
            } else {
                result.append(p2.ch);
                p2.freq--;
            }

            // add to max heap again if frequency is non-zero
            if (p1.freq != 0) {
                pq.add(p1);
            }

            if (p2.freq != 0) {
                pq.add(p2);
            }
        }

        // last pair if exists
        if (!pq.isEmpty()) {
            Pairr last = pq.remove();

            if (last.freq >= 2) {
                result.append(last.ch).append(last.ch);
            } else {
                result.append(last.ch);
            }
        }

        return result.toString();
    }
}

//custom pair class
class Pairr implements Comparable<Pairr> {
    char ch;
    int freq;

    public Pairr(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pairr that) {
        return this.freq - that.freq;
    }
}
