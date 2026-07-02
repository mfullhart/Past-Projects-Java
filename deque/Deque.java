import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A functioning deque class.
 *
 * @author mfullhart20@georgefox.edu.
 *
 * @param <E> Type of elements in deque list.
 */

public class Deque<E> implements Iterable<E>
{

    // Node head of the deque.
    private DequeNode _head;
    // Node tail of the deque.
    private DequeNode _tail;
    // Size of the deque.
    private int _depth;

    /**
     * Construct an empty deque.
     */
    public Deque()
    {
        _head = null;
        _tail = null;
        _depth = 0;
    }

    /**
     * Add an element to the tail of the deque.
     *
     * @param element Element to add to the tail of the deque.
     * @return True if the element was added successfully.
     */
    public boolean enqueue(E element)
    {
        if (element == null)
        {
            throw new NullPointerException("Null elements are not allowed.");
        }

        DequeNode newNode = new DequeNode(element);

        if (isEmpty())
        {
            _head = newNode;
            _tail = newNode;
        }
        else
        {
            _tail.setNext(newNode);
            newNode.setPrevious(_tail);
            _tail = newNode;
        }

        _depth++;
        return true;
    }

    /**
     * Add multiple elements to the deque.
     *
     * @param elements Iterable collection of elements to add to deque.
     */
    public void enqueueAll(Iterable<E> elements)
    {
        for (E element : elements)
        {
            if (element == null)
            {
                throw new NullPointerException("Null elements are not allowed in enqueueAll.");
            }
            enqueue(element);
        }
    }

    /**
     * Add an element to the head of the deque.
     *
     * @param element Element to add to the head of the deque.
     * @return True if the element was added successfully.
     */
    public boolean enqueueHead(E element)
    {
        if (element == null)
        {
            throw new NullPointerException("Null elements are not allowed.");
        }

        DequeNode newNode = new DequeNode(element);

        if (isEmpty())
        {
            _head = newNode;
            _tail = newNode;
        }
        else
        {
            newNode.setNext(_head);
            _head.setPrevious(newNode);
            _head = newNode;
        }

        _depth++;
        return true;
    }

    /**
     * Get the element at the head of the deque without removing it.
     *
     * @return Element at the head of the deque.
     * @throws NoSuchElementException If the deque is empty.
     */
    public E head()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }

        return _head.getValue();
    }

    /**
     * Get the element at the tail of the deque without removing it.
     *
     * @return Element at the tail of the deque.
     * @throws NoSuchElementException If the deque is empty.
     */
    public E tail()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }

        return _tail.getValue();
    }

    /**
     * Remove and return the element at the head of the deque.
     *
     * @return Element removed from the head of the deque.
     * @throws NoSuchElementException If the deque is empty.
     */
    public E dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }

        E element = _head.getValue();
        _head = _head.getNext();

        if (_head != null)
        {
            _head.setPrevious(null);
        }
        else
        {
            _tail = null;
        }

        _depth--;
        return element;
    }

    /**
     * Remove and return the element at the tail of the deque.
     *
     * @return Element removed from the tail of the deque.
     * @throws NoSuchElementException If the deque is empty.
     */
    public E dequeueTail()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }

        E element = _tail.getValue();
        _tail = _tail.getPrevious();

        if (_tail != null)
        {
            _tail.setNext(null);
        }
        else
        {
            _head = null;
        }

        _depth--;
        return element;
    }

    /**
     * Clear all elements from the deque.
     */
    public void clear()
    {
        _head = null;
        _tail = null;
        _depth = 0;
    }

    /**
     * Returns the number of elements in the deque.
     *
     * @return Number of elements in the deque.
     */
    public int depth()
    {
        return _depth;
    }

    /**
     * Check if the deque is empty.
     *
     * @return True if the deque is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return _depth == 0;
    }

    /**
     * Get an iterator for the deque from head to tail.
     *
     * @return Iterator for the deque.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new DequeIterator(false);
    }

    /**
     * Get a reverse iterator for the deque from tail to head.
     *
     * @return Reverse iterator for the deque.
     */
    public Iterator<E> reverseIterator()
    {
        return new DequeIterator(true);
    }

    /**
     * A functioning  class where DequeueNode represents a node in the list.
     * <p>
     * Each node holds a reference to an element, as well as references to the previous
     * and next nodes.
     */
    private class DequeNode
    {
        private E _value;
        private DequeNode _previous;
        private DequeNode _next;

        /**
         * Constructs DequeNode.
         */
        public DequeNode()
        {
            this(null, null, null);
        }

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the element to be stored in this node.
         */
        public DequeNode(E value)
        {
            this(value, null, null);
        }

        /**
         * Constructs a new DequeNode with a specified value, previous node, and next node.
         *
         * @param value The element to be stored in this node.
         * @param prev  The reference to the previous node.
         * @param next  The reference to the next node.
         */

        public DequeNode(E value, DequeNode prev, DequeNode next)
        {
            _value = value;
            _previous = prev;
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
         * Returns the reference to the previous node.
         *
         * @return The previous node in the list, or null if this is the first node.
         */
        public DequeNode getPrevious()
        {
            return _previous;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the next node in the list, or null if this is the last node.
         */
        public DequeNode getNext()
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
         * Sets the reference to the previous node.
         *
         * @param previous The new previous node.
         */
        public void setPrevious(DequeNode previous)
        {
            _previous = previous;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param next The new next node.
         */
        public void setNext(DequeNode next)
        {
            _next = next;
        }
    }

    /**
     * A functioning LinkedListIterator class to iterate through the list in
     * forward or reverse order.
     */
    private class DequeIterator implements Iterator<E>
    {
        private DequeNode _current;
        private boolean _reverse;

        /**
         * Constructor for forward or reverse iteration.
         *
         * @param reverse Reverse specifies the direction of iteration.
         */
        public DequeIterator(boolean reverse)
        {
            this._reverse = reverse;
            if (reverse)
            {
                _current = _tail;
            }
            else
            {
                _current = _head;
            }
        }

        /**
         * Function to return true if iteration has more elements.
         *
         * @return true if iteration has more elements.
         */
        @Override
        public boolean hasNext()
        {
            return _current != null;
        }

        /**
         * Function to return next element in the iteration or throws exception if there is nothing.
         *
         * @return next element in the iteration.
         * @throws NoSuchElementException if there are no more elements.
         */
        @Override
        public E next()
        {

            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            E value = _current.getValue();

            if (_reverse)
            {
                _current = _current.getPrevious();
            }
            else
            {
                _current = _current.getNext();
            }

            return value;
        }
    }
}