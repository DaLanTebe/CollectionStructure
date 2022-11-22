package Collection.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<String> arrayList;

    @BeforeEach
    void init() {
        arrayList = new ArrayList<>();
    }

    void fillList() {
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");
        arrayList.add("fourth");
    }
    void fillListFiveElements(){
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
    }

    @Test
    void indexOf() {
        arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add(0, "4");
        arrayList.add("5");

        assertEquals(5, arrayList.size());
        assertEquals("4", arrayList.get(0));
        assertEquals("1", arrayList.get(1));
        assertEquals("2", arrayList.get(2));
        assertEquals("3", arrayList.get(3));
        assertEquals("5", arrayList.get(4));
        assertEquals(-1, arrayList.indexOf("6"));
    }

    @Test
    void add() {
        arrayList = new ArrayList<>();
        fillList();

        assertEquals(4, arrayList.size());
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));
        assertEquals("fourth", arrayList.get(3));
    }

    @Test
    void addWithCapacity() {
        arrayList = new ArrayList<>(2);
        fillList();

        assertEquals(4, arrayList.size());
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.get(2));
        assertEquals("fourth", arrayList.get(3));

    }

    @Test
    void addWithRecreateLeft() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");

        arrayList.add(0, "element");
        arrayList.add("element2");

        assertEquals(5, arrayList.size());
        assertEquals("element", arrayList.get(0));
        assertEquals("first", arrayList.get(1));
        assertEquals("second", arrayList.get(2));
        assertEquals("third", arrayList.get(3));
        assertEquals("element2", arrayList.get(4));
    }

    @Test
    void addWithLeftReserve() {
        arrayList = new ArrayList<>(3);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add(0, "4");
        arrayList.add(1, "5");

        assertEquals(5, arrayList.size());
        assertEquals("4", arrayList.get(0));
        assertEquals("5", arrayList.get(1));
        assertEquals("1", arrayList.get(2));
        assertEquals("2", arrayList.get(3));
        assertEquals("3", arrayList.get(4));
    }

    @Test
    void addWithLeftShift() {
        ArrayList<String> list = new ArrayList<>(4);
        list.add("1");
        list.add("2");
        list.add("3");

        list.add(1, "4");

        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("4", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("3", list.get(3));
    }

    @Test
    void addWithRightShift() {
        ArrayList<String> list = new ArrayList<>(4);
        list.add("1");
        list.add("2");
        list.add(0, "3");
        list.add("4");

        assertEquals(4, list.size());
        assertEquals("3", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("4", list.get(3));

    }

    @Test
    void removeLeft(){
        arrayList = new ArrayList<>();
        fillListFiveElements();
        arrayList.remove(1);

        assertEquals(4, arrayList.size());
        assertEquals("1", arrayList.get(0));
        assertEquals("3", arrayList.get(1));
        assertEquals("4", arrayList.get(2));
        assertEquals("5", arrayList.get(3));
    }

    @Test
    void remove() throws NoSuchFieldException, IllegalAccessException {
        arrayList = new ArrayList<>(100);
        fillListFiveElements();
        arrayList.remove(1);

        assertEquals(4, arrayList.size());
        assertEquals("1", arrayList.get(0));
        assertEquals("3", arrayList.get(1));
        assertEquals("4", arrayList.get(2));
        assertEquals("5", arrayList.get(3));

        Field items = ArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        assertEquals(50, ((Object[]) items.get(arrayList)).length);
    }

    @Test
    void clear() {
        arrayList = new ArrayList<>();
        fillListFiveElements();
        arrayList.clear();

        assertEquals(0, arrayList.size());
    }


}