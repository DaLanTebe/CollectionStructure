package Collection.List;

public class SingleLinkedList<T> implements List<T>{

    private SingleNode<T> firstNode;
    private SingleNode<T> lastNode;
    private int size;

    private static class SingleNode<T>{
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

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
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

    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
