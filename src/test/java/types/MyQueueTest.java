package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

    private MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }
}
