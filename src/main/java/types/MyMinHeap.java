package types;
import lists.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;
    private MyArrayList<T> sorter;

    public MyMinHeap() {
        heap = new MyArrayList<>();
        sorter = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        bubbleSort();
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        heap.remove(0);
        return min;
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void bubbleSort() {
        sorter.sort("bubble");
        heap = sorter;
        sorter = new MyArrayList<>();
    }
}
