package main.hackerrank.linkedlist;

public class DeleteDuplicateValueNodesFromASortedLinkedList {
    public void run() {

    }

    Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if (head == null)
            return null;

        Node tempHead = head;
        Node previousNode = null;

        while (tempHead != null) {
            if (previousNode != null) {
                if (previousNode.data == tempHead.data){
                    previousNode.next = tempHead.next;
                } else {
                    previousNode = tempHead;
                }
            } else {
                previousNode = tempHead;
            }

            tempHead = tempHead.next;
        }

        return head;
    }
}
