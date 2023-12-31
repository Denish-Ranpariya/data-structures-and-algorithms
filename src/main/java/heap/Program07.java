package heap;

import linked_list.ListNode;

import java.util.PriorityQueue;

/**
 * Leetcode 23. Merge k Sorted Lists
 * For explanation : one note -> heaps
 */
public class Program07 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add all heads to min queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode resultHead = null;
        ListNode resultTail = null;

        while (!pq.isEmpty()) {
            ListNode current = pq.remove(); // remove min element from min heap

            // add to result linked list
            if (resultHead == null) {
                resultHead = current;
                resultTail = current;
            } else {
                resultTail.next = current;
                resultTail = resultTail.next;
            }

            // if there is a non-null node for current linked list then add it to min heap
            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return resultHead;
    }
}
