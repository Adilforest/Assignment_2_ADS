package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.MyStack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(100);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());

        stack.push(5);
        stack.push(10);

        assertEquals(2, stack.size());

        stack.pop();

        assertEquals(1, stack.size());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(EmptyStackException.class, stack::peek);
    }
}
