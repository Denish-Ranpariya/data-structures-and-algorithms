package stack;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 1019. Next Greater Node In Linked List
 */
public class Program10 {
    public int[] nextLargerNodes(ListNode head) {

        // iterate thorugh linked list and add node values to list
        ListNode current = head;

        List<Integer> nums = new ArrayList<>();

        while (current != null) {
            nums.add(current.val);
            current = current.next;
        }

        // same logic as next greater element
        int n = nums.size();
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int num = nums.get(i);

            while (!s.isEmpty() && s.peek() <= num) {
                s.pop();
            }

            if (s.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = s.peek();
            }

            s.push(num);
        }

        return result;
    }
}
