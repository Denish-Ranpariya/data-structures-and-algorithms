package linked_list;

/**
 * leetcode 148. Sort List
 * <p>
 * For explanation -> one note -> Linked list
 */
public class Program14 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        //find prev of mid
        ListNode prevOfMid = findPrevOfMid(head);
        ListNode mid = prevOfMid.next;
        prevOfMid.next = null; //unlink MIMP

        //sort both halves
        ListNode headA = sortList(head);
        ListNode headB = sortList(mid);

        //merge two sorted halves
        return merge(headA, headB);
    }

    ListNode findPrevOfMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    // same as Program11
    public ListNode merge(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        ListNode newNode = new ListNode(-1);

        ListNode temp = newNode;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                temp = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                temp = p2;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            temp.next = p2;
        }

        if (p2 == null) {
            temp.next = p1;
        }

        return newNode.next;
    }
}
