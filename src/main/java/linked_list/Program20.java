package linked_list;

/**
 * Leetcode 328. Odd Even Linked List
 */
public class Program20 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;

        ListNode current = head;

        // to keep track of odd or even list
        boolean isOdd = true;

        while (current != null) {

            // if odd then add to odd list
            if (isOdd) {
                if (oddHead == null || oddTail == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else {

                //if even add to even list
                if (evenHead == null || evenTail == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }

            // toggle variable
            isOdd = !isOdd;
            current = current.next;
        }

        //detach MIMP
        if (evenTail != null) {
            evenTail.next = null;
        }

        // join even head to odd tail
        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        return oddHead;
    }
}
