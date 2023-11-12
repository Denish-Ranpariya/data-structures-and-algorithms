package linked_list;

/**
 * leetcode 234. Palindrome Linked List
 */
public class Program03 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        if (head.next == null) {
            return true;
        }


        // to find the mid
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // reverse second half
        ListNode secondHalfHead = reverse(mid);

        //join reversed second half to first half
        prev.next = secondHalfHead;

        // two pointers
        // first on start of first half
        // second on start of second half
        // keep comparing data till the first pointer reaches second half head
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;

        while (p1 != secondHalfHead) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // to reverse the linked list
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
