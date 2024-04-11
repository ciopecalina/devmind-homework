import java.util.NoSuchElementException;

class Queue {
    private int size;
    private int front, rear, counter;
    private String circularArray[];

    public Queue(int size) {
        this.size = size;
        this.front = this.rear = -1;
        this.counter = 0;
        this.circularArray = new String[size];
    }

    public boolean isFull() {
        return counter == size;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void enqueue(String newElement) {
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

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        String elementToReturn = circularArray[front];
        front = (front + 1) % circularArray.length;
        counter--;

        if (isEmpty()) {
            front = rear = -1;
        }

        return elementToReturn;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return circularArray[front];
    }

    private void resize() {
        String[] newElements = new String[size * 2];

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

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            int i = front;
            do {
                System.out.print(circularArray[i] + " ");
                i = (i + 1) % circularArray.length;
            } while (i != (rear + 1) % circularArray.length);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(2);
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


//        queue.add("John");
//        System.out.println(queue.peek());
//        queue.remove();
//        queue.add("Maria");
//        System.out.println(queue.peek());
//        queue.remove();
//        queue.add("Joni");
//        System.out.println(queue.peek());
//        queue.remove();
//        queue.add("Ali");
//        queue.add("Mihaela");
//        queue.add("Isa");
//        queue.add("Alin");
//        queue.add("Mihai");
//        queue.add("Matei");


        //System.out.println("Hello world!");
    }
}