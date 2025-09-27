package data_structures;
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);

        System.out.print("List after insertions: ");
        list.printList(); // 5 10 20 30

        list.deleteByValue(20);
        System.out.print("After deleting 20: ");
        list.printList(); // 5 10 30

        list.deleteByValue(5);
        System.out.print("After deleting 5: ");
        list.printList(); // 10 30
    }
}

/* ---------- Node Definition ---------- */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/* ---------- Singly Linked List ---------- */
class SinglyLinkedList {
    private Node head; // first node

    /* Insert a new node at the beginning */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /* Insert a new node at the end */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /* Delete the first node that contains the given value */
    public void deleteByValue(int data) {
        if (head == null)
            return; // empty list

        // If the node to delete is the head
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /* Traverse and print the list */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /* Check if list is empty */
    public boolean isEmpty() {
        return head == null;
    }

    /* Get size of the list */
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
