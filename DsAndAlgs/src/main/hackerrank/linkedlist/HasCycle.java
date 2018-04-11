package main.hackerrank.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public void run() {

    }

    boolean hasCycle(Node head) {
        Set<Node> nodeCollection = new HashSet<Node>();

        Node tempHead = head;

        while (tempHead != null) {
            if (nodeCollection.contains(tempHead))
                return true;
            else
                nodeCollection.add(tempHead);

            tempHead = tempHead.next;
        }

        return false;
    }
}
