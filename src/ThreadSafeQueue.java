public class ThreadSafeQueue {

    private Node head;
    private Node tail;
    private final Object lock = new Object();

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void enqueue(int value) {

        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer dequeue() {
        if (head == null) {
            return null;
        }
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;

    }

    public boolean isEmpty() {
        return head == null;
    }
}