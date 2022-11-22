package Collection.List;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {

    private Object[] items;
    private int size;
    private int start;

    public ArrayList() {
        items = new Object[10];
    }

    public ArrayList(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity has to be bigger than 0");
        }
        items = new Object[capacity];
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

        if (size == 0) {
            items[start] = element;
        } else if (size < items.length) {//Резерв есть
            if (index < size / 2){// вставляем в первую половину списка
                if (start == 0){//нет резерва вначале
                    // добавить резерв слева и передвинуть список вправо
                    addLeftShift(index, element);
                }else {//есть резерв вначале
                    //вставляем елемент влево и передвигаем список вправо
                    addLeft(index, element);
                }

            } else {//вставляем во вторую половину списка
                if (start + size < items.length){//есть резерв в конце массива
                    // вставляем элемент вправо и остаток списка двигаем вправо
                    addRight(index, element);
                }else {//нет резерва в конце
                    // вставляем элемент влево и все что левее смещяем влево
                    addRightShift(index, element);
                }
            }
        } else {//резерва нет пересоздаем массив
            recreateItems(index, element);
        }
        size++;
    }

    private void addLeftShift(int index, T element) {
        for (int i = size - 1; i >= index; i--) {
            items[start + i + 1] = items[i];
        }
        items[start + index] = element;
        for (int i = index - 1; i >= 0; i--) {
            items[start + i] = items[i];
        }
        Arrays.fill(items, 0, start, null);
    }
    private void addLeft(int index, T element) {
        for (int i = 0; i < index; i++) {
            items[start + i - 1] = items[start + i];
        }
        start--;
        items[start + index] = element;
    }
    private void addRight(int index, T element) {
        for (int i = size; i > index; i--) {
            items[start + i] = items[start + i - 1];
        }
        items[start + index] = element;
    }
    private void addRightShift(int index, T element) {
        int newStart = start / 2;
        for (int i = 0; i < index; i++) {
            items[newStart + i] = items[start + i];
        }
        items[newStart + index] = element;

        if (newStart != start - 1){
            for (int i = index; i < size; i++) {
                items[newStart + i + 1] = items[start + 1];
            }
        }
        Arrays.fill(items, start + size, items.length, null);
    }

    private void recreateItems(int index, T element) {
        int newStart = start;
        if (newStart == 0 && index < size / 2) {
            newStart = (items.length * 2 - size) / 2;
        }

        Object[] newItems = new Object[items.length * 2];

        for (int i = 0; i < index; i++) {
            newItems[newStart + i] = items[start + i];
        }

        newItems[newStart + index] = element;

        for (int i = index; i < size; i++) {
            newItems[newStart + i + 1] = items[start + i];
        }

        items = newItems;
        start = newStart;
    }

    @Override
    public void remove(int index) {
        if (index > size){
            throw new IllegalArgumentException("Not correct index");
        }
        if (items.length > size * 4){
            recreateItems(index);
        }else {
            if (index <= size / 2){
                for (int i = index; i > 0; i--) {
                    items[start + i] = items[start + i - 1];
                }
                items[start] = null;
                start++;

            } else {
                for (int i = index; i < size - 1; i++) {
                    items[start + i] = items[start + i + 1];
                }
                items[size] = null;
            }
        }
        size--;
    }

    private void recreateItems (int index){
        int newStart = start;
        if (newStart == 0){
            newStart = (items.length / 2 - size) / 2;
        }

        Object[] newItems = new Object[items.length / 2];

        for (int i = 0; i < index; i++) {
            newItems[newStart + i] = items[start + i];
        }

        for (int i = index; i < size - 1; i++) {
            newItems[newStart + i] = items[start + i + 1];
        }
        items = newItems;
        start = newStart;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Not correct index");
        }
        return (T)items[start + index];
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Not correct index");
        }
        items[start + index] = element;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, items[start + i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

}
