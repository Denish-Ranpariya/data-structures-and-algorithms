package linked_list;

/**
 * leetcode 61. Rotate List
 */
public class Program17 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        int n = 1;

        while (current.next != null) {
            current = current.next;
            n++;
        }

        ListNode last = current;

        k = k % n;

        if (k == 0) {
            return head;
        }

        current = head;
        ListNode prev = null;

        for (int i = 0; i < n - k; i++) {
            prev = current;
            current = current.next;
        }

        last.next = head;
        head = current;
        prev.next = null;

        return head;
    }
}
