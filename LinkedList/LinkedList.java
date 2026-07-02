import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A functioning link list class.
 *
 * @author mfullhart20@georgefox.edu.
 *
 * @param <E> Type of elements in link list.
 */
public class LinkedList<E> implements Iterable<E>
{
    // Head of link list.
    private LinkedListNode _head;
    // Tail of link list.
    private LinkedListNode _tail;
    // Size of link list
    private int _size;
    // Counts number of modifications.
    private long _modCount = 0;

    /**
     * Construct a link list.
     */
    public LinkedList()
    {
        this._head = null;
        this._tail = null;
        this._size = 0;
    }

    /**
     * Add an element at a specified index in LL.
     *
     * @param index index Specified index at which element is to be added in LL.
     * @param element Element to be added in LL.
     * @throws IndexOutOfBoundsException Throw IOOBE if index is out of bounds of LL.
     */
    public void add(int index, E element)
    {
        if (index < 0 || index > _size)
        {
            throw new IndexOutOfBoundsException();
        }

        if (index == _size)
        {
            add(element);
            return;
        }

        LinkedListNode newNode = new LinkedListNode(element);
        if (index == 0)
        {
            newNode.setNext(_head);
            if (_head != null)
            {
                _head.setPrevious(newNode);
            }
            _head = newNode;
        }
        else
        {
            LinkedListNode current = seekNode(index - 1);
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);

            if (current.getNext() != null)
            {
                current.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
        }

        if (newNode.getNext() == null)
        {
            _tail = newNode;
        }

        _size++;
        _modCount++;
    }

    /**
     * Add element to end of LL.
     *
     * @param element Element to be added to LL.
     * @return True if element is added to LL.
     */
    public boolean add(E element)
    {
        LinkedListNode newNode = new LinkedListNode(element);

        if (_tail == null)
        {
            _head = _tail = newNode;
        }
        else
        {
            _tail.setNext(newNode);
            newNode.setPrevious(_tail);
            _tail = newNode;
        }

        _size++;
        return true;
    }

    /**
     * Clears all elements in LL.
     */
    public void clear()
    {
        _head = _tail = null;
        _size = 0;

        _modCount++;
    }

    /**
     * Get element at specified index in LL.
     *
     * @param index Specified index at which element is to be gotten from in LL.
     * @return Element at specified index in LL.
     * @throws IndexOutOfBoundsException Throw IOOBE if index is out of bounds of LL.
     */
    public E get(int index)
    {
        if (index < 0 || index >= _size)
        {
            throw new IndexOutOfBoundsException();
        }

        return seekNode(index).getValue();
    }

    /**
     *Find index of first instance of specified element in LL.
     *
     * @param element Element to be found in LL.
     * @return Index of first instance of specified element, if not found return -1.
     */
    public int indexOf(E element)
    {
        LinkedListNode current = _head;

        for (int i = 0; i < _size; i++)
        {
            if (current.getValue().equals(element))
            {
                return i;
            }
            current = current.getNext();
        }

        return -1; // Element not found
    }

    /**
     * Check if LL is empty.
     *
     * @return True if LL is empty.
     */
    public boolean isEmpty()
    {
        return _size == 0;
    }

