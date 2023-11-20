package linked_list;

/**
 * Leetcode 21. Merge Two Sorted Lists
 * <p>
 * For explanation -> one note -> Linked list
 */
public class Program11 {
    // loom link : https://www.loom.com/share/56e832d149ff49d7bc1ece9a6a472e8e?sid=4b8bd34b-daa9-417e-98b2-60d20ee9cef3
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode newNode = new ListNode(-1);

        ListNode temp = newNode;

        ListNode p1 = list1;
        ListNode p2 = list2;

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
