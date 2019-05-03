package michaelryan.struct.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A circular queue implemented by an array. The array will be of length 0 by default, then increase to 1 in length
 * when an item is enqueued. From then on, when required, the array will double in length.
 */
@SuppressWarnings("unused")
public class CircularArrayQueue<T> implements Queue<T> {

    private T[] data;
    private int head;
    private int tail;
    private int noItems;

    /**
     * Creates a new empty {@link CircularArrayQueue}
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(){
        this.data = (T[]) new Object[0];
        this.head = -1;
        this.tail = 0;
        this.noItems = 0;
    }

    /**
     * Creates a new {@link CircularArrayQueue} starting with the given int array. The tail is expected to be at
     * index 0 and the head is at the end of the array.
     *
     * @param data the data to initialise the queue with.
     */
    public CircularArrayQueue(T[] data){
        this.data = data;
        this.head = data.length - 1;
        this.tail = 0;
        this.noItems = data.length;
    }

    /**
     * Returns the number of items in this queue
     *
     * @return the number of items in this queue
     */
    public int noItems(){
        return this.noItems;
    }

    @Override
    public int size(){
        return this.noItems;
    }

    /**
     * Gets the capacity remaining of the array implementing this queue
     *
     * @return the capacity remaining of the array queue
     */
    public int getCapacityLeft(){
        return this.data.length - this.noItems;
    }

    @Override
    public Iterator<T> iterator(){
        return new CircularArrayQueueIterator();
    }

    private class CircularArrayQueueIterator implements Iterator<T> {

        private int pointer;

        private CircularArrayQueueIterator(){
            this.pointer = tail;
        }

        @Override
        public boolean hasNext(){
            return (this.pointer + 1) % data.length != head;
        }

        @Override
        public T next(){
            this.pointer = (this.pointer + 1) % data.length;
            return data[pointer];
        }
    }

    /**
     * Adds an item to the back of this queue. Doubles the size of the array implementing this queue if the array is
     * full.
     *
     * @param in the item to be added to the back of this queue
     */
    @SuppressWarnings("unchecked")
    public void add(T in){
        if(this.data.length == 0){ // If we have a zero length array, make it a 1 length array.
            this.data = (T[]) new Object[1];
        } else if(this.noItems == this.data.length){ // If the array is full, double the length of it
            // Shift the data backwards so the tail is at index 0, and the head is at the last position of the array.
            // This is so when we introduce new unused spaces, they're not created in the middle of the queue.
            this.data = this.shiftToStart(this.data, this.head, this.tail);
            this.tail = 0;
            this.head = this.noItems - 1;

            // Temp saves the data in the queue while we create a new array of double the size
            T[] temp = this.data.clone();
            this.data = (T[]) new Object[2 * this.data.length];

            // Copy from temp back to this.data
            System.arraycopy(temp, 0, this.data, 0, temp.length);
        }

        // Add the new item
        this.head = (this.head + 1) % this.data.length;
        this.noItems++;
        this.data[head] = in;
    }

    /**
     * Returns the element at front of this queue while removing it from this queue.
     *
     * @return the element at front of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }

        T returnValue = this.data[tail];
        this.tail = (this.tail + 1) % this.data.length;
        this.noItems--;

        return returnValue;
    }



    /**
     * Returns true if this queue is empty
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty(){
        return this.noItems == 0;
    }

    /**
     * Moves all queue elements leftwards from an arbitrary position in a given array queue to have the tail at index 0.
     *
     * @param data the array queue
     * @param head the head index of the queue
     * @param tail the tail index of the queue
     * @return the given array queue but with the tail at index 0
     */
    @SuppressWarnings("unchecked")
    private T[] shiftToStart(T[] data, int head, int tail){
        T[] temp = (T[]) new Object[data.length];
        int i = -1;

        // Starts at the tail and finishes just before the head. Copies elements from data[n] to temp[k] where n - k
        // is constant, and k starts at 0.
        for(int index = tail; index != head; index = (index + 1) % data.length){
            i++;
            int newIndex = index - tail;

            // If we have a negative index (counting backwards from the end, translate it to a proper index.
            while(newIndex < 0){
                newIndex += temp.length;
            }

            temp[newIndex] = data[index];
        }

        temp[i + 1] = data[head];

        return temp;
    }



    /**
     * Returns the element at front of this queue without removing it from the queue.
     *
     * @return the element at front of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }

        return this.data[tail];
    }
}
