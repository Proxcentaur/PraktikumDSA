package com.septiadinirahayu.forum.list;

public class DoublyLinkedListDeletion {
    // Function to delete a node after a given node in
    // doubly linked list
    private static Node deleteAfter(Node head, int key) {
        Node curr = head;

        // Iterate over Linked List to find the key
        while (curr != null) {
            if (curr.data == key)
                break;
            curr = curr.next;
        }

        // If curr is null or curr.next is null, there is no
        // node to delete
        if (curr == null || curr.next == null)
            return head;

        // Node to be deleted
        Node nodeDelete = curr.next;

        // Update the next of the current node to the next
        // of the node to be deleted
        curr.next = nodeDelete.next;

        // If the node to be deleted is not the last node,
        // update the previous pointer of the next node
        if (nodeDelete.next != null) {
            nodeDelete.next.prev = curr;
        }

        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void execute() {

        // Create a hardcoded doubly linked list:
        // 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head = deleteAfter(head, 2);
        printList(head);
    }
}
