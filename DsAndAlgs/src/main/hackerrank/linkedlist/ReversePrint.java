package main.hackerrank.linkedlist;

public class ReversePrint {
    public void run() {

    }

    void ReversePrint(Node head) {
        if (head == null)
            return;

        ReversePrint(head.next);
        System.out.println(head.data);
    }
}
