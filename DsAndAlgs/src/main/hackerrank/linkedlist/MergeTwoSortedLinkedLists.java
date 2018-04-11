package main.hackerrank.linkedlist;

public class MergeTwoSortedLinkedLists {
    public void run() {
        LinkedList linkedList1 = new LinkedList(new int[]{1, 13, 15, 60});
        LinkedList linkedList2 = new LinkedList(new int[]{2, 40, 51});

        Node test = mergeLists(linkedList1.head, linkedList2.head);
    }

    Node mergeLists(Node headA, Node headB) {
        Node newHeadNode = null;
        Node tempNewHead = null;

        // While one of these lists still has entries.
        while (headA != null || headB != null) {
            Node winningNode = null;
            // What are the cases?
            // headA is not empty.  headB IS empty.
            if (headA != null && headB == null) {
                winningNode = headA;
                headA = headA.next;
            }
            // headB is not empty.  headA IS empty.
            else if (headB != null && headA == null) {
                winningNode = headB;
                headB = headB.next;
            }
            // neither headA nor headB are empty.
            else if (headA != null && headB != null) {
                if (headA.data <= headB.data) {
                    winningNode = headA;
                    headA = headA.next;
                } else {
                    winningNode = headB;
                    headB = headB.next;
                }
            }
            // both headA and headB are empty. (This can't happen under current 'while' conditions.)
            // headA.data < headB.data
            // headB.data > headA.data
            if (newHeadNode == null) {
                newHeadNode = winningNode;
                tempNewHead = newHeadNode;
            } else {
                tempNewHead.next = winningNode;
                tempNewHead = winningNode;
            }
        }

        return newHeadNode;
    }
}
