package Lists;

public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    int indexOf(T object);
    boolean exists(T object);
    T[] toArray();
    void clear();
    int size();
    void sort();

    int lastIndexOf(T item);
}