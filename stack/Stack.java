import java.util.Iterator;
import java.lang.Iterable;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A functioning stack list class.
 *
 * @author mfullhart20@georgefox.edu.
 *
 * @param <E> Type of elements in stack list.
 */
public class Stack<E> implements Iterable<E>
{
    // Top node of the stack.
    private StackNode _top;
    // Size of the stack.
    private int _size;

    /**
     * Construct an empty stack list.
     */
    public Stack()
    {
        this._top = null;
        this._size = 0;
    }

    /**
     * Push an element to the top of the stack.
     *
     * @param element Element to be added to the stack.
     * @return true if element is added.
     */
    public boolean push(E element)
    {
        StackNode newNode = new StackNode(element);
        newNode.setNext(_top);
        _top = newNode;
        _size++;
        return true;

    }

    /**
     * Pushes all elements to the top of the stack.
     *
     * @param elements Elements to be added to the stack.
     */
    public void pushAll(Iterable<E> elements)
    {
        for (E element : elements)
        {
            if (element == null)
            {
                throw new NullPointerException("Null elements are not allowed in pushAll.");
            }
            push(element);
        }
    }


    /**
     * Peek at the top element without removing it.
     *
     * @return Top element of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public E peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _top.getValue();
    }

    /**
     * Pop the top element from the stack.
     *
     * @return Element that was removed from the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public E pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        E data = _top.getValue();
        _top = _top._next;
        _size--;
        return data;
    }

    /**
     * Clears all elements.
     */
    public void clear()
    {
        _top = null;
        _size = 0;
    }

    /**
     * Get the current size (depth) of the stack.
     *
     * @return Number of elements in the stack.
     */
    public int depth()
    {
        return _size;
    }

    /**
     * Check if stack is empty.
     *
     * @return True if stack is empty.
     */
    public boolean isEmpty()
    {
        return _size == 0;
    }

    /**
     * Returns an iterator for the stack.
     *
     * @return StackIterator for iterating over the stack elements.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new StackIterator();
    }

    /**
     * Node class representing each element in the stack.
     */
    private class StackNode
    {
        private E _value;
        private StackNode _next;

        /**
         * Constructs StackNode.
         */
        public StackNode()
        {
            this(null, null);
        }

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the element to be stored in this node.
         */
        public StackNode(E value)
        {
            this(value, null);
        }

        /**
         * Constructs a new LinkedListNode with a specified value, previous node, and next node.
         *
         * @param value The element to be stored in this node.
         * @param next The reference to the next node.
         */

        public StackNode(E value, StackNode next)
        {
            _value = value;
            _next = next;
        }

        /**
         * Returns the value stored in this node.
         *
         * @return The value stored in this node.
         */
        public E getValue()
        {
            return _value;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the next node in the list, or null if this is the last node.
         */
        public StackNode getNext()
        {
            return _next;
        }

        /**
         * Sets the value of this node to the specified element.
         *
         * @param value The new value to be stored in this node.
         */
        public void setValue(E value)
        {
            _value = value;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param next The new next node.
         */
        public void setNext(StackNode next)
        {
            _next = next;
        }
    }

    /**
     * Stack iterator for iterating over the stack without modifying it.
     */
    private class StackIterator implements Iterator<E>
    {
        // Current node in iteration.
        private StackNode _currentNode;

        public StackIterator()
        {
            _currentNode = _top;
        }

        /**
         * Function to check if there are more elements in the stack.
         *
         * @return True if more elements are present.
         */
        @Override
        public boolean hasNext()
        {
            return _currentNode != null;
        }

        /**
         * Function to get the next element in the iteration.
         *
         * @return Next element in the stack.
         * @throws NoSuchElementException if no more elements are present.
         */
        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            E data = _currentNode.getValue();
            _currentNode = _currentNode.getNext();
            return data;
        }
    }
}