package stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    public StackUsingQueues() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        mainQueue.offer(x);
        while (!tempQueue.isEmpty()) {
            mainQueue.offer(tempQueue.poll());
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

        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(1);
        stackUsingQueues.push(2);
        stackUsingQueues.top(); // return 2
        stackUsingQueues.pop(); // return 2
        stackUsingQueues.empty(); // return False

    }
}
