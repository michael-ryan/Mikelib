package michaelryan.struct;

import java.util.Iterator;

/**
 * A first-in first-out queue.
 * <p>
 *     The order of items added to this queue is retained, such that the first element added will be the first to
 *     be removed.
 * </p>
 * @param <T> the type of elements held in this queue
 */
public interface Queue<T> {

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Inserts an item into this queue.
     *
     * @param newItem the item to be added
     */
    void add(T newItem);

    /**
     * Returns and removes the item at the front of this queue.
     *
     * @return the item at the front of this queue
     */
    T dequeue();

    /**
     * Returns but does not remove the item at the front of this queue.
     *
     * @return the item at the front of this queue
     */
    T peek();

    /**
     * Returns an iterator over the elements in this queue. The iterator does not return the elements in any
     * particular order.
     *
     * @return an iterator over the elements in this queue
     */
    Iterator<T> iterator();
}
