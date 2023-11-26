package linked_list;

/**
 * Leetcode 2181. Merge Nodes in Between Zeros
 */
public class Program19 {
    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        // to iterate through list
        ListNode current = head.next;

        // to keep track of prev of last zero
        ListNode lastZeroPrev = null;


        // to keep track of last zero
        ListNode lastZero = head;

        int sum = 0;

        while (current != null) {

            //node with zero encountered
            if (current.val == 0) {

                //assign value of sum to lastZero node
                lastZero.val = sum;

                //reset sum
                sum = 0;

                //remove nodes in between
                lastZero.next = current;

                //update lastZeroPrev and lastZero
                lastZeroPrev = lastZero;
                lastZero = current;
            }
            sum = sum + current.val;
            current = current.next;
        }

        //to remove last node at the end of the linked list with value zero
        lastZeroPrev.next = null;

        return head;
    }
}
