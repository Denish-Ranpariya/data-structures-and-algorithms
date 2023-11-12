package linked_list;

/**
 * GFG Add 1 to a number represented as linked list
 */
public class Program06 {
    public static Node addOne(Node head) {
        //code here.

        if (head == null) {
            return head;
        }

        //reverse the linked list
        head = reverse(head);

        Node current = head;
        Node prev = null;

        int carry = 1; //need to add one

        while (current != null) {

            int sum = carry + current.data;

            int num = sum % 10;

            carry = sum / 10;

            current.data = num;

            // if carry becomes zero then break
            if (carry == 0) {
                break;
            }

            prev = current;
            current = current.next;
        }

        //if carry is non zero
        //need to add at the end
        if (current == null) {
            Node newNode = new Node(carry);
            prev.next = newNode;
        }

        //reverse again
        return reverse(head);
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
