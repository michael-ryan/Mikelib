package michaelryan.struct.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class StackImpl<T> implements Stack<T> {

    private final List<T> data;

    /**
     * Constructs a new empty stack.
     */
    public StackImpl(){
        this.data = new ArrayList<>();
    }

    @Override
    public void push(T newItem){
        this.data.add(newItem);
    }

    @Override
    public T pop(){
        if(!this.isEmpty()){
            return this.data.remove(this.data.size() - 1);
        } else {
            throw new NoSuchElementException("Size: " + this.data.size());
        }
    }

    @Override
    public boolean isEmpty(){
        return this.data.size() == 0;
    }

    @Override
    public T peek(){
        if(!this.isEmpty()){
            return this.data.get(this.data.size() - 1);
        } else {
            throw new NoSuchElementException("Size: " + this.data.size());
        }
    }
}
