package linked_list;

/**
 * leetcode 160. Intersection of Two Linked Lists
 * <p>
 * For explanation -> one note -> Linked list
 */
public class Program13 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //calculate lengths of both the linked lists

        ListNode current1 = headA;
        int len1 = 0;

        while (current1 != null) {
            current1 = current1.next;
            len1++;
        }

        ListNode current2 = headB;
        int len2 = 0;

        while (current2 != null) {
            current2 = current2.next;
            len2++;
        }

        boolean isFirstLinkedListLonger = len1 > len2;

        int diff = isFirstLinkedListLonger ? len1 - len2 : len2 - len1;

        //move diff steps in the longer Linked list
        current1 = headA;
        current2 = headB;
        if (isFirstLinkedListLonger) {
            for (int i = 0; i < diff; i++) {
                current1 = current1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                current2 = current2.next;
            }
        }

        //move both the pointers until they meet :)

        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1;
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }
}
