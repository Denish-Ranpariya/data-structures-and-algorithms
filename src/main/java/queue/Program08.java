package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 225. Implement Stack using Queues
 * Using one queue
 * For explanation one note -> queue
 */
public class Program08 {
    Queue<Integer> q;

    public Program08() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);

        int n = q.size();

        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
