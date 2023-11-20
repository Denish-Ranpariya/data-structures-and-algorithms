package linked_list;

public class Node {

    int data;
    Node next;

    Node bottom;

    Node() {
    }

    Node(int val) {
        this.data = val;
    }

    Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }
}

