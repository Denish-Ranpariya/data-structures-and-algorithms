package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode 215. Kth Largest Element in an Array
 */
public class Program03 {
    // M-1 using max heap of size n
    public int findKthLargest1(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }

        return pq.peek();
    }

    // M-2 using min heap of size k
    public int findKthLargest2(int[] nums, int k) {
        // insert first k elements in heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        //iterate through other elements of array and only replace with it root if it is greater than root
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        //return top element in min heap
        return pq.peek();
    }
}
