package michaelryan.struct.extendablearrays;

import java.util.Arrays;

public class ExtendableArrayImpl<T> implements ExtendableArray<T> {

    private T[] data;
    private int itemCount;

    @SuppressWarnings("unchecked")
    public ExtendableArrayImpl(){
        this.data = (T[]) new Object[0];
        this.itemCount = 0;
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return this.data[index];
    }

    @Override
    public void replace(int index, T item){
        checkIndex(index);

        this.data[index] = item;
    }

    @Override
    public void add(T item){
        if(isFull()){
            doubleSpace();
        }

        this.data[this.itemCount] = item;
        this.itemCount++;
    }

    @Override
    public void add(int index, T item){
        checkIndex(index);
        if(isFull()){
            doubleSpace();
        }

        shiftDataFromIndexToRight(index);

        this.data[index] = item;

        this.itemCount++;
    }

    @Override
    public T remove(int index){
        checkIndex(index);

        T item = get(index);

        shiftDataFromRightToIndex(index);
        this.itemCount--;

        return item;
    }

    @Override
    public Object[] toArray(){
        return Arrays.copyOf(this.data, this.itemCount);
    }

    @Override
    public int itemCount(){
        return this.itemCount;
    }

    @Override
    public boolean isEmpty(){
        return this.itemCount == 0;
    }

    /**
     * Throws an {@link IndexOutOfBoundsException} if there is no item at the specified index.
     *
     * @param index the index to check
     */
    private void checkIndex(int index){
        if(index < 0 || index >= this.itemCount){
            throw new IndexOutOfBoundsException("No element exists at index: " + index);
        }
    }

    /**
     * Copies the data in this object into a new array with twice the length, padding with {@code null}s.
     */
    @SuppressWarnings("unchecked")
    private void doubleSpace(){
        if(this.data.length != 0){
            this.data = Arrays.copyOf(data, data.length * 2);
        } else {
            this.data = (T[]) new Object[1];
        }
    }

    private boolean isFull(){
        return this.itemCount == this.data.length;
    }

    private void shiftDataFromRightToIndex(int index){
        try {
            Object x = this.data[index + 1];
        } catch(ArrayIndexOutOfBoundsException e) {
            return; // we don't need to shift as index is at right end
        }
        for(int i = index; i < this.itemCount; i++){
            this.data[i] = this.data[i + 1];
        }
    }

    private void shiftDataFromIndexToRight(int index){
        for(int i = this.itemCount; i > index; i--){
            this.data[i] = this.data[i - 1];
        }
    }
}
