package michaelryan.struct.extendablearrays;

import java.util.Arrays;

public class ExtendableArrayImpl<T> implements ExtendableArray<T> {

    private T[] data;
    private int itemCount;

    @SuppressWarnings("unchecked")
    public ExtendableArrayImpl(){
        this.data = (T[]) new Object[0];
    }

    @Override
    public T get(int index){
        return null;
    }

    @Override
    public void replace(int index, T item){

    }

    @Override
    public void add(T item){

    }

    @Override
    public void add(int index, T item){

    }

    @Override
    public T remove(int index){
        return null;
    }

    @Override
    public T[] toArray(){
        return null;
    }

    @Override
    public int itemCount(){
        return 0;
    }

    @Override
    public boolean isEmpty(){
        return false;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= this.itemCount){
            throw new IndexOutOfBoundsException("No element exists at index: " + index);
        }
    }

    @SuppressWarnings("unchecked")
    private void doubleSpace(){
        if(this.data.length != 0){
            this.data = Arrays.copyOf(data, data.length * 2);
        } else {
            this.data = (T[]) new Object[1];
        }
    }
}
