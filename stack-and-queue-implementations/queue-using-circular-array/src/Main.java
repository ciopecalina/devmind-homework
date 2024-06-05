class Queue<E> {
    private int size;
    private int front, rear, counter;
    private E[] circularArray;

    public Queue(int size) {
        this.size = size;
        this.front = this.rear = -1;
        this.counter = 0;
        this.circularArray = (E[]) new Object[size];
    }

    public boolean isFull() {
        return counter == size;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void enqueue(E newElement) {
        if (isFull()) {
            resize();
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % circularArray.length;
        circularArray[rear] = newElement;
        counter++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E valueDequeued = circularArray[front];
        front = (front + 1) % circularArray.length;
        counter--;

        if (isEmpty()) {
            front = rear = -1;
        }

        return valueDequeued;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return circularArray[front];
    }

    private void resize() {
        E[] newElements = (E[]) new Object[size * 2];

        int i = 0;
        int j = front;
        while (j != rear) {
            newElements[i] = circularArray[j];
            i++;
            j = (j + 1) % circularArray.length;
        }
        newElements[i] = circularArray[rear];

        front = 0;
        rear = size - 1;
        size = size * 2;
        circularArray = newElements;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(2);
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