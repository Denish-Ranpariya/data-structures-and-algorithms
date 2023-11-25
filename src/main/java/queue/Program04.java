package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * GFG : First negative integer in every window of size k
 * <p>
 * MIMP
 * <p>
 * for explanation one note -> queue
 */
public class Program04 {
    public long[] printFirstNegativeInteger(long[] a, int n, int k) {

        long[] result = new long[n - k + 1];
        int resultIndex = -1;


        if (k > n) {
            return result;
        }

        Queue<Integer> q = new LinkedList<>();

        // process first window
        for (int i = 0; i < k; i++) {
            if (a[i] < 0) {
                q.add(i);
            }
        }

        if (!q.isEmpty()) {
            resultIndex++;
            result[resultIndex] = a[q.peek()];
        } else {
            resultIndex++;
            result[resultIndex] = 0;
        }


        //set window's start and end
        int start = 0;
        int end = k - 1;

        //till the end of the array
        while (end != n - 1) {

            //before incrementing start check if it is negative
            //if it is negative then add the index i to queue
            if (a[start] < 0) {
                q.remove();
            }

            //increment the start
            start++;

            //increment the end
            end++;

            //if element at end is negative then add its index to queue
            if (a[end] < 0) {
                q.add(end);
            }

            //for the result if queue is empty then it's zero else element at front
            if (!q.isEmpty()) {
                resultIndex++;
                result[resultIndex] = a[q.peek()];
            } else {
                resultIndex++;
                result[resultIndex] = 0;
            }
        }

        return result;
    }
}
