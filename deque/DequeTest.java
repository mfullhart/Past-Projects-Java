import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new Deque<>();
    }

    // Basic enqueue operations
    @Test
    void testEnqueue() {
        assertTrue(deque.enqueue(10));
        assertEquals(1, deque.depth());
        assertEquals(10, deque.head());
    }

    @Test
    void testEnqueueHead() {
        assertTrue(deque.enqueueHead(20));
        assertEquals(1, deque.depth());
        assertEquals(20, deque.head());
    }

    // Check head and tail
    @Test
    void testHeadAndTailAfterEnqueues() {
        deque.enqueueHead(30);
        deque.enqueue(40);
        assertEquals(30, deque.head());
        assertEquals(40, deque.tail());
    }

    // Enqueue multiple elements and check depth
    @Test
    void testEnqueueMultiple() {
        deque.enqueueAll(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, deque.depth());
        assertEquals(1, deque.head());
        assertEquals(5, deque.tail());
    }

    // Dequeue operations
    @Test
    void testDequeueHead() {
        deque.enqueueAll(Arrays.asList(1, 2, 3));
        assertEquals(1, deque.dequeue());
        assertEquals(2, deque.head());
    }

    @Test
    void testDequeueTail() {
        deque.enqueueAll(Arrays.asList(1, 2, 3));
        assertEquals(3, deque.dequeueTail());
        assertEquals(2, deque.tail());
    }

    // Test isEmpty
    @Test
    void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.enqueue(1);
        assertFalse(deque.isEmpty());
    }

    // Test depth after clear
    @Test
    void testClear() {
        deque.enqueueAll(Arrays.asList(1, 2, 3));
        deque.clear();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.depth());
    }

    // Access head or tail on an empty deque should throw exception
    @Test
    void testHeadOnEmptyDeque() {
        assertThrows(NoSuchElementException.class, deque::head);
    }

    @Test
    void testTailOnEmptyDeque() {
        assertThrows(NoSuchElementException.class, deque::tail);
    }

    // Dequeue on an empty deque should throw exception
    @Test
    void testDequeueOnEmptyDeque() {
        assertThrows(NoSuchElementException.class, deque::dequeue);
    }

    @Test
    void testDequeueTailOnEmptyDeque() {
        assertThrows(NoSuchElementException.class, deque::dequeueTail);
    }

    // Test forward iteration
    @Test
    void testForwardIteration() {
        deque.enqueueAll(Arrays.asList(1, 2, 3));
        Iterator<Integer> it = deque.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }

    // Test reverse iteration
    @Test
    void testReverseIteration() {
        deque.enqueueAll(Arrays.asList(1, 2, 3));
        Iterator<Integer> it = deque.reverseIterator();
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertEquals(1, it.next());
        assertFalse(it.hasNext());
    }

    // Mix enqueue and dequeue operations
    @Test
    void testMixedEnqueueDequeue() {
        deque.enqueue(1);
        deque.enqueueHead(0);
        deque.enqueue(2);
        deque.enqueueHead(-1);

        assertEquals(-1, deque.dequeue());
        assertEquals(0, deque.dequeue());
        assertEquals(1, deque.dequeue());
        assertEquals(2, deque.dequeueTail());
    }

    // Test depth consistency
    @Test
    void testDepthConsistency() {
        deque.enqueueAll(Arrays.asList(1, 2, 3, 4));
        assertEquals(4, deque.depth());
        deque.dequeue();
        assertEquals(3, deque.depth());
    }

    // Testing enqueueHead and enqueue consistency
    @Test
    void testEnqueueHeadAndTailConsistency() {
        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueueHead(0);
        assertEquals(0, deque.head());
        assertEquals(2, deque.tail());
    }

    // Test dequeue on multiple elements
    @Test
    void testMultipleDequeue() {
        deque.enqueueAll(Arrays.asList(10, 20, 30, 40, 50));
        assertEquals(10, deque.dequeue());
        assertEquals(20, deque.dequeue());
        assertEquals(30, deque.dequeue());
        assertEquals(2, deque.depth());
    }

    // Test reverse iteration empty deque
    @Test
    void testReverseIterationOnEmptyDeque() {
        Iterator<Integer> it = deque.reverseIterator();
        assertFalse(it.hasNext());
    }

    // Test forward iteration empty deque
    @Test
    void testForwardIterationOnEmptyDeque() {
        Iterator<Integer> it = deque.iterator();
        assertFalse(it.hasNext());
    }

    // Test clear and then re-enqueue
    @Test
    void testClearAndReEnqueue() {
        deque.enqueueAll(Arrays.asList(5, 10, 15));
        deque.clear();
        deque.enqueue(20);
        assertEquals(1, deque.depth());
        assertEquals(20, deque.head());
    }

    // Enqueue head with multiple elements
    @Test
    void testEnqueueHeadMultiple() {
        deque.enqueueHead(10);
        deque.enqueueHead(20);
        deque.enqueueHead(30);
        assertEquals(30, deque.head());
    }

    // Enqueue/dequeue head then tail
    @Test
    void testDequeueHeadThenTail() {
        deque.enqueueAll(Arrays.asList(1, 2, 3, 4));
        assertEquals(1, deque.dequeue());
        assertEquals(4, deque.dequeueTail());
        assertEquals(2, deque.head());
        assertEquals(3, deque.tail());
    }
}
