class Stack<E> {
    private DoublyLinkedListNode<E> bottom = null;
    private DoublyLinkedListNode<E> top = null;

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return top.value();
    }

    public void push(E value) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<E>(value);
        if (isEmpty()) {
            bottom = newNode;
            top = newNode;
        } else {
            top.next(newNode);
            newNode.previous(top);
            top = newNode;
        }
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E valuePopped = top.value();
        top = top.previous();

        if (top == null) //Stack is empty
        {
            bottom = null;
        } else {
            top.next = null;
        }

        return valuePopped;
    }

    public boolean isEmpty() {
        if (top == null)
            return true;
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

        Stack<String> stack = new Stack<>();

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