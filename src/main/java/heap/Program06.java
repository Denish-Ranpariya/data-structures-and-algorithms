package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * GFG - Merge k Sorted Arrays
 * For explanation : one note -> heaps
 */
public class Program06 {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        // add first element from each row
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i][0], i));
        }

        // to keep track of pointers at each row
        int[] pointers = new int[k];

        while (result.size() != k * k) {
            Pair current = pq.remove(); // remove min element from heap
            pointers[current.row]++;    // update pointer for current row
            result.add(current.value);  // add to result

            // if next element exists for current row then add it to queue
            if (pointers[current.row] < k) {
                pq.add(new Pair(arr[current.row][pointers[current.row]], current.row));
            }
        }

        return result;
    }
}

class Pair implements Comparable<Pair> {
    int value;
    int row;

    public Pair(int value, int row) {
        this.value = value;
        this.row = row;
    }

    @Override
    public int compareTo(Pair that) {
        // Compare based on the 'value' field for the min heap
        return Integer.compare(this.value, that.value);
    }
}
