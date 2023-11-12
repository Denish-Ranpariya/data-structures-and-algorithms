package linked_list;

/**
 * leetcode 206. Reverse Linked List
 */
public class Program01 {

    //iterative method
    public ListNode reverseList1(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    //recursive method
    public ListNode reverseList2(ListNode head) {

        return solve(head, null);

    }

    public ListNode solve(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }

        ListNode next = current.next;

        current.next = prev;
        return solve(next, current);
    }

}
