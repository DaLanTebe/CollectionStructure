package Collection.List;

import java.util.Objects;

public class DoubleLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
// +++++
    }

    @Override
    public void remove(int index) {
// +++++
    }

    @Override
    public boolean remove(T element) {
        // +++++
        return false;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Not correct index");
        }
        if (index < size / 2) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<T> node = last;
            for (int i = size - 1; i < index; i--) {
                node = node.previous;
            }
            return node;
        }
    }

    @Override
    public void set(int index, T element) {
        getNode(index).value = element;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.value, element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
