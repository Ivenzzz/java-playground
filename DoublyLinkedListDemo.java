public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);

        System.out.print("List after insertions: ");
        list.printForward();    // 5 10 20 30

        list.delete(20);
        System.out.print("After deleting 20: ");
        list.printForward();    // 5 10 30

        System.out.print("Traverse backwards: ");
        list.printBackward();   // 30 10 5
    }
}

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class DLinkedList {
    private Node head;
    private Node tail;

    // Insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {              // empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {              // empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete the first node with matching value
    public void delete(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else { // deleting head
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else { // deleting tail
                    tail = current.prev;
                }
                return; // stop after deleting first match
            }
            current = current.next;
        }
    }

    // Print list from head to tail
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print list from tail to head
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
