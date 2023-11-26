package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 138. Copy List with Random Pointer
 */
public class Program16 {
    //M1 - using map
    public Node copyRandomList(Node head) {

        //corner case
        if (head == null) {
            return null;
        }

        Node current = head;

        //for cloned linkedlist
        Node resultHead = null;
        Node resultTail = null;

        //to store respective cloned nodes
        //key - original node
        //value - cloned node
        Map<Node, Node> map = new HashMap<>();

        //iterate through original linked list and create clone
        //append at end
        //put entries in map
        while (current != null) {
            Node newNode = new Node(current.data);

            map.put(current, newNode);

            if (resultHead == null || resultTail == null) {
                resultHead = newNode;
                resultTail = newNode;
            } else {
                resultTail.next = newNode;
                resultTail = newNode;
            }

            current = current.next;
        }


        //set random pointers - IMP part
        current = head;

        //iterate through original linked list
        while (current != null) {

            //get respective cloned node
            Node newListNode = map.get(current);

            //get current node's respective random node and assign it to respective cloned node's random node
            newListNode.random = map.get(current.random);
            current = current.next;
        }

        return resultHead;
    }

    // M-2 without using extra space
    // for explanation -> one note -> linked list
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }

        Node it = head;

        //duplicate nodes to next
        while (it != null) {
            Node newNode = new Node(it.data);
            newNode.next = it.next;
            it.next = newNode;
            it = it.next.next;
        }

        //set random pointers
        it = head;
        while (it != null) {
            it.next.random = it.random == null ? null : it.random.next;
            it = it.next.next;
        }

        //detach
        it = head;
        Node newHead = null;
        Node newTail = null;

        while (it != null) {
            if (newHead == null || newTail == null) {
                newHead = it.next;
                newTail = it.next;
            } else {
                newTail.next = it.next;
                newTail = newTail.next;
            }

            Node temp = it.next;
            it.next = it.next == null ? null : it.next.next;
            if (temp != null) {
                temp.next = null;
            }
            it = it.next;
        }

        return newHead;
    }
}
