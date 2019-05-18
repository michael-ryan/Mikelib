package michaelryan.struct.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @Test
    void shouldNotThrowOnInsertion(){
        Stack<Object> stack = new StackImpl<>();
        assertDoesNotThrow(() -> stack.push(new Object()));
    }

    @Test
    void shouldReturnItemsInReverseOrder(){
        Stack<String> stack = new StackImpl<>();
        String firstIn = "test string one";
        String secondIn = "test string two";

        stack.push(firstIn);
        stack.push(secondIn);

        String firstOut = stack.pop();
        String secondOut = stack.pop();

        assertEquals(firstIn, secondOut);
        assertEquals(secondIn, firstOut);
    }

    @Test
    void shouldThrowWhenRetrievingWhileEmpty(){
        Stack stack = new StackImpl();
        assertThrows(IndexOutOfBoundsException.class, stack::pop);
    }

    @Test
    void shouldBeEmptyWhenNewStackMade(){
        Stack stack = new StackImpl();
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldBeEmptyWhenItemAddedThenRemoved(){
        Stack stack = new StackImpl();
        stack.push(new Object());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldNotBeEmptyWhenItemAdded(){
        Stack stack = new StackImpl();
        stack.push(new Object());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldNotBeEmptyWhenPeeking(){
        Stack stack = new StackImpl();
        stack.push(new Object());
        stack.peek();
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldThrowWhenPeekingWhileEmpty(){
        Stack stack = new StackImpl();
        assertThrows(IndexOutOfBoundsException.class, stack::peek);
    }
}