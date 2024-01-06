package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 295. Find Median from Data Stream
 * <p>
 * Hard question
 * MMIMP
 * <p>
 * for explanation one note -> heaps
 */
public class Program12 {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    double median;

    public Program12() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        median = 0;
    }

    public void addNum(int num) {
        if (num > median) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.remove());
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        }

        if (maxHeap.size() == minHeap.size()) {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            median = maxHeap.peek();
        } else {
            median = minHeap.peek();
        }
    }

    public double findMedian() {
        return median;
    }
}
