package main.hackerrank.linkedlist;

public class LinkedListExperiment {
    private static LinkedList linkedListInstance = new LinkedList();
    private static int[] data = new int[]{2, 4, 6, 8, 10};

    static {
        Node node1 = new Node();
        node1.data = 2;

        Node node2 = new Node();
        node2.data = 4;

        Node node3 = new Node();
        node3.data = 6;

        Node node4 = new Node();
        node4.data = 8;

        Node node5 = new Node();
        node5.data = 10;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        linkedListInstance.head = node1;
    }

    public static void run() {
        LinkedList cloneExperiment = linkedListInstance.clone();
    }
}
