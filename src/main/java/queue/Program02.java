package queue;

import java.util.Queue;
import java.util.Stack;

/**
 * GFG : Reverse First K elements of Queue
 *
 * for explanation -> one note -> queue
 */
public class Program02 {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int n = q.size();

        if (k > n) {
            return q;
        }

        //remove first k elements from queue and add them to stack
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        //now add these elements from stack to queue at the end of the queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        //now remove first n-k element from the front of the queue and add them at the end of the queue
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
