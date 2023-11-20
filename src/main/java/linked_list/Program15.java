package linked_list;

/**
 * GFG flatten linked list
 * <p>
 * For explanation -> one note -> Linked list
 */
public class Program15 {

    Node flatten(Node root) {

        if (root == null) {
            return root;
        }

        Node flattenListHead = null;

        Node outerPointer = root;

        while (outerPointer != null) {
            flattenListHead = mergeTwoSortedLinkedLists(flattenListHead, outerPointer);
            outerPointer = outerPointer.next;
        }

        return flattenListHead;
    }

    Node mergeTwoSortedLinkedLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node newNode = new Node(-1);
        Node temp = newNode;

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                temp.bottom = p1;
                temp = p1;
                p1 = p1.bottom;
            } else {
                temp.bottom = p2;
                temp = p2;
                p2 = p2.bottom;
            }
        }

        if (p1 == null) {
            temp.bottom = p2;
        }

        if (p2 == null) {
            temp.bottom = p1;
        }

        return newNode.bottom;
    }
}
