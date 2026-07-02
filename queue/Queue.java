import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A functioning Queue class.
 *
 * @author mfullhart20@georgefox.edu.
 *
 * @param <E> Type of elements in queue list.
 */
public class Queue<E> implements Iterable<E>
{
    // Node head of the deque.
    private QueueNode _head;
    // Node tail of the deque.
    private QueueNode _tail;
    // Size of the deque.
    private int _depth;

    /**
     * Constructs an empty Queue.
     */
    public Queue()
    {
        _head = null;
        _tail = null;
        _depth = 0;
    }

    /**
     * Adds an element to the tail of the queue.
     *
     * @param element Element to add to the tail of the Queue.
     * @return true if the element was added successfully.
     */
    public boolean enqueue(E element)
    {
        if (element == null)
        {
            throw new NullPointerException("Null elements are not allowed.");
        }

        QueueNode newNode = new QueueNode(element);

        if (isEmpty())
        {
            _head = newNode;
        }
        else
        {
            _tail.setNext(newNode);
        }

        _tail = newNode;
        _depth++;
        return true;
    }

    /**
     * Adds all elements from an iterable collection to the queue.
     *
     * @param elements An iterable collection of elements to add.
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
     * Retrieves the element at the head of the queue without removing it.
     *
     * @return The element at the head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E head()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }

        return _head.getValue();
    }

    /**
     * Removes and returns the element at the head of the queue.
     *
     * @return The element removed from the head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }

        E element = _head.getValue();
        _head = _head.getNext();

        if (_head == null)
        {
            _tail = null;
        }

        _depth--;
        return element;
    }

    /**
     * Clears all elements in the queue.
     */
    public void clear()
    {
        _head = null;
        _tail = null;
        _depth = 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int depth()
    {
        return _depth;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return _depth == 0;
    }

    /**
     * Returns an iterator over the elements in this queue in FIFO order.
     *
     * @return An iterator over the elements in this queue.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new QueueIterator();
    }

    /**
     * Private inner class representing a node in the queue.
     */
    private class QueueNode
    {
        private E _value;
        private QueueNode _previous;
        private QueueNode _next;

        /**
         * Constructs LinkedListNode.
         */
        public QueueNode()
        {
            this(null, null, null);
        }

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the element to be stored in this node.
         */
        public QueueNode(E value)
        {
            this(value, null, null);
        }

        /**
         * Constructs a new LinkedListNode with a specified value, previous node, and next node.
         *
         * @param value The element to be stored in this node.
         * @param prev The reference to the previous node.
         * @param next The reference to the next node.
         */

        public QueueNode(E value, QueueNode prev, QueueNode next)
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
        public QueueNode getPrevious()
        {
            return _previous;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the next node in the list, or null if this is the last node.
         */
        public QueueNode getNext()
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
        public void setPrevious(QueueNode previous)
        {
            _previous = previous;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param next The new next node.
         */
        public void setNext(QueueNode next)
        {
            _next = next;
        }
    }

    /**
     * Private inner class implementing an iterator for the queue.
     */
    private class QueueIterator implements Iterator<E>
    {
        private QueueNode _currentNode;

        /**
         * Constructs QueueIterator.
         */
        public QueueIterator()
        {
            _currentNode = _head;
        }

        /**
         * Function to return true if iteration has more elements.
         *
         * @return true if iteration has more elements.
         */
        @Override
        public boolean hasNext()
        {
            return _currentNode != null;
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

            E value = _currentNode.getValue();
            _currentNode = _currentNode.getNext();
            return value;
        }
    }
}