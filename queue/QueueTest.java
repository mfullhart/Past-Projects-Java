import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    // Test enqueue and enqueueAll methods
    @Test
    void testEnqueueAndEnqueueAll() {
        assertTrue(queue.enqueue(10));
        queue.enqueueAll(List.of(20, 30, 40));
        assertEquals(4, queue.depth());
        assertEquals(10, queue.head());
    }

    // Test head method
    @Test
    void testHead() {
        queue.enqueue(1);
        assertEquals(1, queue.head());
        queue.enqueue(2);
        assertEquals(1, queue.head()); // Head should still be the first enqueued element
    }

    // Test dequeue method
    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.depth());
        assertEquals(2, queue.head());
    }

    // Test isEmpty method
    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    // Test clear method
    @Test
    void testClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.depth());
    }

    // Test head on empty queue
    @Test
    void testHeadOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, queue::head);
    }

    // Test dequeue on empty queue
    @Test
    void testDequeueOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    // Test forward iteration
    @Test
    void testForwardIteration() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> it = queue.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }

    // Test depth consistency
    @Test
    void testDepthConsistency() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(3, queue.depth());
        queue.dequeue();
        assertEquals(2, queue.depth());
    }
}
