package JAVA.day5;

// Implementation of a Linked List in Java

public class LL {
    Node head;
    private int size;

    public LL() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next; // Pointer to a next node of the Linked list.

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add - first, last (adding last is difficult)
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // Print the linked list
    public void printList() {
        if (head != null) {
            Node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
        }
        System.out.println("NULL");
    }

    // Delete a node of a linked list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty");
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next; // head.next = null -> lastNode = null

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("list");
        list.addFirst("this");

        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());

        list.addFirst("this");
        System.out.println(list.getSize());
    }
}
