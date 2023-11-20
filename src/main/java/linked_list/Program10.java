package linked_list;

/**
 * GFG Delete N nodes after M nodes of a linked list
 *
 * for explanation -> One note -> Linked List
 */
public class Program10 {
    public static void linkdelete(Node head, int M, int N) {
        if (head == null) {
            return;
        }

        //calculate the length\
        Node current = head;
        int len = 0;

        while (current != null) {
            current = current.next;
            len++;
        }

        //corner case
        if (M >= len) {
            return;
        }

        current = head;

        int pos = 1;

        //skip M nodes
        while (pos != M) {
            current = current.next;
            pos++;
        }

        //skip N Nodes
        Node current1 = current;
        int count = 0;

        while (count != N + 1 && current1 != null) {
            current1 = current1.next;
            count++;
        }

        //remove N nodes by changing the link
        current.next = current1;

        linkdelete(current1, M, N);

    }
}
