package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 1962. Remove Stones to Minimize the Total
 * <p>
 * For explanation -> one note -> heaps
 */
public class Program09 {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // add all elements to max heap
        for (int pile : piles) {
            pq.add(pile);
        }

        // k operations
        while (k != 0) {
            int top = pq.remove(); //remove max element
            int half = top / 2; // calculate half
            int diff = (top - half);

            pq.add(diff); // add diff to max heap again
            k--;
        }

        // now calculate the sum of elements which are present in queue
        int sum = 0;

        while (!pq.isEmpty()) {
            sum += pq.remove();
        }

        return sum;
    }
}
