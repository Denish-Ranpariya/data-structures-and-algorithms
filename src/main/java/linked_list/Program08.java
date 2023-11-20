package linked_list;

/**
 * leetcode 25. Reverse Nodes in k-Group
 * <p>
 * MMIMP
 */
public class Program08 {
    private static int getLength(ListNode head) {
        ListNode current = head;
        int len = 0;

        while (current != null) {
            len++;
            current = current.next;
        }

        return len;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //base condition
        if (head == null) {
            return head;
        }

        //base condition
        if (head.next == null) {
            return head;
        }

        //base condition
        int length = getLength(head);

        if (length < k) {
            return head;
        }

        //reverse k nodes
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        int pos = 0;

        while (pos < k) {
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
            pos++;
        }

        //calculate remaining ans using recursion and attach
        head.next = reverseKGroup(next, k);

        //new head will be prev
        return prev;
    }
}
