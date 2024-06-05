class Queue<E> {

    private DoublyLinkedListNode<E> front = null;
    private DoublyLinkedListNode<E> rear = null;

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return front.value();
    }

    public void enqueue(E value) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next(newNode);
            newNode.previous(rear);
            rear = newNode;
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E valueDequeued = front.value();
        front = front.next();
        if (front == null) {
            rear = null;
        } else {
            front.previous(null);
        }

        return valueDequeued;
    }

    public boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }

    class DoublyLinkedListNode<E> {

        private E value;
        private DoublyLinkedListNode<E> next;
        private DoublyLinkedListNode<E> previous;

        public DoublyLinkedListNode(E value, DoublyLinkedListNode<E> next, DoublyLinkedListNode<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public DoublyLinkedListNode(E value) {
            this(value, null, null);
        }

        public DoublyLinkedListNode() {
        }

        public void value(E value) {
            this.value = value;
        }

        public E value() {
            return value;
        }

        public DoublyLinkedListNode<E> next() {
            return next;
        }

        public void next(DoublyLinkedListNode<E> next) {
            this.next = next;
        }

        public DoublyLinkedListNode<E> previous() {
            return previous;
        }

        public void previous(DoublyLinkedListNode<E> previous) {
            this.previous = previous;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        System.out.println(queue.peek());
        queue.enqueue("John");
        queue.enqueue("Mary");
        System.out.println(queue.peek());
        queue.enqueue("George");
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        queue.enqueue("Jolene");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());

    }
}