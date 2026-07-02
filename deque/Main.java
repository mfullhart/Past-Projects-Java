import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a new deque
        Deque<Integer> deque = new Deque<>();

        // Test enqueue (add to tail)
        System.out.println("Enqueue elements at the tail:");
        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueue(3);
        deque.enqueue(4);

        // Print current elements from head to tail using the iterator
        System.out.print("Deque from head to tail after enqueuing: ");
        for (int value : deque) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test enqueueHead (add to head)
        System.out.println("\nEnqueue elements at the head:");
        deque.enqueueHead(0);

        // Print current elements from head to tail
        System.out.print("Deque from head to tail after enqueueHead: ");
        for (int value : deque) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test head and tail retrieval
        System.out.println("\nCurrent head of the deque: " + deque.head());
        System.out.println("Current tail of the deque: " + deque.tail());

        // Test dequeue (remove from head)
        System.out.println("\nDequeue element from head: " + deque.dequeue());

        // Print elements after dequeue
        System.out.print("Deque from head to tail after dequeue: ");
        for (int value : deque) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test dequeueTail (remove from tail)
        System.out.println("\nDequeue element from tail: " + deque.dequeueTail());

        // Print elements after dequeueTail
        System.out.print("Deque from head to tail after dequeueTail: ");
        for (int value : deque) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test reverse iterator
        System.out.print("\nDeque from tail to head using reverse iterator: ");
        for (Iterator<Integer> it = deque.reverseIterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Test clear
        deque.clear();
        System.out.println("\nDeque cleared. Is empty? " + deque.isEmpty());
    }
}
