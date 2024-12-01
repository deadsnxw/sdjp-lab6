import java.util.*;

/**
 * Class representing a custom typed collection based on a doubly linked list
 * and implementing the Set interface.
 *
 * @param <T> the type of elements in this collection, extending MusicComposition
 */
public class DoublyLinkedSet<T extends MusicComposition> implements Set<T> {

    // Inner class representing a node in the doubly linked list
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Default constructor for creating an empty collection.
     */
    public DoublyLinkedSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructor that initializes the collection with a single element.
     *
     * @param item the element to be added to the collection
     */
    public DoublyLinkedSet(T item) {
        this();
        add(item);
    }

    /**
     * Constructor that initializes the collection with elements from a standard collection.
     *
     * @param collection the collection of elements to be added
     */
    public DoublyLinkedSet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public boolean add(T item) {
        if (item == null) return false;
        if (contains(item)) return false;

        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;

        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;

        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T item : c) {
            if (add(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T item = it.next();
            if (!c.contains(item)) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (T item : this) {
            array[index++] = item;
        }
        return array;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Object[] result = a;
        for (T item : this) {
            result[index++] = item;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
