package Types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMinHeapTest {

    private MyMinHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new MyMinHeap<>();
    }

    @Test
    void testInsertAndFindMin() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);

        assertEquals(3, minHeap.findMin());
    }

    @Test
    void testDeleteMin() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);

        assertEquals(3, minHeap.deleteMin());
        assertEquals(5, minHeap.deleteMin());
        assertEquals(10, minHeap.deleteMin());
        assertEquals(15, minHeap.deleteMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minHeap.isEmpty());
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
    }
}
