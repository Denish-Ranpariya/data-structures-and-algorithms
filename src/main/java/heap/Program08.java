package heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 632. Smallest Range Covering Elements from K Lists
 * <p>
 * For explanation -> one note -> heaps
 */
public class Program08 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int firstElement = nums.get(i).get(0);
            minHeap.add(new Pair(firstElement, i));
            max = Math.max(max, firstElement);
        }

        int[] pointers = new int[k];

        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        while (true) {
            Pair currentMinPair = minHeap.remove();
            int currentMin = currentMinPair.value;
            int currentMax = max;

            if ((long) currentMax - currentMin < (long) high - low) {
                high = currentMax;
                low = currentMin;
            }

            pointers[currentMinPair.row]++;

            if (pointers[currentMinPair.row] < nums.get(currentMinPair.row).size()) {
                int num = nums.get(currentMinPair.row).get(pointers[currentMinPair.row]);
                Pair pair = new Pair(num, currentMinPair.row);
                minHeap.add(pair);

                max = Math.max(num, max);
            } else {
                break;
            }
        }

        return new int[]{low, high};
    }
}
