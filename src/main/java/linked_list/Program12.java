package linked_list;

/**
 * GFG - Nth node from end of linked list
 * <p>
 * For explanation -> one note -> Linked list
 */
public class Program12 {
    int getNthFromLast(Node head, int n) {

        if (head == null) {
            return -1;
        }

        //create the window of size n

        Node start = head;
        Node end = head;

        for (int i = 0; i < n - 1; i++) {

            if (end.next == null) {
                return -1;
            }

            end = end.next;
        }

        //move the window to end
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }

        return start.data;
    }
}
