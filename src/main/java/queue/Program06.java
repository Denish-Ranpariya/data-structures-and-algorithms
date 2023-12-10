package queue;

import java.util.Stack;

/**
 * Leetcode  232. Implement Queue using Stacks
 *
 * Can also be done by making pop operation costly
 *
 * For explanation one note -> queue
 */
public class Program06 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public Program06() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
