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
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Not correct index");
        }
        Node<T> node = new Node<>();
        node.value = element;
        if (size == 0) {
            first = last = node;
        } else if (size == index) {
            last.next = node;
            node.previous = last;
            last = node;
        } else if (index == 0) {
            first.previous = node;
            node.next = first;
            first = node;
        } else {
            Node<T> next = getNode(index);
            node.next = next;
            node.previous = next.previous;
            next.previous.next = node;
            next.previous = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Not correct index");
        }
        if (size == 1) {
            first = null;
            last = null;
        } else if (size == 2) {
            if (index == 0) {
                first = last;
                last.previous = null;
            } else {
                last = first;
                first.next = null;
            }
        } else if (index == 0) {
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            Node<T> node = getNode(index);
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    @Override
    public boolean remove(T element) {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            if (Objects.equals(first.value, element)) {
                clear();// Dangerous zone
                return true;
            } else return false;
        }
        if (size == 2) {
            if (Objects.equals(first.value, element)) {
                first = last;
                last.previous = null;
                size--;
                return true;
            } else if (Objects.equals(last.value, element)) {
                last = first;
                first.next = null;
                size--;
                return true;
            } else return false;
        }
        if (Objects.equals(first.value, element)) {
            first = first.next;
            first.previous = null;
            size--;
            return true;
        } else {
            Node<T> previousNode = first;
            for (int i = 1; i < size; i++) {
                if (Objects.equals(previousNode.next.value, element)) {
                    previousNode.next = previousNode.next.next;
                    if (i == size - 1) {
                        last = previousNode;
                    } else {
                        previousNode.next.previous = previousNode;
                    }
                    size--;
                    return true;
                }
                previousNode = previousNode.next;
            }
        }
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
            for (int i = size - 1; i > index; i--) {
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
