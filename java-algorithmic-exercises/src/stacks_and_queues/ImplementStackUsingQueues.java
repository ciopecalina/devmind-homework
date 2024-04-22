package stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.poll());
        }

        mainQueue.add(x);

        while (!tempQueue.isEmpty()) {
            mainQueue.add(tempQueue.poll());
        }
    }

    public int pop() {
        return mainQueue.poll();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

public class ImplementStackUsingQueues {
    public static void main(String[] args) {

        //Your MyStack object will be instantiated and called as such:
//        MyStack obj = new MyStack();
//        obj.push(x);
//        int param_2 = obj.pop();
//        int param_3 = obj.top();
//        boolean param_4 = obj.empty();
    }
}
