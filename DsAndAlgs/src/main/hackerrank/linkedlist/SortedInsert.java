package main.hackerrank.linkedlist;

public class SortedInsert {
    public void run() {
        LinkedList linkedList = new LinkedList(new int[]{2, 5});

        Node test = SortedInsert(linkedList.head, 4);
    }

    Node SortedInsert(Node head, int data) {
        /* Create Node to insert */
        Node newNode = new Node();
        newNode.data = data;

        if (head == null) { // insert in empty list
            return newNode;
        } else if (data < head.data) { // insert in front of list
            newNode.next = head;
            head.prev = newNode;

            return newNode;
        } else {

            Node previousNode = null;
            Node currentNode = head;

            while (currentNode != null && currentNode.data < data) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode == null) { // insert at end of list
                previousNode.next = newNode;
                newNode.prev = previousNode;
            } else { // insert in empty list
                previousNode.next = newNode;
                currentNode.prev = newNode;

                newNode.prev = previousNode;
                newNode.next = currentNode;
            }

            return head;
        }
    }
}
