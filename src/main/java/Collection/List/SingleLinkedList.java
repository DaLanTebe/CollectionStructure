package Collection.List;

import java.util.Objects;

public class SingleLinkedList<T> implements List<T> {

    private SingleNode<T> firstNode;
    private SingleNode<T> lastNode;
    private int size;

    private static class SingleNode<T> {
        private T value;
        private SingleNode<T> nextSingleNode;
    }

    @Override
    public int size() {
        return this.size;
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
        SingleNode<T> singleNode = new SingleNode<>();
        singleNode.value = element;
        if (index == size) {
            if (size == 0) {
                firstNode = singleNode;
            } else {
                lastNode.nextSingleNode = singleNode;
            }
            lastNode = singleNode;
            size++;
            return;
        }
        if (index == 0) {
            singleNode.nextSingleNode = firstNode;
            firstNode = singleNode;
            size++;
            return;
        }
        SingleNode<T> previousNode = firstNode;
        for (int i = 1; i < index; i++) {
            previousNode = previousNode.nextSingleNode;
        }
        singleNode.nextSingleNode = previousNode.nextSingleNode;
        previousNode.nextSingleNode = singleNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Not correct index");
        }
        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size--;
            return;
        }

        if (size == 2) {
            if (index == 0) {
                firstNode = lastNode;
            } else {
                lastNode = firstNode;
                firstNode.nextSingleNode = null;
            }
            size--;
            return;
        }

        if (index == 0) {
            firstNode = firstNode.nextSingleNode;
            size--;
            return;
        }
        SingleNode<T> previousNode = firstNode;

        for (int i = 1; i < index; i++) {
            previousNode = previousNode.nextSingleNode;
        }
        previousNode.nextSingleNode = previousNode.nextSingleNode.nextSingleNode;

        if (index == size - 1){
            lastNode = previousNode;
            size--;
        }
    }

    @Override
    public boolean remove(T element) {
        if (size == 0){
            return false;
        }
        if (size == 1){
            return removeWhenOne(element);
        }
        if (size == 2){
            return removeWhenTwo(element);
        }
        return findAndRemove(element);
    }

    private boolean removeWhenOne(T element){
        if (Objects.equals(firstNode.value, element)){
            firstNode = lastNode = null;
            size--;
            return true;
        }else return false;
    }

    private boolean removeWhenTwo(T element){
        if (Objects.equals(firstNode.value, element)){
            firstNode = lastNode;
            size--;
            return true;
        }else if (Objects.equals(lastNode, element)){
            lastNode = firstNode;
            firstNode.nextSingleNode = null;
            size--;
            return true;
        }else return false;
    }

    private boolean findAndRemove(T element){
        if (Objects.equals(firstNode.value, element)){
            firstNode = firstNode.nextSingleNode;
            size--;
            return true;
        }
        SingleNode<T> previousNode = firstNode;
        for (int i = 1; i < size; i++) {
            if (Objects.equals(previousNode.nextSingleNode.value, element)){
                previousNode.nextSingleNode = previousNode.nextSingleNode.nextSingleNode;
                if (i == size -1){
                    lastNode = previousNode;
                }
                size--;
                return true;
            }
            previousNode = previousNode.nextSingleNode;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Not correct index");
        }
        SingleNode<T> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.nextSingleNode;
        }
        return node.value;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Not correct index");

        SingleNode<T> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.nextSingleNode;
        }
        node.value = element;
    }

    @Override
    public int indexOf(T element) {
        SingleNode<T> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.value, element)){
                return i;
            }
            node = node.nextSingleNode;
        }
        return -1;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
}
