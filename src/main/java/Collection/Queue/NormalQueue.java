package Collection.Queue;

import Collection.AbstractCollection;

import java.util.Objects;

public class NormalQueue<T> extends AbstractCollection<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(T element) {
        if (Objects.isNull(element)) {
            throw new IllegalArgumentException("New element cannot be null");
        }
        Node<T> node = new Node<>();
        node.value = element;

        if (size == 0) first = node;
        else last.next = node;

        last = node;
        size++;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return first.value;
    }

    @Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        T returnValue = first.value;
        first = first.next;
        size--;
        return returnValue;
    }
}
