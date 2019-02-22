package michaelryan.struct;

import java.util.Iterator;

public interface PriorityQueue<T>{

    /**
     * Returns true if this priority queue is empty
     *
     * @return true if this priority queue is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this priority queue
     *
     * @return the number of elements in this priority queue
     */
    int size();


    void add(T newItem, int priority);

    T dequeue();

    T peek();

    Iterator<T> iterator();
}
