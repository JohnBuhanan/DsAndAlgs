package main.hackerrank.linkedlist;

public class CompareTwoLinkedLists {
    public void run() {
        LinkedList linkedList1 = new LinkedList(new int[]{1, 2, 3, 4, 5});
        LinkedList linkedList2 = new LinkedList(new int[]{1, 2, 3, 4});

        int result = CompareLists(linkedList1.head, linkedList2.head);
    }

    int CompareLists(Node headA, Node headB) {
        if (headA == null && headB == null)
            return 1;
        else if (headA == null || headB == null)
            return 0;

        // [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] -> 1
        int result = 0;
        if (headA.data == headB.data)
            result = 1;

        return CompareLists(headA.next, headB.next) & result;
    }
}
