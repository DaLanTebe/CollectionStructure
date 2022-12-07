package Collection.List;

import Collection.AbstractCollection;
import Collection.Queue.NormalQueue;

import java.util.Objects;

public class Stack<T> extends AbstractCollection<T> {

    private Node<T> last;
    private int size;

    private static class Node<T>{
        private Node<T> next;
        private T value;
    }


    @Override
    public int size() {
        return size;
    }

    public void push(T element){
        if (Objects.isNull(element)) {
            throw new IllegalArgumentException("New element cannot be null");
        }
        Node<T> node = new Node<>();
        node.value = element;
        node.next = last;
        last = node;
        size++;
    }
    public T pop(){
        if (size == 0) {
            return null;
        }
        T returnValue = last.value;
        last = last.next;
        size--;
        return returnValue;
    }
    public T peek() {
        if (size == 0) {
            return null;
        }
        return last.value;
    }

}
