import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Pushing elements: 1, 2, 3 onto the stack...");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek top element (should be 3): " + stack.peek());
        System.out.println("Stack depth (should be 3): " + stack.depth());

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        System.out.println("Stack is empty (should be true): " + stack.isEmpty());

        System.out.println("Pushing elements 4, 5...");
        stack.push(4);
        stack.push(5);
        System.out.println("Clearing stack...");
        stack.clear();

        System.out.println("Stack is empty after clear (should be true): " + stack.isEmpty());

        // Attempt to peek or pop from an empty stack to see exception handling.
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException on pop (expected)");
        }

        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException on peek (expected)");
        }

        // Testing pushAll and iterator
        System.out.println("Pushing elements 6, 7, 8 using pushAll and iterating:");
        stack.pushAll(java.util.Arrays.asList(6, 7, 8));
        for (int elem : stack) {
            System.out.println("Element: " + elem);
        }
    }
}
