package linked_list;

/**
 * leetcode 83. Remove Duplicates from Sorted List
 */
public class Program09 {
    public ListNode deleteDuplicates(ListNode head) {

        // corner case
        if (head == null) {
            return head;
        }

        // corner case
        if (head.next == null) {
            return head;
        }

        ListNode current = head;

        // iterate through linked list
        while (current != null && current.next != null) {

            // check if next node also have same value
            if (current.val == current.next.val) {

                // skip the next node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
