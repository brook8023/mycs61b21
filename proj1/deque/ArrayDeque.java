package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            int index = (head + i) % items.length;
            tmp[i] = items[index];
        }
        items = tmp;
        head = 0;
        tail = size;
    }

    @Override
    public void addFirst(T item) {
        if (size > Math.round(items.length * 0.75)) {
            resize(items.length * 2);
        }
        head = (head - 1 + items.length) % items.length;
        items[head] = item;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size > Math.round(items.length * 0.75)) {
            resize(items.length * 2);
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 2);
        }
        T result = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size -= 1;
        return result;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 2);
        }
        int index = (tail - 1 + items.length) % items.length;
        T result = items[index];
        items[index] = null;
        tail = index;
        size -= 1;
        return result;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        int i = (head + index) % items.length;
        return items[i];
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArrayDeque)) {
            return false;
        }
        Iterator<T> t1 = iterator();
        Iterator<?> t2 = ((ArrayDeque<?>) obj).iterator();
        while (t1.hasNext() && t2.hasNext()) {
            T o1 = t1.next();
            Object o2 = t2.next();
            if (o1 == null || !o1.equals(o2)) {
                return false;
            }
        }
        return !(t1.hasNext()) && !(t2.hasNext());
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
}
