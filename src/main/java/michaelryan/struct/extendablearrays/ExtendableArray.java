package michaelryan.struct.extendablearrays;

/**
 * A wrapper for an array that can be extended as needed.
 *
 * @param <T> the type to be stored in the array
 */
public interface ExtendableArray<T> {

    /**
     * Returns the item at the specified index.
     *
     * @param index the index at which the requested item is stored
     * @return the item at the specified index
     */
    T get(int index);

    /**
     * Replaces the item at the specified index with the given item.
     *
     * @param index the index at which
     * @param item  the item to insert
     */
    void replace(int index, T item);

    /**
     * Adds the specified item to the end of the array.
     *
     * @param item the item to be added
     */
    void add(T item);

    /**
     * Inserts the specified item into the array at the given index. All items to the right are shifted rightwards by
     * one.
     *
     * @param index the position to insert the new item into
     * @param item  the item to insert
     */
    void add(int index, T item);

    /**
     * Removes the item at the specified index. For convenience, this item is also returned.
     *
     * @param index the index of the item to remove
     * @return the item at the specified index.
     */
    T remove(int index);

    /**
     * Returns an array representation of this object. The returned array is "safe" such that no references to it are
     * maintained by this object. All items are in their proper position based on their index in the collection.
     *
     * @return an array representation of this object
     */
    Object[] toArray();

    /**
     * Returns the number of items stored in the array.
     *
     * @return the number of items stored in the array
     */
    int itemCount();

    /**
     * Returns {@code true} if the number of items in this array is zero.
     *
     * @return {@code true} if the number of items in this array is zero
     */
    boolean isEmpty();
}
