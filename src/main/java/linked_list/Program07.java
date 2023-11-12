package linked_list;

/**
 * leetcode 2. Add Two Numbers
 */
public class Program07 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode n1 = l1;
        ListNode n2 = l2;

        ListNode resultHead = null;
        ListNode resultTail = null;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            int num = sum % 10;

            carry = sum / 10;

            ListNode newNode = new ListNode(num);

            if (resultHead == null || resultTail == null) {
                resultHead = newNode;
                resultTail = newNode;
            } else {
                resultTail.next = newNode;
                resultTail = newNode;
            }

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        while (carry != 0) {
            ListNode newNode = new ListNode(carry % 10);
            carry = carry / 10;
            resultTail.next = newNode;
            resultTail = newNode;
        }

        return resultHead;
    }
}
