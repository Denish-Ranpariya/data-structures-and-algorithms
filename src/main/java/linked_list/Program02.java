package linked_list;

/**
 * leetcode 876. Middle of the Linked List
 */
public class Program02 {

    //slow pointer - fast pointer method
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
