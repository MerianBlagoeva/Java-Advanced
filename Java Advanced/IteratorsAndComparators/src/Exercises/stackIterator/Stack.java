package Exercises.stackIterator;

import java.util.Iterator;
public class Stack<T> implements Iterable<T> {

    private class StackIterator implements Iterator<T> {

        private Node<T> current = top;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T element = current.element;
            current = current.previous;
            return element;
        }
    }

    private static class Node<E> {
        private final E element;
        private Node<E> previous;

        private Node(E element) {
            this.element = element;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    public T pop() {
        ensureNotEmpty();

        T toRemove = top.element;
        top = top.previous;
        size--;
        return toRemove;
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new IllegalStateException("No elements");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
