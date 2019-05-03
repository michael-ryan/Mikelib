package michaelryan.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A priority queue implemented with a max-heap.
 *
 * @param <T> The type of data to store in the queue
 */
@SuppressWarnings("unused")
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    private final List<Node> contents;

    /**
     * Constructs a new empty {@link HeapPriorityQueue}
     */
    public HeapPriorityQueue(){
        this.contents = new ArrayList<>();
    }

    /**
     * A single item in the queue. Stores the data itself and the node's priority.
     */
    @SuppressWarnings("WeakerAccess")
    private class Node {

        private final T data;
        private final int priority;

        /**
         * Constructs a new node with the given data and priority.
         *
         * @param data     the data the node should hold
         * @param priority the priority of the node
         */
        public Node(T data, int priority){
            this.data = data;
            this.priority = priority;
        }

        /**
         * Returns the data held by this node.
         *
         * @return the data held by this node
         */
        public T getData(){
            return data;
        }

        /**
         * Returns this node's priority.
         *
         * @return this node's priority
         */
        public int getPriority(){
            return priority;
        }
    }

    /**
     * An iterator that iterates over the data in this queue, in no particular order.
     */
    private class QueueIterator implements Iterator<T> {

        final Iterator<Node> nodeIterator;

        /**
         * Constructs a new {@link QueueIterator}
         */
        private QueueIterator(){
            this.nodeIterator = contents.iterator();
        }

        @Override
        public boolean hasNext(){
            return this.nodeIterator.hasNext();
        }

        @Override
        public T next(){
            return this.nodeIterator.next().getData();
        }
    }

    @Override
    public boolean isEmpty(){
        return this.contents.isEmpty();
    }

    @Override
    public int size(){
        return this.contents.size();
    }

    @Override
    public void add(T newItem, int priority){
        // If the priority of this data is negative, make it zero.
        if(priority < 0){
            priority = 0;
        }

        // Add the new data to the end of the ArrayList, and record where we put it.
        this.contents.add(new Node(newItem, priority));
        int position = this.contents.size() - 1;

        // Sift up
        Node tempNode;
        while(position > 0 &&
                this.contents.get(position).getPriority() > this.contents.get(this.goUp(position)).getPriority()){
            tempNode = this.contents.get(this.goUp(position));

            this.contents.set(this.goUp(position), this.contents.get(position));
            this.contents.set(position, tempNode);

            position = this.goUp(position);
        }
    }

    @Override
    public T dequeue(){
        // If empty then return null
        if(this.isEmpty()){
            return null;
        }

        Node removedNode = this.contents.get(0);

        // Move last data to front. Replace front
        if(this.contents.size() == 1){
            this.contents.remove(0);
        } else {
            this.contents.set(0, this.contents.remove(this.contents.size() - 1));
        }

        // Sift down
        int position = 0;
        int lowerNode = 0;
        boolean complete = false;
        boolean valid = false;

        while(!complete){
            // check if lower than either child
            if(this.hasLeft(position)){
                if(this.contents.get(position).getPriority() < this.contents.get(this.goLeft(position)).getPriority()){
                    valid = true;
                }
            }
            if(this.hasRight(position)){
                if(this.contents.get(position).getPriority() < this.contents.get(this.goRight(position)).getPriority()){
                    valid = true;
                }
            }

            if(valid){
                if(this.hasLeft(position) && this.hasRight(position)){
                    if(this.contents.get(this.goLeft(position)).getPriority() >
                            this.contents.get(this.goRight(position)).getPriority()){
                        lowerNode = this.goLeft(position);
                    } else {
                        lowerNode = this.goRight(position);
                    }
                } else if(this.hasLeft(position) && !this.hasRight(position)){
                    lowerNode = this.goLeft(position);
                } else if(!this.hasLeft(position) && this.hasRight(position)){
                    lowerNode = this.goRight(position);
                } else {
                    complete = true;
                }
            } else {
                complete = true;
            }

            if(!complete){
                this.swap(position, lowerNode);
                position = lowerNode;
            }
        }

        return removedNode.getData();
    }

    @Override
    public T peek(){
        return this.contents.get(0).getData();
    }

    @Override
    public Iterator<T> iterator(){
        return new QueueIterator();
    }

    /**
     * Returns the index of the element that would be the left child of the node at the given index. Does not check
     * if such a node exists.
     *
     * @param origin the index of the parent node
     * @return the index of the parent node's left child
     */
    private int goLeft(int origin){
        return (2 * origin) + 1;
    }

    /**
     * Returns the index of the element that would be the right child of the node at the given index. Does not check
     * if such a node exists.
     *
     * @param origin the index of the parent node
     * @return the index of the parent node's right child
     */
    private int goRight(int origin){
        return (2 * origin) + 2;
    }

    /**
     * Returns the index of the element that would be the parent of the node at the given index. Does not check if
     * such a node exists.
     *
     * @param origin the index of the child node
     * @return the index of the child node's parent
     */
    private int goUp(int origin){
        return (origin - 1) >> 1;
    }

    /**
     * Returns {@code true} if a left child node of the node at the given index exists.
     *
     * @param origin the node which may have a left child
     * @return {@code true} if a left child exists of the node at the given index
     */
    private boolean hasLeft(int origin){
        try {
            Node node = this.contents.get(this.goLeft(origin));
            return node != null;
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Returns {@code true} if a right child node of the node at the given index exists.
     *
     * @param origin the node which may have a right child
     * @return {@code true} if a right child exists of the node at the given index
     */
    private boolean hasRight(int origin){
        try {
            Node node = this.contents.get(this.goRight(origin));
            return node != null;
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Swaps the position of two nodes, given their indices.
     *
     * @param a the index of the first node to swap
     * @param b the index of the second node to swap
     */
    private void swap(int a, int b){
        Node node = this.contents.get(a);
        this.contents.set(a, this.contents.get(b));
        this.contents.set(b, node);
    }
}
