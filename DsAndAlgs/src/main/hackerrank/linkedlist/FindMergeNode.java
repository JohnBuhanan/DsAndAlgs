package main.hackerrank.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindMergeNode {
    public void run() {

    }

    int FindMergeNode(Node headA, Node headB) {
        if (headA == null || headB == null)
            return 0;

        // Complete this function
        // Do not write the main method.
        Set<Node> nodeCollection = new HashSet<Node>();

        Node tempHeadA = headA;
        while (tempHeadA != null) {
            nodeCollection.add(tempHeadA);
            tempHeadA = tempHeadA.next;
        }

        Node tempHeadB = headB;
        while (tempHeadB != null) {
            if (nodeCollection.contains(tempHeadB))
                return tempHeadB.data;

            tempHeadB = tempHeadB.next;
        }

        return -1;
    }
}
