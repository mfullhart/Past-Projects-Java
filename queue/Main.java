import java.util.List;
import java.util.Arrays;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Create a new queue of integers
        Queue<Integer> queue = new Queue<>();

        System.out.println("Testing Queue Operations:");

        // Test enqueue and display queue state
        System.out.println("\nEnqueueing elements 10, 20, 30:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue depth (should be 3): " + queue.depth());
        System.out.println("Head element (should be 10): " + queue.head());

        // Test dequeue
        System.out.println("\nDequeue an element (should be 10): " + queue.dequeue());
        System.out.println("Queue depth after dequeue (should be 2): " + queue.depth());
        System.out.println("New head element (should be 20): " + queue.head());

        // Test enqueueAll
        System.out.println("\nEnqueueing multiple elements 40, 50, 60:");
        queue.enqueueAll(List.of(40, 50, 60));
        System.out.println("Queue depth (should be 5): " + queue.depth());

        // Test head without dequeue
        System.out.println("\nCurrent head element without dequeue (should be 20): " + queue.head());

        // Display all elements in the queue using iterator
        System.out.println("\nIterating through queue elements:");
        for (Integer elem : queue) {
            System.out.print(elem + " ");
        }
        System.out.println();

        // Test clear
        System.out.println("\nClearing the queue.");
        queue.clear();
        System.out.println("Queue depth after clearing (should be 0): " + queue.depth());
        System.out.println("Is queue empty? (should be true): " + queue.isEmpty());

        // Edge case: Test head and dequeue on empty queue
        System.out.println("\nAttempting to access head of empty queue:");
        try {
            queue.head();
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e);
        }

        System.out.println("\nAttempting to dequeue from empty queue:");
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }
}
