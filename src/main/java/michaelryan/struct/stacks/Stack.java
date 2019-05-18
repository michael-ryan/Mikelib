package michaelryan.struct.stacks;

/**
 * A last-in first-out (LIFO) data structure.
 *
 * @param <T> The type to store
 */
public interface Stack<T> {

    /**
     * Puts a new item onto the top of this stack.
     *
     * @param item the item to put on this stack
     */
    void push(T item);

    /**
     * Removes the top item from this stack and returns it.
     *
     * @return the top item from this stack
     */
    T pop();

    /**
     * Returns {@code true} if this stack is empty.
     *
     * @return {@code true} if this stack is empty
     */
    boolean isEmpty();

    /**
     * Returns the top item from this stack without removing it.
     *
     * @return the top item from this stack
     */
    T peek();
}
