import java.util.Arrays;

/**
 * A functioning array list.
 *
 * @author mfullhart20@georgefox.edu
 *
 * @param <E> Type of elements in array list.
 */
public class ArrayList<E> {

    // Attributes
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Construct an array list.
     */
    public ArrayList()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Set initial capacity of AL.
     *
     * @param initialCapacity Set initial capacity of AL.
     * @throws IllegalArgumentException Throw IAE if initial capacity is < 0.
     */
    public ArrayList(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        elements = (E[]) new Object[initialCapacity];
        size = 0;
    }

    /**
     * Add an element at a specified index in AL.
     * Shift element(s) to right if necessary.
     *
     * @param index Specified index at which element is to be added in AL.
     * @param element Element to be added in AL.
     */
    public void add(int index, E element)
    {
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Append element to end of AL.
     *
     * @param element Element to be added to AL.
     * @return True if element is added to AL.
     */
    public boolean add(E element)
    {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    /**
     * Clears all elements in AL.
     */
    public void clear()
    {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Get element at specified index in AL.
     *
     * @param index Specified index at which element is to be gotten from in AL.
     * @return Element at specified index in AL.
     */
    public E get(int index)
    {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Find index of first instance of specified element in AL.
     *
     * @param element Element to be found in AL.
     * @return Index of first instance of specified element, if not found return -1.
     */
    public int indexOf(E element)
    {
        if (element == null)
        {
            for (int i = 0; i < size; i++)
            {
                if (elements[i] == null)
                {
                    return i;
                }
            }
        }

        else
        {
            for (int i = 0; i < size; i++)
            {
                if (element.equals(elements[i]))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Check if AL is empty.
     *
     * @return True if AL is empty.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Remove element at a specified index in AL.
     *
     * @param index Specified index at which element is to be removed from in AL.
     * @return Element that was removed from AL.
     */
    public E remove(int index)
    {
        checkIndex(index);
        E oldValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Clear the last element
        return oldValue;
    }

    /**
     * Set new element at specified index in AL.
     *
     * @param index Specified index at which new element is to be set in AL.
     * @param element Element to be set at specified index in AL.
     * @return The previous element in the specified index in AL.
     */
    public E set(int index, E element)
    {
        checkIndex(index);
        E oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * Determine number of elements in AL.
     *
     * @return Number of elements in AL.
     */
    public int size()
    {
        return size;
    }

    /**
     * Ensure that there is enough capacity in AL to add new elements.
     * If not, double capacity of AL.
     */
    private void ensureCapacity()
    {
        if (size == elements.length)
        {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /**
     * Check if index is within bounds of AL.
     *
     * @param index Index in AL to check.
     * @throws IndexOutOfBoundsException Throw IOOBE if index is out of bounds of AL.
     */
    private void checkIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
