package stack;

import java.util.Stack;

/**
 * leetcode 155. Min Stack
 * <p>
 * create a stack but also store the latest minimum value along side while pushing new element
 */
public class Program02 {
    Stack<Pair> s;

    public Program02() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(new Pair(val, val));
        } else {
            if (val < s.peek().getMin()) {
                s.push(new Pair(val, val));
            } else {
                s.push(new Pair(val, s.peek().getMin()));
            }
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().getValue();
    }

    public int getMin() {
        return s.peek().getMin();
    }
}
