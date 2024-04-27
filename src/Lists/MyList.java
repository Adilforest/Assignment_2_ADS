package Lists;

public interface MyList<T extends Comparable<T>> extends Iterable<T> {

    /**
     * Adds an element to the end of the list.
     *
     * @param item The element to add to the list.
     */
    void add(T item);

    /**
     * Updates the element at the specified index with a new value.
     *
     * @param index The index of the element to update.
     *              Must be within the range of 0 to (size - 1).
     * @param item  The new value to set at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    void set(int index, T item);

    /**
     * Inserts an element at a specific index in the list.
     * Elements at and after the specified index are shifted one position to the right.
     *
     * @param index The index where the new element should be inserted.
     *              Must be within the range of 0 to size (inclusive).
     * @param item  The element to insert at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    void add(int index, T item);

    /**
     * Adds an element to the beginning of the list.
     * This is equivalent to calling `add(0, item)`.
     *
     * @param item The element to add to the beginning of the list.
     */
    void addFirst(T item);

    /**
     * Adds an element to the end of the list.
     * This is equivalent to calling `add(size(), item)`.
     *
     * @param item The element to add to the end of the list.
     */
    void addLast(T item);

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index The index of the element to retrieve.
     *              Must be within the range of 0 to (size - 1).
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    T get(int index);

    /**
     * Returns the first element in the list (equivalent to get(0)).
     *
     * @return The first element in the list, or null if the list is empty.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    T getFirst();

    /**
     * Returns the last element in the list (equivalent to get(size - 1)).
     *
     * @return The last element in the list, or null if the list is empty.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    T getLast();

    /**
     * Removes the element at the specified index from the list.
     * Elements after the removed element are shifted one position to the left.
     *
     * @param index The index of the element to remove.
     *              Must be within the range of 0 to (size - 1).
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    T remove(int index);

    /**
     * Removes the first element from the list (equivalent to remove(0)).
     *
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    void removeFirst();

    /**
     * Removes the last element from the list (equivalent to remove(size - 1)).
     *
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    void removeLast();

    /**
     * Searches for the first occurrence of the specified object in the list
     * and returns its index.
     *
     * @param object The object to search for.
     * @return The index of the first occurrence of the object in the list,
     *          or -1 if the object is not found.
     */
    int indexOf(T object);

    /**
     * Checks if the specified object exists in the list.
     *
     * @param object The object to search for.
     * @return True if the object exists in the list, false otherwise.
     */
    boolean exists(T object);

    /**
     * Converts the list elements into an array.
     *
     * @return An array containing all the elements in the list,
     *         or an empty array if the list is empty.
     */
    T[] toArray();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * @return
     * The number of elements currently in the list.
     */
    int size();

    /**
     * Sorts the elements in the list in ascending order.
     * The sorting algorithm used is implementation-dependent.
     */
    void sort();

    /**
     * Searches for the last occurrence of the specified object in the list
     * and returns its index.
     *
     * @param item The object to search for.
     * @return The index of the last occurrence of the object in the list,
     *          or -1 if the object is not found.
     */
    int lastIndexOf(T item);
}
