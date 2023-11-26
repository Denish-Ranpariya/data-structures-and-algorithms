package linked_list;

public class Node {

    int data;
    Node next;

    Node bottom;

    Node random;

    Node() {
    }

    Node(int val) {
        this.data = val;
    }

    Node(int val, Node next, Node random) {
        this.data = val;
        this.next = next;
        this.random = random;
    }
}

