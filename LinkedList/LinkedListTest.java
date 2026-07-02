import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest
{
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp()
    {
        list = new LinkedList<>();
    }

    @Test
    void testAddSingleElement()
    {
        assertTrue(list.add(10));
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddMultipleElements()
    {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtSpecificIndex()
    {
        list.add(10);
        list.add(20);
        list.add(1, 15); // Insert 15 at index 1
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    void testAddAtIndexOutOfBounds()
    {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, 15)); // Out of bounds
    }

    @Test
    void testRemoveElement()
    {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1)); // Remove element at index 1
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void testRemoveFromEmptyList()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0)); // Remove from empty list
    }

    @Test
    void testRemoveAtIndexOutOfBounds()
    {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1)); // Index out of bounds
    }

    @Test
    void testGetElement()
    {
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testGetFromEmptyList()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0)); // Get from empty list
    }

    @Test
    void testGetAtIndexOutOfBounds()
    {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1)); // Index out of bounds
    }

    @Test
    void testSetElement()
    {
        list.add(10);
        list.add(20);
        list.set(1, 25); // Set element at index 1 to 25
        assertEquals(25, list.get(1));
    }

    @Test
    void testSetInEmptyList()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 15)); // Set in empty list
    }

    @Test
    void testSetAtIndexOutOfBounds()
    {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, 20)); // Index out of bounds
    }

    @Test
    void testIndexOfExistingElement()
    {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(1, list.indexOf(20)); // Should return index 1
    }

    @Test
    void testIndexOfNonExistingElement()
    {
        list.add(10);
        list.add(20);
        assertEquals(-1, list.indexOf(30)); // Should return -1
    }

    @Test
    void testClear()
    {
        list.add(10);
        list.add(20);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
    }

    @Test
    void testSize()
    {
        assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    void testForwardIterator()
    {
        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testReverseIterator()
    {
        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> reverseIterator = list.reverseIterator();
        assertTrue(reverseIterator.hasNext());
        assertEquals(30, reverseIterator.next());
        assertTrue(reverseIterator.hasNext());
        assertEquals(20, reverseIterator.next());
        assertTrue(reverseIterator.hasNext());
        assertEquals(10, reverseIterator.next());
        assertFalse(reverseIterator.hasNext());
    }
}
