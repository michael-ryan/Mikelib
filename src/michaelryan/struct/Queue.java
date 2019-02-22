package michaelryan.struct;

import java.util.Iterator;

public interface Queue<T> {
    /**
     * Returns true if this
     * @return
     */
    boolean isEmpty();

    int size();

    void add(T newItem);

    T dequeue();

    T peek();

    Iterator<T> iterator();
}
