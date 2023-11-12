package linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * <p>
 * check if there is a cycle in linked list or not
 */
public class Program04 {

    // using hash set
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> hs = new HashSet<ListNode>();

        ListNode current = head;
        while (current != null) {
            if (hs.contains(current)) {
                return true;
            } else {
                hs.add(current);
            }
            current = current.next;
        }

        return false;
    }

    //using fast and slow pointers
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
