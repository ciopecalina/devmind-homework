class Stack<E> {
    private int size;
    private int topIndex;
    private E[] array;

    public Stack(int size) {
        this.size = size;
        this.topIndex = -1;
        this.array = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == size - 1;
    }

    public void push(E element) {
        if (isFull()) {
            resize();
        }
        topIndex++;
        array[topIndex] = element;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = array[topIndex];
        topIndex--;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[topIndex];
    }

    private void resize() {
        int newSize = size * 2;
        E[] newArray = (E[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        size = newSize;
        array = newArray;
    }
}

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>(2);

        System.out.println(stack.peek());
        stack.push("John");
        stack.push("Mary");
        System.out.println(stack.peek());
        stack.push("George");
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("Jolene");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}