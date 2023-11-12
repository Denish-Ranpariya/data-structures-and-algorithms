package linked_list;

/**
 * 142. Linked List Cycle II
 * <p>
 * find starting point of a linked list
 */
public class Program05 {

    /**
     * similar to check cycle in linked list
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //loop is detected
                slow = head; // point slow to head

                //now move slow and fast my one steps and check if they are equal
                while (true) {
                    if (slow == fast) {
                        return slow;
                    }

                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }

        return null;
    }
}
