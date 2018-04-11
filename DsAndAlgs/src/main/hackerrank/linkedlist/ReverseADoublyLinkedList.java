package main.hackerrank.linkedlist;

public class ReverseADoublyLinkedList {
    public void run() {
        LinkedList linkedList = new LinkedList(new int[]{2, 4, 6});

        Node test = Reverse(linkedList.head);
    }

    Node Reverse(Node head) {
        if (head == null)
            return null;

        Node newHead = head;
        Node tempHead = head;

        // [2, 4, 6] -> [6, 4, 2]
        while (tempHead != null) {
            Node tempPrev = tempHead.prev;
            tempHead.prev = tempHead.next;
            tempHead.next = tempPrev;

            newHead = tempHead;

            tempHead = tempHead.prev; // Can't do .next because we just changed it.
        }

        return newHead;
    }
}
