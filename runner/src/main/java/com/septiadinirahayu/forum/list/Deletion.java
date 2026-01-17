package com.septiadinirahayu.forum.list;

public class Deletion {
    // Delete the head node and return the new head
    static Node deleteHead(Node head) {

        // Check if the list is empty
        if (head == null)
            return null;

        // Store the current head in a
        // temporary variable
        Node temp = head;

        // Move the head pointer to the next node
        head = head.next;

        // Free the memory of the old head node
        temp = null;

        return head;
    }

    // Function to print the linked list
    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
    }
}
