package michaelryan.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * A last-in first-out (LIFO) data structure.
 *
 * @param <T> The type to store
 */
public class Stack<T> {

    private List<T> data;

    /**
     * Constructs a new empty stack.
     */
    public Stack(){
        this.data = new ArrayList<>();
    }

    /**
     * Puts a new item onto the top of this stack.
     *
     * @param newItem the item to put on this stack
     */
    public void push(T newItem){
        this.data.add(newItem);
    }

    /**
     * Removes the top item from this stack and returns it.
     *
     * @return the top item from this stack
     */
    public T pop(){
        if(!this.isEmpty()){
            return this.data.remove(this.data.size() - 1);
        } else {
            throw new IndexOutOfBoundsException("Size: " + this.data.size());
        }
    }

    /**
     * Returns {@code true} if this stack is empty.
     *
     * @return {@code true} if this stack is empty
     */
    public boolean isEmpty(){
        return this.data.size() == 0;
    }

    /**
     * Returns the top item from this stack without removing it.
     *
     * @return the top item from this stack
     */
    public T peek(){
        if(!this.isEmpty()){
            return this.data.get(this.data.size() - 1);
        } else {
            throw new IndexOutOfBoundsException("Size: " + this.data.size());
        }
    }
}
