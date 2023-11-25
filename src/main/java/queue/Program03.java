package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GFG : Interleave the First Half of the Queue with Second Half
 * <p>
 * for explanation -> one note -> queue
 */
public class Program03 {
    public static ArrayList<Integer> rearrangeQueue(int n, Queue<Integer> q) {
        ArrayList<Integer> result = new ArrayList<>();

        //take two queues
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // insert first half into first queue
        for (int i = 0; i < n / 2; i++) {
            q1.add(q.remove());
        }

        //insert second half into second queue
        for (int i = 0; i < n / 2; i++) {
            q2.add(q.remove());
        }

        //while first queue doesn't become empty remove element from first and second queue and add to result
        while (!q1.isEmpty()) {
            result.add(q1.remove());
            result.add(q2.remove());
        }

        return result;
    }
}
