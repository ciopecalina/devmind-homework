package stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

public class BaseballGame {
    public static int calPoints(String[] operations) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    int oldTop = stack.pop();
                    int newTop = stack.peek();
                    stack.push(oldTop);
                    stack.push(oldTop + newTop);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