    /**
     * Remove element at a specified index in LL.
     *
     * @param index Specified index at which element is to be removed from in LL.
     * @return Element that was removed from LL.
     * @throws IndexOutOfBoundsException Throw IOOBE if index is out of bounds of LL.
     */
    public E remove(int index)
    {
        if (index < 0 || index >= _size)
        {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode toRemove = seekNode(index);
        if (toRemove == _head)
        {
            _head = toRemove.getNext();
            if (_head != null)
            {
                _head.setPrevious(null);
            }
        }
        else if (toRemove == _tail)
        {
            _tail = toRemove.getPrevious();
            if (_tail != null)
            {
                _tail.setNext(null);
            }
        }
        else
        {
            toRemove.getPrevious().setNext(toRemove.getNext());
            toRemove.getNext().setPrevious(toRemove.getPrevious());
        }
        _size--;
        _modCount++;

        return toRemove.getValue();
    }

    /**
     * Set new element at specified index in LL.
     *
     * @param index Specified index at which new element is to be set in LL.
     * @param element Element to be set at specified index in LL.
     * @return The previous element in the specified index in LL.
     */
    public E set(int index, E element)
    {
        LinkedListNode node = seekNode(index);
        E oldValue = node.getValue();
        node.setValue(element);
        return oldValue;
    }

    /**
     * Determine number of elements in LL.
     *
     * @return Number of elements in LL.
     */
    public int size()
    {
        return _size;
    }

    /**
     * Returns an iterator over elements of type E in forward order.
     *
     * @return An iterator for forward traversal of the list.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListIterator(false);
    }

    /**
     * Returns an iterator over elements of type E in reverse order.
     *
     * @return An iterator for reverse traversal of the list.
     */
    public Iterator<E> reverseIterator()
    {
        return new LinkedListIterator(true);
    }

    /**
     * A functioning LinkedListIterator class to iterate through the list in
     * forward or reverse order.
     */
    private class LinkedListIterator implements Iterator<E>
    {
        private LinkedListNode _current;
        private boolean _reverse;
        private long _expectedModCount;

        /**
         * Constructor for forward or reverse iteration.
         *
         * @param reverse Reverse specifies the direction of iteration.
         */
        public LinkedListIterator(boolean reverse)
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

            _modCount = _expectedModCount;
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
         * @throws ConcurrentModificationException Throw CME if detected concurrent modification of an object when such modification is not permissible.
         * @throws NoSuchElementException if there are no more elements.
         */
        @Override
        public E next()
        {
            if (_modCount != _expectedModCount)
            {
                throw new ConcurrentModificationException();
            }

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

    /**
     * A functioning LinkedListNode class where LinkedListNode represents a node in a
     * doubly linked list.
     *
     * Each node holds a reference to an element, as well as references to the previous
     * and next nodes.
     */
    private class LinkedListNode
    {
        private E _value;
        private LinkedListNode _previous;
        private LinkedListNode _next;

        /**
         * Constructs LinkedListNode.
         */
        public LinkedListNode()
        {
            this(null, null, null);
        }

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the element to be stored in this node.
         */
        public LinkedListNode(E value)
        {
            this(value, null, null);
        }

        /**
         * Constructs a new LinkedListNode with a specified value, previous node, and next node.
         *
         * @param value The element to be stored in this node.
         * @param prev The reference to the previous node in the LL.
         * @param next The reference to the next node in the LL.
         */

        public LinkedListNode(E value, LinkedListNode prev, LinkedListNode next)
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
         * Returns the reference to the previous node in the LL.
         *
         * @return The previous node in the list, or null if this is the first node.
         */
        public LinkedListNode getPrevious()
        {
            return _previous;
        }

        /**
         * Returns the reference to the next node in the LL.
         *
         * @return the next node in the list, or null if this is the last node.
         */
        public LinkedListNode getNext()
        {
            return _next;
        }

        /**
         * Sets the value of this node to the specified element in the LL.
         *
         * @param value The new value to be stored in this node.
         */
        public void setValue(E value)
        {
            _value = value;
        }

        /**
         * Sets the reference to the previous node in the LL.
         *
         * @param previous The new previous node in the LL.
         */
        public void setPrevious(LinkedListNode previous)
        {
            _previous = previous;
        }

        /**
         * Sets the reference to the next node in the LL.
         *
         * @param next The new next node in the LL.
         */
        public void setNext(LinkedListNode next)
        {
            _next = next;
        }
    }

    /**
     * Seeks the node at the specified index in the LL.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     * @throws IndexOutOfBoundsException Throw IOOBE if index is out of bounds of LL.
     */
    private LinkedListNode seekNode(int index)
    {
        if (index < 0 || index >= _size)
        {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode current = _head;

        for (int i = 0; i < index; i++)
        {
            current = current.getNext();
        }

        return current;
    }
}
