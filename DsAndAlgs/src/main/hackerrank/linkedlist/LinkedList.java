package main.hackerrank.linkedlist;

public class LinkedList {
    public Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(int[] values) {
        Node tempHead = null;

        for (int value : values) {
            Node node = new Node();
            node.data = value;

            if (tempHead == null) {
                head = node;
                tempHead = head;
            } else {
                tempHead.next = node;
                node.prev = tempHead;
                tempHead = node;
            }
        }
    }

    public void push(int newData) {
        Node node = new Node();
        node.data = newData;
        node.next = this.head;
        this.head = node;
    }

    public void addToEnd(int newData) {
        Node newNode = new Node();
        newNode.data = newData;

        Node tempHead = head;

        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }

        tempHead.next = newNode;
    }

    // origCurr   2 -> 4 -> 6 -> 8 -> 10
    // cloneCurr  2 -> 4 -> 6 -> 8 -> 10
    public LinkedList clone() {
        if (head == null)
            return null;

        Node origCurr = head;
        Node cloneCurr = new Node(); // clone head
        cloneCurr.data = origCurr.data;

        LinkedList linkedListClone = new LinkedList(cloneCurr);

        while (origCurr.next != null) {
            cloneCurr.next = new Node();
            cloneCurr.next.data = origCurr.next.data;

            cloneCurr = cloneCurr.next;
            origCurr = origCurr.next;
        }

        return linkedListClone;
    }
}