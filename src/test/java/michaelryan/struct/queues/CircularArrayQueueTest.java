package michaelryan.struct.queues;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayQueueTest {

    @Test
    void shouldReturnItemsInSuppliedOrder(){
        Queue<String> queue = new CircularArrayQueue<>();
        String firstIn = "test string one";
        String secondIn = "test string two";

        queue.add(firstIn);
        queue.add(secondIn);

        String firstOut = queue.get();
        String secondOut = queue.get();

        assertEquals(firstIn, firstOut);
        assertEquals(secondIn, secondOut);
    }

    @Test
    void shouldNotThrowWhenItemAdded(){
        Queue<Object> queue = new CircularArrayQueue<>();
        assertDoesNotThrow(() -> queue.add(new Object()));
    }

    @Test
    void shouldNotBeEmptyWhenItemAdded(){
        Queue<Object> queue = new CircularArrayQueue<>();
        queue.add(new Object());
        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldBeEmptyWhenItemAddedThenRemoved(){
        Queue<Object> queue = new CircularArrayQueue<>();
        queue.add(new Object());
        queue.get();
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldBeEmptyWhenCreated(){
        Queue<Object> queue = new CircularArrayQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldThrowWhenRemovingItemWhileEmpty(){
        Queue<Object> queue = new CircularArrayQueue<>();
        assertThrows(NoSuchElementException.class, queue::get);
    }
}