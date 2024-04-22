package stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] validExpressions = {"()[]({})", "(((([{}]))))[]", "()[([{}])]", "()(([])){[[()]]}"};
        String[] invalidExpressions = {"[[[]", "[[]])", "[[(]])", "[(])"};

        System.out.println("Valid expressions:");
        for (String expression : validExpressions) {
            System.out.println(expression + ": " + isValid(expression));
        }

        System.out.println("\nInvalid expressions:");
        for (String expression : invalidExpressions) {
            System.out.println(expression + ": " + isValid(expression));

        }
    }
}
