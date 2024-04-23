package stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MyStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

public class MinStack {
    public static void main(String[] args) {

    }
}
