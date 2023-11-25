package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverse a queue
 */
public class Program01 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);

//        reverseQueue(q);
        reverseUsingRecursion(q);

        System.out.println("---AFTER REVERSE---");
        System.out.println(q);
    }

    // reverse using a stack
    private static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // recursion
    private static void reverseUsingRecursion(Queue<Integer> q) {

        //base case
        if (q.isEmpty()) {
            return;
        }

        //remove element from front
        int temp = q.remove();

        //reverse remaining queue using recursion
        reverseUsingRecursion(q);

        //add removed element at last
        q.add(temp);
    }
}
