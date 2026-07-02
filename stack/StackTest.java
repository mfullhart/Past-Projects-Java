import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Stack<E> class.
 */
public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPushAndPeek() {
        stack.push(10);
        assertEquals(10, stack.peek(), "Peek should return the last pushed element.");
        stack.push(20);
        assertEquals(20, stack.peek(), "Peek should return the latest pushed element.");
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop(), "Pop should remove and return the latest pushed element.");
        assertEquals(10, stack.pop(), "Pop should return the next element after popping the previous one.");
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements.");
    }

    @Test
    public void testDepth() {
        assertEquals(0, stack.depth(), "Initial depth should be zero.");
        stack.push(5);
        stack.push(15);
        assertEquals(2, stack.depth(), "Depth should match the number of elements pushed.");
    }

    @Test
    public void testClear() {
        stack.push(5);
        stack.push(15);
        stack.clear();
        assertTrue(stack.isEmpty(), "Stack should be empty after clear.");
        assertEquals(0, stack.depth(), "Depth should be zero after clear.");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty(), "New stack should be empty.");
        stack.push(30);
        assertFalse(stack.isEmpty(), "Stack should not be empty after a push.");
        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after popping the only element.");
    }

    @Test
    public void testPushAll() {
        stack.pushAll(java.util.Arrays.asList(1, 2, 3));
        assertEquals(3, stack.depth(), "Depth should match the number of elements pushed with pushAll.");
        assertEquals(3, stack.pop(), "Popped elements should match the pushed sequence.");
        assertEquals(2, stack.pop(), "Popped elements should match the pushed sequence.");
        assertEquals(1, stack.pop(), "Popped elements should match the pushed sequence.");
    }

    @Test
    public void testIterator() {
        stack.pushAll(java.util.Arrays.asList(1, 2, 3));
        int[] expected = {3, 2, 1};
        int i = 0;
        for (int elem : stack) {
            assertEquals(expected[i++], elem, "Iterator should return elements in LIFO order.");
        }
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(EmptyStackException.class, stack::pop, "Pop on empty stack should throw EmptyStackException.");
    }

    @Test
    public void testPeekOnEmptyStack() {
        assertThrows(EmptyStackException.class, stack::peek, "Peek on empty stack should throw EmptyStackException.");
    }
}
