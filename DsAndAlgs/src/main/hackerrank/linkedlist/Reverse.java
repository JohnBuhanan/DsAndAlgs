package main.hackerrank.linkedlist;

public class Reverse {
    public void run() {
        LinkedList linkedList = new LinkedList(new int[]{1, 2, 3, 4, 5});

        Node reversedNode = Reverse(linkedList.head);

        String test = "";
    }

    Node Reverse(Node head) {
        if (head == null)
            return head;

        Node previous = null;
        Node current = head;
        Node next = null;

        // [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;

        return head;
    }
}
