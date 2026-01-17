package com.septiadinirahayu.forum.list;

public class CircularDoublyLinkedList {
    // Function to insert a node at the beginning
    // of the doubly circular linked list
    static Node insertAtBeginning(Node head, int newData) {
        Node newNode = new Node(newData);

        if (head == null) {

            // List is empty
            newNode.next = newNode.prev = newNode;
            head = newNode;
        } else {

            // List is not empty
            Node last = head.prev;

            // Insert new node
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;

            // Update head
            head = newNode;
        }

        return head;
    }

    static void printList(Node head) {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    static void execute() {
        // Linked List : 10<->20<->30
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = head;
        head.prev = head.next.next;

        head = insertAtBeginning(head, 5);
        printList(head);
    }
 }
