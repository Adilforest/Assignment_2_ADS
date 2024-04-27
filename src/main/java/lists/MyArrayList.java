package lists;
import java.util.Iterator;

public class MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {
    private static final int DEFAULT = 5;
    private T[] array;
    private int size;

    public MyArrayList(){
        array = (T[]) new Object[DEFAULT];
        size = 0;
    }
    @Override
    public void add(T item){
        if (size >= array.length)
            increaseSize();
        array[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size >= array.length)
            increaseSize();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }


    @Override
    public void addFirst(T item) {
        if (size >= array.length)
            increaseSize();
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }

    @Override
    public void addLast(T item){
        add(item);
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return array[index];
    }
    @Override
    public T getFirst(){
        return array[0];
    }
    @Override
    public T getLast(){
        return array[size - 1];
    }

    @Override
    public T remove(int index){
        checkIndex(index);
        T removedItem = array[index];
        for(int i = index + 1; i < size; i++){
            array[i - 1] = array[i];
        }
        size--;
        return removedItem;
    }


    @Override
    public void removeFirst(){
        remove(0);
    }

    @Override
    public void removeLast(){
        remove(size - 1);
    }
    @Override
    public int indexOf(T item){
        for (int i = 0; i < size; i++){
            if (item.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(T item){
        for (int i = size - 1; i >= 0; i--){
            if (item.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(T item){
        return indexOf(item) >= 0;

    }
    @Override
    public T[] toArray(){
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++){
            arr[i] = array[i];
        }
        return arr;
    }
    @Override
    public void sort(String algorithm) {
        switch (algorithm) {
            case "bubble":
                bubbleSort();
                break;
            case "quick":
                quickSort(0, size - 1);
                break;
            case "merge":
                mergeSort(0, size - 1);
                break;
            default:
                System.out.println("Unsupported sorting algorithm.");
        }
    }
    private void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++)
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    swapped = true;
                }
            if (!swapped)
                break;
        }
    }
    private int partition(int low, int high) {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    private void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }
    private void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T L[] = (T[]) new Comparable[n1];
        T R[] = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    @Override
    public void clear(){
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index invalid");
    }

    private void increaseSize() {
        int newSize = (array.length == 0) ? DEFAULT : array.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArr, 1, size);
        array = newArr;
    }

    @Override
    public Iterator<T> iterator(){
        return new MyArrayListIterator();
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void swap(int index, int parentIndex) {
        T temp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = temp;
    }

    private class MyArrayListIterator implements Iterator<T>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }
        @Override
        public T next(){
            return array[currentIndex++];
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException("is not supported");
        }
    }
}