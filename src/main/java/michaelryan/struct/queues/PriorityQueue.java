package michaelryan.struct.queues;

import java.util.Iterator;

/**
 * A priority queue.
 * <p>
 * The order of items added to this queue is not retained, such that the element with the highest priority will
 * always be the first to be removed. Elements of equal priority are removed in arbitrary order.
 * </p>
 *
 * @param <T> the type of elements held in this priority queue
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface PriorityQueue<T> {

    /**
     * Returns true if this priority queue contains no elements.
     *
     * @return true if this priority queue contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this priority queue.
     *
     * @return the number of elements in this priority queue
     */
    int size();

    /**
     * Inserts an item into this priority queue. A lower number represents a higher priority, with zero as the highest
     * priority. Negative numbers are treated as zero.
     *
     * @param newItem  the item to be added
     * @param priority the priority of the item
     */
    void add(T newItem, int priority);

    /**
     * Returns and removes the item at the front of this priority queue.
     *
     * @return the item at the front of this priority queue
     */
    T dequeue();

    /**
     * Returns but does not remove the item at the front of this priority queue.
     *
     * @return the item at the front of this priority queue
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
