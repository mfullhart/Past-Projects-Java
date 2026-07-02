import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest
{
    private ArrayList<String> list;
    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }


    // Test adding elements to the list
    @Test
    void testAddElements()
    {
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");


        assertEquals(3, list.size(), "Size should be 3 after adding 3 elements.");
        assertEquals("Apple", list.get(0), "First element should be Apple.");
        assertEquals("Banana", list.get(1), "Second element should be Banana.");
        assertEquals("Cherry", list.get(2), "Third element should be Cherry.");
    }


    // Test inserting elements at a specific index
    @Test
    void testAddElementAtIndex()
    {
        list.add("Apple");
        list.add("Cherry");
        list.add(1, "Banana");


        assertEquals(3, list.size(), "Size should be 3 after adding 3 elements.");
        assertEquals("Apple", list.get(0), "First element should be Apple.");
        assertEquals("Banana", list.get(1), "Second element should be Banana.");
        assertEquals("Cherry", list.get(2), "Third element should be Cherry.");
    }


    // Test get element at a specific index
    @Test
    void testGetElement()
    {
        list.add("Apple");
        list.add("Banana");


        assertEquals("Apple", list.get(0), "First element should be Apple.");
        assertEquals("Banana", list.get(1), "Second element should be Banana.");
    }


    // Test removing an element by index
    @Test
    void testRemoveElement()
    {
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");


        String removed = list.remove(1);


        assertEquals("Banana", removed, "The removed element should be Banana.");
        assertEquals(2, list.size(), "Size should be 2 after removal.");
        assertEquals("Cherry", list.get(1), "Second element should now be Cherry.");
    }


    // Test checking if the list is empty
    @Test
    void testIsEmpty()
    {
        assertTrue(list.isEmpty(), "List should be empty initially.");


        list.add("Apple");
        assertFalse(list.isEmpty(), "List should not be empty after adding an element.");
    }


    // Test finding the index of an element
    @Test
    void testIndexOfElement()
    {
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");


        assertEquals(1, list.indexOf("Banana"), "Index of Banana should be 1.");
        assertEquals(-1, list.indexOf("Orange"), "Index of a non-existing element should be -1.");
    }


    // Test setting an element at a specific index
    @Test
    void testSetElement()
    {
        list.add("Apple");
        list.add("Banana");


        String oldElement = list.set(1, "Cherry");
        assertEquals("Banana", oldElement, "Old element should be Banana.");
        assertEquals("Cherry", list.get(1), "Element at index 1 should now be Cherry.");
    }


    // Test the clear method
    @Test
    void testClear()
    {
        list.add("Apple");
        list.add("Banana");


        list.clear();
        assertEquals(0, list.size(), "Size should be 0 after clearing the list.");
        assertTrue(list.isEmpty(), "List should be empty after clearing.");
    }


    // Test adding an element when list exceeds initial capacity
    @Test
    void testEnsureCapacity()
    {
        ArrayList<Integer> intList = new ArrayList<>(2);
        intList.add(1);
        intList.add(2);
        intList.add(3); // Should trigger resizing


        assertEquals(3, intList.size(), "Size should be 3 after adding 3 elements.");
        assertEquals(1, intList.get(0), "First element should be 1.");
        assertEquals(2, intList.get(1), "Second element should be 2.");
        assertEquals(3, intList.get(2), "Third element should be 3.");
    }


    // Test adding at an invalid index (should throw an exception)
    @Test
    void testAddElementAtInvalidIndex()
    {
        list.add("Apple");


        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "Banana"),
                "Should throw IndexOutOfBoundsException for index out of range.");
    }


    // Test getting an element from an invalid index (should throw an exception)
    @Test
    void testGetElementAtInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0),
                "Should throw IndexOutOfBoundsException when getting from empty list.");
    }


    // Test removing an element from an invalid index (should throw an exception)
    @Test
    void testRemoveElementAtInvalidIndex()
    {
        list.add("Apple");


        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1),
                "Should throw IndexOutOfBoundsException for index out of range.");
    }
}
