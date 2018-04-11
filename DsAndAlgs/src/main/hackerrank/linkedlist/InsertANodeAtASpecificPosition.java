package main.hackerrank.linkedlist;

public class InsertANodeAtASpecificPosition {

    public void run() {
//        5
        Node head = new Node();
        head.data = 5;

//        3 0
        head = InsertNth(head, 3, 0);
//        5 1
        head = InsertNth(head, 5, 1);
//        4 2
        head = InsertNth(head, 4, 2);
//        2 3
        head = InsertNth(head, 2, 3);
//        10 1
        head = InsertNth(head, 10, 1);
    }



    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node tempHead = head;

        Node beforeNode = null;
        Node afterNode = null;

        // []
        // [3]
        if (head == null) {
            head = new Node();
            head.data = data;

            return head;
        } else {
            Node newNode = new Node();
            newNode.data = data;

            // [3]
            // [2, 3]
            if (position == 0) {
                newNode.next = head;
                return newNode;
            } else {
                // [1, 2, 3, 4]
                // [1, 2, 7, 3, 4]
                for (int i = 0; i < position; i++) { // 0 to position 5 (index 4)
                    beforeNode = tempHead;
                    afterNode = tempHead.next;
                    tempHead = tempHead.next;
                }

                beforeNode.next = newNode;
                newNode.next = afterNode;

                return head;
            }
        }
    }
}