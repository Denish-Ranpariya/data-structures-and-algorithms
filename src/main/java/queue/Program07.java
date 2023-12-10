package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 225. Implement Stack using Queues
 *
 * using two queues
 *
 * Can also be done by making push operation costly
 *
 * For explanation one note -> queue
 */
public class Program07 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Program07() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int n = q1.size();

        for(int i = 0; i < n - 1; i++) {
            q2.add(q1.remove());
        }

        int poppedElem = q1.remove();

        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        return poppedElem;
    }

    public int top() {
        int n = q1.size();

        for(int i = 0; i < n - 1; i++) {
            q2.add(q1.remove());
        }

        int top = q1.peek();
        q2.add(q1.remove());

        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
