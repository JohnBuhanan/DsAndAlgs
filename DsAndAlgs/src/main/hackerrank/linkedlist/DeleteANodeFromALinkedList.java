package main.hackerrank.linkedlist;

public class DeleteANodeFromALinkedList {
    public void run() {
        Node head = new Node();
    }

    Node Delete(Node head, int position) {
        // Complete this method
        Node tempHead = head;

        Node beforeNode = null;
        Node afterNode = null;

        // []
        // []
        if (head == null) {
            return head;
        } else {
            // [3] -> []
            // [3, 2] -> [2]
            // [1, 2, 3, 4] -> [2, 3, 4]
            if (position == 0) {
                head = head.next;
                return head;
            } else {
                // [1] -> [1, 4]
                // [1, 2, 3, 4] -> [1, 3, 4]
                // [1, 2, 3, 4] -> [1, 2, 4]
                for (int i = 0; i < position; i++) { // 0 to position 5 (index 4)
                    beforeNode = tempHead;
                    afterNode = tempHead.next;
                    tempHead = tempHead.next;
                }

                beforeNode.next = afterNode.next;

                return head;
            }
        }
    }
}