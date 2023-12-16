package stack;

import java.util.Stack;

/**
 * Leetcode 901. Online Stock Span
 * monotonic stack
 * <p>
 * for explanation one note -> stack
 * <p>
 * somewhat similar to next greater element
 */
public class Program11 {
    Stack<Pair> s;

    public Program11() {
        s = new Stack<>();
    }

    public int next(int price) {
        int span = 1; //itself

        while (!s.isEmpty() && s.peek().price <= price) {
            span += s.pop().span;
        }

        s.push(new Pair(price, span));

        return span;
    }

    static class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}


