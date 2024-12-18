package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{


    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item) {
            this.item = item;
        }
        public Node() {}

    }
    private final Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node(item);
        Node nextNode = sentinel.next;
        sentinel.next = node;
        node.prev = sentinel;
        node.next = nextNode;
        nextNode.prev = node;
        this.size += 1;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item);
        Node prevNode = sentinel.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = sentinel;
        sentinel.prev = node;
        this.size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node pnode = sentinel.next;
        while (pnode != sentinel) {
            System.out.print(pnode.item + " ");
            pnode = pnode.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.next;
        Node nextnode = sentinel.next.next;
        sentinel.next = nextnode;
        nextnode.prev = sentinel;
        T result = node.item;
        node = null;
        this.size -= 1;
        return result;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.prev;
        Node prevnode = sentinel.prev.prev;
        sentinel.prev = prevnode;
        prevnode.next = sentinel;
        T result = node.item;
        node = null;
        this.size -= 1;
        return result;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        Node current = sentinel;
        for (int i = index; i >= 0; i--) {
            current = current.next;
        }

        return current.item;
    }

    private T getRecursiveHelp(int index, Node node){
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelp(index - 1, node.next);
    }
    public T getRecursive(int index){
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelp(index,sentinel.next);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LinkedListDeque)) {
            return false;
        }
        Iterator<T> t1 = iterator();
        Iterator<?> t2 = ((LinkedListDeque<?>) obj).iterator();
        while(t1.hasNext() && t2.hasNext()) {
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
        return new Iterator<T>() {
            private Node pnode = sentinel;

            @Override
            public boolean hasNext() {
                return pnode.next != sentinel;
            }

            @Override
            public T next() {
                pnode = pnode.next;
                return pnode.item;
            }
        };
    }
}
