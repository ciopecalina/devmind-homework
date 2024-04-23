package stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> mainStack;
    private Deque<Integer> tempStack;

    public MyQueue() {
        mainStack = new LinkedList<>();
        tempStack = new LinkedList<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        if (tempStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                tempStack.push(mainStack.pop());
            }
        }
        return tempStack.pop();
    }

    public int peek() {
        if (tempStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                tempStack.push(mainStack.pop());
            }
        }
        return tempStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty() && tempStack.isEmpty();
    }
}

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
//        MyQueue myQueue = new MyQueue();
//        System.out.println("Output:");
//        System.out.println(myQueue.push(1)); // Output: null
//        System.out.println(myQueue.push(2)); // Output: null
//        System.out.println(myQueue.peek()); // Output: 1
//        System.out.println(myQueue.pop()); // Output: 1
//        System.out.println(myQueue.empty()); // Output: false
    }
}
