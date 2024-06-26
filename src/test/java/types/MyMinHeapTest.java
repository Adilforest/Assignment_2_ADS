package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.MyMinHeap;

import static org.junit.jupiter.api.Assertions.*;

class MyMinHeapTest {

    private MyMinHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new MyMinHeap<>();
    }

    @Test
    void testInsertAndFindMin() {
        long startTime = System.currentTimeMillis();

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);

        int min = minHeap.findMin();

        long endTime = System.currentTimeMillis();
        double timeInSeconds = (endTime - startTime) / 1000.0; // Преобразование миллисекунд в секунды
        System.out.println("Time taken: " + timeInSeconds + " seconds");

        assertEquals(3, min);
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
